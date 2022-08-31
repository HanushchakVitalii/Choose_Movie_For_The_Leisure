package com.aureliano_vitalii.choose_movie_for_the_leisure.presentation

import android.app.Application



class FilmApp: Application(){
    val component by lazy{
//        DaggerAppComponent.factory().create(this)
    }
}