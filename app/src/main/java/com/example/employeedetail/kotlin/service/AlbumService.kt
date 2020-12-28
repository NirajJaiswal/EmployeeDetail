package com.example.employeedetail.kotlin.service

import com.example.employeedetail.kotlin.Albums
import retrofit2.Response
import retrofit2.http.GET

interface AlbumService
{
    @GET("/albums")
    suspend fun getAlbums():Response<Albums>
}