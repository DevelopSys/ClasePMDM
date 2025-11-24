package com.example.examen.model

import java.io.Serializable

class Coche(
    var nombre: String,
    var matricula: String,
    var combustible: String,
    var anio: Int,
    var autonomia: Int = 0

) : Serializable