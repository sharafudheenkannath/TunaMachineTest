package com.example.tuna_test.view.listing.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tuna_test.R
import com.example.tuna_test.databinding.RowRoomListBinding
import com.example.tuna_test.view.listing.model.EscapeRoomsMovy

class MovieListAdapter(private val context: Context, private val list: ArrayList<EscapeRoomsMovy>, private val callBack: MovieListAdapterListener) :
    RecyclerView.Adapter<MovieListAdapter.Holder>() {
    inner class Holder(binding: RowRoomListBinding) : RecyclerView.ViewHolder(binding.root) {
        private val itemBinding = binding
        fun bind(itemPosition: Int, data: EscapeRoomsMovy) {
            itemBinding.data = data
            itemBinding.callBack = callBack
            itemBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding: RowRoomListBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.row_room_list, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position, list[position])
    }

    override fun getItemCount(): Int = list.size

    interface MovieListAdapterListener {
        fun onItemClicked(data: EscapeRoomsMovy)
    }
}