import model.Categoria
import model.Cliente
import model.Producto
import model.Tienda

fun main() {

    println((1..14).random())
    var gorra = Producto()
    var pantalones = Producto(2, 10.0, categoria = Categoria.Ropa)
    var zapatillas = Producto(3, 30.0, "zapatillas", categoria = Categoria.Ropa)
    var cartera = Producto(4, 5.0, descripcion = "esta cartera es para guardar la pasta")
    var camiseta = Producto(
        1, 10.0, "camiseta", "camiseta para salir de fiesta"
        , categoria = Categoria.Ropa
    )


    // camiseta.mostrarDatos()
    // array es una coleccion fija de elementos
    val listaProductos: Array<Producto?> = arrayOf(gorra, pantalones, zapatillas, cartera, camiseta)
    val listaProductosTamanio: Array<Producto?> = arrayOfNulls(5)
    // listaProductos[0].mostrarDatos()
    //listaProductos[0] = null
    // listaProductos[0]?.mostrarDatos() ?: println("No se puede ejecuatr porque es nulo")
    //listaProductos.first().mostrarDatos()
    // listaProductos.first() = null
    // mostrar los datos de todos los productos de la lista

    /*
    val tienda = Tienda()
    tienda.agregarProducto(camiseta) // 1
    tienda.agregarProducto(cartera) // 4
    tienda.agregarProducto(zapatillas) // 2
    tienda.agregarProducto(pantalones) // 2
    tienda.mostrarProductos()
    */
    /* FOREACH -> recorrer y acceder a la info
    listaProductos.forEach{
        it?.mostrarDatos() ?: println("Hueco vacio")
    }*/

    var cliente: Cliente = Cliente(1,"Borja")
    cliente.agregarProducto(Producto(id = 1, precio = 10.0, categoria = Categoria.Ropa))
    cliente.agregarProducto(Producto(id = 2, precio = 30.0, categoria = Categoria.Tecnologia))
    cliente.agregarProducto(Producto(id = 3, precio = 20.0, categoria = Categoria.Ropa))
    cliente.borrarxCategoria(Categoria.Ropa)
    cliente.mostrarProductos()
//cliente.mostrarProductos()
    // 0.0
    // []


    /*for (item in listaProductos){
        // item?.mostrarDatos()
        if (item?.id==1){
            item = null
        }
    }*/

    // modificar elementos de un array o arraylist
    /*for (i in 0..listaProductos.size-1){
        if (listaProductos[i]?.id == 1){
            listaProductos[i] = null
        }
    }*/

    // vamos a crear una tienda. Para ello la tienda tendrá que crearse de forma
    // obligatoria con un nombre
    // ademas de esto la tienda cuenta con una caja (la pasta que voy ganando con la venta de los productos)
    // ademas la tienda tiene un almacen (donde se guardan todos los productos)
    // la tienda solo cuenta con espacio para 5 productos, que inicialmente no tiene nada

}