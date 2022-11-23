package com.develop.t3_listas_ret.model

class Usuario(var nombre: String, var telefono: Int, var genero: String) {

    override fun toString(): String {
        return nombre
    }
}