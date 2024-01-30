package com.example.openinappassignment.utils

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title: String,
    val icon:Int,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)