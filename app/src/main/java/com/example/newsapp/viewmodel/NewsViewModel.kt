package com.example.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {
    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _articles

    private val _selectedArticle = MutableLiveData<Article?>()
    val selectedArticle: LiveData<Article?> = _selectedArticle

    private val _likes = MutableLiveData<Int>()
    val likes: LiveData<Int> = _likes

    private val _comments = MutableLiveData<Int>()
    val comments: LiveData<Int> = _comments

    init {
        fetchTopHeadlines()
    }

    private fun fetchTopHeadlines() {
        viewModelScope.launch {
            val articles = repository.getTopHeadlines()
            _articles.postValue(articles)
        }
    }

    fun selectArticle(article: Article?) {
        _selectedArticle.value = article
        fetchSocialData(article?.getArticleId() ?:"")
    }

    private fun fetchSocialData(articleId: String) {
        viewModelScope.launch {
            _likes.postValue(repository.getLikes(articleId))
            _comments.postValue(repository.getComments(articleId))
        }
    }
}