package com.example.mijnwerkervaringen

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ErvaringDatabaseDao {
    @Insert
    fun insert (ervaring: Ervaring)

    @Update
    fun update (ervaring: Ervaring)

    @Query("SELECT * from Werk_ervaringen WHERE ervaringID = :key")
    fun get(key: Int): Ervaring?

    @Query("DELETE from Werk_ervaringen")
    fun clear()

    @Query("SELECT * FROM Werk_ervaringen ORDER BY ervaringID DESC LIMIT 1")
    fun getErvaring(): Ervaring?

    @Query("SELECT * FROM Werk_ervaringen ORDER BY ervaringID DESC")
    fun getAllErvaringen(): LiveData<List<Ervaring>>
}