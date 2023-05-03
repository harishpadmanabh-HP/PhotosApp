package com.hpcoding.photosapp.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hpcoding.photosapp.common.Resource
import com.hpcoding.photosapp.domain.usecases.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase
):ViewModel(){

    private val _state = mutableStateOf(PhotosScreenState())
    val state: State<PhotosScreenState> = _state

     fun getPhotos() {
        viewModelScope.launch {
            getPhotosUseCase().collectLatest {result->
                when (result) {
                    is Resource.Success -> {
                        _state.value = PhotosScreenState(photos = result.data ?: emptyList())
                    }
                    is Resource.Error -> {
                        _state.value = PhotosScreenState(
                            error = result.message ?: "An unexpected error occured"
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = PhotosScreenState(isLoading = true)
                    }
                }
            }
        } }
    }
