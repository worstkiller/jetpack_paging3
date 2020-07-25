package com.vikas.paging3.data

import com.vikas.paging3.repository.remote.DoggoApiService
import com.vikas.paging3.repository.remote.RemoteInjector

/**
 * repository class to manage the data flow and map it if needed
 */
class DoggoImagesRepository(val doggoApiService: DoggoApiService = RemoteInjector.injectDoggoApiService()) {


}