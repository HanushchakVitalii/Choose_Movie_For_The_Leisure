package com.aureliano_vitalii.choose_movie_for_the_leisure.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aureliano_vitalii.choose_movie_for_the_leisure.entity.ShortFilmInfo
import com.aureliano_vitalii.choose_movie_for_the_leisure.repository.FilmRepository
import kotlinx.coroutines.launch


class FilmInfoViewModel : ViewModel() {


    val filmList = MutableLiveData<List<ShortFilmInfo>>()

    init {
        viewModelScope.launch {
            for(i in 1..20){
                FilmRepository.loadData(i)
                filmList.postValue(FilmRepository.getFilmShortInfoSet().toList())

            }

//            Log.d("VM", "$counter")

        }
    }
}








