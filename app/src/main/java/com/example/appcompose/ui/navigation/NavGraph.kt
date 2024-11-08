package com.example.appcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appcompose.ui.FeedScreen
import com.example.appcompose.ui.PostDetailScreen
import com.example.appcompose.model.posts

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "feed") {
        composable("feed") {
            FeedScreen(onPostClick = { post ->
                navController.navigate("postDetail/${post.id}")
            })
        }
        composable("postDetail/{postId}") { backStackEntry ->
            val postId = backStackEntry.arguments?.getString("postId")
            val post = posts.find { it.id == postId }
            post?.let {
                PostDetailScreen(post = it)
            }
        }
    }
}
