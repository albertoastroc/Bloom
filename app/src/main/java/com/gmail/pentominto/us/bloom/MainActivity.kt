package com.gmail.pentominto.us.bloom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gmail.pentominto.us.bloom.ui.theme.BloomTheme
import com.gmail.pentominto.us.bloom.ui.theme.Pink100
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BloomTheme {

                val systemUiController = rememberSystemUiController()

                if (isSystemInDarkTheme()) {

                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = false
                    )
                } else {

                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = true
                    )
                }

                MyAppNavHost()

            }
        }
    }
}

@Composable
fun MyAppNavHost(
    modifier : Modifier = Modifier,
    navController : NavHostController = rememberNavController(),
    startDestination : String = "welcome"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("welcome") {
            WelcomeScreen(
                onLoginClick = { navController.navigate("loginScreen") },
            )
        }
        composable("loginScreen") {

            LoginScreen(
                onLoginClick = { navController.navigate("home") },
            )
        }

        composable("home") {

            HomeScreen()
        }
    }
}