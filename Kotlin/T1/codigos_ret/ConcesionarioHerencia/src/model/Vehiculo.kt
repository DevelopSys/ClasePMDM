package model

abstract class Vehiculo(
    var matricula: String,
    var marca: String,
    var modelo: String,
    var km: Int,
    var cv: Int,
    var precio: Double
) {

    open fun mostrarDatos() {
        println("matricula = $matricula")
        println("marca = $marca")
        println("modelo = $modelo")
        println("km = $km")
        println("cv = $cv")
        println("precio = $precio")
    }
}