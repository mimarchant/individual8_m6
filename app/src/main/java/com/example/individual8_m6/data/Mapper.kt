package com.example.individual8_m6.data

import com.example.individual8_m6.data.local.RazaDetailEntity
import com.example.individual8_m6.data.local.RazaEntity


fun String.toEntity(id: String): RazaDetailEntity = RazaDetailEntity(id, this)

fun String.toRazaEntity(): RazaEntity = RazaEntity(this)