package com.hulusimsek.a6_sayitahmin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@Composable
fun GameOver(modifier: Modifier = Modifier, navController: NavController, result: Boolean) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Oyun bitti")
        if(result) {
            Image(painter = painterResource(id = R.drawable.baseline_mood_24), contentDescription = "")

        }
        else {
            Image(painter = painterResource(id = R.drawable.baseline_mood_bad_24), contentDescription = "")

        }
        Button(onClick = {navController.navigate("gamescreen")}) {
            Text(text = "Oyuna Başla")
        }
    }
}