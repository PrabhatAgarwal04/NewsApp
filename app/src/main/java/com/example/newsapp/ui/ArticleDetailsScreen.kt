package com.example.newsapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newsapp.viewmodel.NewsViewModel

@Composable
fun ArticleDetailScreen(viewModel: NewsViewModel, onBack: () -> Unit) {
    val article = viewModel.selectedArticle.value ?: return
    val likes by viewModel.likes.observeAsState(0)
    val comments by viewModel.comments.observeAsState(0)

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = article.title ?: "No Title")
        Text(text = article.description ?: "No Description")
        Text(text = "Author: ${article.author ?: "Unknown"}")
        Text(text = "Likes: $likes")
        Text(text = "Comments: $comments")
        Button(onClick = onBack) {
            Text("Back")
        }
    }
}