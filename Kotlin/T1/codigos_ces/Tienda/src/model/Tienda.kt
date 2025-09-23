package model

class Tienda(
    var nombre: String,
) {

    var caja: Double =0.0
    lateinit var almacen: Array<Producto?>

    // init -> ejecuta si o si despues del constructor (primario o secundario)
    init {
        almacen = arrayOfNulls(6)
    }

    // un metodo para poder mostrar todos los productos del almacen. En caso de
    // tener todos los huecos disponibles (vacios) sacar un aviso
}