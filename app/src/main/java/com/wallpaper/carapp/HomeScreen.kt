package com.wallpaper.carapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onWallpaperClick: (Int) -> Unit = {},
    onSettingsClick: () -> Unit = {}
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Car Wallpapers")
                },
                actions = {
                    Text(
                        text = "⋮",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable {
                                onSettingsClick()
                            }
                    )
                }
            )
        }
    ) { paddingValues ->

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            items(
                WallpaperRepository.wallpapers
            ) { wallpaper ->

                Image(
                    painter = painterResource(
                        id = wallpaper.imageRes
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable {
                            onWallpaperClick(
                                wallpaper.imageRes
                            )
                        }
                )
            }
        }
    }
}