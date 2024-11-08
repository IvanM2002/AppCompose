package com.example.appcompose.model

import androidx.annotation.DrawableRes
import com.example.appcompose.R

data class Post(
    val id: String,
    val username: String,
    val jobTitle: String,
    val content: String,
    @DrawableRes val imageRes: Int
)

fun generatePosts(n: Int): List<Post> {
    return List(n) { index ->
        Post(
            id = (index + 1).toString(),
            username = "Username $index",
            jobTitle = "Software Engineer at XYZ Company",
            content = "This is an example of a LinkedIn post. Here is where the content of the post will be displayed.",
            imageRes = R.drawable.img_cat
        )
    }
}

val posts = generatePosts(10)
