package com.example.usuarios.data

import com.example.usuarios.model.Usuario

class Usuarios {

    companion object{
        val  listado = ArrayList<Usuario>()
        fun getUsuario(): ArrayList<Usuario> {
            listado.add(Usuario("usaurio1@gmail.com","password1","madrid","masculino","administrador"))
            listado.add(Usuario("usaurio2@gmail.com","password2","madrid","femenino","usuario"))
            listado.add(Usuario("usaurio3@gmail.com","password3","madrid","femenino","usuario"))
            listado.add(Usuario("usaurio4@gmail.com","password4","madrid","masculino","usuario"))
            listado.add(Usuario("usaurio5@gmail.com","password5","madrid","masculino","usuario"))
            listado.add(Usuario("usaurio6@gmail.com","password6","madrid","femenino","usuario"))
            listado.add(Usuario("usaurio7@gmail.com","password7","madrid","masculino","administrador"))
            listado.add(Usuario("usaurio8@gmail.com","password8","madrid","femenino","usuario"))
            listado.add(Usuario("usaurio9@gmail.com","password9","madrid","masculino","administrador"))
            return listado;
        }
    }
}