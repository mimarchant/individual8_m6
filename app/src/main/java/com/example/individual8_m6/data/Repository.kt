package com.example.individual8_m6.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.individual8_m6.data.local.Dao
import com.example.individual8_m6.data.local.RazaDetailEntity
import com.example.individual8_m6.data.local.RazaEntity
import com.example.individual8_m6.data.remote.Api

class Repository(private val perrosApi: Api, private val razaDao: Dao) {

    fun obtenerRazaEntentity(): LiveData<List<RazaEntity>> = razaDao.getRazas()
    fun obtenerDetalleEntentity(id: String): LiveData<List<RazaDetailEntity>> = razaDao.getRazaDetalle(id)
    suspend fun getRazas(){
        val response = perrosApi.getDataPerros()
        if(response.isSuccessful){
            val message = response.body()!!.message
            val keys = message.keys

            keys.forEach{raza->
                val razaEntity = raza.toRazaEntity()
                razaDao.insertRaza(razaEntity)
            }

        }else{
            Log.e("error: ", response.errorBody().toString())
        }

    }

    suspend fun getDetallePerro(id: String){
        val response = perrosApi.getDetallePerro(id)
        if(response.isSuccessful){
            response.body()!!.message.forEach{url->
                val razaDetalleEntity = url.toEntity(id)
                razaDao.insertDetallePerro(razaDetalleEntity)
            }


        }else{
            Log.e("error", response.errorBody().toString())
        }

    }
}