package com.example.individual8_m6

import com.example.individual8_m6.data.toEntity
import org.junit.Assert.*

import org.junit.Test
class TestMapperRazaDetail {
    @Test
    fun toEntity() {
        val url = "datoUrl"
        val id = "datoId"

        val result = url.toEntity(id)

        assertEquals(id, result.razaDetalle)
        assertEquals(url, result.url)
    }
}