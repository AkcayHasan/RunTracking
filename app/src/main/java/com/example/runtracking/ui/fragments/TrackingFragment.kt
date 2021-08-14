package com.example.runtracking.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.runtracking.base.BaseFragment
import com.example.runtracking.databinding.FragmentStatisticsBinding
import com.example.runtracking.databinding.FragmentTrackingBinding
import com.example.runtracking.ui.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrackingFragment : BaseFragment<FragmentTrackingBinding>(){

    private val viewModel : MainViewModel by viewModels()

    override fun getViewBinding(): FragmentTrackingBinding {
        return FragmentTrackingBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



}