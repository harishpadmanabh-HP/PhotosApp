package com.hpcoding.photosapp.data.repository

import com.hpcoding.photosapp.data.remote.PhotosApi
import com.hpcoding.photosapp.data.remote.dto.PhotoDto
import com.hpcoding.photosapp.domain.model.PhotoItem
import com.hpcoding.photosapp.domain.repository.PhotoRepository
import javax.inject.Inject

class PhotosRepoImpl @Inject constructor(
    private val api: PhotosApi
) : PhotoRepository {
    override suspend fun getPhotos(): List<PhotoDto> = api.getPhotos()
}

fun PhotoDto.toPhotoItem() = PhotoItem(url = url)