package com.example.concesionario.model

import java.io.Serializable

class Marca(var nombre: String, var imagen: Int): Serializable{
    override fun toString(): String {
        return nombre
    }
}