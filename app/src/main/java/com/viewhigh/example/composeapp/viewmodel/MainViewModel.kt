package com.viewhigh.example.composeapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.viewhigh.example.composeapp.model.entity.Category

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


    fun updateCategoryIndex(index : Int) {
        categoryIndex = index
    }
}