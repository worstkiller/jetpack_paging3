package com.vikas.paging3.view.remote

import androidx.lifecycle.*
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import androidx.paging.rxjava2.cachedIn
import com.vikas.paging3.data.DoggoImagesRepository
import com.vikas.paging3.model.DoggoImageModel
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@ExperimentalPagingApi
class RemoteViewModel(
    val repository: DoggoImagesRepository = DoggoImagesRepository.getInstance()
) : ViewModel() {

    /**
     * we just mapped the data received from the repository to [PagingData<String>] to show the map
     * function you can always return the original model if needed, in our case it would be [DoggoImageModel]
     */
    fun fetchDoggoImages(): Flow<PagingData<String>> {
        return repository.letDoggoImagesFlow()
            .map { it.map { it.url } }
            .cachedIn(viewModelScope)
    }

    //rxjava use case
    fun fetchDoggoImagesObservable(): Observable<PagingData<String>> {
        return repository.letDoggoImagesObservable()
            .map { it.map { it.url } }
            .cachedIn(viewModelScope)
    }

    //live data use case
    fun fetchDoggoImagesLiveData(): LiveData<PagingData<String>> {
        return repository.letDoggoImagesLiveData()
            .map { it.map { it.url } }
            .cachedIn(viewModelScope)
    }

}