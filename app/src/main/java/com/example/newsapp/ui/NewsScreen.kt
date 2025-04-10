package com.example.newsapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.newsapp.R
import com.example.newsapp.data.model.Article
import com.example.newsapp.viewmodel.NewsViewModel

object NewsScreen {
    @Composable
    fun NewsScreen(viewModel: NewsViewModel) {
        val articles by viewModel.articles.observeAsState(emptyList())
        val selectedArticle by viewModel.selectedArticle.observeAsState()
// Conditional rendering: if no article is selected, show the news list; otherwise, show details
        if (selectedArticle == null) {
            LazyColumn {
                items(articles) { article ->
                    NewsItem(article) { viewModel.selectArticle(article) }
                }
            }
        } else {
            // If an article is selected, navigate to the detail screen
            // Pass the ViewModel and a back handler to reset the selected article
            ArticleDetailScreen(viewModel, onBack = { viewModel.selectArticle(null) })
        }
    }

    @Composable
    fun NewsItem(article: Article, onClick: () -> Unit) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable { onClick() }
        ) {
            Row {
                AsyncImage(
                    model = article.imageUrl ?: R.drawable.ic_launcher_background,
                    contentDescription = "Article Image",
                    modifier = Modifier.size(100.dp)
                )
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(text = article.description ?: "No description")
                    Text(text = "By ${article.author ?: "Unknown"}")
                }
            }
        }
    }
}