package com.vikas.paging3.view.remote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.vikas.paging3.data.DoggoImagesRepository
import com.vikas.paging3.model.DoggoImageModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

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

}