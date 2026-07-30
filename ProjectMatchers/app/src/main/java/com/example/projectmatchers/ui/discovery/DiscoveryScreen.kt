package com.example.projectmatchers.ui.discovery

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectmatchers.data.model.UserProfile
import com.example.projectmatchers.ui.components.ActionButtons
import com.example.projectmatchers.ui.components.SwipeCardStack

@Composable
fun DiscoveryScreen() {
    val profiles = remember {
        listOf(
            UserProfile("1", "Sarah", 24, "Adventurer & Coffee Lover", listOf("https://images.unsplash.com/photo-1494790108377-be9c29b29330")),
            UserProfile("2", "John", 27, "Techie and Gamer", listOf("https://images.unsplash.com/photo-1500648767791-00dcc994a43e")),
            UserProfile("3", "Emily", 22, "Artist & Musician", listOf("https://images.unsplash.com/photo-1438761681033-6461ffad8d80")),
            UserProfile("4", "Michael", 29, "Fitness enthusiast", listOf("https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d")),
            UserProfile("5", "Jessica", 25, "Bookworm & Traveller", listOf("https://images.unsplash.com/photo-1544005313-94ddf0286df2"))
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            ActionButtons(
                onDislike = { /* Handle via state or swipe trigger */ },
                onLike = { /* Handle via state or swipe trigger */ },
                onUndo = { /* Handle undo logic */ }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (profiles.isNotEmpty()) {
                SwipeCardStack(
                    profiles = profiles,
                    onSwipeLeft = { profile -> println("Disliked ${profile.name}") },
                    onSwipeRight = { profile -> println("Liked ${profile.name}") }
                )
            } else {
                Text("No more profiles nearby", fontSize = 20.sp)
            }
        }
    }
}
