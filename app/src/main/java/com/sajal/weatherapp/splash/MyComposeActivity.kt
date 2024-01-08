package com.sajal.weatherapp.splash

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
            UseOfModifierInTextView()
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
    private fun MyInputTextField() {
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

    @Preview(showBackground = true, name = "Preview Message", widthDp = 500, heightDp = 500)
    @Composable
    private fun myPreviewFunction() {
//        Column {
//            ListViewItem(R.drawable.profile_circle, "Sajal Jain", "Technical Lead")
//            ListViewItem(R.drawable.profile_circle, "Akshit", "Product Manager")
//            ListViewItem(R.drawable.profile_circle, "Ankit", "Product Manager")
//            ListViewItem(R.drawable.profile_circle, "Dhruv", "Technical Lead")
//        }
        UseOfModifierInTextView()
        // MakeCircularImageView()
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

    @Composable
    fun UseOfModifierInTextView() {
        Text(
            text = "Hello",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier
                .background(Color.Blue)
                .clickable {
                    Log.d("sajal" ,"Outside redline")
                }
                .size(200.dp)
                .padding(8.dp) //Outer 8dp padding
                .border(4.dp,Color.Red)
                .clickable {
                    Log.d("sajal" ,"inside the red border")
                }
                .padding(40.dp) //innner padding from redline to yellow starting
                //.clip(RoundedCornerShape(20.dp))
                .clip(CircleShape)
                .clickable { Log.d("sajal" ,"inside the yellow") }
                .background(Color.Yellow)
                .padding(60.dp) //yeah hello text ki padding hai outer most block se
        )
    }

    @Composable
    fun MakeCircularImageView() {
        Image(
            painter = painterResource(id = R.drawable.self),
            contentDescription = "Image of Android developer Sajal Jain",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(180.dp)
                .clip(CircleShape)
                .border(2.dp, Color.LightGray, CircleShape)
        )
    }

}