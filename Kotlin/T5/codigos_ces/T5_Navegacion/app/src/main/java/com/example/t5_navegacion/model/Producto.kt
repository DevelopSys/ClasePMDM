package com.example.t5_navegacion.model

class Producto(
    var id: Int? = null,
    var title: String? = null,
    var price: Double? = null,
    var description: String? = null,
    var category: String? = null,
    var thumbnail: String? = null,
    var images: ArrayList<String>? = null
) {}
