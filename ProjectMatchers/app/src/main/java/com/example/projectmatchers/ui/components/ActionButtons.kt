package com.example.projectmatchers.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ActionButtons(
    onDislike: () -> Unit,
    onLike: () -> Unit,
    onUndo: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onUndo,
            modifier = Modifier.size(50.dp),
            colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White),
            content = {
                Icon(Icons.Default.Refresh, contentDescription = "Undo", tint = Color.Yellow)
            }
        )

        IconButton(
            onClick = onDislike,
            modifier = Modifier.size(64.dp),
            colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White),
            content = {
                Icon(Icons.Default.Close, contentDescription = "Dislike", tint = Color.Red, modifier = Modifier.size(32.dp))
            }
        )

        IconButton(
            onClick = onLike,
            modifier = Modifier.size(64.dp),
            colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White),
            content = {
                Icon(Icons.Default.Favorite, contentDescription = "Like", tint = Color.Green, modifier = Modifier.size(32.dp))
            }
        )
    }
}
