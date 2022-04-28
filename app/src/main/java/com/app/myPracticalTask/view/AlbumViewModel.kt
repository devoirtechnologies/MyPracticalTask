package com.app.myPracticalTask.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.myPracticalTask.view.di.AlbumRepository
import com.app.myPracticalTask.view.pojo.PojoAlbum
import com.hubwallet.utillss.ErrorResponse
import com.hubwallet.utillss.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.FileNotFoundException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(val repository: AlbumRepository) : ViewModel() {

    private var liveDataAlbumData = MutableLiveData<ResultWrapper<PojoAlbum>>()
    fun AndroidGetAlbumData( ) :MutableLiveData<ResultWrapper<PojoAlbum>>{
        viewModelScope.launch (Dispatchers.IO){
            liveDataAlbumData.postValue(ResultWrapper.Loading)
            try {
                val responsee = repository.albumData()
                liveDataAlbumData.postValue(ResultWrapper.Success(responsee))
            }catch (e:Exception){
                e.printStackTrace()
                liveDataAlbumData.postValue(ResultWrapper.GenericError(
                    ErrorResponse(-1, e.message)
                ))

            }
        }
        return liveDataAlbumData
    }
}