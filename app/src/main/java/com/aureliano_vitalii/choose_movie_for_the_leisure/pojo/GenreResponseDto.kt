package com.aureliano_vitalii.choose_movie_for_the_leisure.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class GenreResponseDto (
    @SerializedName("genres")
    @Expose
    private val genres: List<GenreDto>? = null

)