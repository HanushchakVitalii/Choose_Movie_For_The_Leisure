package com.aureliano_vitalii.choose_movie_for_the_leisure.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aureliano_vitalii.choose_movie_for_the_leisure.R
import com.aureliano_vitalii.choose_movie_for_the_leisure.databinding.FilmShortInfoItemBinding
import com.aureliano_vitalii.choose_movie_for_the_leisure.entity.ShortFilmInfo
import com.bumptech.glide.Glide


class FilmListAdapter : ListAdapter<ShortFilmInfo, FilmListAdapter.FilmShortInfoViewHolder>(FilmShortItemDiffCallback()) {

    var onFilmItemClickListener: ((ShortFilmInfo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmShortInfoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FilmShortInfoItemBinding.inflate(inflater, parent, false)
        Log.d("Holder", binding.toString())
        return FilmShortInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmShortInfoViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }


    inner class FilmShortInfoViewHolder(private val binding: FilmShortInfoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(itemFilm: ShortFilmInfo) {
            with(binding) {
                itemCard.setOnClickListener {
                    onFilmItemClickListener?.invoke(itemFilm)
                }
                titleName.text = itemFilm.title
                voteAverageView.text = itemFilm.voteAverage.toString()
                Glide.with(posterView.context)
                    .load(itemFilm.poster_path)
                    .placeholder(R.drawable.placeholder_film)
                    .error(R.drawable.placeholder_film)
                    .into(posterView)

            }

        }
    }

}