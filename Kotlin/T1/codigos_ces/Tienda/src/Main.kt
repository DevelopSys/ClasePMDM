import model.Producto
import model.Tienda

fun main() {

    var camiseta: Producto = Producto(id = 1, precio = 14.99)
    var zapatillas = Producto(2, 20.0)
    // id, precio, nombre
    var pantalones = Producto(3, 30.0, "Pantalones")
    var gorra = Producto(4, 20.0, descripcion = "Gorra molona")
    var cartera = Producto(
        5, 5.0, "Cartera",
        "Cartera para guardar la pasta"
    )

    val listaProductos: Array<Producto?> =
        arrayOf(camiseta, zapatillas, pantalones, gorra, cartera)

    // String[] clientes = new String[]{"asdasdasd"}
    val listaClientes: Array<String> = arrayOf("asdasd","asdasdasd")

    //int[] numeros = new int[8]
    val listaProductoVacio: Array<Producto?> = arrayOfNulls(5)

    listaProductos.last()?.precio = 20.0
    //listaProductos[2] = null

    /*listaProductos.forEach {
        it?.mostrarDatos()
    }*/

    listaProductos.forEachIndexed { index, producto ->
        println("Mostrando producto en posicion $index")
        producto?.mostrarDatos()
    }

    var tienda: Tienda = Tienda("asdasd")
    tienda.mostrarAlmacen()


}

// vamos crear una tienda. Para ello crear la clase necesaria
// donde se pueda asignar
// 1- Nombre a la tienda (obligatorio)
// 2- Almacen: sitio donde se guardan los productos.
//    Tiene un tamaño fijo de 6
// 3- Caja: se guardara la pasta cuando se venda un producto