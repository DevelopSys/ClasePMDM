package com.example.t3_ui.model

import java.io.Serializable

class Marca (var nombre: String, var calificacion: Double, var imagen: Int): Serializable {

    override fun toString(): String {
        return nombre
    }
}