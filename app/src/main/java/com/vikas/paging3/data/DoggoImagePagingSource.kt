package com.vikas.paging3.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingSource
import com.vikas.paging3.data.DoggoImagesRepository.Companion.DEFAULT_PAGE_INDEX
import com.vikas.paging3.model.DoggoImageModel
import com.vikas.paging3.repository.remote.DoggoApiService
import retrofit2.HttpException
import java.io.IOException

/**
 * provides the data source for paging lib from api calls
 */
@ExperimentalPagingApi
class DoggoImagePagingSource(val doggoApiService: DoggoApiService) :
    PagingSource<Int, DoggoImageModel>() {

    /**
     * calls api if there is any error getting results then return the [LoadResult.Error]
     * for successful response return the results using [LoadResult.Page] for some reason if the results
     * are empty from service like in case of no more data from api then we can pass [null] to
     * send signal that source has reached the end of list
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DoggoImageModel> {
        //for first case it will be null, then we can pass some default value, in our case it's 1
        val page = params.key ?: DEFAULT_PAGE_INDEX
        return try {
            val response = doggoApiService.getDoggoImages(page, params.loadSize)
            LoadResult.Page(
                response, prevKey = if (page == DEFAULT_PAGE_INDEX) null else page - 1,
                nextKey = if (response.isEmpty()) null else page + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}