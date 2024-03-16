package com.pqc.perfisys.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.example.newbasicstructure.util.extensionFunction.addReplaceFragment
import com.pqc.perfisys.R
import com.pqc.perfisys.core.ui.BaseActivity
import com.pqc.perfisys.databinding.ActivityMainBinding
import com.pqc.perfisys.ui.fragment.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addReplaceFragment(R.id.fl_container, HomeFragment(), addFragment = false, false)
    }
}