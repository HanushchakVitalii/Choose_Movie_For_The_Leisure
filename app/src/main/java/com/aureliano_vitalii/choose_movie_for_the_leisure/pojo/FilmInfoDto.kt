package com.aureliano_vitalii.choose_movie_for_the_leisure.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class FilmInfoDto (
    @SerializedName("adult")
    @Expose
     val adult: Boolean? = null,

    @SerializedName("genre_ids")
    @Expose
     val genreIds: List<Int>? = null,

    @SerializedName("id")
    @Expose
     val id: Int? = null,

    @SerializedName("overview")
    @Expose
     val overview: String? = null,

    @SerializedName("popularity")
    @Expose
     val popularity: Double? = null,

    @SerializedName("poster_path")
    @Expose
     val posterPath: String? = null,

    @SerializedName("release_date")
    @Expose
     val releaseDate: String? = null,

    @SerializedName("title")
    @Expose
     val title: String? = null,

    @SerializedName("video")
    @Expose
     val video: Boolean? = null,

    @SerializedName("vote_average")
    @Expose
     val voteAverage: Double? = null,

    @SerializedName("vote_count")
    @Expose
     val voteCount: Int? = null
)