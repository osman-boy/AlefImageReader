package kz.osman.alefimagereader.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kz.osman.alefimagereader.R
import kz.osman.alefimagereader.databinding.FragmentShowImageFullScreenBinding

/**
 * Created by Osman Zhuzhoev at 03.10.2022
 */

class ShowImageFullScreen : Fragment() {

    private var imageUrl = ""
    private var _binding: FragmentShowImageFullScreenBinding? = null
    private val binding: FragmentShowImageFullScreenBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            imageUrl = getString(IMAGE_URL_PARAM, "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShowImageFullScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(view.context).load(imageUrl).centerCrop()
            .placeholder(R.drawable.placeholder)
            .into(binding.image)
    }

    companion object {

        private const val IMAGE_URL_PARAM = "image_url"

        @JvmStatic
        fun newInstance(imageUrl: String) =
            ShowImageFullScreen().apply {
                arguments = Bundle().apply {
                    putString(IMAGE_URL_PARAM, imageUrl)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}