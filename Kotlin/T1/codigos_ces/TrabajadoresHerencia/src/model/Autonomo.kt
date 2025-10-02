package model

class Autonomo(
    nombre: String, apellido: String, dni: String,
    salario: Double, var seguro: Boolean, var coutasSS: Int
) : Trabajador(nombre, apellido, dni, salario) {


    fun pedirDescuento(pprcet: Double) {
        if (seguro) {
            coutasSS = (coutasSS - coutasSS * pprcet).toInt();
        }
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("coutasSS = ${coutasSS}")
        println("seguro = ${seguro}")
    }

    override fun calcularSalarioNeto(): Double {
        return salario - (coutasSS * 12)
    }
}