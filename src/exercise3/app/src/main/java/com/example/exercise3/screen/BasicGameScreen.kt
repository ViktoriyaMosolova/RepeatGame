package com.example.exercise3.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.exercise3.components.GetUserSequence
import com.example.exercise3.components.RestartPage
import com.example.exercise3.components.ShowSequence
import com.example.exercise3.model.BasicGameStatus
import com.example.exercise3.model.StatusType
import com.example.exercise3.model.UserProgress
import com.example.exercise3.model.Sequence

@Composable
fun BasicGameScreen(
    paddingValues: PaddingValues,
    changeSharedBestLevel: (Int) -> Unit,
) {
    var gameStatus by remember { mutableStateOf(BasicGameStatus.status) }
    var sequence by remember { mutableStateOf(Sequence.base) }
    var userProgress by remember { mutableStateOf(UserProgress) }
    when (gameStatus) {
        StatusType.SHOW_SEQUENCE -> ShowSequence(paddingValues, userProgress, gameStatus, sequence) {
            gameStatus = it
        }
        StatusType.GET_USER_SEQUENCE -> GetUserSequence(paddingValues, userProgress, gameStatus) {
            when(it) {
                StatusType.SHOW_SEQUENCE -> {
                    userProgress.level++
                    userProgress.bestLevel = maxOf(userProgress.level-1, userProgress.bestLevel)
                    Sequence.setSequenceForNextLevel()
                    sequence = Sequence.base
                }
                StatusType.RESTART_PAGE -> {
                    Sequence.setInitSequences()
                    sequence = Sequence.base
                    userProgress.level = userProgress.level-1
                }
                else -> {}
            }
            gameStatus = it
        }
        StatusType.RESTART_PAGE -> RestartPage(paddingValues, userProgress) {
            Sequence.setInitSequences()
            sequence = Sequence.base
            userProgress.bestLevel = maxOf(userProgress.level-1, userProgress.bestLevel)
            userProgress.level = 1
            gameStatus = StatusType.SHOW_SEQUENCE
        }
    }
    changeSharedBestLevel(userProgress.bestLevel)
}