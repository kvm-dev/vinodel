package com.vinodel.di

import com.vinodel.main.imp.di.mainModule
import com.vinodel.splash.imp.di.splashModule
import org.koin.dsl.module

val injectionModule = module {
    includes(mainModule, splashModule)
}