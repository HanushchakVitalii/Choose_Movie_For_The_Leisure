package com.aureliano_vitalii.choose_movie_for_the_leisure.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class GenreDto(

    @SerializedName("id")
    @Expose
    val id: Int? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null
)