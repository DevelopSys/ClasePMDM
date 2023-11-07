package com.example.t3_ui.model

import java.io.Serializable

class Usuario (var nombre: String, var correo: String, var pass: String,
               var perfil: String, var periodo: String, var recordar: Boolean)
    : Serializable{
}