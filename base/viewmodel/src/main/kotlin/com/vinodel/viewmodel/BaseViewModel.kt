package com.vinodel.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vinodel.utils.exceptions.AppExceptions
import com.vinodel.viewmodel.model.ProgressState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    private val _progressState = MutableStateFlow(ProgressState.COMPLETED)
    val progressState: StateFlow<ProgressState> = _progressState.asStateFlow()

    open val genericErrorHandler: CoroutineExceptionHandler
        get() = CoroutineExceptionHandler { _, throwable ->
            if (throwable is AppExceptions) {
                handleException(throwable)
            }
        }

    protected fun CoroutineScope.with(
        onError: (AppExceptions) -> Unit = {},
        block: suspend CoroutineScope.() -> Unit,
    ) = launch(genericErrorHandler) {
        withActionSuspending(
            block = block,
            onError = onError
        )
    }

    protected fun CoroutineScope.withProgress(
        onError: (AppExceptions) -> Boolean = { false },
        block: suspend CoroutineScope.() -> Unit,
    ) = launch(genericErrorHandler) { withProgressSuspending(onError, block) }

    private suspend fun <T> withProgressSuspending(
        onError: (AppExceptions) -> Boolean = { false },
        block: suspend CoroutineScope.() -> T,
    ): T? = withActionSuspending(
        block = block,
        onStart = { startProgress() },
        onComplete = { completeProgress() },
        onError = { error ->
            completeProgress()
            if (!onError(error)) {
                when (error) {
                    AppExceptions.NetworkException.InternalServerException,
                    AppExceptions.NetworkException.BadRequestException->{
                        //todo чего будем делать)
                    }

                    else -> {}
                }
            }
        },
    )

    @Suppress("TooGenericExceptionCaught")
    private suspend fun <T> withActionSuspending(
        onStart: (() -> Unit)? = null,
        onError: (AppExceptions) -> Unit,
        onComplete: (() -> Unit)? = null,
        block: suspend CoroutineScope.() -> T,
    ): T? = coroutineScope {
        try {
            onStart?.invoke()
            block().also { onComplete?.invoke() }
        } catch (e: AppExceptions.LocalException) {
            Log.e(TAG, "${((e as? AppExceptions.LocalException.UnknownException)?.throwable ?: e)}")
            onError(e)
            throw e
        } catch (e: AppExceptions.NetworkException) {
            Log.e(TAG, "$e")
            onError(e)
            null
        } catch (e: Throwable) {
            Log.e(TAG, "$e")
            onComplete?.invoke()
            throw e
        }
    }

    protected fun startProgress() {
        _progressState.value = ProgressState.LOADING
    }

    protected fun completeProgress(){
        _progressState.value = ProgressState.COMPLETED
    }

    protected open fun handleException(exception: AppExceptions, onRetry: (() -> Unit)? = null) {
        when (exception) {
            is AppExceptions.NetworkException -> when (exception) {
                is AppExceptions.NetworkException.UnprocessableEntityException -> {}
                else -> {}
            }
            is AppExceptions.LocalException -> when (exception) {
                AppExceptions.LocalException.NoInternetConnectionException,
                is AppExceptions.LocalException.UnknownException -> {}
                else -> {}
            }
        }
    }

    abstract fun initViewModel()

    companion object{
        val TAG = "ViewModel"
    }
}

fun <T> MutableLiveData<T>.readOnly(): LiveData<T> = this