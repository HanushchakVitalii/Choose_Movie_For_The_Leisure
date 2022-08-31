package com.aureliano_vitalii.choose_movie_for_the_leisure.di

import androidx.lifecycle.ViewModel
import com.aureliano_vitalii.choose_movie_for_the_leisure.presentation.FilmInfoViewModel
import com.aureliano_vitalii.choose_movie_for_the_leisure.presentation.FullFilmInfoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FilmInfoViewModel::class)
    fun bindFilmInfoViewModel(viewModel: FilmInfoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FullFilmInfoViewModel::class)
    fun bindFullFilmInfoViewModel(viewModel: FullFilmInfoViewModel): ViewModel
}