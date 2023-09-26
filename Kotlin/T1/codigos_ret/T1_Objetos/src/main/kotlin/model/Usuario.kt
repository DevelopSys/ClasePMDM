package model

open class Usuario(var nombre: String, var apellido: String) {

    /*
    * TrabajadorAsalariado: numeroPagas, salario
    *   - calcularSueldoNetoMes -> salario - 0.21 / meses
    *   - mostrarDatos -> overide
    * TrabajadorAutonomo: cuotaSS, salario
    *   - calcularSueldoNetoMes -> salario - (12*coutaSS) / meses
    *   - mostrarDatos -> overide
    * Director: %beneficios, indiceResponsabilidad
    *   - mostrarDatos -> overide
    * */


    // public Usuario(String nombre){
    // this.nombre = nombre
    // }
    lateinit var correo: String

    init {
        println("Este es un bloque init")
        this.correo = "correo_defecto"
    }

    var pass: String? = null
    var telefono: Int? = null

    constructor(nombre: String, apellido: String, pass: String, correo: String) : this(nombre, apellido) {
        this.pass = pass
        this.correo = correo
    }
     constructor(nombre: String, apellido: String, pass: String, correo: String, telefono: Int): this(nombre, apellido){
         this.pass = pass
         this.correo = correo
         this.telefono = telefono
     }

    open fun mostrarDatos(): Unit {
        println("Nombre $nombre")
        println("Apellido $apellido")
        println("Telefono ${telefono ?: "sin datos"}")
        println("Pass ${pass ?: "sin datos"}")
        println("Correo ${correo ?: "sin datos"}")
    }
}