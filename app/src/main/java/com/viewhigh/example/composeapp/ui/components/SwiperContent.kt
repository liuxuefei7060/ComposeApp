package com.viewhigh.example.composeapp.ui.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
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
fun SwiperContent(viewModel: MainViewModel) {
    //实际页数
    val actualCount = viewModel.swiperData.size
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
        }, 3000, 3000)
        onDispose {
            timer.cancel()
        }
    }

    HorizontalPager(
        count = virtualCount,
        state = pagerState,
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(8.dp))
    ) { index ->
        AsyncImage(
            model = viewModel.swiperData[index % actualCount].url,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(7 / 3f),
            contentScale = ContentScale.Crop
        )
    }

}