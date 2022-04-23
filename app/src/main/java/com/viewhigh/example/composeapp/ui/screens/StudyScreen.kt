package com.viewhigh.example.composeapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.viewhigh.example.composeapp.ui.components.TopAppBar

@Composable
fun StudyScreen() {

    Column() {


        TopAppBar() {
            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .weight(1f),
                color = Color(0x33FFFFFF)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null,
                        tint = Color.White,

                        )
                    Text(
                        text = "搜索感兴趣的咨询或课程",
                        fontSize = 12.sp,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

            }
            Text(
                text = "学习\n进度",
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp)
            )
            Text(
                text = "26%",
                color = Color.White,
                modifier = Modifier.padding(start = 6.dp)
            )
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = null,
                tint = Color.White, modifier = Modifier.padding(start = 6.dp)
            )
        }
    }
}