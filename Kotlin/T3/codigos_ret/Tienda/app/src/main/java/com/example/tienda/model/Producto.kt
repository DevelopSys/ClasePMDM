package com.example.tienda.model

import java.io.Serializable

class Producto(
    var nombre: String,
    var categoria: String,
    var precio: Double,
    var descripcion: String
): Serializable