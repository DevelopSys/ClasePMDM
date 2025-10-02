package model


// Trabajador() : Persona(), Junta
abstract class Trabajador(
    nombre: String, apellido: String, dni: String,
    var salario: Double
) : Persona(nombre, apellido, dni) {

    // nombre, apellido, dni, SALARIO,NPAGAS
    // telefono, email, SEGURO
    var seguro: Boolean = false;

    constructor(
        nombre: String, apellido: String, dni: String,
        salario: Double,seguro: Boolean, telefono: Int, correo: String,
    ) : this(nombre, apellido, dni, salario) {
        this.seguro = seguro;
        this.telefono = telefono
        this.correoE = correo
    }

    abstract fun calcularSalarioNeto(): Double ;

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Salario : $salario")
        println("Seguro : $seguro")
    }

}