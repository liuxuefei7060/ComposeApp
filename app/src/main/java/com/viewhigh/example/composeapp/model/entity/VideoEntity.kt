package com.viewhigh.example.composeapp.model.entity

/**
 * desc :
 *
 * @author:  Liu XueFei
 * @email:   liuxuefei@viewhigh.com
 * @date:    2022/4/25 17:39
 *
 */
data class VideoEntity(
    val title: String,
    val imageUrl: String,
    val source: String,
    var timestamp: String
) {
}