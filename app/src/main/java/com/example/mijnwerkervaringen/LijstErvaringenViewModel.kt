package com.example.mijnwerkervaringen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LijstErvaringenViewModel(
    val database: ErvaringDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private var _voegNieuweErvaringToe: MutableLiveData<Boolean> = MutableLiveData()
    val voegNieuweErvaringToe: LiveData<Boolean>
        get() {
            return _voegNieuweErvaringToe
        }

    fun voegNieuweErvaringToe() {
        _voegNieuweErvaringToe.value = true
    }
}

//class LijstErvaringenViewModel : ViewModel() {
//
//    private var _ervaringen : MutableLiveData<List<Ervaring>> = MutableLiveData()
//    val ervaringen : LiveData<List<Ervaring>>
//    get() {
//        return _ervaringen
//    }
//
//    private var _ervaring : MutableLiveData<Ervaring> = MutableLiveData()
//    val ervaring : LiveData<Ervaring>
//        get() {
//            return _ervaring
//        }
//

//
//    init {
//        _ervaringen.value = MockUpDB().getWerkervaringen()
//        _voegNieuweErvaringToe.value = false
//    }
//
//    fun clickErvaring(ervaring: Ervaring){
//        _ervaring.value = ervaring
//    }
//

//
//    fun navigateToWerkErvaringenFinished() {
//        _voegNieuweErvaringToe.value = false
//    }
//
//}