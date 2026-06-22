package com.wallpaper.carapp

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebViewScreen() {

    AndroidView(
        factory = { context ->

            WebView(context).apply {

                webViewClient = WebViewClient()

                settings.javaScriptEnabled = true

                loadUrl(
                    "https://naver.com"
                )
            }
        }
    )
}