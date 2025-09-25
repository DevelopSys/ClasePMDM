package model

class Cliente(var id: Int, var nombre: String) {
    lateinit var carrito: ArrayList<Producto>
    var factura: Double = 0.0

    init {
        // carrito = ArrayList()
        carrito = arrayListOf()
    }

    fun agregarProductoCarrito(producto: Producto) {

        carrito.add(producto)
        println("Producto agregado al carrito correctamente")
    }

    // mostrar todos los elementos del carrito
    fun mostrarCarrito() {
        if (carrito.isEmpty()) {
            println("No hay nada en el carrito")
        } else {
            carrito.forEach { it.mostrarDatos() }
        }
    }

    // mostrar el producto que esta en una posicion indicada
    fun accesoPorPosicion(posicon: Int) {
        if (posicon > carrito.size - 1) {
            println("ID fuera de rango")
        } else {
            carrito[posicon].mostrarDatos()
        }
    }

    fun borrarElementos(id: Int) {


        /*carrito.find {
            return@find true
        }


        carrito.removeAll(carrito.filter {
            return@filter true
        })*/
        var listaFiltrada = carrito.filter {
            return@filter it.id == id
        }

        if (listaFiltrada.isEmpty()) {
            println("el numero de resultado es ${listaFiltrada.size} por lo que no se puede borrar")
        } else if (listaFiltrada.size == 1) {
            carrito.remove(listaFiltrada.first())
            // carrito.removeFirst()
            println("Borrado correctamente")
        } else {
            println(
                "Se han encontrado varias coincidencias, " +
                        "cual quieres borrar: (1 para el primero / n para todos)"
            )
            val opcion: String = readln()
            if (opcion.equals("1", true)) {
                carrito.remove(listaFiltrada.first())
            } else if (opcion.equals("n", true)) {
                carrito.removeAll(listaFiltrada.toSet())
            }
        }
    }

    fun pedirFactura() {
        if (carrito.isEmpty()){
            println("No puedes pedir, no hay productos en carrito")
        } else{
            carrito.forEach {
                factura+=it.precio
            }
            println("Debes un total de $factura")
            carrito.clear()
            factura = 0.0
        }
    }

    // hacer un metodo para calcular la factura del cliente
    // cuando un cliente pide la factura se muestra por consola y vacia el carrito

    // eliminar un producto del carrito
    // en caso de no estar el id en el carrito -> aviso de que no se encuentra
    // en caso de si estar en el carrito y solo existir uno, lo elimina
    // en caso de si estar en el carrito y existir varios, confirmacion de eliminar 1 o todos
}