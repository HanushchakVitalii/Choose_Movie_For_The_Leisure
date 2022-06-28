package com.aureliano_vitalii.choose_movie_for_the_leisure.repository

import android.util.Log
import com.aureliano_vitalii.choose_movie_for_the_leisure.api.ApiFactory
import androidx.lifecycle.MutableLiveData
import com.aureliano_vitalii.choose_movie_for_the_leisure.entity.FilmShortInfo
import com.aureliano_vitalii.choose_movie_for_the_leisure.pojo.MainFilmResponseDto

object FilmRepository {

    private val apiService = ApiFactory.apiService
    private var mainFilmResponseDto: MainFilmResponseDto? = null
    private val filmShortInfoListLD = MutableLiveData<Set<FilmShortInfo>>()
    private val filmShortInfoList = mutableSetOf<FilmShortInfo>()
    private var isSuccessfull: Boolean = false


    suspend fun loadData(): Boolean {
        try {
            mainFilmResponseDto = apiService.getMainFilmResponse()
            isSuccessfull = true
        } catch (e: Exception) {
        }
        return isSuccessfull

    }

    fun getFilmShotInfoSet(): MutableLiveData<Set<FilmShortInfo>> {
        createFilmInfo()
        filmShortInfoListLD.value = filmShortInfoList.toSet()
        return filmShortInfoListLD


    }

    private fun createFilmInfo() {
        if (isSuccessfull) {
            mainFilmResponseDto?.let {
                for (i in it.results!!) {
                    val filmShortInfo = FilmShortInfo(i.id, i.title, i.posterPath, i.voteAverage)
                    filmShortInfoList.add(filmShortInfo)
                }
            }
            Log.d("repository", filmShortInfoList.toString())
        }
    }



}
