package com.aureliano_vitalii.choose_movie_for_the_leisure.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.aureliano_vitalii.choose_movie_for_the_leisure.R
import com.aureliano_vitalii.choose_movie_for_the_leisure.databinding.FragmentFullFilmInfoBinding
import com.aureliano_vitalii.choose_movie_for_the_leisure.entity.ShortFilmInfo
import com.aureliano_vitalii.choose_movie_for_the_leisure.presentation.viewmodels.FullFilmInfoViewModel
import com.aureliano_vitalii.choose_movie_for_the_leisure.presentation.viewmodels.ViewModelFactory
import com.bumptech.glide.Glide
import javax.inject.Inject


class FullFilmInfoFragment : Fragment() {

    private val component by lazy{
        (requireActivity().application as FilmApp).component
    }

    private lateinit var filmInfo: ShortFilmInfo

    private var _binding: FragmentFullFilmInfoBinding? = null
    private val binding: FragmentFullFilmInfoBinding
        get() = _binding ?: throw RuntimeException("FragmentFullFilmInfoBinding == null")


    lateinit var viewModel: FullFilmInfoViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFullFilmInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun parseArgs() {
        requireArguments().getParcelable<ShortFilmInfo>(FILM)?.let {
            filmInfo = it
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[FullFilmInfoViewModel::class.java]
        val filmAdditionalInfo = filmInfo.id?.let { viewModel.getItemFullFilmInfo(it) }
        with(binding){
            val into = Glide.with(posterView.context)
                .load(filmInfo.poster_path)
                .placeholder(R.drawable.placeholder_film)
                .error(R.drawable.placeholder_film)
                .into(posterView)
            titleName.text = filmInfo.title
            releaseDate.text = filmAdditionalInfo!!.releaseDate
            genreName.text = filmAdditionalInfo.genreIds
            voteAverageView.text = filmInfo.voteAverage.toString()
            voteCountView.text = filmAdditionalInfo.voteCount.toString()
            overview.text = filmAdditionalInfo.overview
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

   companion object {

       private const val FILM  = "film"

        fun newInstance(shortFilmInfo: ShortFilmInfo) =
            FullFilmInfoFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(FILM, shortFilmInfo)
                }
            }
    }
}