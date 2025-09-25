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
    fun agregarProducto(producto: Producto){
        for (item in 0..almacen.size-1){
            if (almacen[item] == null){
                 almacen[item] = producto;
                return;
            }
        }
        println("El almacen esta completo")
    }

    // vamos a vender un producto. PAra ello se solicita el id del producto
    // a vender. En caso de estar en el almacen:
        // se elimina de este
        // su precio se suma a la caja
    // si se vende se da aviso de producto vendido y se da el valor de la caja
    // si no se encuentra se da aviso de que no esta en el almacen

    fun venderProducto(id: Int){
        for ( i in 0..almacen.size-1 ){
            // no es nulo lo que accedo
            if (almacen[i]!=null && almacen[i]?.id == id){
                caja += almacen[i]!!.precio
                almacen[i] = null
                return
            }
        }
        println("El id indicado no esta en la lista")
    }

    fun buscarProductosCategoria(categoria: Categoria){
        // filtrando -> obteniendo varios
        val filtro: ArrayList<Producto?> = almacen.filter {
            return@filter it?.categoria == categoria
        } as ArrayList<Producto?>

        println("El numero de elementos resultantes es ${filtro.size}")

    }

    fun buscarProductoId(id: Int):Unit{
        // buscando -> obtengo solo un elemento
        var productoBusqueda: Producto? = almacen.find {
            return@find it?.id == id
        }
    }
}