package com.example.employeedetail.kotlin.repository

import androidx.lifecycle.MutableLiveData
import com.example.employeedetail.kotlin.Albums
import com.example.employeedetail.kotlin.service.AlbumService
import com.example.employeedetail.kotlin.service.RetrofitInstance

class AlbumRepository
{
    private var albumList:List<Albums>?=null
    private var mutableLiveDataListAlbums:MutableLiveData<List<Albums>>?=null
    init {
        albumList=ArrayList()
        mutableLiveDataListAlbums= MutableLiveData()
    }

    /*suspend fun getMutableList():MutableLiveData<List<Albums>>
    {

       val response=RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java).getAlbums()
        return response.body().



    }*/
}