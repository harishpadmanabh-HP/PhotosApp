package com.hpcoding.photosapp.data.remote

import com.hpcoding.photosapp.data.remote.dto.PhotoDto
import retrofit2.http.GET

interface PhotosApi {

    @GET("photos")
    suspend fun getPhotos():List<PhotoDto>
}