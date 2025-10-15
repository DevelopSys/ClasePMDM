package model

class ArmaTradicional (id: Int, nombre: String, potencia: Int, danio: Int, var peso: Int)
    : Arma(id,nombre,potencia,danio) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("peso = ${peso}")
    }

}