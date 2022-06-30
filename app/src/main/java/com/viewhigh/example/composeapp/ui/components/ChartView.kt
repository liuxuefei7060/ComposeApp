package com.viewhigh.example.composeapp.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp


/**
 * 折线图
 */
@Composable
fun ChartView(points: List<Float>, modifier: Modifier) {

    //每一行的高度
    val heightForRow = 24
    //总行数
    val countForRow = 5

    //小圆圈的半径
    val circleRadius = 2.5


    //画布的宽度 = 屏幕宽度 - padding * 2
    val canvasWidth = LocalConfiguration.current.screenWidthDp - 8 * 2

    val perY = 8  //24
    //7平分的宽度
    val averageOfWidth = canvasWidth / 7
    //画布的高度
    val canvasHeight = heightForRow * countForRow + circleRadius * 2
    Canvas(
        modifier = modifier.size(
            width = canvasWidth.dp,
            height = canvasHeight.dp
        )
    ) {
        //背景横线
        for (index in 0..countForRow) {
            val y = (heightForRow * index + circleRadius).dp.toPx()
            drawLine(Color(0xFFEEEEEE), start = Offset(0f, y), end = Offset(size.width, y))
        }
        //画圆点，折线

        for (index in 0 until points.count()) {
            val circleCenter = Offset(
                (averageOfWidth * index + averageOfWidth / 2).dp.toPx(),
                (heightForRow * countForRow - points[index] * perY + circleRadius).dp.toPx()
            )
            drawCircle(
                Color(0xFF149EE7),
                radius = circleRadius.dp.toPx(),
                center = circleCenter,
                style = Stroke(4f)
            )

            if (index < points.count() - 1) {
                val nextPointCenter = Offset(
                    (averageOfWidth * (index + 1) + averageOfWidth / 2).dp.toPx(),
                    (heightForRow * countForRow - points[(index + 1)] * perY + circleRadius).dp.toPx()
                )
                drawLine(
                    Color(0xFF149EE7),
                    start = circleCenter,
                    end = nextPointCenter,
                    strokeWidth = 5f
                )
            }
        }
        


    }


}