package com.solicode.hellocounter.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CompteurSection(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Compteur",
            style = MaterialTheme.typography.titleMedium
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = { if (count > 0) count-- },
                enabled = count > 0,
                modifier = Modifier.size(48.dp)
            ) {
                Icon(Icons.Filled.Remove, contentDescription = "Diminuer")
            }

            Text(
                text = "$count",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.widthIn(min = 40.dp)
            )

            IconButton(
                onClick = { count++ },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Augmenter")
            }
        }
    }
}