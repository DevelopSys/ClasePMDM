package com.example.tienda.model

import java.io.Serializable

class Producto(
    var id: Int,
    var nombre: String,
    var stock: Int,
    var precio: Double,
    var descripcion: String,
    var categoria: String,
    var imagen: String
) : Serializable