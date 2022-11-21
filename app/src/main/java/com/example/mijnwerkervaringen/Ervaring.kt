package com.example.mijnwerkervaringen

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ervaring(var datumVan: String, var datumTot: String, var school: String, var functie: String) : Parcelable {
}