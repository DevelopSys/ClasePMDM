package com.example.tienda.dateset

import com.example.tienda.model.User

class DataSet {

    companion object {
        val lista: ArrayList<User> = arrayListOf()

        fun agregarUsuario(user: User): Boolean {
            // cuando se puede agregar
            if (lista.find { it.correo == user.correo } == null) {
                this.lista.add(user)
                return true
            } else {
                return false
            }
        }

        fun login(correo: String, pass: String): User? {
            return lista.find { it.correo == correo }
        }

    }
}