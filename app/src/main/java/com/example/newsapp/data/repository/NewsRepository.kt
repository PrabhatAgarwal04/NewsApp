package com.example.newsapp.data.repository

import com.example.newsapp.data.api.LikeAndCommentApi
import com.example.newsapp.data.api.NewsApi
import com.example.newsapp.data.model.Article

class NewsRepository(
    private val newsApi: NewsApi,
    private val likeAndCommentApi: LikeAndCommentApi,
    private val apiKey: String
) {
    suspend fun getTopHeadlines(): List<Article> {
        return try {
            newsApi.getTopHeadlines(apiKey = apiKey).articles
        } catch (e: Exception) {
            // Log the error for debugging (in production, use a proper logging framework)
            println("Failed to fetch headlines: ${e.message}")
            emptyList() // Return empty list on failure to prevent crash
        }
    }

    suspend fun getLikes(articleId: String): Int {
        return try {
            likeAndCommentApi.getLikes(articleId)
        } catch (e: Exception) {
            0 // Fallback value
        }
    }

    suspend fun getComments(articleId: String): Int {
        return try {
            likeAndCommentApi.getComments(articleId)
        } catch (e: Exception) {
            0 // Fallback value
        }
    }
}