package com.example.newsapp.data.api

import retrofit2.http.GET
import retrofit2.http.Path

interface LikeAndCommentApi {
    @GET("likes/{articleId}")
    suspend fun getLikes(@Path("articleId") articleId: String): Int

    @GET("comments/{articleId}")
    suspend fun getComments(@Path("articleId") articleId: String): Int
}