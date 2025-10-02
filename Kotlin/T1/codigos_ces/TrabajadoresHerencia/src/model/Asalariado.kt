package model

class Asalariado(
    nombre: String, apellido: String, dni: String,
    salario: Double, var nPagas: Int, var irpf: Double
) :
    Trabajador(nombre, apellido, dni, salario) {
    override fun calcularSalarioNeto(): Double {
        // 10000 0.20
        // salario total - lo que te quitan de IRPF
        return salario - (salario * irpf)

    }

    fun pedirAumento(){
        val aleatorio = (1..10).random();
        if (aleatorio<5){
            println("No hay incremento de sueldo")
        } else {
            salario *= 1.1;
            // salario = salario *1.1;
        }
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("nPagas = ${nPagas}")
        println("irpf = ${irpf}")
    }

}