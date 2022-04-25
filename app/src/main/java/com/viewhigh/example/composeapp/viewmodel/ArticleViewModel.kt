package com.viewhigh.example.composeapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.viewhigh.example.composeapp.model.entity.ArticleEntity

/**
 * desc : 新闻列表数据
 *
 * @author:  Liu XueFei
 * @email:   liuxuefei@viewhigh.com
 * @date:    2022/4/25 17:40
 *
 */
class ArticleViewModel : ViewModel() {

    var list = mutableStateListOf(
        ArticleEntity("人社部向疫情防控期参与复工复产的劳动者表1", "光明日报", "2022-04-25"),
        ArticleEntity("人社部向疫情防控期参与复工复产的劳动者表2", "光明日报", "2022-04-25"),
        ArticleEntity("人社部向疫情防控期参与复工复产的劳动者表3", "光明日报", "2022-04-25"),
        ArticleEntity("人社部向疫情防控期参与复工复产的劳动者表4", "光明日报", "2022-04-25"),
        ArticleEntity("人社部向疫情防控期参与复工复产的劳动者表5", "光明日报", "2022-04-25"),
        ArticleEntity("人社部向疫情防控期参与复工复产的劳动者表6", "光明日报", "2022-04-25"),
        ArticleEntity("人社部向疫情防控期参与复工复产的劳动者表7", "光明日报", "2022-04-25"),
        ArticleEntity("人社部向疫情防控期参与复工复产的劳动者表8", "光明日报", "2022-04-25"),
        ArticleEntity("人社部向疫情防控期参与复工复产的劳动者表9", "光明日报", "2022-04-25"),
        ArticleEntity("人社部向疫情防控期参与复工复产的劳动者表10", "光明日报", "2022-04-25"),
        ArticleEntity("人社部向疫情防控期参与复工复产的劳动者表11", "光明日报", "2022-04-25"),
        ArticleEntity("人社部向疫情防控期参与复工复产的劳动者表13", "光明日报", "2022-04-25"),
    )
        private set


}