package com.example.iniciofg.dataset

import com.example.iniciofg.model.Usuario

class DataSet {

    companion object {
        val listaUsuarios: ArrayList<Usuario> = ArrayList()
        fun registrarUsuario(x: Usuario) {
            listaUsuarios.add(x)
        }

        fun realizarLogin(correo: String, pass: String): Usuario? {
            return this.listaUsuarios.find { it.correo.equals(correo) && it.pass.equals(pass) }
        }
    }

}