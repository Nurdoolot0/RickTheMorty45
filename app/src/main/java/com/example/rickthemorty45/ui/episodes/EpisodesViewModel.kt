package com.example.rickthemorty45.ui.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickthemorty45.data.Repository
import com.example.rickthemorty45.data.paging.EpisodesPagingSource

class EpisodesViewModel(
    private val repository: Repository
) : ViewModel() {

    val episodes = Pager(PagingConfig(pageSize = 20)) {
        EpisodesPagingSource(repository)
    }.flow.cachedIn(viewModelScope)
}