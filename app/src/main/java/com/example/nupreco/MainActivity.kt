package com.example.nupreco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.material3.* // Garante acesso aos componentes básicos se precisar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Estado central que controla a navegação entre as telas
            // Começa em "start" (tela de boas-vindas)
            var currentScreen by remember { mutableStateOf("start") }

            // Lógica de navegação baseada no estado atual
            when (currentScreen) {
                "start" -> StartScreen(
                    onNavigateToRegister = { currentScreen = "setup" },
                    onNavigateToLogin = { currentScreen = "login" }
                )

                "setup" -> SetupAccountScreen(
                    onSuccess = { currentScreen = "login" },
                    onBack = { currentScreen = "start" }
                )

                "login" -> AccessScreen(
                    // Ao logar com sucesso, mudamos o estado para "inicio"
                    onLoginSuccess = { currentScreen = "inicio" },
                    onBack = { currentScreen = "start" }
                )

                "inicio" -> InicioScreen(
                    onLogout = {
                        // Ação ao clicar em SAIR:
                        // 1. Aqui você pode limpar tokens do SharedPreferences/Backend futuramente
                        // 2. Voltamos o estado para a tela de login
                        currentScreen = "login"
                    }
                )
            }
        }
    }
}