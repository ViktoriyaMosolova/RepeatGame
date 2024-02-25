package com.example.exercise3.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercise3.R

@Composable
fun AboutScreen(paddingValues: PaddingValues, record: Int) {
    val rainbowColors = listOf(colorResource(id = R.color.button1), colorResource(id = R.color.button2), colorResource(id = R.color.button3), colorResource(id = R.color.button4))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(
                Brush.verticalGradient(rainbowColors)
            )
            .padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = stringResource(id = R.string.about_record, record),
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White // Set a default color
            ),
            modifier = Modifier
                .padding(top = 16.dp)
        )
        Text(
            text = stringResource(id = R.string.about_rules),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White // Set a default color
            ),
            modifier = Modifier
                .padding(top = 16.dp)
                .width(350.dp)
        )
        Text(
            text = stringResource(id = R.string.about_author),
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White // Set a default color
            ),
            modifier = Modifier
                .padding(top = 16.dp)
        )
    }
}