package model

// CONSTRUCTOR PRIMARIO -> tiene todas las variables que son
// "obligatorias"
class Usuario(var nombre: String? = null, var apellido: String? = null) {

    // VARIABLES (LATEINIT o ? -> VAR)
    var correo: String? = null;
    var telefono: Int?=null;
    // CONSTRUCTOR -> SECUNDARIOS
    
    constructor(nombre: String?, apellido: String?, correo: String) : this(nombre, apellido){
     this.correo = correo;
    }
    constructor(nombre: String?, apellido: String?, telefono: Int) : this(nombre, apellido){
        this.telefono = telefono
    }
    // FUNCIONES
    // GET - SET -> implicitos a no ser que quiera
    // modificar su comportamiento
}