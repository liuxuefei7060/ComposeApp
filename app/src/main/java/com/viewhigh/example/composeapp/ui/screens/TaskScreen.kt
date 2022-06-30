package com.viewhigh.example.composeapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.insets.systemBarsPadding
import com.viewhigh.example.composeapp.ui.components.ChartView
import com.viewhigh.example.composeapp.ui.components.CircleRing
import com.viewhigh.example.composeapp.ui.components.appBarHeight
import com.viewhigh.example.composeapp.ui.theme.Blue700
import com.viewhigh.example.composeapp.viewmodel.TaskViewModel

@Composable
fun TaskScreen(taskVM: TaskViewModel = viewModel()) {

    //圆环的高度
    var boxWidthDp: Int
    with(LocalConfiguration.current) {
        boxWidthDp = screenWidthDp / 2
    }

    LaunchedEffect(taskVM.pointOfYearPercent) {
        taskVM.updatePointPercent()
    }

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
        //标题栏
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
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                // 学习周期
                Text(
                    text = taskVM.taskDate,
                    color = Color.White,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            //进度圆环
            item {
                Box(
                    modifier = Modifier
                        .height(boxWidthDp.dp)
                        .padding(top = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    //圆环
                    CircleRing(boxWidthDp, taskVM.pointOfYearPercent)
                    //进度数据
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(top = (1).dp)
                            .offset(y = (-16).dp)
                    ) {
                        Text(
                            buildAnnotatedString {
                                append(taskVM.pointOfYear.toString())
                                withStyle(SpanStyle(fontSize = 12.sp)) {
                                    append("分")
                                }
                            },
                            color = Color.White,
                            fontSize = 36.sp,
                        )
                        Text(text = "学年积分", fontSize = 12.sp, color = Color.White)
                    }
                }
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-50).dp)
                ) {
                    Column() {
                        Text(
                            text = "${taskVM.totalPointOfYear}分",
                            fontSize = 16.sp,
                            color = Color.White
                        )
                        Text(
                            text = "学年规定分", fontSize = 16.sp,
                            color = Color.White
                        )
                    }
                    Column() {
                        Text(
                            text = "${taskVM.totalPointOfYear - taskVM.pointOfYear}分",
                            fontSize = 16.sp,
                            color = Color.White
                        )
                        Text(
                            text = "还差", fontSize = 16.sp,
                            color = Color.White
                        )
                    }
                }
            }
            //学习明细

            item {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .padding(horizontal = 8.dp, vertical = 8.dp)

                ) {
                    Text(
                        text = "学习明细",
                        fontSize = 16.sp, color = Color(0xFF333333)
                    )
                    Text(
                        modifier = Modifier.padding(vertical = 8.dp),
                        text = "最近一周获得积分情况",
                        fontSize = 14.sp, color = Color(0xFF999999)
                    )
                    //积分的折线图
                    ChartView(taskVM.pointsOfWeek)
                }
            }
        }

    }
}


@Preview
@Composable
fun TaskScreenPreview() {
    TaskScreen()
}