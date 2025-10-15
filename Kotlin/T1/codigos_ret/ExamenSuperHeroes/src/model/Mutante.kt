package model

class Mutante(id: Int, nombre: String, nivel: Int, )
    : SuperHeroe(id, nombre, nivel) {


    override fun mostrarDatos() {
        super.mostrarDatos()
        println("arma = ${arma}")
    }
}