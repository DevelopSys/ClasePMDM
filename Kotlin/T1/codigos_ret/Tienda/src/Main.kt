import model.Producto

fun main() {

    println((1..14).random())
    var gorra = Producto()
    var pantalones = Producto(2, 10.0)
    var zapatillas = Producto(3, 30.0, "zapatillas")
    var cartera = Producto(4, 5.0, descripcion = "esta cartera es para guardar la pasta")
    var camiseta = Producto(1, 10.0, "camiseta", "camiseta para salir de fiesta")

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

    /* FOREACH -> recorrer y acceder a la info
    listaProductos.forEach{
        it?.mostrarDatos() ?: println("Hueco vacio")
    }*/


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