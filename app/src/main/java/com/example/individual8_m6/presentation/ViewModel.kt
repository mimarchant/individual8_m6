package com.example.individual8_m6.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.individual8_m6.data.Repository
import com.example.individual8_m6.data.local.RazaDatabase
import com.example.individual8_m6.data.remote.DogRetrofit
import kotlinx.coroutines.launch

class ViewModel(application: Application): AndroidViewModel(application) {

    private val repositorio: Repository

    fun razaLiveData() = repositorio.obtenerRazaEntentity()

    fun detalleLiveData(id: String) = repositorio.obtenerDetalleEntentity(id)

    init {
        val api = DogRetrofit.gesRetroFitAves()
        val razaDatabase = RazaDatabase.getDatabase(application).getRazaDao()
        repositorio = Repository(api,razaDatabase)
    }

    fun getAllRazas() = viewModelScope.launch {
        repositorio.getRazas()
    }

    fun getDetallePerroVM(id: String) = viewModelScope.launch {
        repositorio.getDetallePerro(id)
    }
}