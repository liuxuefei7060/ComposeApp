package com.viewhigh.example.composeapp.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.viewhigh.example.composeapp.model.entity.VideoEntity
import com.viewhigh.example.composeapp.ui.screens.TaskScreen

/**
 * desc :
 *
 * @author:  Liu XueFei
 * @email:   liuxuefei@viewhigh.com
 * @date:    2022/4/25 17:48
 *
 */


@Composable
fun CircleRing(boxWidthDp: Int, pointOfYearPercent : Float) {

    Canvas(modifier = Modifier.size(boxWidthDp.dp)) {


        drawArc(
            Color(0, 0, 10, 33),
            startAngle = 0f + 170f, sweepAngle = 200f, useCenter = false,
            style = Stroke(30f, cap = StrokeCap.Round)
        )

        drawArc(
            Color.White,
            startAngle = 0f + 170f, sweepAngle = pointOfYearPercent, useCenter = false,
            style = Stroke(30f, cap = StrokeCap.Round)
        )
    }

}

@Preview
@Composable
fun TaskScreenPreview() {
    CircleRing(100, 140f)
}
