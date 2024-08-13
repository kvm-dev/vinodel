package com.vinodel.main.imp.viewmodel

import com.vinodel.main.imp.domain.interactor.MainInteractor
import com.vinodel.main.imp.presentation.state.MainViewState
import com.vinodel.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(private val interactor: MainInteractor): BaseViewModel() {
    private val _connectionState = MutableStateFlow(MainViewState.ConnectionState.DISCONNECTED)
    val connectionState = _connectionState.asStateFlow()

    private fun somethingFun() = interactor.somethingFun()

    override fun initViewModel() {
        startProgress().also {
            somethingFun()
        }
        completeProgress()
    }
}