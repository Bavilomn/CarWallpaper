package com.wallpaper.carapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(
    onSecretClick: () -> Unit = {},
    onDeveloperClick: () -> Unit = {},
    onLicenseClick: () -> Unit = {}
) {

    var clickCount by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "설정"
        )


        Spacer(
            modifier = Modifier.height(25.dp)
        )


        // 기존 숨겨진 기능
        Text(
            text = "정보",
            modifier = Modifier.clickable {

                clickCount++

                if (clickCount >= 20) {
                    clickCount = 0
                    onSecretClick()
                }
            }
        )


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        Divider()


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        Text(
            text = "앱 정보"
        )


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        Text(
            text = "자동차 배경화면 앱"
        )

        Text(
            text = "버전 1.0.0"
        )


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        Divider()


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        // 개발자 페이지 버튼
        Text(
            text = "개발자 페이지",
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onDeveloperClick()
                }
                .padding(12.dp)
        )


        Spacer(
            modifier = Modifier.height(10.dp)
        )


        // 라이선스 버튼
        Text(
            text = "오픈소스 라이선스",
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onLicenseClick()
                }
                .padding(12.dp)
        )


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        Divider()


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        Text(
            text = "저작권"
        )


        Spacer(
            modifier = Modifier.height(8.dp)
        )


        Text(
            text = "© 2026 CarApp. All rights reserved."
        )
    }
}