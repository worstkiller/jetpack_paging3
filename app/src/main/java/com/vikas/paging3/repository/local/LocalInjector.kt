package com.vikas.paging3.repository.local

object LocalInjector {

    var appDatabase: AppDatabase? = null

    fun injectDb(): AppDatabase? {
        return appDatabase
    }
}