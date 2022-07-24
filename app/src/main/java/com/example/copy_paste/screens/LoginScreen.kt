package com.example.copy_paste.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.copy_paste.navigation.DETAIL_GRAPH_ROUTE
import com.example.copy_paste.navigation.Screen

@Composable
fun LoginScreen(navController: NavHostController, myViewModel: LoginViewModel){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            MyTextField(
                label = "Username",
                value = myViewModel.username,
                onValueChanged = {myViewModel.onUsernameChanged(it)}
            )
            MyTextField(
                label = "Password",
                keyboard = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTrans = PasswordVisualTransformation(),
                value = myViewModel.password,
                onValueChanged = {myViewModel.onPasswordChanged(it)}
            )
            Text(
                text = "Don't have account SignUp",
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.secondaryVariant,
                modifier = Modifier
                    .clickable {
                        navController.navigate(
                            route = Screen.SignUp.route
                        )
                    }
            )
            Button(
                onClick = {
                    navController.navigate(route = DETAIL_GRAPH_ROUTE)
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                enabled = myViewModel.username.isNotBlank() && myViewModel.password.isNotBlank()
            ) {
                Text(
                    text = "Login",
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun MyTextField(
    label: String,
    visualTrans: VisualTransformation = VisualTransformation.None,
    keyboard: KeyboardOptions = KeyboardOptions.Default,
    value: String,
    onValueChanged:(String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = { Text(label)},
        visualTransformation = visualTrans,
        keyboardOptions = keyboard
    )
}

class LoginViewModel: ViewModel(){
    //State
    var username by mutableStateOf("")
    var password by mutableStateOf("")

    //events
    fun onUsernameChanged(newString: String){
        username = newString
    }
    fun onPasswordChanged(newString: String){
        password = newString
    }
}

@Composable
@Preview(showBackground = true)
fun Display3(){
    LoginScreen(navController = rememberNavController(), myViewModel = LoginViewModel())
}

