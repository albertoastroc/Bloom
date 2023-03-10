@file:OptIn(ExperimentalGlideComposeApi::class)

package com.gmail.pentominto.us.bloom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.gmail.pentominto.us.bloom.ui.theme.Gray
import com.gmail.pentominto.us.bloom.ui.theme.Shapes
import com.gmail.pentominto.us.bloom.ui.theme.White

@Composable
fun HomeScreen() {

    val themesList = listOf<Pair<Int, String>>(
        R.drawable.jungle_vibes to "Jungle vibes",
        R.drawable.desert_chic to "Desert chic",
        R.drawable.easy_care to "Easy care",
        R.drawable.statements to "Statements",
        R.drawable.tiny_terrariums to "Tiny terrariums"
    )

    //Added themes items to have enough to scroll
    val plantsList = listOf<Pair<Int, String>>(
        R.drawable.aglaonema to "Aglaonema",
        R.drawable.fiddle_leaf to "Fiddle Leaf",
        R.drawable.peace_lily to "Peace Lily",
        R.drawable.snake_plant to "Snake Plant",
        R.drawable.monstera to "Monstera",
        R.drawable.pothos to "Pothos",
        R.drawable.jungle_vibes to "Jungle vibes",
        R.drawable.desert_chic to "Desert chic",
        R.drawable.easy_care to "Easy care",
        R.drawable.statements to "Statements",
        R.drawable.tiny_terrariums to "Tiny terrariums"
    )

    val bottomNavChoices = listOf<Pair<ImageVector, String>>(
        Icons.Filled.Home to "Home",
        Icons.Filled.FavoriteBorder to "Favorites",
        Icons.Filled.AccountCircle to "Profile",
        Icons.Filled.ShoppingCart to "Cart",
    )

    Scaffold(
        bottomBar = {

            BottomNavigation(
                backgroundColor = MaterialTheme.colors.primary,
                elevation = 16.dp
            ) {

                bottomNavChoices.forEach { icon ->

                    BottomNavItem(icon)

                }
            }
        }
    ) { padding ->

        Surface(
            modifier = Modifier.padding(padding),
            color = MaterialTheme.colors.background
        ) {

            Column() {

                SearchBar()

                ThemesRow(themesList)

                PlantsList(plantsList)
            }
        }

    }
}

@Composable
private fun RowScope.BottomNavItem(icons : Pair<ImageVector, String>) {

    val selected = icons.second == "Home"

    BottomNavigationItem(
        selected = selected,
        onClick = { },
        icon = {
            Icon(
                imageVector = icons.first,
                contentDescription = "Home",
            )
        },
        label = { Text(
            text = icons.second,
            style = MaterialTheme.typography.caption
        ) },
    )
}

@Composable
private fun PlantsList(plantsList : List<Pair<Int, String>>) {

    PlantsHeader()

    PlantsColumn(plantsList)
}

@Composable
private fun PlantsColumn(plantsList : List<Pair<Int, String>>) {
    LazyColumn(
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp
            ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        items(plantsList) { item ->

            val isChecked = remember { mutableStateOf(false) }

            PlantsColumnRow(
                item,
                isChecked
            )
        }
    }
}

@Composable
private fun PlantsColumnRow(item : Pair<Int, String>, isChecked : MutableState<Boolean>) {

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        GlideImage(
            model = item.first,
            contentScale = ContentScale.FillBounds,
            contentDescription = "plant image",
            modifier = Modifier
                .height(64.dp)
                .width(64.dp)
        )

        Column {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Column(

                    modifier = Modifier
                        .padding(start = 16.dp),
                    horizontalAlignment = Alignment.Start
                ) {

                    Text(
                        text = item.second,
                        style = MaterialTheme.typography.h2
                    )
                    Text(
                        text = "This is a description",
                        style = MaterialTheme.typography.body1
                    )
                }

                Checkbox(
                    checked = isChecked.value,
                    onCheckedChange = { isChecked.value = it },
                    modifier = Modifier.offset(x = 12.dp),
                    colors = CheckboxDefaults.colors(
                     checkmarkColor = MaterialTheme.colors.background
                    )

                    )
            }

            Divider(
                color = MaterialTheme.colors.onBackground,
                thickness = 1.dp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

    }
}

@Composable
private fun PlantsHeader() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
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
}

@Composable
private fun ThemesRow(themesList : List<Pair<Int, String>>) {

    Text(
        text = "Browse themes",
        modifier = Modifier
            .paddingFromBaseline(
                top = 32.dp,
                bottom = 16.dp
            )
            .padding(horizontal = 16.dp),
        style = MaterialTheme.typography.h1
    )

    ThemesRowItem(themesList)
}

@Composable
private fun ThemesRowItem(themesList : List<Pair<Int, String>>) {

    LazyRow(
        modifier = Modifier.height(136.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {

        items(themesList) { item ->

            Card(
                shape = Shapes.small,
                elevation = 4.dp
            ) {

                Column() {

                    GlideImage(
                        model = item.first,
                        contentScale = ContentScale.FillBounds,
                        contentDescription = "theme image",
                        modifier = Modifier
                            .height(96.dp)
                            .width(128.dp)
                    )
                    Box(
                        modifier = Modifier
                            .background(MaterialTheme.colors.surface)
                            .width(128.dp)
                            .height(40.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = item.second,
                            style = MaterialTheme.typography.h2
                        )
                    }

                }
            }
        }
    }
}

@Composable
private fun SearchBar() {

    var searchState by remember { mutableStateOf("") }

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
            textColor = MaterialTheme.colors.onBackground,
            disabledTextColor = Color.Transparent,
            backgroundColor = MaterialTheme.colors.background,
            focusedBorderColor = MaterialTheme.colors.onBackground,
            unfocusedBorderColor = MaterialTheme.colors.onBackground,
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
}