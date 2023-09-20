package model

abstract class Usuario(var nombre: String?, var apellido: String?) {

    var dni: String? = null


    constructor(nombre: String, apellido: String, dni: String)
            : this(nombre, apellido) {
        this.dni = dni;
    }

    /*init {
        println("Bloque ejecutado siempre")
    }*/
    /*lateinit var nombre: String;
    lateinit var apellido: String;
    var edad: Int = 0;*/
    //val DNI = "123"

    open fun mostrarDatos(): Unit {
        println("Nombre: $nombre")
        println("apellido: $apellido")
        println("dni: ${dni ?: "sin dni"}")
    }

    abstract fun metodoAbs();

    override fun toString(): String {
        return super.toString()
    }
}