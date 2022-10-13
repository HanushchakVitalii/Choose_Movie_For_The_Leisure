package com.aureliano_vitalii.choose_movie_for_the_leisure.di

import android.content.Context
import com.aureliano_vitalii.choose_movie_for_the_leisure.presentation.FullFilmInfoFragment
import com.aureliano_vitalii.choose_movie_for_the_leisure.presentation.MainActivity
import com.aureliano_vitalii.choose_movie_for_the_leisure.presentation.MainFilmInfoFragment
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [ ViewModelModule::class, RetrofitModule::class ]
)
interface AppComponent {

    fun inject(fragment: MainFilmInfoFragment)

    fun inject(fragment: FullFilmInfoFragment)

    @Component.Factory
    interface ApplicationComponentFactory {

        fun create(
            @BindsInstance context: Context
        ): AppComponent

    }
}
