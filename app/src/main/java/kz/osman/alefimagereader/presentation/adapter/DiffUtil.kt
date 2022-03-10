package kz.osman.alefimagereader.presentation.adapter

import androidx.recyclerview.widget.DiffUtil

/**
 * Created by Osman Zhuzhoev on 3/9/2022.
 */
class DiffUtil:DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}