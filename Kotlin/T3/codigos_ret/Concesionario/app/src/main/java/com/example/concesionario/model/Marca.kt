package com.example.concesionario.model

import java.io.Serializable
import java.util.ArrayList

class Marca (var nombre: String?=null, var imagen: Int?=null): Serializable{
    override fun toString(): String {
        return nombre.toString()
    }
}