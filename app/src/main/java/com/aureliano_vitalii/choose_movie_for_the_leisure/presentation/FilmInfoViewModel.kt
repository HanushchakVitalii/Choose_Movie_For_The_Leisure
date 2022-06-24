package com.aureliano_vitalii.choose_movie_for_the_leisure.presentation

import androidx.lifecycle.ViewModel
import com.aureliano_vitalii.choose_movie_for_the_leisure.repository.FilmRepository
import kotlinx.coroutines.*


class FilmInfoViewModel:ViewModel() {

    var job: Job? = null
    private var tempStr = "НИХУЯ"

    fun worktaksyak(): String {
        return FilmRepository.getddd()
    }


    fun load() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val check = FilmRepository.loadData()
            withContext(Dispatchers.Main) {
                if (check) {
                    tempStr = FilmRepository.getddd()

                }
            }

        }
    }
}