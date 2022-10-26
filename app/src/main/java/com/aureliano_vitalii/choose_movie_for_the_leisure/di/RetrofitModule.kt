package com.aureliano_vitalii.choose_movie_for_the_leisure.di


import com.aureliano_vitalii.choose_movie_for_the_leisure.api.ApiService
import com.aureliano_vitalii.choose_movie_for_the_leisure.utils.NetworkConfig
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



@Module
object RetrofitModule {

    @AppScope
    @Provides
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(NetworkConfig.BASE_URL)

    }

    @AppScope
    @Provides
    fun provideRetrofitService(retrofit: Retrofit.Builder): ApiService {
        return retrofit
            .build()
            .create(ApiService::class.java)
    }

}