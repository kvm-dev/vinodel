package com.vinodel.main.imp.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import com.vinodel.main.imp.viewmodel.MainViewModel
import com.vinodel.ui.components.BaseText
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun MainScreen(mainViewModel: MainViewModel = koinViewModel()) {
    BaseText("MainScreen")
}