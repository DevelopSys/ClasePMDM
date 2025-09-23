package model

class Tienda(
    var nombre: String,
) {

    var caja: Double = 0.0
    lateinit var almacen: Array<Producto?>

    // init -> ejecuta si o si despues del constructor (primario o secundario)
    init {
        almacen = arrayOfNulls(6)
    }

    fun mostrarAlmacen() {
        var nulos = 0;
        almacen.forEach {
            it?.mostrarDatos() ?: nulos++ /*if (it == null){
                nulos++
            }*/
        }
        if (nulos == almacen.size)
            println("No hay productos en el almacen")
    }

    // agregar un elemento al almacen. En caso de no tener hueco
    // disponible se mostrara un aviso
}