package com.example.mijnwerkervaringen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GebruikerViewModelFactory : ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GebruikerViewModel::class.java)) {
            return GebruikerViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}