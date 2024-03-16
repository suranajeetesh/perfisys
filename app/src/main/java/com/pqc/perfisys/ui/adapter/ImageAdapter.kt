package com.pqc.perfisys.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.pqc.perfisys.R
import com.pqc.perfisys.data.local.ImageData
import com.pqc.perfisys.databinding.ItemMarghBinding

class ImageAdapter(
    private val context: Context,
    private val imageList: List<ImageData>,
    private val itemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(imageData: ImageData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_margh, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageData = imageList[position]
        Log.e("TAG","onBindViewHolder() imageData--> $imageData")
        holder.bindData()
        Glide.with(context)
            .load(imageData.imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .into(holder.binding.imgQuotes)

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(imageData)
        }
    }

    override fun getItemCount(): Int {
        return imageList.size
    }


    class ImageViewHolder(var binding: ItemMarghBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData() = binding.apply {
            executePendingBindings()
        }
    }
}
