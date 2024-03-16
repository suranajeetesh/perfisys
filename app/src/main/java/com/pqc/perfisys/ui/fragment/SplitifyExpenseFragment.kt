package com.pqc.perfisys.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newbasicstructure.util.extensionFunction.gotoBack
import com.pqc.perfisys.core.ui.BaseFragment
import com.pqc.perfisys.data.local.HistoryModel
import com.pqc.perfisys.databinding.FragmentSplitifyExpenseBinding
import com.pqc.perfisys.ui.adapter.HistoryAdapter
import com.pqc.perfisys.viewmodel.SplitifyViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Jeetesh Surana.
 */
@AndroidEntryPoint
class SplitifyExpenseFragment : BaseFragment() {

    private lateinit var binding: FragmentSplitifyExpenseBinding
    private val splitifyViewModel: SplitifyViewModel by viewModels()
    private var mAdapter: HistoryAdapter? = null
    private var list = ArrayList<HistoryModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplitifyExpenseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initRecyclerView()
        initObserver()
        binding.imgBack.setOnClickListener {
            gotoBack()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initObserver() {
        splitifyViewModel.historyList.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) {
                list.clear()
                list.addAll(it)
                mAdapter?.notifyDataSetChanged()
            }
        })
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        mAdapter = HistoryAdapter(list)
        binding.historyList.layoutManager = layoutManager
        binding.historyList.adapter = mAdapter
    }
}