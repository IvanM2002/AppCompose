package com.example.appcompose.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.appcompose.model.Post
import com.example.appcompose.model.posts
import com.example.appcompose.ui.components.PostItem

@Composable
fun FeedScreen(onPostClick: (Post) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(posts) { post ->
            PostItem(post, onPostClick)
        }
    }
}
