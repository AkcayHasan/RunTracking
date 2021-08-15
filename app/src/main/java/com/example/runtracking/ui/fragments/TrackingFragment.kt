package com.example.runtracking.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.runtracking.base.BaseFragment
import com.example.runtracking.databinding.FragmentStatisticsBinding
import com.example.runtracking.databinding.FragmentTrackingBinding
import com.example.runtracking.services.TrackingService
import com.example.runtracking.ui.viewModels.MainViewModel
import com.example.runtracking.utils.Constants.ACTION_START_OR_RESUME_SERVICE
import com.google.android.gms.maps.GoogleMap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrackingFragment : BaseFragment<FragmentTrackingBinding>(){

    private val viewModel : MainViewModel by viewModels()
    private var map : GoogleMap ?= null

    override fun getViewBinding(): FragmentTrackingBinding {
        return FragmentTrackingBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        actions()

        binding.mapView.onCreate(savedInstanceState)

        binding.mapView.getMapAsync {
            map = it
        }
    }

    private fun actions(){
        binding.btnToggleRun.setOnClickListener {
            sendCommandToService(ACTION_START_OR_RESUME_SERVICE)
        }
    }

    private fun sendCommandToService(action : String){
        Intent(binding.root.context, TrackingService::class.java).also {
            it.action = action
            binding.root.context.startService(it)
        }
    }

    //map lifecycle functions
    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
    }


}