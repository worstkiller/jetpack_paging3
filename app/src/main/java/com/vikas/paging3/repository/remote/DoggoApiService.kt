package com.vikas.paging3.repository.remote

import com.vikas.paging3.model.DoggoImageModel
import retrofit2.http.GET
import retrofit2.http.Query

interface DoggoApiService {

    @GET("v1/images/search")
    suspend fun getDoggoImages(@Query("page") page: Int, @Query("limit") size: Int): List<DoggoImageModel>

}