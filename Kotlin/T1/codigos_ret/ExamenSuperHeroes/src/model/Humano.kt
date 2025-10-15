package model

class Humano(id: Int, nombre: String, nivel: Int,
             var resistencia: Int)
    : SuperHeroe(id,nombre,nivel,) {


    override fun mostrarDatos() {
        super.mostrarDatos()
        println("resistencia = ${resistencia}")
        println("arma = ${arma}")
    }
}