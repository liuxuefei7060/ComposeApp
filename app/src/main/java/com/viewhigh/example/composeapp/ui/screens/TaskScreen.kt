package com.viewhigh.example.composeapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.google.accompanist.insets.systemBarsPadding
import com.viewhigh.example.composeapp.ui.components.TopAppBar
import com.viewhigh.example.composeapp.ui.components.appBarHeight
import com.viewhigh.example.composeapp.ui.theme.Blue200
import com.viewhigh.example.composeapp.ui.theme.Blue700

@Composable
fun TaskScreen() {
//    TopAppBar() {
//        Text(text = "任务")
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(
                        Blue700,
                        Color.White
                    )
                )
            )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .systemBarsPadding(start = true, bottom = false)
                .height(appBarHeight),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "任务",
                fontSize = 18.sp,
                color = Color.White
            )
        }


    }
}