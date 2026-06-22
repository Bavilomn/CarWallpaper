package com.wallpaper.carapp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun LicenseScreen(){

    Text(
        text = """
        오픈소스 라이선스
        
        본 앱은 일부 오픈소스 라이브러리를 사용합니다.
        
        AndroidX
        Jetpack Compose
        Kotlin
        
        © 2026 CarApp
        """.trimIndent()
    )

}