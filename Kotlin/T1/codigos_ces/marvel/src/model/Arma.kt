package model

abstract class Arma(
    var id: Int? = null,
    var nombre: String? = null,
    var potencia: Int? = null,
    var danio: Int? = null
) {

    open fun mostrarDatos() {
        println("ID $id")
        println("Nombre $nombre")
        println("Potencia $potencia")
        println("Daño $danio")
    }
}