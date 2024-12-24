package com.example.rickthemorty45.ui.episodes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rickthemorty45.ui.common.EpisodeCard
import com.example.rickthemorty45.ui.common.LoadMoreButton

@Composable
fun EpisodesScreen(viewModel: EpisodesViewModel = viewModel()) {

    val episodes = viewModel.episodes.collectAsState().value

    LazyColumn {
        items(episodes) { episode ->
            EpisodeCard(episode)
        }
        item {
            LoadMoreButton(
                onClick = { viewModel.loadMoreEpisodes() },
            )
        }
    }
}