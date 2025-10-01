package com.solicode.hellocounter.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun DireBonjourSection(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var greetingName by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Prénom") },
            placeholder = { Text("Entrez votre prénom") },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { greetingName = name.takeIf { it.isNotBlank() }?.trim() },
            enabled = name.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Dire bonjour")
        }

        if (greetingName != null) {
            AssistChip(
                onClick = {},
                label = { Text("Bonjour, $greetingName !") }
            )
        }
    }
}