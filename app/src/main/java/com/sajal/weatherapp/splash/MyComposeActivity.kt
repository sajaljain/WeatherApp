package com.sajal.weatherapp.splash

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.ModifierLocalNode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sajal.weatherapp.R

class MyComposeActivity : ComponentActivity() {
    val TAG: String = "MyComposeActivity"
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
        //this function is errorneous will check it later
        var state = remember {
            mutableStateOf("Sajal")
        }
        TextField(
            value = TextFieldValue(text = state.value),
            onValueChange = {
                Log.d(TAG, "myInputTextField: before value ${state.value}")
                state.value = it.text
                Log.d(TAG, "myInputTextField: after value ${state.value}")
            },
            placeholder = { "My Placeholder value" },
            label = { "My Label" }
        )
    }

    @Preview(showBackground = true, name = "Preview Message", widthDp = 200, heightDp = 300)
    @Composable
    private fun myPreviewFunction() {
        Column {
            ListViewItem(R.drawable.profile_circle, "Sajal Jain", "Technical Lead")
            ListViewItem(R.drawable.profile_circle, "Akshit", "Product Manager")
            ListViewItem(R.drawable.profile_circle, "Ankit", "Product Manager")
            ListViewItem(R.drawable.profile_circle, "Dhruv", "Technical Lead")
        }
    }

    @Composable
    fun makeBoxSample() {
        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.heart_16),
                contentDescription = "heart",
                Modifier.size(24.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.diagonal_arrow_right_up),
                contentDescription = "arrow",
                Modifier.size(72.dp)
            )
        }
    }

    @Composable
    fun ListViewItem(imageId: Int, name: String, occupation: String) {
        Row(Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = "",
                Modifier.size(40.dp)
            )
            Column {
                Text(text = name, fontWeight = FontWeight.Bold)
                Text(text = occupation, fontWeight = FontWeight.Thin, fontSize = 12.sp)
            }
        }
    }


}