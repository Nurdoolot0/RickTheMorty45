package com.example.rickthemorty45.ui.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickthemorty45.data.Repository
import com.example.rickthemorty45.data.models.LocationResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocationDetailViewModel(private val repository: Repository) : ViewModel() {

    private val _location = MutableStateFlow<LocationResponse.Location?>(null)
    val location: StateFlow<LocationResponse.Location?> get() = _location

    fun fetchLocationById(id: Int) {
        viewModelScope.launch {
            val response = repository.getLocationById(id)
            if (response.isSuccessful) {
                _location.value = response.body()
            }
        }
    }
}