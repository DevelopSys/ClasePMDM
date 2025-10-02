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

    // un asalariado, puede pedir un aumento de sueldo
        // se genera un aleatorio entre 1-10
        // en caso de generar un numero <5 no se le sube el salario
        // en caso de generar un numero >=5 se le sube un 10% el salario

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("nPagas = ${nPagas}")
        println("irpf = ${irpf}")
    }

}