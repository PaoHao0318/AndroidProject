package com.example.helloworldcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 呼叫主要畫面元件
            HelloWorldScreen()
        }
    }
}

@Composable
fun HelloWorldScreen() {
    // 建立一個狀態變數 showDialog，用來控制警告視窗是否顯示
    var showDialog by remember { mutableStateOf(false) }
    // var showDialog = false

    // 使用 Box 容器將內容置中
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // 建立按鈕，點擊時將 showDialog 設為 true
        Button(onClick = { showDialog = true }) {
            Text(text = "Hello World")
        }
    }

    // 當 showDialog 為 true 時，顯示 AlertDialog
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = "提示") },
            text = { Text(text = "Hello World") },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("OK")
                }
            }
        )
    }
}

// 預覽元件，讓你在編輯器右側直接看到畫面
@Preview(showBackground = true)
@Composable
fun HelloWorldPreview() {
    HelloWorldScreen()
}