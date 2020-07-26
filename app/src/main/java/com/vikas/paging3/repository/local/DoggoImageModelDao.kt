package com.vikas.paging3.repository.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vikas.paging3.model.DoggoImageModel

@Dao
interface DoggoImageModelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(doggoModel: List<DoggoImageModel>)

    @Query("SELECT * FROM doggoimagemodel")
    fun getAllDoggoModel(): PagingSource<Int, DoggoImageModel>

    @Query("DELETE FROM doggoimagemodel")
    suspend fun clearAllDoggos()

}