package com.example.exercise3.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.exercise3.model.ButtonList
import com.example.exercise3.model.StatusType
import com.example.exercise3.model.UserProgress

@Composable
fun ShowButtonBox(paddingValues: PaddingValues, userProcess: UserProgress, gameState: StatusType, currentSelectedElement: Int, updateStatus: (StatusType) -> Unit, playMusic: (Int) -> Unit = {}) {
    Box(modifier = Modifier.fillMaxSize().padding(paddingValues), contentAlignment = Alignment.BottomCenter) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row {
                MusicButton(gameState, ButtonList.BUTTON1, currentSelectedElement == ButtonList.BUTTON1.number-1, updateStatus, playMusic)
                MusicButton(gameState, ButtonList.BUTTON2, currentSelectedElement == ButtonList.BUTTON2.number-1, updateStatus, playMusic)
            }
            Row {
                MusicButton(gameState, ButtonList.BUTTON3, currentSelectedElement == ButtonList.BUTTON3.number-1, updateStatus, playMusic)
                MusicButton(gameState, ButtonList.BUTTON4, currentSelectedElement == ButtonList.BUTTON4.number-1, updateStatus, playMusic)
            }
            InfoText(userProcess)
        }
    }
}