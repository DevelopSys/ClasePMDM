package model

class Autonomo(
    nombre: String,
    apellido: String,
    dni: String,
    sueldo: Double,
    var coutasSS: Int,
    var contrata: Boolean
) : Trabajador(nombre, apellido, dni, sueldo) {
    override fun calcularSalario() {
        //var salarioMes: Double = sueldo?.div(12) ?:0.0
        var salarioMes: Double = (sueldo!! - (coutasSS * 12) / 12)
        println(salarioMes)
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Cuotas SS $coutasSS")
        println("Contratado SS $contrata")
    }
}