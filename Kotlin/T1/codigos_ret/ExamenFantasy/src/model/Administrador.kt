package model

import controller.Fantasy

class Administrador(var id: Int, var nombre: String, var clave: Int) {
    fun iniciarLiga(clave: Int, liga: Fantasy){
        if (clave == this.clave){
            liga.iniciarConteo()
        }
    }
}