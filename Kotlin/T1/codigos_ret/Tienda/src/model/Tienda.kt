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

    // [ null p2 null p4 p5 ]
    // vamos a meter prductos al almacen.
    // para ello crear un metodo que permita poner un
    // producto en el almacen
    // se colocará en el primer hueco disponible
    // en caso de estar todos los huecos ocupados saltar un aviso
    // NO HAY HUECO
}