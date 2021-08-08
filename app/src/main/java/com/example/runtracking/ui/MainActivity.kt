package com.example.runtracking.ui

import android.os.Bundle
import com.example.runtracking.R
import com.example.runtracking.base.BaseActivity
import com.example.runtracking.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


}