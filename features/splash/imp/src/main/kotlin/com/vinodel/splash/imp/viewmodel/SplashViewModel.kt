package com.vinodel.splash.imp.viewmodel

import com.vinodel.splash.imp.domain.interactor.SplashInteractor
import com.vinodel.splash.imp.presentation.state.SplashViewState
import com.vinodel.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SplashViewModel(private val interactor: SplashInteractor): BaseViewModel() {
    private val _connectionState = MutableStateFlow(SplashViewState.ConnectionState.DISCONNECTED)
    val connectionState = _connectionState.asStateFlow()

   private fun somethingFun() = interactor.somethingFun()

    override fun initViewModel() {
        startProgress().also {
            somethingFun()
        }
        completeProgress()
    }
}