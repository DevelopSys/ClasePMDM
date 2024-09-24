package model

class Usuario (var nombre: String?=null, var apellido: String?=null ) {

    // variables -> nombre, apellido
    var correo: String?=null;
    var matriculado = true;
    // lateinit var asignaturas: ArrayList<String>

    init {
        // se ejecutara si o si despues del constructor
        nombre = nombre+"23_24"
        // asignaturas = ArrayList()
    }
    constructor(nombre: String?, apellido: String?, correo:String) : this(nombre, apellido) {
        this.correo = correo;
    }

    // metodos -> get set -> implicitos
    fun mostrarDatos(): Unit{
        println("Nombre $nombre")
        println("Apellido $apellido")
        println("Correo ${correo?:"sin especificar"}")
    }

    fun desmatricular(){
        this.matriculado = false;
    }

    fun matricularse(id: Int){
        // hacer lo que tenga que ser
    }
}