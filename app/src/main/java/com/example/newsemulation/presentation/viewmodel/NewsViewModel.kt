package com.example.newsemulation.presentation.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsemulation.data.model.News
import com.example.newsemulation.domain.usecase.GetNewsUseCase

class NewsViewModel(private val getNewsUseCase: GetNewsUseCase) : ViewModel() {

    private val _news = MutableLiveData<List<News>>()
    val news: LiveData<List<News>> get() = _news

    private val handler = Handler(Looper.getMainLooper())
    private val newsList = mutableListOf<News>()

    fun startFetchingNews() {
        handler.post(object : Runnable {
            override fun run() {
                getNewsUseCase.execute { newNews ->
                    if (!newsList.any { it.news_id == newNews.news_id }) {
                        newsList.add(0, newNews)
                        _news.postValue(newsList.toList())
                    }
                }
                handler.postDelayed(this, 1000) // Обновляем каждую секунду
            }
        })
    }
}