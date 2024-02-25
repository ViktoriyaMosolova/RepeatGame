package com.example.exercise3.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.exercise3.model.UserProgress

@Composable
fun RestartPage(paddingValues: PaddingValues, userProcess: UserProgress, onClick: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize().padding(paddingValues), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick), contentAlignment = Alignment.Center) {
            Column(modifier = Modifier
                .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Text(text = "Restart", color = Color.DarkGray, fontSize = 100.sp)
                InfoText(userProcess)
            }
        }
    }
}
