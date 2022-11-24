package com.example.mijnwerkervaringen

import android.os.Parcelable
import androidx.room.ColumnInfo
import kotlinx.android.parcel.Parcelize
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Werk_ervaringen")

@Parcelize
data class Ervaring(
    @PrimaryKey(autoGenerate = true)
    var ervaringID: Int = 1,
    @ColumnInfo(name = "start_datum")
    var datumVan: String,
    @ColumnInfo(name = "eind_datum")
    var datumTot: String,
    @ColumnInfo(name = "school")
    var school: String,
    @ColumnInfo(name = "functie")
    var functie: String) : Parcelable {
}