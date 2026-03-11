package com.example.nupreco

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Usuario() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFF008040)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "TELA DE USUÁRIO", color = Color.White)
    }
}