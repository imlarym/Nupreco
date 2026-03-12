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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun AccessScreen(onLoginSuccess: () -> Unit, onBack: () -> Unit) {
    // Estados para os campos de texto
    var nome by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    // --- ESTADOS PARA A TASK LLW-179 (Loading e Erro) ---
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()

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
                Text("LOGIN", color = Color.White, fontSize = 42.sp, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(40.dp))

                Column(
                    modifier = Modifier.padding(horizontal = 30.dp),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    CustomTextField(value = nome, onValueChange = { nome = it }, label = "NOME")
                    CustomTextField(value = senha, onValueChange = { senha = it }, label = "Senha", isPassword = true)

                    // Exibe mensagem de erro caso exista
                    if (errorMessage != null) {
                        Text(
                            text = errorMessage!!,
                            color = Color(0xFFFFEB3B), // Amarelo para destacar no fundo verde
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }
        }

        // Rodapé com botão e logo
        Column(
            modifier = Modifier.fillMaxWidth().weight(0.7f).padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    // Inicia o estado de carregamento
                    isLoading = true
                    errorMessage = null

                    scope.launch {
                        try {
                            // Simulação da chamada ao backend Java/Spring
                            delay(1500)

                            if (nome.isBlank() || senha.isBlank()) {
                                errorMessage = "Por favor, preencha todos os campos."
                                isLoading = false
                            } else {
                                isLoading = false
                                onLoginSuccess() // Navega para a Home
                            }
                        } catch (e: Exception) {
                            isLoading = false
                            errorMessage = "Falha na conexão com o servidor."
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth().height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF068352)),
                shape = RoundedCornerShape(12.dp),
                enabled = !isLoading // Desabilita o botão enquanto carrega
            ) {
                if (isLoading) {
                    // Círculo de progresso quando estiver carregando
                    CircularProgressIndicator(
                        color = Color.White,
                        modifier = Modifier.size(24.dp),
                        strokeWidth = 3.dp
                    )
                } else {
                    Text("Entrar", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                }
            }

            TextButton(
                onClick = onBack,
                enabled = !isLoading
            ) {
                Text("Voltar ao início", color = Color.Gray)
            }

            Image(
                painter = painterResource(id = R.drawable.logonupreco),
                contentDescription = "NuPreço",
                modifier = Modifier.height(45.dp)
            )
        }
    }
}