package com.aureliano_vitalii.choose_movie_for_the_leisure.entity

data class AdditionalFilmInfo (
    val adult: Boolean? = null,
    val genreIds: List<Int>? = null,
    val overview: String? = null,
    val voteCount: Int? = null,
    val releaseDate: String? = null,
)