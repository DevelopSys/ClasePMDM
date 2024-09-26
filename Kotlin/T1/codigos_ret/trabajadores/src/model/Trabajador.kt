package model

abstract class Trabajador(
    var nombre: String? = null,
    var apellido: String? = null,
    var dni: String? = null,
    var sueldo: Double? = null
) {

    open fun mostrarDatos() {
        println("Nombre: ${nombre!!}")
        println("Apellido: ${apellido!!}")
        println("DNI: ${dni!!}")
        println("Sueldo: ${sueldo!!}")
    }

    abstract fun calcularSalario();

}