// Archivo: DetalleScreen.kt
package com.example.mydex

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.util.*

@Composable
fun DetalleScreen(registro: Registro) {
    val context = LocalContext.current
    var tts: TextToSpeech? = remember { null }

    DisposableEffect(Unit) {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts?.language = Locale("es", "ES")
                tts?.speak("${registro.nombre}: ${registro.descripcion}",
                    TextToSpeech.QUEUE_FLUSH, null, null)
            }
        }
        onDispose {
            tts?.stop()
            tts?.shutdown()
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = registro.nombre, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = registro.descripcion, style = MaterialTheme.typography.bodyLarge)
    }
}
