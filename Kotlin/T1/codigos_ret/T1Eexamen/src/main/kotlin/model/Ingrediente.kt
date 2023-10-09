package model

class Ingrediente (var nombre: String, var precio: Double) {
    fun mostrarDatos(): Unit {
        println("$nombre: $precio")
    }
}