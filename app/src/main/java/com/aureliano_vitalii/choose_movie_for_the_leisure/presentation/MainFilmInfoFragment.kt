package com.aureliano_vitalii.choose_movie_for_the_leisure.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aureliano_vitalii.choose_movie_for_the_leisure.databinding.FragmentMainFilmInfoBinding


class MainFilmInfoFragment : Fragment() {

    private var _binding: FragmentMainFilmInfoBinding? = null
    private val binding: FragmentMainFilmInfoBinding
        get() = _binding ?: throw RuntimeException("FragmentMainFilmInfoBinding == null")
    private lateinit var viewModel: FilmInfoViewModel
    private lateinit var filmAdapter: FilmListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainFilmInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setupRecyclerView() {
        val rvFilmListInfo = _binding?.rvFilmListInfo
        filmAdapter = FilmListAdapter()
        rvFilmListInfo?.adapter = filmAdapter
        Log.d("onSetupRecycler", filmAdapter.toString())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel = ViewModelProvider(this)[FilmInfoViewModel::class.java]

        viewModel.filmList.observe(viewLifecycleOwner) {
            filmAdapter.filmInfoList = it
            Log.d("viewCeated", filmAdapter.filmInfoList.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}