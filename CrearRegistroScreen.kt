// Archivo: CrearRegistroScreen.kt
package com.example.mydex

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CrearRegistroScreen(registros: MutableList<Registro>, navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripción") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (nombre.isNotEmpty() && descripcion.isNotEmpty()) {
                registros.add(Registro(nombre, descripcion))
                navController.popBackStack() // volver a lista
            }
        }) {
            Text("Guardar")
        }
    }
}
