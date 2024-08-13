package com.vinodel.main.imp.di

import com.vinodel.main.imp.domain.interactor.MainInteractor
import com.vinodel.main.imp.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val mainModule = module {
    single { MainInteractor()}
    viewModelOf(::MainViewModel)
}