package com.example.t5_navegacion.model

class Producto(
    var id: Int,
    var nombre: String,
    var precio: Double,
    var descripcion: String,
    var categoria: String,
    var imagen: String,
    var imagenes: ArrayList<String>
    ) {
}