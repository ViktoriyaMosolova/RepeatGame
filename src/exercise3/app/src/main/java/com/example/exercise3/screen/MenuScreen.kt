package com.example.exercise3.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercise3.R

@Composable
fun MenuScreen(changeNavigation: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ButtonMenu(R.string.basic_game_title) { changeNavigation("basic_game") }
        ButtonMenu(R.string.free_game_title) { changeNavigation("free_game") }
        ButtonMenu(R.string.about_title) { changeNavigation("about") }
    }
}

@Composable
fun ButtonMenu(strRes: Int, changeNavigation: () -> Unit) {
    Button(onClick = { changeNavigation() }, modifier = Modifier.padding(bottom = 16.dp), colors = ButtonDefaults.buttonColors(Color.Gray)) {
        Text(text = stringResource(id = strRes), fontSize = 30.sp)
    }
}