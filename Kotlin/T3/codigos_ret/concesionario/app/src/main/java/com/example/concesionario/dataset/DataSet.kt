package com.example.concesionario.dataset

import android.view.Display
import com.example.concesionario.model.Marca
import com.example.concesionario.model.Modelo

class DataSet {

    companion object {
        fun getListaModelos(marca: Marca): ArrayList<Modelo> {
            val listaModelos: ArrayList<Modelo> = arrayListOf()

            when (marca.nombre) {
                "Ford" -> {
                    listaModelos.add(Modelo(marca,"Mondeo"))
                    listaModelos.add(Modelo(marca,"Focus"))
                    listaModelos.add(Modelo(marca,"Fiesta"))
                    listaModelos.add(Modelo(marca,"Kuga"))
                }
                "Mercedes" -> {
                    listaModelos.add(Modelo(marca,"Clase A"))
                    listaModelos.add(Modelo(marca,"Clase B"))
                    listaModelos.add(Modelo(marca,"Clase C"))
                    listaModelos.add(Modelo(marca,"Clase S"))
                }
                "Seat" -> {
                    listaModelos.add(Modelo(marca,"Ibiza"))
                    listaModelos.add(Modelo(marca,"Arona"))
                    listaModelos.add(Modelo(marca,"Panda"))
                }
                "Audi" -> {
                    listaModelos.add(Modelo(marca,"E-Tron"))
                    listaModelos.add(Modelo(marca,"A3"))
                    listaModelos.add(Modelo(marca,"A4"))
                    listaModelos.add(Modelo(marca,"A6"))
                }
            }

            return listaModelos
        }
    }
}