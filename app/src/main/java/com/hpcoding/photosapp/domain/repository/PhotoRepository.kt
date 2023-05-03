package com.hpcoding.photosapp.domain.repository

import com.hpcoding.photosapp.data.remote.dto.PhotoDto

interface PhotoRepository {

    suspend fun getPhotos(): List<PhotoDto>
}