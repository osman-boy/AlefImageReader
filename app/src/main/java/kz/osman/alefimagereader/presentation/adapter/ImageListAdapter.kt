package kz.osman.alefimagereader.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.osman.alefimagereader.R
import kz.osman.alefimagereader.databinding.ImageItemBinding

/**
 * Created by Osman Zhuzhoev on 3/9/2022.
 */

typealias OnImageClickListener = (String) -> Unit

class ImageListAdapter : ListAdapter<String, ImageListAdapter.ImageViewHolder>(DiffUtil()) {

    class ImageViewHolder(val binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root)

    var onImageClickListener: OnImageClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ImageItemBinding.inflate(inflater, parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageView = holder.binding.image
        val item = getItem(position)

        Glide.with(imageView.context).load(item).centerCrop()
            .placeholder(R.drawable.placeholder)
            .into(imageView)

        imageView.setOnClickListener { onImageClickListener?.invoke(item) }
    }
}