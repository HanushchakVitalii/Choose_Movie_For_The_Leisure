package com.aureliano_vitalii.choose_movie_for_the_leisure.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aureliano_vitalii.choose_movie_for_the_leisure.entity.ShortFilmInfo
import com.aureliano_vitalii.choose_movie_for_the_leisure.repository.FilmRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


class FilmInfoViewModel @Inject constructor(repository: FilmRepository) : ViewModel() {


    val filmList = MutableLiveData<List<ShortFilmInfo>>()

    init {
        viewModelScope.launch {
                repository.loadData()
                filmList.postValue(repository.getFilmShortInfoSet().toList())


            repository.loadGenre()
//            Log.d("VM", "$counter")

        }
    }
}








