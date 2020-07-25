package com.vikas.paging3.view.loader

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.vikas.paging3.data.DoggoImagesRepository
import com.vikas.paging3.model.DoggoImageModel
import kotlinx.coroutines.flow.Flow

class LoaderViewModel(val repository: DoggoImagesRepository = DoggoImagesRepository.getInstance()) :
    ViewModel() {

    /**
     * returning non modified PagingData<DoggoImageModel> value as opposite to remote view model
     * where we have mapped the coming values into different object
     */
    fun fetchDoggoImages(): Flow<PagingData<DoggoImageModel>> {
        return repository.letDoggoImagesFlow().cachedIn(viewModelScope)
    }

}