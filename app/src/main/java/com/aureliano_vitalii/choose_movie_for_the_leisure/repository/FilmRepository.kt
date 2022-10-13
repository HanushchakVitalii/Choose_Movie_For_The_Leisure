package com.aureliano_vitalii.choose_movie_for_the_leisure.repository

import android.util.Log
import com.aureliano_vitalii.choose_movie_for_the_leisure.api.ApiService
import com.aureliano_vitalii.choose_movie_for_the_leisure.di.AppScope
import com.aureliano_vitalii.choose_movie_for_the_leisure.entity.AdditionalFilmInfo
import com.aureliano_vitalii.choose_movie_for_the_leisure.entity.ShortFilmInfo
import com.aureliano_vitalii.choose_movie_for_the_leisure.pojo.GenreResponseDto
import com.aureliano_vitalii.choose_movie_for_the_leisure.pojo.MainFilmResponseDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AppScope
class FilmRepository @Inject constructor(private val apiService: ApiService){

    private var mainFilmResponseDto: MainFilmResponseDto? = null
    private val filmShortInfoSet = mutableSetOf<ShortFilmInfo>()
    private val filmInfoMap = mutableMapOf<Int?, AdditionalFilmInfo>()
    private var isSuccessfullLoadData: Boolean = false
    private var isSuccessfullLoadGenre: Boolean = false
    private var genreFilmResponseDto: GenreResponseDto? = null
    private val genreMap = mutableMapOf<Int?, String?>()


    suspend fun loadData() = withContext(Dispatchers.IO) {
        try {
            mainFilmResponseDto = apiService.getMainFilmResponse()
            isSuccessfullLoadData = true

        } catch (e: Exception) {
        }

    }

    suspend fun loadGenre() = withContext(Dispatchers.IO)  {
        try {
            genreFilmResponseDto = apiService.getGenreFilmResponse()
            isSuccessfullLoadGenre = true
            createMapGenre()
            createAdditionalFilmInfo()
        } catch (e: Exception) {
        }
    }

    private fun createMapGenre()  {
        genreFilmResponseDto?.let {
            for (i in it.genres!!) {
                genreMap[i.id] = i.name
            }
        }
    }

    fun getFilmShortInfoSet(): Set<ShortFilmInfo> {
        createShortFilmInfo()
        return filmShortInfoSet
    }

    fun getFilmAdditionalInfo(id: Int): AdditionalFilmInfo? {
        return filmInfoMap[id]
    }

    private fun getGenre(list: List<Int>?): String {
        var str = ""
        if (list != null) {
            for (i in list) {
                str += genreMap[i] + ", "
            }
        }
        Log.d("Repository", str)
        return str

    }


    private fun createShortFilmInfo() {
        if (isSuccessfullLoadData) {
            mainFilmResponseDto?.let {
                for (i in it.results!!) {
                    val shortFilmInfo = ShortFilmInfo(
                        i.id,
                        i.title,
                        Companion.BASE_URL_FOR_IMAGE + i.posterPath,
                        i.voteAverage
                    )
                    filmShortInfoSet.add(shortFilmInfo)
                }
            }
        }

    }


    private fun createAdditionalFilmInfo() {
        if (isSuccessfullLoadData) {
            mainFilmResponseDto?.let {
                for (i in it.results!!) {
                    val additionalFilmInfo = AdditionalFilmInfo(
                        i.adult,
                        getGenre(i.genreIds),
                        i.overview,
                        i.voteCount,
                        i.releaseDate
                    )
                    filmInfoMap[i.id] = additionalFilmInfo
                }
            }
        }

    }

    companion object {
        private const val BASE_URL_FOR_IMAGE = "https://image.tmdb.org/t/p/w500"
    }


}
