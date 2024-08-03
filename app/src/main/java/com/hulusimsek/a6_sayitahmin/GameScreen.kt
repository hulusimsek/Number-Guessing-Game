package com.hulusimsek.a6_sayitahmin

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import kotlin.random.Random

@Composable
fun GameScreen(modifier: Modifier = Modifier, navController: NavController) {
    var remaining = remember {
        mutableStateOf(5)
    }
    var help = remember {
        mutableStateOf("")
    }
    var guess = remember {
        mutableStateOf("")
    }
    var number = remember {
        mutableStateOf(0)
    }

    fun makeGuess() {
        remaining.value -= 1
        if(guess.value.toInt() == number.value) {
            navController.navigate("gameover/true") {popUpTo("gamescreen") {inclusive=true} }
        }
        else if(guess.value.toInt() > number.value) {
            help.value = "Daha düşük bir tahmin yapın"
        }
        else if(guess.value.toInt() < number.value) {
            help.value = "Daha yüksek bir tahmin yapın"
        }
        if(remaining.value==0) {
            navController.navigate("gameover/false") {popUpTo("gamescreen") {inclusive=true} }
        }
    }
    LaunchedEffect(key1 = true) {
        number.value = Random.nextInt(100)
        Log.e("hile",number.value.toString())
    }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Kalan Hak: ${remaining.value}")
        Text(text = "Yardım: ${help.value}")
        TextField(
            value = guess.value,
            onValueChange = { guess.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            keyboardActions = KeyboardActions(onDone = { makeGuess() }),
            label = { Text(text = "Tahmin: ") })
        Button(onClick = {
            makeGuess()
        }) {
            Text(text = "Tahmin et")
        }
    }
}