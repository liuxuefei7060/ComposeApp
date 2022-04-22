package com.viewhigh.example.composeapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.viewhigh.example.composeapp.ui.theme.Blue200
import com.viewhigh.example.composeapp.ui.theme.Blue700

/**
 * desc :
 *
 * @author:  Liu XueFei
 * @email:   liuxuefei@viewhigh.com
 * @date:    2022/4/22 12:48
 *
 */

@Composable
fun TopAppBar(statusBarHeight: Int, content: @Composable () -> Unit) {


    //标题栏高度
    val statusBarHeightDp = with(LocalDensity.current) {
        statusBarHeight.toDp()
    }
    val appBarHeight = 56.dp

    Row(
        modifier = Modifier
            .background(
                Brush.linearGradient(
                    listOf(
                        Blue700,
                        Blue200
                    )
                )
            )
            .fillMaxWidth()
            .height(appBarHeight + statusBarHeightDp)
            .padding(top = statusBarHeightDp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}


@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBar(30) {
        Text("标题")
    }
}