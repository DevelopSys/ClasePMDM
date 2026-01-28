package com.example.tienda.model


import java.io.Serializable

class User(
    var nombre: String,
    var apellido: String,
    var correo: String,
    var pass: String,
    var edad: Int
): Serializable