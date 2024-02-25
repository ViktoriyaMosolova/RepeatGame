package com.example.exercise3.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.exercise3.model.StatusType
import com.example.exercise3.model.UserProgress
import com.example.exercise3.utils.Music
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ShowSequence(paddingValues: PaddingValues, userProgress: UserProgress, gameState: StatusType, sequence: MutableList<Int>, updateStatus: (StatusType) -> Unit) {
    var currentSelectedElement by remember { mutableIntStateOf(-1) }
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        coroutineScope.launch {
            delay(1000)
            currentSelectedElement = -1
            sequence.forEach { element ->
                currentSelectedElement = element
                delay(500)
                Music.playAudio(context, currentSelectedElement+1)
                currentSelectedElement = -1
            }
            currentSelectedElement = -2
            updateStatus(StatusType.GET_USER_SEQUENCE)
        }
    }
    ShowButtonBox(paddingValues, userProgress, gameState, currentSelectedElement, updateStatus)
}