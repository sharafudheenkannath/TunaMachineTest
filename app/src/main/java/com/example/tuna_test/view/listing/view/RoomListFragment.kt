package com.example.tuna_test.view.listing.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tuna_test.BR
import com.example.tuna_test.R
import com.example.tuna_test.base.BaseFragmentDataBinding
import com.example.tuna_test.databinding.BottomSheetMovieDetailsBinding
import com.example.tuna_test.databinding.FragmentRoomListBinding
import com.example.tuna_test.util.DataResult
import com.example.tuna_test.view.listing.adapter.MovieListAdapter
import com.example.tuna_test.view.listing.model.EscapeRoomsMovy
import com.example.tuna_test.view.listing.viewmodel.RoomListFragmentVM
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RoomListFragment : BaseFragmentDataBinding<FragmentRoomListBinding, RoomListFragmentVM>(), MovieListAdapter.MovieListAdapterListener {
    private val vm: RoomListFragmentVM by viewModels()
    private val roomList = ArrayList<EscapeRoomsMovy>()
    private val adapter: MovieListAdapter by lazy {
        MovieListAdapter(requireContext(), roomList, this)
    }
    private val bottomSheet: BottomSheetDialog by lazy {
        BottomSheetDialog(requireContext())
    }
    private lateinit var selectedMovieId: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getViewModel(): RoomListFragmentVM = vm

    override fun getLayoutId(): Int = R.layout.fragment_room_list

    override fun initLayout() {
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.rvRoomList.adapter = adapter
    }

    override fun setupObservers() {
        vm.movieListResult.observe(viewLifecycleOwner) {
            when (it.status) {
                DataResult.Status.SUCCESS -> {
                    loader.hide()
                    roomList.clear()
                    roomList.addAll(it.data as ArrayList<EscapeRoomsMovy>)
                    adapter.notifyDataSetChanged()
                }

                DataResult.Status.ERROR -> {
                    loader.hide()
                    showToast(it.message.toString())
                }

                DataResult.Status.LOADING -> {
                    loader.show()
                }
            }
        }
        vm.navigateToBookingPage.observe(viewLifecycleOwner) {
            if (it) {
                bottomSheet.dismiss()
                findNavController().navigate(RoomListFragmentDirections.actionMovieBookingFragment(selectedMovieId))
            }
        }
    }

    override fun onItemClicked(data: EscapeRoomsMovy) {
        showMovieInfoBottomSheet(data)
    }

    private fun showMovieInfoBottomSheet(data: EscapeRoomsMovy) {
        selectedMovieId = data.ScheduledFilmId
        vm.selectedMovieData = data
        val bottomSheetBinding: BottomSheetMovieDetailsBinding =
            DataBindingUtil.inflate(LayoutInflater.from(requireContext()), R.layout.bottom_sheet_movie_details, null, false)
        bottomSheetBinding.viewModel = vm
        bottomSheetBinding.executePendingBindings()
        bottomSheet.setContentView(bottomSheetBinding.root)
        bottomSheet.show()
        bottomSheetBinding.ivClose.setOnClickListener { bottomSheet.dismiss() }
    }
}