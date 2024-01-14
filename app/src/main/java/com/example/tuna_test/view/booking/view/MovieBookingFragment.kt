package com.example.tuna_test.view.booking.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.tuna_test.BR
import com.example.tuna_test.R
import com.example.tuna_test.base.BaseFragmentDataBinding
import com.example.tuna_test.databinding.FragmentMovieBookingBinding
import com.example.tuna_test.view.booking.adapter.ShowDatesAdapter
import com.example.tuna_test.view.booking.adapter.ShowTimesAdapter
import com.example.tuna_test.view.booking.model.ShowTime
import com.example.tuna_test.view.booking.viewmodel.MovieBookingFragmentVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieBookingFragment : BaseFragmentDataBinding<FragmentMovieBookingBinding, MovieBookingFragmentVM>() {
    private val vm: MovieBookingFragmentVM by viewModels()
    private val args: MovieBookingFragmentArgs by navArgs()
    private val timeList = ArrayList<ShowTime>()
    private val showTimesAdapter: ShowTimesAdapter by lazy {
        ShowTimesAdapter(requireContext(), timeList)
    }
    private val dateList = ArrayList<String>()
    private val showDatesAdapter: ShowDatesAdapter by lazy {
        ShowDatesAdapter(requireContext(), dateList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.loadMovieInfo(args.movieId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getViewModel(): MovieBookingFragmentVM = vm

    override fun getLayoutId(): Int = R.layout.fragment_movie_booking

    override fun initLayout() {
        binding.rvShowDate.adapter = showDatesAdapter
        binding.rvShowTime.adapter = showTimesAdapter
    }

    override fun setupObservers() {
        vm.movieInfoResult.observe(viewLifecycleOwner) {
            timeList.clear()
            timeList.addAll(it.show_times)
            showTimesAdapter.notifyDataSetChanged()
            dateList.clear()
            dateList.addAll(it.date_list)
            showDatesAdapter.notifyDataSetChanged()
        }

    }

}