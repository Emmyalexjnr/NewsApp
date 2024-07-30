package com.newsapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newsapp.api.NewsApi
import com.newsapp.data.newsresponse.Article
import com.newsapp.data.newsresponse.NewsResponse
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private var _newsState by mutableStateOf(NewsResponse.noResponse())
    var allArticles by mutableStateOf<List<Article>>(emptyList())
    var gettingAllNews by mutableStateOf(false)

    var news
        get() = _newsState
        set(value) { _newsState = value }

    private fun updateNews(news: NewsResponse) {
        _newsState = news
    }

    init {
        viewModelScope.launch {
            fetchNews()
        }
    }

    fun fetchNews() {
        gettingAllNews = true
        NewsApi().getAllNews(callback = { news ->
            updateNews(news)
            allArticles = news.articles
            gettingAllNews = false
        }, errorCallback = { errorMessage: String? ->
            gettingAllNews = false
        })
    }
}