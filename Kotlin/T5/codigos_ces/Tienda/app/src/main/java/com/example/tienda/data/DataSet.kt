package com.example.tienda.data

import com.example.tienda.model.User

class DataSet {
    companion object {
        val listaUsuarios: ArrayList<User> = ArrayList()
        fun registerUser(user: User): Boolean {
            if (listaUsuarios.find { it.correo == user.correo } != null) {
                return false
            } else {
                this.listaUsuarios.add(user)
                return true
            }
        }


    }
}