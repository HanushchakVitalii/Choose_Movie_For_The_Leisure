package com.aureliano_vitalii.choose_movie_for_the_leisure.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShortFilmInfo(
    val id: Int?,
    val title: String?,
    val poster_path: String?,
    val voteAverage: Double?,
):Parcelable
