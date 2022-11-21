package com.example.mijnwerkervaringen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var _gebruiker : MutableLiveData<Gebruiker> = MutableLiveData()
    val gebruiker: LiveData<Gebruiker>
        get() {
            return _gebruiker
        }

    private var _navigeerNaarGebruikerGegevens : MutableLiveData<Boolean> = MutableLiveData()
    val navigeerNaarGebruikerGegevens: LiveData<Boolean>
        get() {
            return _navigeerNaarGebruikerGegevens
        }

    private var _navigeerNaarLijstErvaringen : MutableLiveData<Boolean> = MutableLiveData()
    val navigeerNaarLijstErvaringen: LiveData<Boolean>
        get() {
            return _navigeerNaarLijstErvaringen
        }

    fun naarGebruikerGegevens() {
        _navigeerNaarGebruikerGegevens.value = true
    }

    fun naarErvaringen() {
        _navigeerNaarLijstErvaringen.value = true
    }

    fun naarGebruikerGegevensFinished() {
        _navigeerNaarGebruikerGegevens.value = false
    }

    fun naarErvaringenFinished() {
        _navigeerNaarLijstErvaringen.value = false
    }

    init {
        _gebruiker.value = MockUpDB().getGebruiker()
        _navigeerNaarGebruikerGegevens.value = false
        _navigeerNaarLijstErvaringen.value = false
    }
}
