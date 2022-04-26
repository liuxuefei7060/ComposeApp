package com.viewhigh.example.composeapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.viewhigh.example.composeapp.model.entity.VideoEntity
import com.viewhigh.example.composeapp.ui.components.*
import com.viewhigh.example.composeapp.ui.components.TopAppBar
import com.viewhigh.example.composeapp.viewmodel.ArticleViewModel
import com.viewhigh.example.composeapp.viewmodel.MainViewModel
import com.viewhigh.example.composeapp.viewmodel.VideoViewModel

@OptIn(ExperimentalPagerApi::class)
@Composable
fun StudyScreen(
    viewModel: MainViewModel = viewModel(),
    videoViewModel: VideoViewModel = viewModel(),
    articleViewModel: ArticleViewModel = viewModel()
) {

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

        //分类
        TabRow(
            selectedTabIndex = viewModel.categoryIndex,
            backgroundColor = Color(0x22149EE7),
            contentColor = Color(0xFF149EE7)
        ) {

            viewModel.categories.forEachIndexed { index, category ->
                Tab(selected = viewModel.categoryIndex == index,
                    selectedContentColor = Color(0xFF149EE7),
                    unselectedContentColor = Color(0xFF666666),
                    onClick = {
                        viewModel.updateCategoryIndex(index = index)
                    }) {
                    Text(
                        text = category.title,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            }
        }
        //数据类型
        TabRow(
            selectedTabIndex = viewModel.curDataIndex,
            backgroundColor = Color.Transparent,
            indicator = {},
            divider = {},
            contentColor = Color(0xFF149EE7)
        ) {

            viewModel.dataTypes.forEachIndexed { index, dataType ->
                LeadingIconTab(selected = viewModel.curDataIndex == index,
                    selectedContentColor = Color(0xFF149EE7),
                    unselectedContentColor = Color(0xFF666666),
                    onClick = {
                        viewModel.updateDataIndex(index = index)
                    }, text = {
                        Text(text = dataType.title, modifier = Modifier.padding(vertical = 8.dp))
                    }, icon = {
                        Icon(imageVector = dataType.icon, contentDescription = null)
                    })
            }
        }

        LazyColumn() {
            //轮播图
            item { SwiperContent(viewModel = viewModel) }
            //通知
            item { NotificationsContent(viewModel = viewModel) }
            if (viewModel.showArticle) {
                //文章列表
                items(articleViewModel.list) { article ->
                    ArticleItem(article)
                }
            } else {
                //视频列表
                items(videoViewModel.list) { videoEntity ->
                    VideoItem(videoEntity)
                }
            }

        }


    }
}

