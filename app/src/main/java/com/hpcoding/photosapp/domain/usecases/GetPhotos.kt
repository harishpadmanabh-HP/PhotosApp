package com.hpcoding.photosapp.domain.usecases

import com.hpcoding.photosapp.common.Resource
import com.hpcoding.photosapp.data.repository.toPhotoItem
import com.hpcoding.photosapp.domain.model.PhotoItem
import com.hpcoding.photosapp.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val repository: PhotoRepository
) {
    operator fun invoke(): Flow<Resource<List<PhotoItem>>> = flow {
        try {
            emit(Resource.Loading())
            val photos = repository.getPhotos().map { it.toPhotoItem() }
            emit(Resource.Success<List<PhotoItem>>(photos))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server. Check your internet connection."))
        }
    }
}