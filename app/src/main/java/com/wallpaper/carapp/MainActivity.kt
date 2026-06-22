package com.wallpaper.carapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.wallpaper.carapp.ui.theme.CarWallpaperTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            CarWallpaperTheme {

                val navController = rememberNavController()


                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {


                    composable("home") {

                        HomeScreen(

                            onWallpaperClick = { imageRes ->

                                navController.navigate(
                                    "detail/$imageRes"
                                )

                            },


                            onSettingsClick = {

                                navController.navigate(
                                    "settings"
                                )

                            }

                        )
                    }



                    composable("settings") {


                        SettingsScreen(

                            // 정보 페이지
                            onInfoClick = {

                                navController.navigate(
                                    "info"
                                )

                            },


                            // 개발자 페이지
                            onDeveloperClick = {

                                navController.navigate(
                                    "developer"
                                )

                            },


                            // 라이선스 페이지
                            onLicenseClick = {

                                navController.navigate(
                                    "license"
                                )

                            }

                        )

                    }



                    composable("info") {

                        InfoScreen(

                            // 기존 비밀기능 유지
                            onSecretClick = {

                                navController.navigate(
                                    "secret"
                                )

                            }

                        )

                    }



                    composable("developer") {

                        DeveloperScreen()

                    }



                    composable("license") {

                        LicenseScreen()

                    }



                    composable("secret") {

                        WebViewScreen()

                    }



                    composable(
                        route = "detail/{imageRes}",
                        arguments = listOf(

                            navArgument("imageRes") {

                                type = NavType.IntType

                            }

                        )

                    ) { backStackEntry ->


                        val imageRes =

                            backStackEntry.arguments?.getInt("imageRes")
                                ?: R.drawable.ic_launcher_background



                        DetailScreen(

                            imageRes = imageRes

                        )

                    }

                }
            }
        }
    }
}
