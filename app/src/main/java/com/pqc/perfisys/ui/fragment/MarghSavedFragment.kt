package com.pqc.perfisys.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pqc.perfisys.core.ui.BaseFragment
import com.pqc.perfisys.databinding.FragmentProfileBinding
import com.pqc.perfisys.databinding.FragmentSavedBinding
import com.pqc.perfisys.databinding.FragmentSplitifyBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Jeetesh Surana.
 */
@AndroidEntryPoint
class MarghSavedFragment : BaseFragment() {

    private lateinit var binding: FragmentSavedBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSavedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

    }
}