package com.sajal.weatherapp.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.sajal.weatherapp.R

class MyComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myInputTextField()
        }
    }

    @Composable
    fun buttonComposable(name: String = "Some Default Name Value") {
        Button(
            onClick = { }, colors = ButtonDefaults.buttonColors(
                contentColor = Color.White, containerColor = Color.Cyan
            ), enabled = false //button enabled or disabled
        ) {
            Text(text = "$name")
            Image(painter = painterResource(id = R.drawable.heart_16), contentDescription = "heart")
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun myInputTextField() {
        var state = remember {
            mutableStateOf("")
        }
        TextField(
            value = TextFieldValue(text = state.value),
            onValueChange = { state.value = it.toString() },
            placeholder = { "My Placeholder value" },
            label = { "My Label" }
        )

    }

    @Preview(showBackground = true, name = "Preview Message", widthDp = 200, heightDp = 200)
    @Composable
    private fun myPreviewFunction() {
        myInputTextField()
    }

}