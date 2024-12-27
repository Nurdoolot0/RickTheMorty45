package com.example.rickthemorty45.ui.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickthemorty45.data.Repository
import com.example.rickthemorty45.data.paging.LocationsPagingSource

class LocationsViewModel(private val repository: Repository) : ViewModel() {

    val locations = Pager(PagingConfig(pageSize = 20)) {
        LocationsPagingSource(repository)
    }.flow.cachedIn(viewModelScope)
}
