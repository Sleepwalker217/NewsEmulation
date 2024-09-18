package com.example.newsemulation.data.remote

import com.example.newsemulation.data.model.News
import retrofit2.Call
import retrofit2.http.GET

interface NewsApi {
    @GET("get_news")
    fun getNews(): Call<News>
}
