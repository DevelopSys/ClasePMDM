package com.example.login.data

import com.example.login.model.User

class DataSet {

    // static
    companion object {
        // todos los elementos asociados a la clase y metodos
        val listUser: ArrayList<User> = arrayListOf()

        fun addUser(user: User): Boolean{
            // si no hay un usuaro con ese correo -> añades
            return false
        }

        fun getLogin(mail: String, pass: String): User? {

            return null;
        }


    }
}