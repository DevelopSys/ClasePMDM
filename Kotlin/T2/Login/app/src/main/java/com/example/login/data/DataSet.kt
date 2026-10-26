package com.example.login.data

import com.example.login.model.User

class DataSet {

    // static
    companion object {
        // todos los elementos asociados a la clase y metodos
        val listUser: ArrayList<User> = arrayListOf()

        fun addUser(user: User): Boolean {
            // si no hay un usuaro con ese correo -> añades
            val exist = listUser.any { user.mail == it.mail }
            if (!exist) {
                listUser.add(user)
                return true
            }
            return false;
        }

        fun getLogin(mail: String, pass: String): User? {
            return listUser.find { mail == it.mail && pass == it.pass };
        }


    }
}