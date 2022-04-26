package com.viewhigh.example.composeapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.viewhigh.example.composeapp.model.entity.VideoEntity

/**
 * desc : 新闻列表数据
 *
 * @author:  Liu XueFei
 * @email:   liuxuefei@viewhigh.com
 * @date:    2022/4/25 17:40
 *
 */
class VideoViewModel : ViewModel() {

    var list = mutableStateListOf(
        VideoEntity(
            "人社部向疫情防控期参与复工复产的劳动者表1",
            "https://docs.bughub.icu/compose/assets/banner1.webp",
            "光明日报",
            "2022-04-25"
        ),
        VideoEntity(
            "人社部向疫情防控期参与复工复产的劳动者表2",
            "https://docs.bughub.icu/compose/assets/banner2.webp",
            "光明日报",
            "2022-04-25"
        ),
        VideoEntity(
            "人社部向疫情防控期参与复工复产的劳动者表13",
            "https://docs.bughub.icu/compose/assets/banner3.webp",
            "光明日报",
            "2022-04-25"
        ),
        VideoEntity(
            "人社部向疫情防控期参与复工复产的劳动者表13",
            "https://docs.bughub.icu/compose/assets/banner3.webp",
            "光明日报",
            "2022-04-25"
        ),
        VideoEntity(
            "人社部向疫情防控期参与复工复产的劳动者表13",
            "https://docs.bughub.icu/compose/assets/banner3.webp",
            "光明日报",
            "2022-04-25"
        ),
        VideoEntity(
            "人社部向疫情防控期参与复工复产的劳动者表13",
            "https://docs.bughub.icu/compose/assets/banner3.webp",
            "光明日报",
            "2022-04-25"
        ),
        VideoEntity(
            "人社部向疫情防控期参与复工复产的劳动者表13",
            "https://docs.bughub.icu/compose/assets/banner3.webp",
            "光明日报",
            "2022-04-25"
        ),
    )
        private set


}