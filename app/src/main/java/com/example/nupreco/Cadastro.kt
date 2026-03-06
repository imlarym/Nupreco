package com.example.nupreco

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*

@Composable
fun SetupAccountScreen(onSuccess: () -> Unit, onBack: () -> Unit) {
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Topo Verde Curvado
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f)
                .background(
                    color = Color(0xFF008040),
                    shape = RoundedCornerShape(bottomStart = 70.dp, bottomEnd = 70.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Cadastro", color = Color.White, fontSize = 42.sp, fontWeight = FontWeight.Bold)
                Text("novo usuário", color = Color.White, fontSize = 24.sp)

                Spacer(modifier = Modifier.height(30.dp))

                // Campos de Entrada (Estilo Figma)
                Column(
                    modifier = Modifier.padding(horizontal = 30.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    CustomTextField(value = nome, onValueChange = { nome = it }, label = "NOME")
                    CustomTextField(value = email, onValueChange = { email = it }, label = "E-MAIL")
                    CustomTextField(value = senha, onValueChange = { senha = it }, label = "Senha", isPassword = true)
                }
            }
        }

        // Parte de baixo
        Column(
            modifier = Modifier.fillMaxWidth().weight(0.7f).padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = onSuccess,
                modifier = Modifier.fillMaxWidth().height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF068352)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Criar nova conta", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }

            TextButton(onClick = onBack) {
                Text("Entrar", color = Color.Gray, fontSize = 16.sp)
            }

            Image(
                painter = painterResource(id = R.drawable.logonupreco),
                contentDescription = "NuPreço",
                modifier = Modifier.height(45.dp)
            )
        }
    }
}