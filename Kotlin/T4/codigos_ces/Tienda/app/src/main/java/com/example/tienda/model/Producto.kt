package com.example.tienda.model

import java.io.Serializable

class Producto(
    var title: String? = null,
    var price: Double? = null,
    var description: String? = null
) : Serializable {
}