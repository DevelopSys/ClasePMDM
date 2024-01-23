package com.example.t5_fragments.model

import java.io.Serializable

class Producto(
    var id: Int,
    var nombre: String,
    var precio: Int,
    var marca: String,
    var categoria: String,
    var imagen: String,
    var imagenes: ArrayList<String>
) : Serializable {
}