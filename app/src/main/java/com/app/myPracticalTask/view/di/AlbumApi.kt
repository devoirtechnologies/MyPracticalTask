package com.app.myPracticalTask.view.di

import com.app.myPracticalTask.view.pojo.PojoAlbum
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface AlbumApi {


    @GET("albums")
    suspend fun getAlbumData(): PojoAlbum

}