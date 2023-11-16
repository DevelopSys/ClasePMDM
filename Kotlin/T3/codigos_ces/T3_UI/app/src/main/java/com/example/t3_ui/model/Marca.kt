package com.example.t3_ui.model

import java.io.Serializable

class Marca (var marca: String, var valoracion: Double, var imagen: Int): Serializable {

    override fun toString(): String {
        return marca
    }
}