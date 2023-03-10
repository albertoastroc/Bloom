package com.gmail.pentominto.us.bloom

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gmail.pentominto.us.bloom.ui.theme.Gray
import com.gmail.pentominto.us.bloom.ui.theme.Shapes

@Composable
fun LoginScreen(
    onLoginClick : () -> Unit
) {

    val isDarkTheme = isSystemInDarkTheme()

    var emailState by remember { mutableStateOf("") }
    var passwordState by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            LoginHeader()

            EmailTextField(emailState)

            PasswordTextField(passwordState)

            TOUMessage()

            LoginButton(onLoginClick)
        }
    }
}

@Composable
private fun LoginHeader() {
    Text(
        text = "Log in with email",
        modifier = Modifier.paddingFromBaseline(
            bottom = 16.dp
        ),
        style = MaterialTheme.typography.h1
    )
}

@Composable
private fun TOUMessage() {
    Text(
        text = "By clicking below, you agree to our Terms of Use and consent to our Privacy Policy.",
        modifier = Modifier
            .paddingFromBaseline(
                top = 24.dp,
                bottom = 16.dp
            )
            .padding(horizontal = 16.dp),
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun EmailTextField(emailState : String) {
    var emailState1 = emailState
    OutlinedTextField(
        value = emailState1,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                bottom = 8.dp,
                start = 16.dp,
                end = 16.dp
            ),
        onValueChange = { emailState1 = it },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colors.onBackground,
            disabledTextColor = Color.Transparent,
            backgroundColor = MaterialTheme.colors.background,
            focusedBorderColor = MaterialTheme.colors.onBackground,
            unfocusedBorderColor = MaterialTheme.colors.onBackground,
        ),
        placeholder = {
            Text(
                text = "Email address",
                style = MaterialTheme.typography.body1
            )
        }
    )
}

@Composable
private fun PasswordTextField(passwordState : String) {
    var passwordState1 = passwordState
    OutlinedTextField(
        value = passwordState1,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                bottom = 8.dp,
                start = 16.dp,
                end = 16.dp
            ),
        onValueChange = { passwordState1 = it },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colors.onBackground,
            disabledTextColor = Color.Transparent,
            backgroundColor = MaterialTheme.colors.background,
            focusedBorderColor = MaterialTheme.colors.onBackground,
            unfocusedBorderColor = MaterialTheme.colors.onBackground,
        ),
        placeholder = {
            Text(
                text = "Password (8+ characters)",
                style = MaterialTheme.typography.body1
            )
        }
    )
}

@Composable
private fun LoginButton(onLoginClick : () -> Unit) {
    Button(
        onClick = { onLoginClick() },
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
            .padding(
                bottom = 8.dp,
                start = 16.dp,
                end = 16.dp
            ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor = MaterialTheme.colors.onSecondary
        ),
        shape = Shapes.medium
    )
    {

        Text(
            text = "Log in",
            modifier = Modifier
        )
    }
}