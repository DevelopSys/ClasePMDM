import model.Categoria
import model.Cliente
import model.Producto
import model.Tienda

fun main() {

    var camiseta: Producto = Producto(id = 1, precio = 14.99, categoria = Categoria.Ropa)
    var zapatillas = Producto(2, 20.0, categoria = Categoria.Ropa)
    // id, precio, nombre
    var pantalones = Producto(3, 30.0, nombre = "Pantalones", categoria = Categoria.Ropa)
    var gorra = Producto(4, 20.0, descripcion = "Gorra molona", categoria = Categoria.Ropa)
    var cartera = Producto(
        5, 5.0, nombre = "Cartera", descripcion = "Cartera para guardar la pasta", categoria = Categoria.Generica
    )
    var telefono = Producto(
        6, 500.0, nombre = "Iphone", descripcion = "Telefono mocil", categoria = Categoria.Tecnologia
    )

    val listaProductos: Array<Producto?> =
        arrayOf(camiseta, zapatillas, pantalones, gorra, cartera, telefono)

    /*
    // String[] clientes = new String[]{"asdasdasd"}
    val listaClientes: Array<String> = arrayOf("asdasd", "asdasdasd")

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
    }*/

    var tienda: Tienda = Tienda("Tienda de todo un poco")
    tienda.almacen = listaProductos
    // tienda.mostrarAlmacen()
    // tienda.buscarProductosCategoria(Categoria.Muebles)
    var cliente: Cliente = Cliente(1,"Borja")
    cliente.agregarProductoCarrito(gorra) // 4
    cliente.agregarProductoCarrito(gorra) // 4
    cliente.agregarProductoCarrito(pantalones) // 3
    //cliente.mostrarCarrito()
    // cliente.accesoPorPosicion(1)
    cliente.borrarElementos(1)


}

// vamos crear una tienda. Para ello crear la clase necesaria
// donde se pueda asignar
// 1- Nombre a la tienda (obligatorio)
// 2- Almacen: sitio donde se guardan los productos.
//    Tiene un tamaño fijo de 6
// 3- Caja: se guardara la pasta cuando se venda un producto