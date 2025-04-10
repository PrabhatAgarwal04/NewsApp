package com.example.newsapp.data.repository

import com.example.newsapp.data.api.NewsApi
import com.example.newsapp.data.api.LikeAndCommentApi
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.model.NewsResponse
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class NewsRepositoryTest {
    private lateinit var newsApiService: NewsApi
    private lateinit var socialApiService: LikeAndCommentApi
    private lateinit var repository: NewsRepository

    @Before
    fun setUp() {
        newsApiService = mock(NewsApi::class.java)
        socialApiService = mock(LikeAndCommentApi::class.java)
        repository = NewsRepository(newsApiService, socialApiService, "test-api-key")
    }

    @Test
    fun `test getTopHeadlines returns articles`() = runBlocking {
        val articles = listOf(Article("Test", "Desc", "Author", "url", "https://test.com"))
        `when`(newsApiService.getTopHeadlines("us", "test-api-key")).thenReturn(NewsResponse("ok", 1, articles))
        val result = repository.getTopHeadlines()
        assertEquals(articles, result)
    }

    @Test
    fun `test getLikes returns value`() = runBlocking {
        `when`(socialApiService.getLikes("test-id")).thenReturn(10)
        val result = repository.getLikes("test-id")
        assertEquals(10, result)
    }
}