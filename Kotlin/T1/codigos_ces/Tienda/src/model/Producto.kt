package model

class Producto(var id: Int, var precio: Double = 10.0) {

    // id
    // precio
    var nombre: String? = null
    var descripcion: String? = null

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
     

}