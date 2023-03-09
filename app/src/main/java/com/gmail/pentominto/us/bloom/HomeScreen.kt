package com.gmail.pentominto.us.bloom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gmail.pentominto.us.bloom.ui.theme.Gray
import com.gmail.pentominto.us.bloom.ui.theme.Pink100

@Composable
fun HomeScreen() {

    var searchState by remember { mutableStateOf("") }

    val themesList = listOf(
        R.drawable.jungle_vibes,
        R.drawable.desert_chic,
        R.drawable.easy_care,
        R.drawable.statements,
        R.drawable.tiny_terrariums
    )

    //Added the list twice to see scrolling
    val plantsList = listOf<Pair<Int, String>>(
        R.drawable.aglaonema to "Aglaonema",
        R.drawable.fiddle_leaf to "Fiddle Leaf",
        R.drawable.peace_lily to "Peace Lily",
        R.drawable.snake_plant to "Snake Plant",
        R.drawable.monstera to "Monstera",
        R.drawable.pothos to "Pothos",
        R.drawable.aglaonema to "Aglaonema",
        R.drawable.fiddle_leaf to "Fiddle Leaf",
        R.drawable.peace_lily to "Peace Lily",
        R.drawable.snake_plant to "Snake Plant",
        R.drawable.monstera to "Monstera",
        R.drawable.pothos to "Pothos"

    )

//    val plantsList = listOf(
//        R.drawable.aglaonema,
//        R.drawable.fiddle_leaf,
//        R.drawable.peace_lily,
//        R.drawable.snake_plant,
//        R.drawable.monstera,
//        R.drawable.pothos
//    )

    Surface() {

        Column() {

            OutlinedTextField(
                value = searchState,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp
                    ),
                onValueChange = { searchState = it },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.Gray,
                    disabledTextColor = Color.Transparent,
                    backgroundColor = Color.White,
                    focusedBorderColor = Gray,
                    unfocusedBorderColor = Gray,
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                },
                placeholder = {
                    Text(
                        text = "Search",
                        style = MaterialTheme.typography.body1
                    )
                }
            )

            Text(
                text = "Browse themes",
                modifier = Modifier
                    .paddingFromBaseline(
                        top = 32.dp,
                        bottom = 16.dp
                    )
                    .padding(horizontal = 16.dp),
//                style = MaterialTheme.typography.body2, 96
            )

            LazyRow(
                modifier = Modifier.height(136.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {

                items(themesList) { image ->

                    Column() {

                        Image(
                            painter = painterResource(id = image),
                            contentScale = ContentScale.FillBounds,
                            contentDescription = "theme image",
                            modifier = Modifier
                                .height(96.dp)
                                .width(128.dp)
                        )
                        Text(
                            text = "Desert chic",
                            modifier = Modifier
                                .background(Pink100)
                                .width(128.dp)
                                .height(40.dp),
//                            textAlign = TextAlign.Center
                        )

                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Design your home garden",
                    modifier = Modifier
                        .paddingFromBaseline(
                            top = 40.dp,
                            bottom = 8.dp
                        ),
                    style = MaterialTheme.typography.h1
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_filter_list_24),
                    contentDescription = "Sort button"
                )
            }

            LazyColumn(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                items(plantsList) { item ->

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(
                            painter = painterResource(id = item.first),
                            contentScale = ContentScale.FillBounds,
                            contentDescription = "plant image",
                            modifier = Modifier
                                .height(64.dp)
                                .width(64.dp)
                        )

                        Column(

                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.Start
                        ) {

                            Text(text = item.second)
                            Text(text = "This is a description")

                        }

                        Checkbox(
                            checked = true,
                            onCheckedChange = {},
                            modifier = Modifier
                                .height(64.dp)
                                .width(64.dp)
                        )

                    }
                }
            }
        }
    }
}