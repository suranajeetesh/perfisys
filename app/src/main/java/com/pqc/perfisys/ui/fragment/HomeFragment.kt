package com.pqc.perfisys.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newbasicstructure.util.extensionFunction.addReplaceFragment
import com.pqc.perfisys.R
import com.pqc.perfisys.core.ui.BaseFragment
import com.pqc.perfisys.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Jeetesh Surana.
 */
@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ActivityHomeBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.cvMargh.setOnClickListener {
            requireActivity().addReplaceFragment(R.id.fl_container, MarghFragment(), addFragment = false, true)
        }
        binding.cvSplitify.setOnClickListener {
            requireActivity().addReplaceFragment(R.id.fl_container, SplitifyFragment(), addFragment = false, true)
        }
    }

}