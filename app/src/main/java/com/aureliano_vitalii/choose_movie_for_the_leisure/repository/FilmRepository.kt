package com.aureliano_vitalii.choose_movie_for_the_leisure.repository

import com.aureliano_vitalii.choose_movie_for_the_leisure.api.ApiFactory
import com.aureliano_vitalii.choose_movie_for_the_leisure.entity.AdditionalFilmInfo
import com.aureliano_vitalii.choose_movie_for_the_leisure.entity.ShortFilmInfo
import com.aureliano_vitalii.choose_movie_for_the_leisure.pojo.FilmInfoDto
import com.aureliano_vitalii.choose_movie_for_the_leisure.pojo.GenreResponseDto
import com.aureliano_vitalii.choose_movie_for_the_leisure.pojo.MainFilmResponseDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object FilmRepository {

    private const val BASE_URL_FOR_IMAGE = "https://image.tmdb.org/t/p/w500"


    private val apiService = ApiFactory.apiService
    private var mainFilmResponseDto: MainFilmResponseDto? = null
    private val filmShortInfoSet = mutableSetOf<ShortFilmInfo>()
    private val filmInfoMap = mutableMapOf<Int?, AdditionalFilmInfo>()
    private var isSuccessfullLoadData: Boolean = false
    private var isSuccessfullLoadGenre: Boolean = false
    private var getGenreFilmResponse: GenreResponseDto? = null


    suspend fun loadData(page: Int) = withContext(Dispatchers.IO) {
        try {
            mainFilmResponseDto = apiService.getMainFilmResponse(page = page)
            isSuccessfullLoadData = true

        } catch (e: Exception) {
        }

    }

    suspend fun loadGenre() {
        try {
            getGenreFilmResponse = apiService.getGenreFilmResponse()
            isSuccessfullLoadGenre = true
        } catch (e: Exception) {
        }
    }

    fun getFilmShortInfoSet(): Set<ShortFilmInfo> {
        createFilmInfo()
        return filmShortInfoSet
    }

    fun getFilmAdditionalInfo(id: Int): AdditionalFilmInfo? {
        return filmInfoMap[id]
    }

    private fun createFilmInfo() {
        if (isSuccessfullLoadData) {
            mainFilmResponseDto?.let {
                for (i in it.results!!) {
                    val shortFilmInfo = ShortFilmInfo(
                        i.id,
                        i.title,
                        BASE_URL_FOR_IMAGE + i.posterPath,
                        i.voteAverage
                    )
                    val additionalFilmInfo = AdditionalFilmInfo(
                        i.adult,
                        i.genreIds,
                        i.overview,
                        i.voteCount,
                        i.releaseDate
                        )
                    filmInfoMap[i.id] = additionalFilmInfo
                    filmShortInfoSet.add(shortFilmInfo)
                }
            }
        }

    }


}
