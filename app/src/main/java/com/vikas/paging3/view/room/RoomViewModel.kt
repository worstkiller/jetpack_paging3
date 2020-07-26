package com.vikas.paging3.view.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.vikas.paging3.data.DoggoImagesRepository
import com.vikas.paging3.model.DoggoImageModel
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RoomViewModel(val repository: DoggoImagesRepository = DoggoImagesRepository.getInstance()) :
    ViewModel() {

    fun fetchDoggoImages(): Flow<PagingData<DoggoImageModel>> {
        return repository.letDoggoImagesFlowDb().cachedIn(viewModelScope)
    }

}