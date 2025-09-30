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

    fun mostrarProductos() {
        if (carrito.isNotEmpty()) {
            carrito.forEach {
                it.mostrarDatos()
            }
        } else {
            println("El carrito esta vacio")
        }
    }

    // realizar un metodo para mostrar la informacion de un producto
    // en caso de no encontrar el id -> aviso

    fun mostrarProducto(id: Int) {
        carrito.find { return@find it.id == id }?.mostrarDatos()
            ?: println("No se encuentra producto con ese id")
    }

    // realizar un metodo para eliminar producto/s por categoria
    // en caso de solo tener un producto -> eliminarlo
    // en caso de tener varios productos -> preguntar si quiero
    // borrar el primero o todos (modificacion: preguntar cuantos quieres borrar)
    // en caso de no tener ninguno, avisar
    fun borrarxCategoria(categoria: Categoria) {
        val listaFiltrada = carrito.filter { it.categoria == categoria }
        when(listaFiltrada.size){
            0->{
                println("No hay productos con esa categoria")
            }
            1->{
                // carrito.remove(listaFiltrada.first())
                carrito.remove(listaFiltrada[0])
                // carrito.remove(listaFiltrada.get(0))
            }
            else->{
                println("Cuantos elementos quieres borrar")
                var nBorrados = readln().toInt()
                if (nBorrados==listaFiltrada.size){
                    carrito.removeAll(listaFiltrada)
                }else if(nBorrados<listaFiltrada.size){
                    for (i in 0..nBorrados-1){
                        carrito.remove(listaFiltrada[i])
                    }
                }
            }
        }
    }


}