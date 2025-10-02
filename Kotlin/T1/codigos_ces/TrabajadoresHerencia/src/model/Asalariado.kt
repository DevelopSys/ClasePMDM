package model

class Asalariado(
    nombre: String, apellido: String, dni: String,
    salario: Int, var nPagas: Int, var irpf: Double
) :
    Trabajador(nombre, apellido, dni, salario) {
    override fun calcularSalarioNeto(): Double {
        // 10000 0.20
        // salario total - lo que te quitan de IRPF
        return salario - (salario * irpf)
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("nPagas = ${nPagas}")
        println("irpf = ${irpf}")
    }

}