package com.example.tienda.model

import java.io.Serializable


class User(
    var nombre: String?=null,
    var apellido: String?=null,
    var edad: Int=0,
    var correo: String?=null,
) : Serializable