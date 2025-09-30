package model

class Tienda(var nombre: String? = null) {
    var caja: Double = 0.0
    var almacen: Array<Producto?>

    init {
        almacen = arrayOfNulls(5)
    }

    // mostrar todos los datos de todos los productos disponibles
    // en caso de no tener ningun producto en el almacen, saltar un aviso
    // de ALMACEN VACIO

    fun mostrarProductos() {
        var nulos: Int = 0;
        // [p1,null,p2, null]
        almacen.forEach {
            it?.mostrarDatos() ?: nulos++
        }

        if (nulos == almacen.size)
            println("El almacen esta vacio")
    }

    fun agregarProducto(producto: Producto) {

        val busqueda: Producto? = almacen.find {
            return@find it?.id == producto.id
        }

        for (i in almacen.indices) {
            if (almacen[i] == null && busqueda==null) {
                almacen[i] = producto
                println("Producto agregado correctamente")
                return
            }
        }
        println("No hay espacio disponible o esta repetido")
    }

    // realizar un metodo que muestre los productos
    // de una categoria pasada
    // si no hay productos de la categoria psada -> AVISO

    fun filtrarCategoria(categoria: Categoria) {
        val listaFiltrada: ArrayList<Producto?> = almacen.filter {
            return@filter it?.categoria == categoria
        } as ArrayList<Producto?>
    }
}