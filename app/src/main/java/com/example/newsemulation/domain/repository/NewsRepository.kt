package com.example.newsemulation.domain.repository

import com.example.newsemulation.data.model.News

interface NewsRepository {
    fun getNews(callback: (News) -> Unit)
}