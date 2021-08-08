package com.example.runtracking.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity <VB : ViewBinding> : AppCompatActivity() {

    lateinit var binding : VB

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding = getViewBinding()
        setContentView(binding.root)
    }

    abstract fun getViewBinding() : VB
}