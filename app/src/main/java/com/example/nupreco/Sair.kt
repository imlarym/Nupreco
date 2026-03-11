package com.example.nupreco

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BotaoSair(onSair: () -> Unit) {
    Icon(
        painter = painterResource(id = R.drawable.sair), // O seu ícone de Sair
        contentDescription = "Sair e voltar para o Login",
        modifier = Modifier
            .padding(16.dp)
            .size(40.dp)
            .clickable { onSair() }, // Chama a função que fará o logout
        tint = Color.White
    )
}