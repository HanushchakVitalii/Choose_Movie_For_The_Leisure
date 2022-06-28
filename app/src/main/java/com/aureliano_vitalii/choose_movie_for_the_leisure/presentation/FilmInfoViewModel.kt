package com.aureliano_vitalii.choose_movie_for_the_leisure.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aureliano_vitalii.choose_movie_for_the_leisure.repository.FilmRepository
import kotlinx.coroutines.*


class FilmInfoViewModel:ViewModel() {

    var job: Job? = null


    fun load() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val check = FilmRepository.loadData()
            withContext(Dispatchers.Main) {
                if (check) {
                    FilmRepository.getFilmShotInfoSet()
                }
            }

        }
    }
}