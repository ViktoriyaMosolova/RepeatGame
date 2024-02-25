package com.example.exercise3.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercise3.model.ButtonList
import com.example.exercise3.utils.Music

@Composable
fun FreeGameScreen(paddingValues: PaddingValues) {
    Box(modifier = Modifier.fillMaxSize().padding(paddingValues), contentAlignment = Alignment.BottomCenter) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row {
                MusicButton(ButtonList.BUTTON1)
                MusicButton(ButtonList.BUTTON2)
            }
            Row {
                MusicButton(ButtonList.BUTTON3)
                MusicButton(ButtonList.BUTTON4)
            }
        }
    }
}

@Composable
fun MusicButton(button: ButtonList) {
    val context = LocalContext.current
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(300.dp)
            .width(200.dp)
            .background(colorResource(id = button.color))
            .clickable(
                onClick = {
                    Music.playAudio(context, button.number)
                }
            )
    ) {
        Text(text = button.number.toString(), fontSize = 80.sp, color = Color.White)
    }
}
