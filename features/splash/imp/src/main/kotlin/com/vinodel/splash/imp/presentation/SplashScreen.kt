package com.vinodel.splash.imp.presentation


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import com.vinodel.splash.imp.viewmodel.SplashViewModel
import com.vinodel.ui.components.BaseText
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun SplashScreen(mainScreen: () -> Unit, splashViewModel: SplashViewModel = koinViewModel()) {
    BaseText("SplashScreen")
}