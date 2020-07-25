package com.vikas.paging3.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.vikas.paging3.model.DoggoImageModel
import com.vikas.paging3.repository.remote.DoggoApiService
import com.vikas.paging3.repository.remote.RemoteInjector
import kotlinx.coroutines.flow.Flow

/**
 * repository class to manage the data flow and map it if needed
 */
class DoggoImagesRepository(val doggoApiService: DoggoApiService = RemoteInjector.injectDoggoApiService()) {

    companion object {
        const val DEFAULT_PAGE_INDEX = 1
        const val DEFAULT_PAGE_SIZE = 20

        //get doggo repository instance
        fun getInstance() = DoggoImagesRepository()
    }

    /**
     * calling the paging source to give results from api calls
     * and returning the results in the form of flow [Flow<PagingData<DoggoImageModel>>]
     * since the [PagingDataAdapter] accepts the [PagingData] as the source in later stage
     */
    fun letDoggoImagesFlow(pagingConfig: PagingConfig = getDefaultPageConfig()): Flow<PagingData<DoggoImageModel>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { DoggoImagePagingSource(doggoApiService) }
        ).flow
    }

    /**
     * let's define page size, page size is the only required param, rest is optional
     */
    fun getDefaultPageConfig(): PagingConfig {
        return PagingConfig(pageSize = DEFAULT_PAGE_SIZE, enablePlaceholders = true)
    }

}