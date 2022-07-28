package com.aureliano_vitalii.choose_movie_for_the_leisure.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aureliano_vitalii.choose_movie_for_the_leisure.R
import com.aureliano_vitalii.choose_movie_for_the_leisure.databinding.FilmShortInfoItemBinding
import com.aureliano_vitalii.choose_movie_for_the_leisure.entity.FilmShortInfo
import com.bumptech.glide.Glide


class FilmListAdapter : ListAdapter<FilmShortInfo, FilmListAdapter.FilmShortInfoViewHolder>(FilmShortItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmShortInfoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FilmShortInfoItemBinding.inflate(inflater, parent, false)
        Log.d("Holder", binding.toString())
        return FilmShortInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmShortInfoViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }


    class FilmShortInfoViewHolder(private val binding: FilmShortInfoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(filmItem: FilmShortInfo) {
            with(binding) {
                titleName.text = filmItem.title
                voteAverageView.text = filmItem.voteAverage.toString()
                Glide.with(posterView.context)
                    .load(filmItem.poster_path)
                    .placeholder(R.drawable.placeholder_film)
                    .error(R.drawable.placeholder_film)
                    .into(posterView)
            }

        }
    }

}