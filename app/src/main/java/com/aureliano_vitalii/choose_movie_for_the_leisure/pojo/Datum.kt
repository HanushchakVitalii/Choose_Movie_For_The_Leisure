package com.aureliano_vitalii.choose_movie_for_the_leisure.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class Datum (
    @SerializedName("page")
    @Expose
    private val page: Int? = null,

    @SerializedName("results")
    @Expose
    private val results: List<FilmInfo>? = null,

    @SerializedName("total_pages")
    @Expose
    private val totalPages: Int? = null,

    @SerializedName("total_results")
    @Expose
    private val totalResults: Int? = null
)