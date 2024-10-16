package com.example.formulario.model

import java.io.Serializable

class Usuario(
    var nombre: String?=null,
    var correo: String?=null,
    var pass: String?=null,
    var recordar: Boolean?=null
): Serializable