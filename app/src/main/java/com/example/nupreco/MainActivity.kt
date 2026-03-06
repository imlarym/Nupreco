package com.example.nupreco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Estado central que controla a navegação entre as telas
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
                "inicio" -> InicioScreen {  } // Aqui chamamos a tela que criamos
            }
        }
    }
}