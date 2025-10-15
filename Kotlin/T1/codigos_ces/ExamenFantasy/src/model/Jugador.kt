package model

class Jugador(
    var id: Int? = null,
    var nombre: String? = null,
    var posicion: String? = null,
    var valor: Int? = null,
    var puntos: Int? = null
) {

    fun mostrarDatos() {
        println("id = ${id}")
        println("nombre = ${nombre}")
        println("posicion = ${posicion}")
        println("valor = ${valor}")
    }
}