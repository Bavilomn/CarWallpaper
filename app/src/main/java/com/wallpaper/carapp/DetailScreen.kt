package com.wallpaper.carapp

import android.app.WallpaperManager
import android.graphics.BitmapFactory
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(
    imageRes: Int
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.weight(1f),
            contentScale = ContentScale.Crop
        )

        Button(
            onClick = {

                try {

                    val bitmap = BitmapFactory.decodeResource(
                        context.resources,
                        imageRes
                    )

                    WallpaperManager
                        .getInstance(context)
                        .setBitmap(bitmap)

                    Toast.makeText(
                        context,
                        "배경화면 설정 완료",
                        Toast.LENGTH_SHORT
                    ).show()

                } catch (e: Exception) {

                    Toast.makeText(
                        context,
                        "배경화면 설정 실패",
                        Toast.LENGTH_SHORT
                    ).show()

                }

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(
                text = "배경화면 설정"
            )

        }

    }

}