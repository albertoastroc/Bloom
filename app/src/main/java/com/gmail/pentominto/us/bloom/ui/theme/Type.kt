package com.gmail.pentominto.us.bloom.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.gmail.pentominto.us.bloom.R

val nunitoFontFamily = FontFamily(
    Font(R.font.nunitosans_bold, weight = FontWeight.Bold),
    Font(R.font.nunitosans_light, weight = FontWeight.Light),
    Font(R.font.nunitosans_semibold, weight = FontWeight.SemiBold)
)


// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = nunitoFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = nunitoFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp
    ),
    h1 = TextStyle(
        fontFamily = nunitoFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    h2 = TextStyle(
        fontFamily = nunitoFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = .15.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = nunitoFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = nunitoFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 1.sp
    ),
    caption = TextStyle(
        fontFamily = nunitoFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    )
)