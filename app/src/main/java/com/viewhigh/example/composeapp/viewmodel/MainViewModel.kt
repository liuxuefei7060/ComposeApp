package com.viewhigh.example.composeapp.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.SmartDisplay
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.viewhigh.example.composeapp.model.entity.Category
import com.viewhigh.example.composeapp.model.entity.DataType
import com.viewhigh.example.composeapp.model.entity.SwiperEntity

/**
 * desc :
 *
 * @author:  Liu XueFei
 * @email:   liuxuefei@viewhigh.com
 * @date:    2022/4/24 12:33
 *
 */
class MainViewModel : ViewModel() {

    //分类数据
    val categories = mutableStateListOf(
        Category("思想政治"),
        Category("法律法规"),
        Category("职业道德"),
        Category("诚信自律")
    )

    //当前分类下表
    var categoryIndex by mutableStateOf(0)
        private set

    //数据类型
    val dataTypes = mutableStateListOf(
        DataType("相关资讯", Icons.Default.Description),
        DataType("法律法规", Icons.Default.SmartDisplay),
    )

    //当前数据类型
    var curDataIndex by mutableStateOf(0)
        private set

    //数据类型
    val swiperData = mutableStateListOf(
        SwiperEntity("https://docs.bughub.icu/compose/assets/banner1.webp"),
        SwiperEntity("https://docs.bughub.icu/compose/assets/banner2.webp"),
        SwiperEntity("https://docs.bughub.icu/compose/assets/banner3.webp")
    )


    fun updateDataIndex(index: Int) {
        curDataIndex = index
    }

    fun updateCategoryIndex(index: Int) {
        categoryIndex = index
    }
}