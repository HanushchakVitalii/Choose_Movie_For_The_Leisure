package com.aureliano_vitalii.choose_movie_for_the_leisure.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.aureliano_vitalii.choose_movie_for_the_leisure.R
import com.aureliano_vitalii.choose_movie_for_the_leisure.api.ApiFactory

class MainActivity : AppCompatActivity() {


    private lateinit var btn: Button
    private lateinit var textView: TextView
    private lateinit var viewModel: FilmInfoViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[FilmInfoViewModel::class.java]

        viewModel.load()
        btn = findViewById(R.id.btnCheck)
        textView = findViewById(R.id.textView)



    }



}
