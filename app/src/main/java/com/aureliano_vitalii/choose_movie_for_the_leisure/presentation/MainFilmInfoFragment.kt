package com.aureliano_vitalii.choose_movie_for_the_leisure.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aureliano_vitalii.choose_movie_for_the_leisure.R
import com.aureliano_vitalii.choose_movie_for_the_leisure.databinding.FragmentMainFilmInfoBinding
import com.aureliano_vitalii.choose_movie_for_the_leisure.entity.ShortFilmInfo
import javax.inject.Inject


class MainFilmInfoFragment : Fragment() {

    private val component by lazy{
        (requireActivity().application as FilmApp).component
    }

    private var _binding: FragmentMainFilmInfoBinding? = null
    private val binding: FragmentMainFilmInfoBinding
        get() = _binding ?: throw RuntimeException("FragmentMainFilmInfoBinding == null")
    private lateinit var viewModel: FilmInfoViewModel
    private lateinit var filmAdapter: FilmListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainFilmInfoBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel = ViewModelProvider(this, viewModelFactory)[FilmInfoViewModel::class.java]

        viewModel.filmList.observe(viewLifecycleOwner) {
            filmAdapter.submitList(it)

        }
        setupClickListener()
    }

    private fun setupClickListener(){
        filmAdapter.onShopItemClickListener = {
             launchFullFilmFragment(it)
        }
    }

    private fun setupRecyclerView() {
        val rvFilmListInfo = _binding?.rvFilmListInfo
        filmAdapter = FilmListAdapter()
        rvFilmListInfo?.adapter = filmAdapter
    }

    private fun launchFullFilmFragment(film: ShortFilmInfo){
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, FullFilmInfoFragment.newInstance(film))
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}