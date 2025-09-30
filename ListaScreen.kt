// Archivo: ListaScreen.kt
package com.example.mydex

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ListaScreen(registros: List<Registro>, navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = { navController.navigate("crear") }) {
            Text("Añadir registro")
        }
        Spacer(modifier = Modifier.height(16.dp))
        registros.forEachIndexed { index, registro ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { navController.navigate("detalle/$index") }
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = registro.nombre, style = MaterialTheme.typography.titleMedium)
                    Text(text = registro.descripcion, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}
