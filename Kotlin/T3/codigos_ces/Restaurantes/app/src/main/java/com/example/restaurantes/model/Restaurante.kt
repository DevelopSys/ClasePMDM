package com.example.restaurantes.model

class Restaurante(
    var nombre: String,
    var localidad: String,
    var puntuacion: Int,
    var comida: String,
    var telefono: Int,
    var caracteristicas: ArrayList<String>
) {
}