package com.example.copy_paste.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.copy_paste.R
import com.example.copy_paste.navigation.DETAIL_GRAPH_ROUTE
import com.example.copy_paste.navigation.Screen

@Composable
fun LoginScreen(navController: NavHostController, myViewModel: LoginViewModel){
    Scaffold(
        backgroundColor = Color.Yellow
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.group),
                contentDescription = "App Logo",
                modifier = Modifier
                    .weight(1f)
                    .size(80.dp),
            )
            Card(
                Modifier
                    .weight(2f)
                    .padding(8.dp),
                shape = RoundedCornerShape(32.dp),
            ){
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(text = "Welcome Back!", fontWeight = FontWeight.Bold, fontSize = 32.sp)
                    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                        Spacer(modifier = Modifier.weight(1f))
                        MyTextField(
                            label = "Username",
                            value = myViewModel.username,
                            onValueChanged = {myViewModel.onUsernameChanged(it)},
                            trailingIconView = myViewModel.trailingIconView
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        MyTextField(
                            label = "Password",
                            keyboard =  KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                            visualTrans = myViewModel.test(),
                            value = myViewModel.password,
                            onValueChanged = {myViewModel.onPasswordChanged(it)},
                            trailingIconView = myViewModel.trailingPeekIcon
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
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {
                                navController.navigate(route = DETAIL_GRAPH_ROUTE)
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            enabled = myViewModel.isFormValid
                        ) {
                            Text(
                                text = "Login",
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            TextButton(onClick = {}) {
                                Text(text = "Sign Up")
                            }
                            TextButton(onClick = { }) {
                                Text(text = "Forgot Password?", color = Color.Gray)
                            }
                        }

                    }
                }
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
    onValueChanged:(String) -> Unit,
    trailingIconView: @Composable () -> Unit = {},
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = { Text(label)},
        visualTransformation = visualTrans,
        keyboardOptions = keyboard,
        singleLine = true,
        trailingIcon = if (value.isNotBlank()) trailingIconView else null
    )
}

class LoginViewModel: ViewModel(){
    //State
    var username by mutableStateOf("")
    var password by mutableStateOf("")
    var isPasswordVisible by mutableStateOf(false)

    val trailingIconView = @Composable {
        IconButton(
            onClick = {
                username = ""
            },
        ) {
            Icon(
                Icons.Default.Clear,
                contentDescription = "",
                tint = Black
            )
        }
    }
    val trailingPeekIcon = @Composable {
        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
            Icon(
                imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                contentDescription = "Password Toggle"
            )
        }
    }
    val isFormValid by derivedStateOf {
        username.isNotBlank() && password.length >= 7
    }
    //event
    fun test(): VisualTransformation{
        if (isPasswordVisible) return VisualTransformation.None else return PasswordVisualTransformation()
    }
    fun onUsernameChanged(newString: String){
        username = newString
    }
    fun onPasswordChanged(newString: String){
        password = newString
    }
}

@Composable
@Preview(showBackground = false)
fun Display3(){
    LoginScreen(navController = rememberNavController(), myViewModel = LoginViewModel())
}

