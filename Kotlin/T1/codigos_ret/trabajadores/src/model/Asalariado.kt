package model

class Asalariado(
    nombre: String, apellido: String, dni: String, sueldo: Double,
    var contratado: Boolean, var nPagas: Int
) : Trabajador(nombre, apellido, dni, sueldo) {
    override fun calcularSalario() {
        var sueldoMes: Double = (sueldo!! - (sueldo!! * 0.21))/nPagas
        println(sueldoMes)
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Contradao $contratado")
        println("Pagas $nPagas")
    }


}