package controller

import model.Coche
import model.Moto
import model.Vehiculo


class Concesionario {

    lateinit var listaVehiculos: ArrayList<Vehiculo>

    init {
        listaVehiculos = arrayListOf()
    }

    fun agregarVehiculo(vehiculo: Vehiculo): Unit {
        listaVehiculos.add(vehiculo)
    }

    fun agregarMoto(moto: Moto): Unit {
        listaVehiculos.add(moto)
    }
}