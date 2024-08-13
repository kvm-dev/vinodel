package com.vinodel.splash.imp.di

import com.vinodel.splash.imp.domain.interactor.SplashInteractor
import com.vinodel.splash.imp.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val splashModule = module {
    single { SplashInteractor()}
    viewModelOf(::SplashViewModel)
}