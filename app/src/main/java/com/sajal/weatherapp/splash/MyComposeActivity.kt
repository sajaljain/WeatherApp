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
import androidx.compose.ui.tooling.preview.Preview
import com.sajal.weatherapp.splash.ui.theme.WeatherAppTheme

class MyComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            sayCheezy("Hello World")
        }
    }

    @Composable
    fun sayCheezy(name : String = "Some Default Name Value") {
        Text(text = "$name")
    }

    @Preview(showBackground = true, name = "Hello Message", widthDp = 100, heightDp = 100)
    @Composable
    private fun myPreviewFunction(){
        sayCheezy("Hello Sajal")
    }
}