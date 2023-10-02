package model

abstract class Trabajador(dni: String, nombre: String, apellido: String, var salario: Double) :
    Persona(dni, nombre, apellido) {

    /*
    * Asalariado: numeroPagas, salario
    *   - calcularSueldoNetoMes -> salario - 0.21 / numeroPagas
    *   - mostrarDatos -> overide
    * Autonomo: cuotaSS, salario
    *   - calcularSueldoNetoMes -> salario - (12*coutaSS) / meses
    *   - mostrarDatos -> overide
    * Director: %beneficios, indiceResponsabilidad, salario
    *   - mostrarDatos -> overide
    *   - calcularSueldoNetoMes -> salario - 0.21 / meses
    * */

    // public Usuario(String nombre){
    // this.nombre = nombre
    // }
    var correo: String? = null;
    var pass: String? = null
    var telefono: Int? = null

    constructor(dni: String, nombre: String, apellido: String, sueldo: Double, pass: String, correo: String) : this(
        dni,
        nombre,
        apellido,
        sueldo
    ) {
        this.pass = pass
        this.correo = correo
    }

    constructor(
        dni: String,
        nombre: String,
        apellido: String,
        sueldo: Double,
        pass: String,
        correo: String,
        telefono: Int
    ) : this(dni, nombre, apellido, sueldo) {
        this.pass = pass
        this.correo = correo
        this.telefono = telefono
    }

    abstract fun calcularSueldoNetoMes()
    override fun mostrarDatos(): Unit {
        super.mostrarDatos()
        println("Salario $salario")
        println("Telefono ${telefono ?: "sin datos"}")
        println("Pass ${pass ?: "sin datos"}")
        println("Correo ${correo ?: "sin datos"}")
    }
}