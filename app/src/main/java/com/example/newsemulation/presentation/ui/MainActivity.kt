package com.example.newsemulation.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsemulation.R
import com.example.newsemulation.presentation.ui.adapters.NewsAdapter
import com.example.newsemulation.presentation.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: NewsViewModel by viewModel()
    private lateinit var adapter: NewsAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = NewsAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.news.observe(this) { newsList ->
            adapter.submitList(newsList) {
                // This callback is called after the list update is complete
                recyclerView.smoothScrollToPosition(0)
            }
        }

        viewModel.startFetchingNews()
    }
}