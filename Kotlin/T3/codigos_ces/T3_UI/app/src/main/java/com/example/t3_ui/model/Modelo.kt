package com.example.t3_ui.model

import java.io.Serializable

class Modelo (var nombre: String, var marca: Marca, var cv: Int,
              var precio: Int, var tipo: String, var imagen: Int, var imagenURL: String): Serializable {
}