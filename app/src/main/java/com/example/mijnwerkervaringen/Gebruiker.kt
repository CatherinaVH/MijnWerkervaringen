package com.example.mijnwerkervaringen

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Gebruiker(var voorNaam : String, var familieNaam: String, var geboortedatum: String,
                var woonplaats : String, var behaaldDiploma: String): Parcelable {
    annotation class parcelize

    fun getNaam(): String {
        return voorNaam + " " + familieNaam
    }

}