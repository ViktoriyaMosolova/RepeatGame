package com.example.exercise3.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercise3.model.ButtonList
import com.example.exercise3.model.StatusType
import com.example.exercise3.model.TypeCompareSequence
import com.example.exercise3.model.Sequence


@Composable
fun MusicButton(gameState: StatusType, button: ButtonList, isSelected: Boolean = false, updateStatus: (StatusType) -> Unit, playMusic: (Int) -> Unit) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(300.dp)
            .width(200.dp)
            .background(if (isSelected && gameState == StatusType.SHOW_SEQUENCE) Color.Black else colorResource(id = button.color))
            .clickable(
                enabled = (gameState == StatusType.GET_USER_SEQUENCE),
                onClick = {
                    playMusic(button.number)
                    when (Sequence.addElementToSequence(button.number - 1)) {
                        TypeCompareSequence.CONTINUE -> updateStatus(StatusType.GET_USER_SEQUENCE)
                        TypeCompareSequence.WIN -> updateStatus(StatusType.SHOW_SEQUENCE)
                        TypeCompareSequence.LOSE -> updateStatus(StatusType.RESTART_PAGE)
                    }
                }
            )
    ) {
        Text(text = button.number.toString(), fontSize = 80.sp, color = Color.White)
    }
}