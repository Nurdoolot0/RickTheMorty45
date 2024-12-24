package com.example.rickthemorty45.ui.favorites

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.example.rickthemorty45.data.local.entities.FavoriteCharacter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteCharactersScreen(viewModel: FavoriteCharacterViewModel) {

    val favorites = viewModel.favorites.collectAsState().value

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Favorites") }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            if (favorites.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No favorite characters yet!")
                }
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(favorites) { character ->
                        FavoriteCharacterItem(character, viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun FavoriteCharacterItem(character: FavoriteCharacter, viewModel: FavoriteCharacterViewModel) {
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Удалить из избранного?") },
            text = { Text("Вы уверены, что хотите удалить этого персонажа из избранного?") },
            confirmButton = {
                TextButton(onClick = {
                    viewModel.removeCharacterFromFavorites(character)
                    showDialog = false
                }) {
                    Text("Удалить")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Отмена")
                }
            }
        )
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        showDialog = true
                    }
                )
            },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Filled.Star, contentDescription = "Star Icon")
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = character.name, style = MaterialTheme.typography.bodyLarge)

            Spacer(modifier = Modifier.weight(1f))

            IconButton(onClick = {
                viewModel.toggleFavorite(character)
            }) {
                Icon(Icons.Filled.Star, contentDescription = "Favorite Toggle")
            }
        }
    }
}