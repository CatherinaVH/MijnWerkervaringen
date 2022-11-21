package com.example.mijnwerkervaringen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddErvaringViewModel : ViewModel() {

    private var _navigeerNaarVoegErvaringToe : MutableLiveData<Boolean> = MutableLiveData()
    val navigeerNaarVoegErvaringToe: LiveData<Boolean>
        get() {
            return _navigeerNaarVoegErvaringToe
        }

    init {
        _navigeerNaarVoegErvaringToe.value = false
    }

    fun voegErvaringToe(){

    }
}