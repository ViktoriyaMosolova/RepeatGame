package com.example.exercise3.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.exercise3.model.StatusType
import com.example.exercise3.model.UserProgress
import com.example.exercise3.utils.Music


@Composable
fun GetUserSequence(paddingValues: PaddingValues, userProcess: UserProgress, gameState: StatusType, updateStatus: (StatusType) -> Unit) {
    var currentSelectedElement = -1
    val context = LocalContext.current
    var playMusic by remember { mutableStateOf(false) }
    ShowButtonBox(paddingValues, userProcess, gameState, currentSelectedElement, updateStatus) {
        playMusic = !playMusic
        Music.playAudio(context, it)
    }
}