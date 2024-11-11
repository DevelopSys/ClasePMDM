package com.example.concesionario.model

import java.util.ArrayList

class Marca (var nombre: String?=null, var imagen: Int?=null){
    override fun toString(): String {
        return nombre.toString()
    }
}