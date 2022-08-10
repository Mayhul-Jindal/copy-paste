package com.example.copy_paste.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.copy_paste.R
import com.example.copy_paste.ViewModels.DetailScreenViewModelAbstract
import com.example.copy_paste.data.Copied
import com.example.copy_paste.navigation.Screen
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(
    navController: NavHostController,
    myViewModel: DetailScreenViewModelAbstract,
){

//    // yeh pehle wali cheez ka part
//    val clipboardManager: androidx.compose.ui.platform.ClipboardManager = LocalClipboardManager.current
//    var text by remember { mutableStateOf("")}

    val copiedListState = myViewModel.copiedListFlow.collectAsState(initial = listOf())
//    var selectedText = "";
    var selectedText by remember { mutableStateOf("")}
    Scaffold {
        Column {
            // testing database thing
            LazyColumn (
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ){
                items(copiedListState.value.size) { index ->
                    val copiedText = copiedListState.value[index]
                    Card(
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(width = 2.dp, color = Color.Black),
                        backgroundColor = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                    ) {
                        Row {
                            val scrollState = rememberScrollState()
                            Box(
                                modifier = Modifier
                                    .clickable {
                                        selectedText = copiedText.text
                                    }
                                    .fillMaxWidth(0.9f)
                                    .height(80.dp)
                                    .verticalScroll(state = scrollState)
                            ) {
                                Text(
                                    modifier = Modifier
                                        .align(Alignment.CenterStart)
                                        .padding(
                                            top = 10.dp,
                                            start = 16.dp,
                                            end = 16.dp,
                                            bottom = 10.dp
                                        ),
                                    text = copiedText.text,
                                    maxLines = 4
                                )
                            }
                            IconButton(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically),
                                onClick = {
                                    myViewModel.deleteCopied(copiedText)
                                }
                            ) {
                                Icon(painter = painterResource(R.drawable.bin_icon), contentDescription = "Bin icon")
                            }
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    modifier = Modifier
                        .align(Alignment.Center),
                    onClick = {
                        navController.navigate(
                            route = Screen.Detail2.passInfo(
                                copied_text = selectedText
                            )
                        )
                    }
                ) {
                    Text(text = "Send to Device")
                }
            }

            // yeh pehle wala part tha hamesha se jo tha
//            Text(
//                text = "Copy the text you want",
//                style = MaterialTheme.typography.body1,
//                color = Color.Black,
//                fontSize = MaterialTheme.typography.h2.fontSize,
//                modifier = Modifier
//                    .clickable {
//                        navController.navigate(
//                            route = Screen.Detail2.passInfo(
//                                text = "this is a test"
//                            )
//                        )
//                    }
//            )
//
//            TextField(value = text, onValueChange = {text = it})
//            Button(onClick = {
//                clipboardManager.setText(AnnotatedString((text)))
//            }) {
//                Text("Copy")
//            }
//
//            Button(onClick = {
//                clipboardManager.getText()?.text?.let {
//                    text = it
//                }
//            }) {
//                Text("Get")
//            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun Display2(){
    DetailScreen(
        navController = rememberNavController(),
        myViewModel = object : DetailScreenViewModelAbstract {
            override val copiedListFlow: Flow<List<Copied>>
                get() = flowOf(
                    listOf(
                        Copied(text = "test1lwjebfqlwefbqljwevqljwev;jwebfq;jwev"),
                        Copied(text = "test2lwjebfqlwefbqljwevqljwev;jwebfq;jwev"),
                        Copied(text = "test2kwejfbqlwjebfqlwefbqljwevqljwev;jwebfq;jwevbqjwdvbclqjwevclqjwehvqljwehvqwjehv;qwkjev;qwkehjv;qwjkevb;qwkjevb;qwkejv;qkwejv;qkwejvb;kvedkjwtest2kwejfbqlwjebfqlwefbqljwevqljwev;jwebfq;jwevbqjwdvbclqjwevclqjwehvqljwehvqwjehv;qwkjev;qwkehjv;qwjkevb;qwkjevb;qwkejv;qkwejv;qkwejvb;kvedkjw"),
                        Copied(text = "test2lwjebfqlwefbqljwevqljwev;jwebfq;jwev"),
                        Copied(text = "test2lwjebfqlwefbqljwevqljwev;jwebfq;jwev"),
                    )
                )
            override fun addCopied(copied: Copied) {}
            override fun deleteCopied(copied: Copied) {}
        }
    )
}

