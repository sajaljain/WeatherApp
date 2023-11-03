package com.sajal.weatherapp.splash

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.sajal.weatherapp.splash.ui.theme.WeatherAppTheme
import kotlin.math.max

class MyComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            sayCheezy("Hello World")
        }
    }

    @Composable
    fun sayCheezy(name : String = "Some Default Name Value") {
        Text(text = "$name",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Red,
            fontSize = 35.sp,
            textAlign = TextAlign.Center,
            maxLines = 2,
            fontFamily = FontFamily.Serif
            )
    }

    @Preview(showBackground = true, name = "Hello Message", widthDp = 200, heightDp = 200)
    @Composable
    private fun myPreviewFunction(){
        sayCheezy("Hello Sajal")
    }

}