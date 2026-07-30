package com.example.projectmatchers.data.model

data class UserProfile(
    val id: String,
    val name: String,
    val age: Int,
    val bio: String,
    val imageUrls: List<String>
)
