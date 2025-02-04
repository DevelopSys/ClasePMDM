package com.example.navegacion.dataset

import com.example.navegacion.model.Usuario

class DataSet {

    companion object{
        val usuarios: ArrayList<Usuario> = ArrayList()

        fun agregarUsuario(usuario: Usuario){
            usuarios.add(usuario)
        }

        fun realizarLogin(correo:String, pass: String):Usuario?{
            return usuarios.find {
                it.correo.equals(correo) and it.pass.equals(pass)
            }
        }
    }
}