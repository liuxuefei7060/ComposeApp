package com.viewhigh.example.composeapp.model.entity

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * desc : 底部导航栏实体
 *
 * @author:  Liu XueFei
 * @email:   liuxuefei@viewhigh.com
 * @date:    2022/3/28 13:06
 *
 */
data class NavigationItem(
    val title: String,//底部导航栏的标题
    val icon: ImageVector////底部导航栏的图标
)