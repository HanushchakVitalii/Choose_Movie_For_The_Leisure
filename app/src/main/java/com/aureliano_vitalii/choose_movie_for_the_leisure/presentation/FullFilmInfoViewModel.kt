package com.aureliano_vitalii.choose_movie_for_the_leisure.presentation

import androidx.lifecycle.ViewModel
import com.aureliano_vitalii.choose_movie_for_the_leisure.entity.AdditionalFilmInfo
import com.aureliano_vitalii.choose_movie_for_the_leisure.pojo.FilmInfoDto
import com.aureliano_vitalii.choose_movie_for_the_leisure.repository.FilmRepository
import javax.inject.Inject

class FullFilmInfoViewModel @Inject constructor(private val repository: FilmRepository): ViewModel() {

    fun getItemFullFilmInfo(id: Int): AdditionalFilmInfo?{
        return repository.getFilmAdditionalInfo(id)
    }


}