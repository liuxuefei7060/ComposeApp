package com.viewhigh.example.composeapp.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.viewhigh.example.composeapp.ui.components.TopAppBar

@Composable
fun MineScreen(statusBarHeight: Int) {
    TopAppBar(statusBarHeight) {
        Text(text = "我的")
    }

}