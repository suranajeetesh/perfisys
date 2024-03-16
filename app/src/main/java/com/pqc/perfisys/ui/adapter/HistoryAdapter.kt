package com.pqc.perfisys.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pqc.perfisys.R
import com.pqc.perfisys.data.local.HistoryModel
import com.pqc.perfisys.databinding.HistoryItemBinding

/**
 * Created by Jeetesh Surana.
 */
class HistoryAdapter(private var historyList: ArrayList<HistoryModel>) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.history_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mData = historyList[position]
        holder.binding.txtItemName.text=mData.item
        holder.binding.txtItemPrice.text=mData.price
        holder.binding.txtItemPaidby.text=mData.paidBy
        holder.binding.txtDate.text=mData.date
        holder.binding.txtTime.text=mData.tima
    }


    override fun getItemCount() = historyList.size

    class ViewHolder(var binding: HistoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(list: HistoryModel) = binding.apply {
            executePendingBindings()
        }
    }
}
