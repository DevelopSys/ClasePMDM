package model

final class Asalariado(nombre: String, apellido: String, dni:String, var salario: Int, var numeroPagas: Int) :
    Persona(nombre, apellido, dni) {

    // nombre, apellido, dni, salario, numPagas
    var contratado: Boolean = true;

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Salario anual $salario")
        println("Salario menual ${salario/numeroPagas}")
        println("Número pagas $numeroPagas")
    }


}