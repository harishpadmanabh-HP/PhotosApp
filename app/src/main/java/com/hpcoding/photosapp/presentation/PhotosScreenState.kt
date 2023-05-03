package com.hpcoding.photosapp.presentation

import com.hpcoding.photosapp.domain.model.PhotoItem

data class PhotosScreenState(
    val isLoading: Boolean = false,
    val photos: List<PhotoItem> = emptyList(),
    val error: String = ""
)