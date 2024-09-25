package model

// CONSTRUCTOR PRIMARIO -> tiene todas las variables que son
// "obligatorias"
// un usuario debería tener un ID único obligatorio y una calificacion = 0
// NECESITAMOS TENER UNA CLASE ADICIONAL QUE GESITIONE TODOS LOS ALUMNOS -> Colegio
    // agregar un alumno al colegio
        // no exista -> no puede haber un alumno con el ID que se da
            // se debe dar aviso del resultado
    // desmatricular un alumno: id
            // se debe dar aviso del resultado -> alumno con nombre XXX desmatriculado
// con exito
    // listar alumnos
            // todos
            // matriculados
            // desmatriculados
    // calificar: id, calificacion
            // si la calificacion no esta en rango -> error
            // si la calificacion esta en rango -> le pones la nota
    // mostrar clasificacion: se mostrará una clasificacion con los alumnos ordenador por notas
// Mediante un menu se debe poder ejecutar la funcionalidad -> ENTRADA

class Usuario(var nombre: String? = null, var apellido: String? = null) {

    // inicializa a true
    // VARIABLES (LATEINIT o ? -> VAR)
    var correo: String? = null;
    var telefono: Int?=null;
    var matriculado: Boolean = true;
    var id: Int = 0;
    var calificacion: Double = 0.0
    // CONSTRUCTOR -> SECUNDARIOS

    init {
        // ejecutado siempre despues del constructor (primario - secundario)
        nombre += "_23/24";
    }

    constructor(nombre: String?, apellido: String?, correo: String?=null, telefono: Int?=null) : this(nombre, apellido){
        this.correo = correo;
        this.telefono = telefono
    }

    // FUNCIONES
    fun mostrarDatos(){
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("Matriculado: $matriculado")
        println("Correo: ${correo?:"sin correo"}")
        println("Telefono: ${telefono?: "sin telefono"}")
    }

    fun desmatricular(){
        this.matriculado = false
    }
    // GET - SET -> implicitos a no ser que quiera
    // modificar su comportamiento
}