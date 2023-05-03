package com.hpcoding.photosapp.di

import com.hpcoding.photosapp.common.Constants
import com.hpcoding.photosapp.data.remote.PhotosApi
import com.hpcoding.photosapp.data.repository.PhotosRepoImpl
import com.hpcoding.photosapp.domain.repository.PhotoRepository
import com.hpcoding.photosapp.domain.usecases.GetPhotosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePhotoApi(): PhotosApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PhotosApi::class.java)

    @Provides
    @Singleton
    fun providePhotoRepository(api: PhotosApi): PhotoRepository = PhotosRepoImpl(api)

    @Provides
    @Singleton
    fun provideGetPhotoUseCase(repository: PhotoRepository):GetPhotosUseCase = GetPhotosUseCase(repository)
}