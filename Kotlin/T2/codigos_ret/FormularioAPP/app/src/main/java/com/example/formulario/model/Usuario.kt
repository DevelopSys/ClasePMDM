package com.example.formulario.model

import java.io.Serializable

class Usuario(
    var nombre: String,
    var pass: String,
    var mail: String,
    var localizacion: String,
    var estudios: String,
    var experiencia: String
) : Serializable