package com.hpcoding.photosapp.data.remote.dto


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.google.gson.annotations.Expose

@Keep
data class PhotoDto(
    @SerializedName("albumId")
    @Expose
    val albumId: Int,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("thumbnailUrl")
    @Expose
    val thumbnailUrl: String,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("url")
    @Expose
    val url: String
)