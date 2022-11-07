// final
abstract class Persona(var nombre: String, var apellido: String) {

    // variables
    var edad = 0;
    var dni: String? = null;
    // constructor
    // public Persona(){}
    // public Persona(int edad){}
    // public Persona(int edad, String nombre){}
    // constructor secundario
    constructor(nombre: String, apellido: String, edad: Int) : this(nombre, apellido) {
        this.edad = edad;
    }

    constructor(nombre: String, apellido: String, edad: Int, dni: String) : this(nombre, apellido) {
        this.edad = edad;
        this.dni = dni;
    }
    // metodos

    abstract fun metodoAbs()

    open fun mostrarDatos(){
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("Edad: $edad")
        println("DNI: ${dni?:"sin dni"}")
    }

    // getter y setter

    // toString
}