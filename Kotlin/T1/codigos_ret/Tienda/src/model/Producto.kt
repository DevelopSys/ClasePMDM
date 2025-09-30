package model

class Producto(
    var id: Int? = null,
    var precio: Double? = null,
    var nombre: String? = null,
    var descripcion: String? = null,
    var categoria: Categoria= Categoria.Generica
) {

    // hacer un metodo que muestre todos los datos del producto
    // en caso de no tener dato, aparecera el mensaje de SIN DEFINIR
    fun mostrarDatos() {
        println("ID: ${id ?: "Sin definir"}")
        println("Precio: ${precio ?: "Sin definir"}")
        println("Nombre: ${nombre ?: "Sin definir"}")
        println("Descripcion: ${descripcion ?: "Sin definir"}")
        println("categoria = ${categoria.nombre}")
    }

}