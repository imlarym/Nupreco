package com.example.nupreco


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*

@Composable
fun StartScreen(onNavigateToRegister: () -> Unit, onNavigateToLogin: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Topo Verde Curvado - Aumentei o peso (weight) para dar mais destaque
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.8f)
                .background(
                    color = Color(0xFF008040),
                    shape = RoundedCornerShape(bottomStart = 70.dp, bottomEnd = 70.dp)
                ),
            contentAlignment = Alignment.BottomCenter // Alinha o camaleão na base da curva
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(113.dp)) // Espaço para não bater na barra de status

                // "Boas-vindas!" - Aumentado de 32 para 42
                Text(
                    text = "Boas-vindas!",
                    color = Color.White,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Frase - Aumentada de 16 para 20sp e negrito leve
                Text(
                    text = "Gestão Simples e eficiente para quem faz tudo sozinho? " +
                            "É com a NuPreço",
                    color = Color.White.copy(alpha = 0.9f),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 30.dp)
                )

                // Camaleão - Ajustado para ocupar o máximo de largura disponível
                Image(
                    painter = painterResource(id = R.drawable.camaleao),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                        .weight(1f) // Faz a imagem crescer para ocupar o espaço
                )
            }
        }

        // Parte de baixo: Botões e Logo
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f)
                .padding(horizontal = 32.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Botão principal - Mais alto (64.dp)
            Button(
                onClick = onNavigateToRegister,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF068352)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("PRIMEIRO ACESSO", fontWeight = FontWeight.ExtraBold, fontSize = 18.sp)
            }

            TextButton(onClick = onNavigateToLogin) {
                Text("Entrar", color = Color.Gray, fontSize = 18.sp)
            }

            // Logo NuPreço - Aumentada de 30 para 45dp
            Image(
                painter = painterResource(id = R.drawable.logonupreco),
                contentDescription = "NuPreço",
                modifier = Modifier.height(45.dp)
            )

            Spacer(modifier = Modifier.height(10.dp)) // Pequeno respiro no final
        }
    }
}