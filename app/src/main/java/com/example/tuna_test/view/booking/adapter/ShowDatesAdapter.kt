package com.example.tuna_test.view.booking.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tuna_test.R
import com.example.tuna_test.databinding.RowShowDateBinding
import com.example.tuna_test.view.booking.model.ShowTime

class ShowDatesAdapter(private val context: Context, private val list: ArrayList<ShowTime>) :
    RecyclerView.Adapter<ShowDatesAdapter.Holder>() {
    inner class Holder(binding: RowShowDateBinding) : RecyclerView.ViewHolder(binding.root) {
        private val itemBinding = binding
        fun bind(itemPosition: Int, data: ShowTime) {
            itemBinding.data = data
            itemBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding: RowShowDateBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.row_show_date, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position, list[position])
    }

    override fun getItemCount(): Int = list.size

}