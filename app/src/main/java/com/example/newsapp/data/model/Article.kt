package com.example.newsapp.data.model

import com.google.gson.annotations.SerializedName

data class Article(
    val title: String?,
    val description: String?,
    val author: String?,
    @SerializedName("urlToImage") val imageUrl: String?,
    val url: String
) {
    fun getArticleId(): String {
        return url.removePrefix("https://").replace("/", "-")
    }
}