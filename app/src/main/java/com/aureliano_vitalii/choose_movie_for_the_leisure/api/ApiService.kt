package com.aureliano_vitalii.choose_movie_for_the_leisure.api

import com.aureliano_vitalii.choose_movie_for_the_leisure.BuildConfig
import com.aureliano_vitalii.choose_movie_for_the_leisure.pojo.GenreResponseDto
import com.aureliano_vitalii.choose_movie_for_the_leisure.pojo.MainFilmResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("3/movie/top_rated")
    suspend fun getMainFilmResponse(
        @Query(QUERY_PARAM_API_KEY) apiKey:String = BuildConfig.API_KEY,
        @Query(QUERY_PARAM_LANG) lang:String = LANG_DEFAULT,
        @Query(QUERY_PARAM_PAGE) page:Int = PAGE_DEFAULT): MainFilmResponseDto

    @GET("3/genre/movie/list")
    suspend fun getGenreFilmResponse(
        @Query(QUERY_PARAM_API_KEY) apiKey:String = BuildConfig.API_KEY,
        @Query(QUERY_PARAM_LANG) lang:String = LANG_DEFAULT): GenreResponseDto


    companion object {
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_LANG = "language"
        private const val QUERY_PARAM_PAGE = "page"

        private const val LANG_DEFAULT = "en-US"
        private const val PAGE_DEFAULT = 1
    }
}