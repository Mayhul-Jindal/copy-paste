package com.example.copy_paste.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

data class ItemModel(
    val title: String,
    val selected: Boolean
)

@Composable
fun DetailScreen2(navController: NavHostController, copiedText: String){
    Log.d("detail_screen_2_test", copiedText)
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ){
//        Text(
//            text = "Send to device",
//            style = MaterialTheme.typography.body1,
//            color = Color.Black,
//            fontSize = MaterialTheme.typography.h2.fontSize,
//            modifier = Modifier
//                .clickable { navController.popBackStack() }
//        )
//    }
    var items by rememberSaveable {
        mutableStateOf(
            (1..20).map {
                ItemModel(
                    title = "Item $it",
                    selected = false
                )
            }
        )
    }

    Column() {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(items.size) { index ->
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        items = items.mapIndexed { jIndex, model ->
                            if (index == jIndex) model.copy(selected = !model.selected)
                            else model
                        }
                    }
                    .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = items[index].title)
                    if (items[index].selected) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "selected",
                            tint = Color.Green,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }

        Button(
            onClick = {}
        ) {
            Text(text = "Done")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Display5(){
    DetailScreen2(navController = rememberNavController(), copiedText = "this is a test")
}
