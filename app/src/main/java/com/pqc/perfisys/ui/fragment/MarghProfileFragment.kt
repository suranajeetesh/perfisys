package com.pqc.perfisys.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.pqc.perfisys.core.ui.BaseFragment
import com.pqc.perfisys.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Jeetesh Surana.
 */
@AndroidEntryPoint
class MarghProfileFragment : BaseFragment() {

    private lateinit var binding: FragmentProfileBinding
    private var pickMediaSingle: ActivityResultLauncher<PickVisualMediaRequest>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pickMediaSingle =
            registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                if (uri != null) {
                    Glide.with(requireActivity()).load(uri).centerCrop().circleCrop().into(binding.imgProfile)
                } else {
                    Toast.makeText(requireContext(), "No media selected", Toast.LENGTH_SHORT)
                        .show();
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.imgProfile.setOnClickListener {
            pickMediaSingle?.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
    }
}