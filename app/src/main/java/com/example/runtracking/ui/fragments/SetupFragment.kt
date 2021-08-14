package com.example.runtracking.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.runtracking.R
import com.example.runtracking.base.BaseFragment
import com.example.runtracking.databinding.FragmentSetupBinding

class SetupFragment : BaseFragment<FragmentSetupBinding>(){

    override fun getViewBinding(): FragmentSetupBinding {
        return FragmentSetupBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvContinue.setOnClickListener {
            it.findNavController().navigate(R.id.action_setupFragment_to_runFragment)
        }
    }



}