package com.example.individual8_m6.data.local
import androidx.room.Entity
@Entity(tableName = "tablaRazasDetalle", primaryKeys = ["razaDetalle","url"])
data class RazaDetailEntity(
    val razaDetalle:String,
    val url: String
)