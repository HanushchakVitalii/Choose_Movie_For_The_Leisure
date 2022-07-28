package com.aureliano_vitalii.choose_movie_for_the_leisure.presentation

import androidx.recyclerview.widget.DiffUtil
import com.aureliano_vitalii.choose_movie_for_the_leisure.entity.FilmShortInfo

class FilmShortItemDiffCallback: DiffUtil.ItemCallback<FilmShortInfo>() {

    override fun areItemsTheSame(oldItem: FilmShortInfo, newItem: FilmShortInfo): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: FilmShortInfo, newItem: FilmShortInfo): Boolean {
        return oldItem == newItem
    }
}