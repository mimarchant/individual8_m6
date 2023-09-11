package com.example.individual8_m6

import com.example.individual8_m6.data.toRazaEntity
import org.junit.Assert.*
import org.junit.Test

class TestMapperRazaEntity {

    @Test
    fun toRazaEntity() {

        //Given

        val raza = "esUnaRaza"

        // When

        val result = raza.toRazaEntity()

        // Then

        assertEquals(raza, result.raza)
    }
}