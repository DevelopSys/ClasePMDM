package com.example.concesionario.model

import java.io.Serializable

class Modelo(
    var marca: String,
    var modelo: String,
    var precio: Double,
    var cv: Int,
    var imagen: Int
) : Serializable