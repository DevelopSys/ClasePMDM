package com.example.tienda.model

import java.io.Serializable


class User(
    var nombre: String,
    var apellido: String,
    var edad: Int,
    var correo: String,
    var pass: String
) : Serializable