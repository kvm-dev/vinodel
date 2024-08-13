package com.vinodel.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.vinodel.ui.R

@RequiresApi(Build.VERSION_CODES.Q)
val oswaldSansFamily = FontFamily(
    Font(R.font.oswald_extra_light, FontWeight.ExtraLight),
    Font(R.font.oswald_light, FontWeight.Light),
    Font(R.font.oswald_regular, FontWeight.Normal),
    Font(R.font.oswald_medium, FontWeight.Medium),
    Font(R.font.oswald_semi_bold, FontWeight.SemiBold),
    Font(R.font.oswald_bold, FontWeight.Bold)
)