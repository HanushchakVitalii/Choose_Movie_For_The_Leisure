package com.aureliano_vitalii.choose_movie_for_the_leisure.repository

import com.aureliano_vitalii.choose_movie_for_the_leisure.api.ApiFactory

object FilmRepository {

    private val apiService = ApiFactory.apiService
    private var ddd = "в репозитории"

    suspend fun loadData() :Boolean{
        return try {
            ddd = apiService.getDatum().toString()
            true
        } catch (e: Exception) {
            ddd = e.toString()
            false
        }

    }
    fun getddd(): String{
        return ddd
    }


}
