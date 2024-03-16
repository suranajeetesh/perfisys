package com.pqc.perfisys.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.newbasicstructure.util.extensionFunction.addReplaceFragment
import com.pqc.perfisys.R
import com.pqc.perfisys.core.ui.BaseFragment
import com.pqc.perfisys.data.local.PersonData
import com.pqc.perfisys.databinding.FragmentSplitifyBinding
import com.pqc.perfisys.ui.adapter.PersonAdapter
import com.pqc.perfisys.viewmodel.SplitifyViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Jeetesh Surana.
 */
@AndroidEntryPoint
class SplitifyFragment : BaseFragment() {

    private lateinit var binding: FragmentSplitifyBinding
    private var mAdapter: PersonAdapter?=null
    private val splitifyViewModel: SplitifyViewModel by viewModels()
    private var list = ArrayList<PersonData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplitifyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        Glide.with(this)
            .asGif()
            .load(R.raw.game)
            .into(binding.game)
        initRecyclerView()
        initObserver()
        binding.cvShowExpenses.setOnClickListener {
            requireActivity().addReplaceFragment(R.id.fl_container, SplitifyExpenseFragment(), addFragment = false, true)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initObserver() {
        splitifyViewModel.personList.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) {
                list.clear()
                list.addAll(it)
                mAdapter?.setPersonList(list)
            }
        })
    }

    private fun initRecyclerView() {
        mAdapter = PersonAdapter(object:PersonAdapter.OnPersonClickListener{
            override fun onPersonClick(person: PersonData) {

            }
        })
        binding.rvPersonList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPersonList.adapter = mAdapter
    }
}