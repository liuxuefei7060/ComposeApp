package com.viewhigh.example.composeapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.viewhigh.example.composeapp.model.entity.ArticleEntity

/**
 * desc :
 *
 * @author:  Liu XueFei
 * @email:   liuxuefei@viewhigh.com
 * @date:    2022/4/25 17:48
 *
 */
@Composable
fun ArticleItem(entity: ArticleEntity) {

    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            entity.title,
            color = Color(0xFF333333),
            fontSize = 16.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text(
                entity.source,
                color = Color(0xFF999999),
                fontSize = 10.sp,
                maxLines = 1,
            )
            Text(
                entity.timestamp,
                color = Color(0xFF999999),
                fontSize = 10.sp,
                maxLines = 1,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Divider()
    }
}
