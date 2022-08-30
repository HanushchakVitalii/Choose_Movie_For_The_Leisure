package com.aureliano_vitalii.choose_movie_for_the_leisure.presentation

import androidx.lifecycle.ViewModel
import com.aureliano_vitalii.choose_movie_for_the_leisure.entity.AdditionalFilmInfo
import com.aureliano_vitalii.choose_movie_for_the_leisure.pojo.FilmInfoDto
import com.aureliano_vitalii.choose_movie_for_the_leisure.repository.FilmRepository

class FullFilmInfoViewModel: ViewModel() {

    fun getItemFullFilmInfo(id: Int): AdditionalFilmInfo?{
        return FilmRepository.getFilmAdditionalInfo(id)
    }


}