package com.sajal.weatherapp.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.sajal.weatherapp.R

class MyComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            sayCheezy("Hello World")
        }
    }

    @Composable
    fun sayCheezy(name : String = "Some Default Name Value") {
        Image(
            painter = painterResource(id = R.drawable.heart_16),
            contentDescription = "Heart Image",
            colorFilter = ColorFilter.tint(Color.Red),
            contentScale = ContentScale.Inside
        )
    }

    @Preview(showBackground = true, name = "Hello Message", widthDp = 200, heightDp = 200)
    @Composable
    private fun myPreviewFunction(){
        sayCheezy("Hello Sajal")
    }

}