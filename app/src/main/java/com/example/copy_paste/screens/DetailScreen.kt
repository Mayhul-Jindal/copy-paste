package com.example.copy_paste.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.copy_paste.data.Copied
import com.example.copy_paste.navigation.Screen

@Composable
fun DetailScreen(
    navController: NavHostController,
//    myViewModel: DetailScreenViewModel,
){
    val clipboardManager: androidx.compose.ui.platform.ClipboardManager = LocalClipboardManager.current
    var text by remember { mutableStateOf("")}

//    var testText = clipboardManager.getText()?.text.toString()
//    myViewModel.addCopied(copied = Copied(id = 1,copiedText = testText))
//    myViewModel.getAllCopied()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
//        LazyColumn {
//            myViewModel.copiedContents
//        }
        Column {
            Text(
                text = "Copy the text you want",
                style = MaterialTheme.typography.body1,
                color = Color.Black,
                fontSize = MaterialTheme.typography.h2.fontSize,
                modifier = Modifier
                    .clickable {
                        navController.navigate(
                            route = Screen.Detail2.passInfo(
                                id = 100,
                                name = "hahahahah"
                            )
                        )
                    }
            )

            TextField(value = text, onValueChange = {text = it})
            Button(onClick = {
                clipboardManager.setText(AnnotatedString((text)))
            }) {
                Text("Copy")
            }

            Button(onClick = {
                clipboardManager.getText()?.text?.let {
                    text = it
                }
            }) {
                Text("Get")
            }
        }

    }
}

//@Composable
//@Preview(showBackground = true)
//
//fun Display2(){
//    DetailScreen(
//        navController = rememberNavController(),
//        myViewModel = DetailScreenViewModel()
//    )
//}

