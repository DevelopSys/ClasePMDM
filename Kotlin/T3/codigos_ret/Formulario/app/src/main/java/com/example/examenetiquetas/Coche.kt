package com.example.examenetiquetas

import java.io.Serializable

class Coche(
    var nombre: String,
    var apellido: String,
    var anio: Int,
    var matricula: String,
    var combustible: String,
    var autonomia: Int? = null
) : Serializable