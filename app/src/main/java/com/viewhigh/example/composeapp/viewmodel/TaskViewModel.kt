package com.viewhigh.example.composeapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {

    var taskDate by mutableStateOf("学习周期：2022.01.01-2022.12.31")
        private set

    //学年总积分
    var totalPointOfYear by mutableStateOf(13500)
        private set

    //学年积分
    var pointOfYear by mutableStateOf(10000)
        private set

    //学年积分进度  200f * pointOfYear / 学年总积分
    var pointOfYearPercent by mutableStateOf(0f)
        private set

    /**
     * 更新学年积分进度
     */
    fun updatePointPercent() {
        pointOfYearPercent = 200f * pointOfYear / totalPointOfYear
    }
}