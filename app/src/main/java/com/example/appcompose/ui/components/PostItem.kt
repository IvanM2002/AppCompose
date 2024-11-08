package com.example.appcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.appcompose.R
import com.example.appcompose.model.Post

@Composable
fun PostItem(post: Post, onImageClick: (Post) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_user_profile_picture),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = post.username, fontWeight = FontWeight.Bold)
                Text(text = post.jobTitle, style = MaterialTheme.typography.bodyMedium)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.ic_send),
                contentDescription = "Options"
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = post.content, style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = painterResource(id = post.imageRes),
            contentDescription = "Post Image",
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .clickable { onImageClick(post) } // Llama a onImageClick con el post actual
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ActionIcon(drawableId = R.drawable.ic_like, label = "Recomendar")
            ActionIcon(drawableId = R.drawable.ic_comment, label = "Comentar")
            ActionIcon(drawableId = R.drawable.ic_share, label = "Compartir")
            ActionIcon(drawableId = R.drawable.ic_send, label = "Enviar")
        }
    }
}


@Composable
fun ActionIcon(drawableId: Int, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(4.dp)
    ) {
        Icon(
            painter = painterResource(id = drawableId),
            contentDescription = label,
            modifier = Modifier.size(24.dp)
        )
        Text(text = label, style = MaterialTheme.typography.labelSmall)
    }
}

