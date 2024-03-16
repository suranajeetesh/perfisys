package com.pqc.perfisys.ui.fragment

import BottomSheetFragment
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.pqc.perfisys.core.ui.BaseFragment
import com.pqc.perfisys.data.local.ImageData
import com.pqc.perfisys.databinding.FragmentHomeBinding
import com.pqc.perfisys.ui.adapter.ImageAdapter
import com.pqc.perfisys.viewmodel.ImageViewModel
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by Jeetesh Surana.
 */
@AndroidEntryPoint
class MarghHomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding
    private var mAdapter: ImageAdapter? = null
    private var list = ArrayList<ImageData>()

    private val imageViewModel: ImageViewModel by viewModels()
    var bottomSheetFragment: BottomSheetFragment? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initObserver()
        binding.clSearch.setOnClickListener {
            openBottomSheet()
        }
        binding.imgVoice.setOnClickListener {
            openBottomSheet()
        }
        binding.edtSearch.setOnClickListener {
            openBottomSheet()
        }
    }

    private fun openBottomSheet() {
        if (bottomSheetFragment == null) {
            bottomSheetFragment = BottomSheetFragment()
        }

//        bottomSheetFragment?.setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenBottomSheetDialogTheme)
        bottomSheetFragment?.show(
            requireActivity().supportFragmentManager,
            bottomSheetFragment?.tag
        )
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvHome.layoutManager = layoutManager
        mAdapter = ImageAdapter(requireContext(), list, object : ImageAdapter.OnItemClickListener {
            override fun onItemClick(imageData: ImageData) {
                Toast.makeText(requireContext(), "Work In Progress", Toast.LENGTH_SHORT).show()
            }
        })
        binding.rvHome.adapter = mAdapter
        LinearSnapHelper().attachToRecyclerView(binding.rvHome)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initObserver() {
        imageViewModel.imageList.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) {
                list.clear()
                list.addAll(it)
                mAdapter?.notifyDataSetChanged()
            }
        })
    }

}