package com.example.newsemulation.domain.usecase

import com.example.newsemulation.data.model.News
import com.example.newsemulation.domain.repository.NewsRepository

class GetNewsUseCase(private val repository: NewsRepository) {
    fun execute(callback: (News) -> Unit) {
        repository.getNews(callback)
    }
}
