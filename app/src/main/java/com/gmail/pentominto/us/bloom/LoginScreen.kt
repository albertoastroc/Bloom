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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Log in with email",
                modifier = Modifier.paddingFromBaseline(
                    top = 184.dp,
                    bottom = 8.dp
                ),
                style = MaterialTheme.typography.h1
            )

            OutlinedTextField(
                value = emailState,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = 8.dp,
                        start = 16.dp,
                        end = 16.dp
                    ),
                onValueChange = { emailState = it },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.Gray,
                    disabledTextColor = Color.Transparent,
                    backgroundColor = Color.White,
                    focusedBorderColor = Gray,
                    unfocusedBorderColor = Gray,
                ),
                placeholder = {
                    Text(
                        text = "Email address",
                        style = MaterialTheme.typography.body1
                    )
                }
            )

            OutlinedTextField(
                value = passwordState,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = 8.dp,
                        start = 16.dp,
                        end = 16.dp
                    ),
                onValueChange = { passwordState = it },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.Gray,
                    disabledTextColor = Color.Transparent,
                    backgroundColor = Color.White,
                    focusedBorderColor = Gray,
                    unfocusedBorderColor = Gray,
                ),
                placeholder = {
                    Text(
                        text = "Password (8+ characters)",
                        style = MaterialTheme.typography.body1
                    )
                }
            )

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
    }
}