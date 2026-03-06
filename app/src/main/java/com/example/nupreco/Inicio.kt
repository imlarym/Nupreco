package com.example.nupreco

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun InicioScreen(onLogout: () -> Unit) {
    var telaAtual by remember { mutableStateOf("INICIO") }

    // Cores conforme seu pedido: Menu Branco, Conteúdo Verde
    val corMenu = Color.White
    val corConteudo = Color(0xFF008040)

    Row(modifier = Modifier.fillMaxSize()) {
        // 1. MENU LATERAL (Branco)
        Column(
            modifier = Modifier
                .width(80.dp)
                .fillMaxHeight()
                .background(corMenu),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            MenuItem(R.drawable.menu, onClick = { /* Ação */ })
            MenuItem(R.drawable.inicio, onClick = { telaAtual = "INICIO" })
            MenuItem(R.drawable.rendimento, onClick = { telaAtual = "RENDIMENTO" })
            MenuItem(R.drawable.estoque, onClick = { telaAtual = "ESTOQUE" })
            MenuItem(R.drawable.usuario, onClick = { telaAtual = "USUARIO" })
            MenuItem(R.drawable.contas, onClick = { telaAtual = "CONTAS" })
            MenuItem(R.drawable.configuracao, onClick = { telaAtual = "CONFIG" })
            MenuItem(R.drawable.sair, onClick = onLogout)
        }

        // 2. CONTEÚDO PRINCIPAL (Verde)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(corConteudo)
                .padding(16.dp)
        ) {
            when (telaAtual) {
                "INICIO" -> Text("Dashboard", color = Color.White)
                "RENDIMENTO" -> RendimentoScreen()
                "ESTOQUE" -> Estoque()
                "USUARIO" -> Usuario()
                "CONTAS" -> Contas()
                "CONFIG" -> Configuracao()
                else -> Text("Bem-vindo", color = Color.White)
            }
        }
    }
}

// COMPONENTES DE AJUDA
@Composable
fun MenuItem(imageRes: Int, onClick: () -> Unit) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        modifier = Modifier
            .size(40.dp)
            .padding(8.dp)
            .clickable { onClick() }
    )
}

// AQUI ESTÃO AS TELAS QUE VOCÊ DEVE TER DEFINIDAS
// Certifique-se de que os nomes abaixo batem com os arquivos que você criou
@Composable
fun RendimentoScreen() { Text("TELA DE RENDIMENTO", color = Color.White) }
@Composable
fun Estoque() { Text("TELA DE ESTOQUE", color = Color.White) }
@Composable
fun Usuario() { Text("TELA DE USUÁRIO", color = Color.White) }
@Composable
fun Contas() { Text("TELA DE CONTAS", color = Color.White) }
@Composable
fun Configuracao() { Text("TELA DE CONFIGURAÇÃO", color = Color.White) }