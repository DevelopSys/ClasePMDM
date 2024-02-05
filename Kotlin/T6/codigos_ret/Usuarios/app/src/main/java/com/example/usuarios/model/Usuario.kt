package com.example.usuarios.model

import java.io.Serializable

class Usuario(
    var correo: String? = null,
    var pass: String? = null,
    var direccion: String? = null,
    var genero: String? = null,
    var perfil: String? = null
) : Serializable {
}