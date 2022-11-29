package com.example.copy_paste.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.copy_paste.CopyPasteNotif
import com.example.copy_paste.R
import com.example.copy_paste.navigation.AUTH_GRAPH_ROUTE
import com.example.copy_paste.navigation.DETAIL_GRAPH_ROUTE
import com.example.copy_paste.navigation.Screen
import com.example.copy_paste.ui.theme.copyPasteColor2


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController){
    val context = LocalContext.current
    Scaffold(
        backgroundColor = copyPasteColor2
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
        ){
            Image(
                painter = painterResource(id = R.drawable.group_17),
                contentDescription = "App Logo",
                modifier = Modifier
                    .padding(top = 30.dp)
                    .size(300.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Welcome to COPY PASTA",
                color = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = 4.dp,
                modifier = Modifier
                    .width(250.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally

                ){
                    Text(
                        text = "One stop destination for all your",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                    )
                    Text(
                        text = "copy paste problems and lorem",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp
                    )
                    Text(
                        text = "ipsum blah blah blah",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            navController.navigate(AUTH_GRAPH_ROUTE)
                        },
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                        modifier = Modifier
                            .width(200.dp)
                    ) {
                        Text(
                            text = "Login",
                            color = Color.White,
                        )
                    }
                }
            }
            OutlinedButton(onClick = {
                val notif = CopyPasteNotif(context, "Test-body", "Test-title")
                notif.fireNotification()
            }) {
                Text(text = "Test hain yeh")
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun Display1(){
    HomeScreen(navController = rememberNavController())
}

