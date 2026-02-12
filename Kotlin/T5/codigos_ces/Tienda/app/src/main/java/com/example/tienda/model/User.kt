package com.example.tienda.model


import java.io.Serializable

class User(
    var nombre: String? = null,
    var apellido: String? = null,
    var correo: String? = null,
    var edad: Int? = null
) : Serializable