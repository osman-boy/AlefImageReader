package kz.osman.alefimagereader.presentation.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.osman.alefimagereader.Application
import kz.osman.alefimagereader.R
import kz.osman.alefimagereader.databinding.FragmentImageListBinding
import kz.osman.alefimagereader.presentation.adapter.ImageListAdapter
import kz.osman.alefimagereader.presentation.viewmodels.MainViewModel

/**
 * Created by Osman Zhuzhoev at 03.10.2022
 */
class ImageListFragment : Fragment() {

    private var _binding: FragmentImageListBinding? = null
    private val binding: FragmentImageListBinding get() = _binding!!

    private val viewModel: MainViewModel by viewModels { (requireActivity().application as Application).component.viewModelFactory() }
    private val imageListAdapter = ImageListAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImageListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView(requireContext())

        viewModel.imageUrlList.observe(viewLifecycleOwner) {
            imageListAdapter.submitList(it)
        }
    }

    private fun setupRecyclerView(context: Context) {
        imageListAdapter.onImageClickListener = {
            parentFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, ShowImageFullScreen.newInstance(it))
                .commit()
        }
        binding.imagesRecycler.setGridlayoutColumn(context)
        binding.imagesRecycler.adapter = imageListAdapter
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun RecyclerView.setGridlayoutColumn(context: Context) {
        val getColumnCount = resources.getInteger(R.integer.column_count)
        this.layoutManager = GridLayoutManager(context, getColumnCount)
    }
}