package com.vinodel.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vinodel.ui.theme.VinodelTheme
import com.vinodel.ui.theme.oswaldSansFamily

@Composable
fun BaseButton(onClick: () -> Unit, text: String){
    Button(
        onClick = {
            onClick()
        }
    ) {
        Text(text = text)
    }
}

@Composable
fun BaseBox(){
    VinodelTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary))
    }
}


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun BaseText(text: String){
    Text(modifier = Modifier.padding(vertical = 12.dp, horizontal = 38.dp), text =text, fontFamily = oswaldSansFamily, fontWeight = FontWeight.Normal, style = TextStyle(
            fontSize = 17.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        ))
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun BaseWhiteText(text: String){
    Text(modifier = Modifier.padding(vertical = 12.dp, horizontal = 38.dp), text =text, fontFamily = oswaldSansFamily, fontWeight = FontWeight.Normal, style = TextStyle(
        fontSize = 18.sp,
        color = Color.White,
        textAlign = TextAlign.Center
    ))
}
