// Archivo: MainActivity.kt
package com.example.mydex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val registros = remember { mutableStateListOf<Registro>() }

    NavHost(navController = navController, startDestination = "lista") {
        composable("lista") {
            ListaScreen(registros = registros, navController = navController)
        }
        composable("crear") {
            CrearRegistroScreen(registros = registros, navController = navController)
        }
        composable("detalle/{index}") { backStackEntry ->
            val index = backStackEntry.arguments?.getString("index")?.toInt() ?: 0
            DetalleScreen(registro = registros[index])
        }
    }
}