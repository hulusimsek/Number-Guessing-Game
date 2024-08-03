package com.hulusimsek.a6_sayitahmin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hulusimsek.a6_sayitahmin.ui.theme._6_SayiTahminTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _6_SayiTahminTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SayfaGecisleri(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SayfaGecisleri(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "homepage") {
        composable("homepage") {
            HomePage(navController = navController, modifier = modifier)
        }
        composable("gamescreen") {
            GameScreen(navController = navController, modifier = modifier)
        }
        composable("gameover/{result}",
            arguments = listOf(
                navArgument("result") { type = NavType.BoolType }
            )) {
            val result = it.arguments?.getBoolean("result")!!
            GameOver(navController = navController, modifier = Modifier, result = result)
        }
    }
}

@Composable
fun HomePage(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tahmin Oyunu")
        Image(
            painter = painterResource(id = R.drawable.baseline_casino_24),
            contentDescription = ""
        )
        Button(onClick = { navController.navigate("gamescreen") }) {
            Text(text = "Oyuna Başla")
        }
    }
}
