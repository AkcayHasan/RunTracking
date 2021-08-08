package com.example.runtracking.ui.viewModels

import androidx.lifecycle.ViewModel
import com.example.runtracking.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val mainRepository: MainRepository
) : ViewModel() {


}