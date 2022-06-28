package com.aureliano_vitalii.choose_movie_for_the_leisure.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class MainFilmResponseDto(
    @SerializedName("page")
    @Expose
    val page: Int? = null,

    @SerializedName("results")
    @Expose
    val results: List<FilmInfoDto>? = null,

    @SerializedName("total_pages")
    @Expose
    val totalPages: Int? = null,

    @SerializedName("total_results")
    @Expose
    val totalResults: Int? = null
)