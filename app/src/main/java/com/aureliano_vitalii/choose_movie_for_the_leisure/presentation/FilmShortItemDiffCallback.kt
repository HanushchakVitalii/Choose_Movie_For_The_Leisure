package com.aureliano_vitalii.choose_movie_for_the_leisure.presentation

import androidx.recyclerview.widget.DiffUtil
import com.aureliano_vitalii.choose_movie_for_the_leisure.entity.ShortFilmInfo

class FilmShortItemDiffCallback: DiffUtil.ItemCallback<ShortFilmInfo>() {

    override fun areItemsTheSame(oldItem: ShortFilmInfo, newItem: ShortFilmInfo): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ShortFilmInfo, newItem: ShortFilmInfo): Boolean {
        return oldItem == newItem
    }
}