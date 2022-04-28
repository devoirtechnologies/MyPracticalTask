package com.app.myPracticalTask.view.di

import com.app.myPracticalTask.view.pojo.PojoAlbum
import javax.inject.Inject

class AlbumRepository @Inject constructor(var albumApi: AlbumApi) {

    suspend fun albumData(): PojoAlbum {
        return albumApi.getAlbumData()
    }
}