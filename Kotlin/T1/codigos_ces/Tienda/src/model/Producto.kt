package model

class Producto(
    var id: Int,
    var precio: Double = 10.0,
    var categoria: Categoria = Categoria.Generica,
    var nombre: String? = null,
    var descripcion: String? = null
) {

    // id
    // precio


    /*
    constructor(id: Int, precio: Double, nombre: String) : this(id, precio) {
        this.nombre = nombre
    }
    constructor(id: Int, precio: Double, descripcion: String?) : this(id, precio) {
        this.descripcion = descripcion
    }
    constructor(id: Int, precio: Double, nombre: String, descripcion:String, ): this (id,precio){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    // crear constructor solo con descripcion y otro con nombre y descripcion
    */

    // metodo para poder mostrar todos los datos del producto concreto
    // si no hay nombre, aparece SIN NOMBRE
    // si no hay descripcion, aparece SIN DESCRIPCION

    fun mostrarDatos() {
        println("ID: $id")
        println("Precio: $precio")
        println("Nombre: ${nombre ?: "SIN DEFINIR"} ")
        println("Categoria: ${categoria.name}")
        println("Descripcion: ${descripcion ?: "SIN DEFINIR"} ")
    }
}