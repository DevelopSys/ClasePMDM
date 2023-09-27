package model

abstract class  Trabajador(
    var nombre: String, var apellido: String,
    var dni: String, var sueldo: Int=10000) {

    open fun mostrarDatos(): Unit{
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("DNI: $dni")
        println("Sueldo: $sueldo")
    }
    abstract fun calcularSueldoNetoMes();
}