package com.gmail.pentominto.us.bloom

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gmail.pentominto.us.bloom.ui.theme.Pink900
import com.gmail.pentominto.us.bloom.ui.theme.Shapes
import com.gmail.pentominto.us.bloom.ui.theme.White

@Composable
fun WelcomeScreen(
    onLoginClick : () -> Unit
) {

    val isDarkTheme = isSystemInDarkTheme()

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colors.primary
    ) {

        BackgroundImage(isDarkTheme)

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            WelcomeGraphic(isDarkTheme)

            WelcomeText(isDarkTheme)

            CreateAccountButton()

            LoginButton(
                isDarkTheme,
                onLoginClick
            )
        }
    }
}

@Composable
private fun BackgroundImage(isDarkTheme : Boolean) {
    Image(
        painterResource(
            id = (if (isDarkTheme) R.drawable.ic_dark_welcome_bg
            else R.drawable.ic_light_welcome_bg)
        ),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
private fun WelcomeGraphic(isDarkTheme : Boolean) {
    Image(
        painterResource(
            id = (if (isDarkTheme) R.drawable.ic_dark_welcome_illos
            else R.drawable.ic_light_welcome_illos)
        ),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .padding(
                top = 72.dp,
                bottom = 48.dp
            )
            .offset(x = 88.dp)
    )
}

@Composable
private fun WelcomeText(isDarkTheme : Boolean) {
    Image(
        painterResource(
            id = (if (isDarkTheme) R.drawable.ic_dark_logo
            else R.drawable.ic_light_logo)
        ),
        contentDescription = null,
        contentScale = ContentScale.Fit
    )

    Text(
        text = "Beautiful home garden solutions",
        modifier = Modifier.paddingFromBaseline(
            top = 32.dp,
            bottom = 40.dp
        ),
        style = MaterialTheme.typography.subtitle1,
        color = MaterialTheme.colors.onBackground
    )
}

@Composable
private fun CreateAccountButton() {
    Button(
        onClick = { /*TODO*/ },
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
            text = "Create account",
            modifier = Modifier
        )
    }
}

@Composable
private fun LoginButton(
    isDarkTheme : Boolean,
    onLoginClick : () -> Unit
) {
    Button(
        onClick = { onLoginClick() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = if (isDarkTheme) White else Pink900
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            hoveredElevation = 0.dp,
            disabledElevation = 0.dp,
            focusedElevation = 0.dp
        )
    )
    {
        Text(
            text = "Log in",
            modifier = Modifier
        )
    }
}

