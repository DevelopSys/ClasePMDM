package com.example.botones.model

class Ciclo(var nombre: String?=null, var siglas: String?=null, var familia: String?=null ){

    override fun toString(): String {
        return siglas ?: "Sin siglas"
    }
}
