package com.example.runtracking.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.runtracking.R
import com.example.runtracking.base.BaseFragment
import com.example.runtracking.databinding.FragmentRunBinding
import com.example.runtracking.ui.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RunFragment : BaseFragment<FragmentRunBinding>(){

    private val viewModel : MainViewModel by viewModels()

    override fun getViewBinding(): FragmentRunBinding {
        return FragmentRunBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            it.findNavController().navigate(R.id.action_runFragment_to_trackingFragment)
        }

    }


}