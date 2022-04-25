package com.viewhigh.example.composeapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import com.viewhigh.example.composeapp.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import java.util.*
import kotlin.concurrent.timerTask

/**
 * desc :
 *
 * @author:  Liu XueFei
 * @email:   liuxuefei@viewhigh.com
 * @date:    2022/4/25 12:20
 *
 */
@OptIn(ExperimentalPagerApi::class)
@Composable
fun NotificationsContent(viewModel: MainViewModel) {
    //实际页数
    val actualCount = viewModel.notifications.size
    //虚拟页数
    //Int范围内为实际页数的最大的偶数倍
    val virtualCount = (Int.MAX_VALUE / actualCount) / 2 * 2 * actualCount
    //初识图片下标 不能设定为Int.Max的一半，会无法滑动
    val initialIndex = virtualCount / 2048

    val pagerState = rememberPagerState(initialPage = initialIndex)

    val coroutineScope = rememberCoroutineScope()
    //定时器

    DisposableEffect(Unit) {
        val timer = Timer()
        timer.schedule(timerTask {
            coroutineScope.launch {
                pagerState.animateScrollToPage(pagerState.currentPage + 1)
            }
        }, 2000, 4000)
        onDispose {
            timer.cancel()
        }
    }

    VerticalPager(
        count = virtualCount,
        state = pagerState,
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .height(45.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0x22149EE7))
    ) { index ->
        Row(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(
                "最新活动：",
                fontSize = 14.sp,
                color = Color(0xFF149EE7),
                overflow = TextOverflow.Ellipsis
            )
            Text(
                viewModel.notifications[index % actualCount],
                maxLines = 1,
                color = Color(0xFF333333),
                fontSize = 14.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            )

            Text(
                "更多",
                fontSize = 14.sp,
                color = Color(0xFF149EE7),
                overflow = TextOverflow.Ellipsis
            )
        }

    }

}