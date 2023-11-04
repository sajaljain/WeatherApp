package com.sajal.weatherapp.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
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
        Button(
            onClick = { }, colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Cyan
            ),
            enabled = false
        ) {
            Text(text = "$name")
            Image(painter = painterResource(id = R.drawable.heart_16), contentDescription = "heart")
        }
    }

    @Preview(showBackground = true, name = "Preview Message", widthDp = 200, heightDp = 200)
    @Composable
    private fun myPreviewFunction(){
        sayCheezy("Hello Sajal")
    }

}