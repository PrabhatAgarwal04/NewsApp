package com.example.newsapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newsapp.data.api.LikeAndCommentApi
import com.example.newsapp.data.api.NewsApi
import com.example.newsapp.data.repository.NewsRepository
import com.example.newsapp.ui.NewsScreen.NewsScreen
import com.example.newsapp.viewmodel.NewsViewModel
import com.example.newsapp.viewmodelfactory.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NewsApp()
        }
    }
}

@Composable
fun NewsApp() {

//    val newsApiService = Retrofit.Builder()
//        .baseUrl("https://newsapi.org/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//        .create(NewsApi::class.java)
//
//    val socialApiService = Retrofit.Builder()
//        .baseUrl("https://cn-news-info-api.herokuapp.com/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//        .create(LikeAndCommentApi::class.java)
//
//    val repository = NewsRepository(newsApiService, socialApiService, "a017a1888ce148d7ab9d2d8bda64c032")
//    val viewModel: NewsViewModel = viewModel(factory = NewsViewModelFactory(repository))
    val viewModel: NewsViewModel = hiltViewModel()
    NewsScreen(viewModel)
}

