package com.aureliano_vitalii.choose_movie_for_the_leisure.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aureliano_vitalii.choose_movie_for_the_leisure.databinding.FilmShortInfoItemBinding
import com.aureliano_vitalii.choose_movie_for_the_leisure.entity.FilmShortInfo
import com.squareup.picasso.Picasso

class FilmListAdapter : RecyclerView.Adapter<FilmListAdapter.FilmShortInfoViewHolder>() {
    var filmInfoList = listOf<FilmShortInfo>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmShortInfoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FilmShortInfoItemBinding.inflate(inflater, parent, false)
        Log.d("Holder", binding.toString())
        return FilmShortInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmShortInfoViewHolder, position: Int) {
        holder.bindView(filmInfoList[position])
    }

    override fun getItemCount(): Int {
        return filmInfoList.size
    }

    class FilmShortInfoViewHolder(private val binding: FilmShortInfoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(filmItem: FilmShortInfo) {
            binding.titleName.text = filmItem.title
            binding.voteAverageView.text = filmItem.voteAverage.toString()
            Picasso.get().load(filmItem.poster_path).into(binding.posterView)
        }
    }

}