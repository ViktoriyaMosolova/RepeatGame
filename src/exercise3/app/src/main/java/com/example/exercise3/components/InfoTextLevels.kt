package com.example.exercise3.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercise3.model.UserProgress

@Composable
fun InfoText(info: UserProgress) {
    Column(modifier = Modifier
        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Level: ${info.level}",
            fontSize = 40.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Best Level: ${info.bestLevel}",
            fontSize = 40.sp,
            color = Color.Gray
        )
    }
}