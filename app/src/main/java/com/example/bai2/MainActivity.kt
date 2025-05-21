package com.example.bai2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
MaterialTheme{
    EmailCheck()
}
        }
    }
}
@Composable
fun EmailCheck() {


    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    var isSuccess by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
        )
        {
            Text(
                text = "Bài tập thực hành 2",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold

            )
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    message = ""
                    isError = false
                    isSuccess = false
                },
                label = { Text("email") },
                isError = isError,

                modifier = Modifier.fillMaxWidth(0.8f)


            )
            if (message.isNotEmpty()) {
                Text(
                    text = message,
                    color = if (isError) Color.Red else Color(0xFF2E7D32),
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .align(Alignment.Start)
                )
            }


            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    message = when {
                        email.isBlank() -> {
                            isError = true
                            isSuccess = false
                            "Email không được để trống"

                        }

                        !email.contains("@") -> {
                            isError = true
                            isSuccess = false
                            "Email không đúng định dạng"

                        }

                        else -> {
                            isError = false
                            isSuccess = true
                            "Email hợp lệ"
                        }

                    }

                },
                modifier = Modifier.fillMaxWidth(0.8f)

            ) {
                Text("kiểm tra")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmailCheckPreview() {
    MaterialTheme {
        EmailCheck()
    }
}

