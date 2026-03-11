package com.example.nupreco

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun InicioScreen(onLogout: () -> Unit) {
    var telaAtual by remember { mutableStateOf("INICIO") }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.width(250.dp)) {
                Spacer(modifier = Modifier.height(40.dp))

                // Opções do menu lateral - Disponíveis em todas as telas
                DrawerItem("INICIO", R.drawable.inicio) { telaAtual = "INICIO"; scope.launch { drawerState.close() } }
                DrawerItem("USUÁRIO", R.drawable.usuario) { telaAtual = "USUARIO"; scope.launch { drawerState.close() } }
                DrawerItem("VENDAS", R.drawable.vendas) { telaAtual = "VENDAS"; scope.launch { drawerState.close() } }
                DrawerItem("ESTOQUE", R.drawable.estoque) { telaAtual = "ESTOQUE"; scope.launch { drawerState.close() } }
                DrawerItem("CONTAS", R.drawable.contas) { telaAtual = "CONTAS"; scope.launch { drawerState.close() } }

                Spacer(modifier = Modifier.weight(1f))

                // ÚNICO SAIR DO SISTEMA (Logout)
                DrawerItem("SAIR", R.drawable.sair) { onLogout() }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    ) {
        // TELA PRINCIPAL
        Box(modifier = Modifier.fillMaxSize().background(Color(0xFF008040))) {
            Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {

                // ÍCONE DE MENU (TRÊS TRACINHOS) - AGORA SEMPRE VISÍVEL
                Icon(
                    painter = painterResource(R.drawable.menu),
                    contentDescription = "Menu",
                    modifier = Modifier
                        .clickable { scope.launch { drawerState.open() } }
                        .size(30.dp)
                        .align(Alignment.Start),
                    tint = Color.White
                )

                Text(telaAtual, color = Color.White, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(24.dp))

                // LÓGICA DE TROCA DE TELAS
                when (telaAtual) {
                    "INICIO" -> {
                        MenuButton("VENDAS", R.drawable.vendas) { telaAtual = "VENDAS" }
                        MenuButton("ESTOQUE", R.drawable.estoque) { telaAtual = "ESTOQUE" }
                        MenuButton("CONTAS", R.drawable.contas) { telaAtual = "CONTAS" }
                        Spacer(modifier = Modifier.weight(1f))
                        Text("NuPreço", color = Color.White, style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold)
                    }
                    else -> {
                        // Conteúdo dinâmico de cada tela
                        Text("Conteúdo de $telaAtual", color = Color.White)
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

// Componente para itens do menu lateral
@Composable
fun DrawerItem(text: String, iconRes: Int, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 20.dp, vertical = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(iconRes), contentDescription = null, tint = Color(0xFF008040), modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Text(text, color = Color(0xFF008040), style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
    }
}

// Componente para botões grandes do início
@Composable
fun MenuButton(text: String, iconRes: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(85.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color(0xFF008040)),
        border = androidx.compose.foundation.BorderStroke(1.dp, Color.White)
    ) {
        Row(modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(iconRes), contentDescription = null, tint = Color.White, modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.width(20.dp))
            Text(text, color = Color.White, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        }
    }
}