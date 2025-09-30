package model

class Cliente(var id: Int, var nombre: String) {

    var factura: Double = 0.0;
    var carrito: ArrayList<Producto>

    // nombre, id, factura, carrito
    init {
        carrito = ArrayList()
    }

    // agregar un producto al carrito
    fun agregarProducto(producto: Producto) {
        // no se podra agregar si hay un producto con ese id
        if (carrito.find { return@find it.id == producto.id } == null) {
            println("Agregado correctamente")
            carrito.add(producto)
            factura += producto.precio ?: 0.0
        } else
            println("El producto ya esta en el carrito")
    }

    fun mostrarProductos(){
        if (carrito.isNotEmpty()){
            carrito.forEach {
                it.mostrarDatos()
            }
        } else {
            println("El carrito esta vacio")
        }
    }

    // realizar un metodo para mostrar la informacion de un producto
        // en caso de no encontrar el id -> aviso

    // realizar un metodo para eliminar producto/s por categoria
        // en caso de solo tener un producto -> eliminarlo
        // en caso de tener varios productos -> preguntar si quiero
        // borrar el primero o todos
        // en caso de no tener ninguno, avisar


}