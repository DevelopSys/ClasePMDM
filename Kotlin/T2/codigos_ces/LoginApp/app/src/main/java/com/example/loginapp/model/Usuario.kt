package com.example.loginapp.model

import java.io.Serializable

class Usuario(
    var correo: String,
    var pass: String, var plataforma: String
) : Serializable