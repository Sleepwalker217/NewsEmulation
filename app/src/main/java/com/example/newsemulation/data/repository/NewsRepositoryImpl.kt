package com.example.newsemulation.data.repository

import android.util.Log
import com.example.newsemulation.data.model.News
import com.example.newsemulation.data.remote.NewsApi
import com.example.newsemulation.domain.repository.NewsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepositoryImpl(private val api: NewsApi) : NewsRepository {
    override fun getNews(callback: (News) -> Unit) {
        val call = api.getNews()
        call.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                if (response.isSuccessful) {
                    response.body()?.let { callback(it) }
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.e("e",t.toString())
            }
        })
    }
}