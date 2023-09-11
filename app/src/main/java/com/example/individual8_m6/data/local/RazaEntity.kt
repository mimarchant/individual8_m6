package com.example.individual8_m6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_razas")
data class RazaEntity (
    @PrimaryKey val raza: String)