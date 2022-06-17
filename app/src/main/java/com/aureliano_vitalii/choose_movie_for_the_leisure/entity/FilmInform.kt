package com.aureliano_vitalii.choose_movie_for_the_leisure.entity

data class FilmInform(
    val id: Int,
    val title: String,
    val poster: String,
    val overview: String,
    val voteAverage: Double,
    val voteCount: Int,
    val generes: List<String>,
    val releaseDate: String,
    val adult: Boolean

)
