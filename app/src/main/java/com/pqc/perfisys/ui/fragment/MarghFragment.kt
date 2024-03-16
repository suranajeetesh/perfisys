package com.pqc.perfisys.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.pqc.perfisys.R
import com.pqc.perfisys.core.ui.BaseFragment
import com.pqc.perfisys.databinding.FragmentMarghBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Jeetesh Surana.
 */
@AndroidEntryPoint
class MarghFragment : BaseFragment() {

    private lateinit var binding: FragmentMarghBinding
    private var active: Fragment? = null
    private var fm: FragmentManager? = null
    private var fragment1: MarghHomeFragment? = null
    private var fragment2: MarghSavedFragment? = null
    private var fragment3: MarghProfileFragment? = null


    val fragments = mapOf(
        R.id.nav_home to MarghHomeFragment(),
        R.id.nav_save to MarghSavedFragment(),
        R.id.nav_profile to MarghProfileFragment()
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMarghBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            val fragment = fragments[menuItem.itemId]
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    fragment1?.let {
                        active?.let { it1 ->
                            fm?.beginTransaction()?.hide(it1)?.show(it)?.commit()
                        }
                    }
                    active = fragment1
                    return@setOnItemSelectedListener true
                }

                R.id.nav_save -> {
                    fm!!.beginTransaction().hide(active!!).show(fragment2!!).commit()
                    active = fragment2
                    return@setOnItemSelectedListener true
                }

                R.id.nav_profile -> {
                    fm!!.beginTransaction().hide(active!!).show(fragment3!!).commit()
                    active = fragment3
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
        binding.bottomNavigation.selectedItemId = R.id.nav_home
        initFragment()
    }

    private fun initFragment() {
        fm = requireActivity().supportFragmentManager
        fragment1 = MarghHomeFragment()
        fragment2 = MarghSavedFragment()
        fragment3 = MarghProfileFragment()
        fm?.beginTransaction()?.add(
            R.id.fl_margh_container,
            fragment3 as MarghProfileFragment,
            MarghProfileFragment::class.java.simpleName
        )?.hide(fragment3 as MarghProfileFragment)?.commit()
        fm?.beginTransaction()?.add(
            R.id.fl_margh_container,
            fragment2 as MarghSavedFragment,
            MarghSavedFragment::class.java.simpleName
        )?.hide(fragment2 as MarghSavedFragment)?.commit()
        fm?.beginTransaction()?.add(
            R.id.fl_margh_container,
            fragment1 as MarghHomeFragment,
            MarghHomeFragment::class.java.simpleName
        )?.commit()
        active = fragment1
    }
}