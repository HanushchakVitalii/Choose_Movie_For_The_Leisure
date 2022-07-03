package com.aureliano_vitalii.choose_movie_for_the_leisure.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aureliano_vitalii.choose_movie_for_the_leisure.databinding.FragmentMainFilmInfoBinding


class MainFilmInfoFragment : Fragment() {

    private var _binding: FragmentMainFilmInfoBinding? = null
    private val binding: FragmentMainFilmInfoBinding
        get() = _binding ?: throw RuntimeException("FragmentMainFilmInfoBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainFilmInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}