package com.example.newsemulation.di

import com.example.newsemulation.data.remote.NewsApi
import com.example.newsemulation.domain.repository.NewsRepository
import com.example.newsemulation.data.repository.NewsRepositoryImpl
import com.example.newsemulation.domain.usecase.GetNewsUseCase
import com.example.newsemulation.presentation.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// AppModule.kt
val appModule = module {
    single { Retrofit.Builder()
        .baseUrl("http://91.221.246.123:8082/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NewsApi::class.java)
    }

    single<NewsRepository> { NewsRepositoryImpl(get()) }
    factory { GetNewsUseCase(get()) }
    viewModel { NewsViewModel(get()) }
}
