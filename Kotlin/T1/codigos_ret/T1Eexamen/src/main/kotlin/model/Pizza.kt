package model

class Pizza(var id: Int, var nombreCliente: String) {

    var precio: Double = 0.0;
    lateinit var listaIngrediente: ArrayList<Ingrediente>
    var estado: Boolean = false;

    init {
        listaIngrediente = ArrayList();
    }

    fun agregarIngrediente(ingrediente: Ingrediente) {
        listaIngrediente.add(ingrediente)
        precio += ingrediente.precio
    }

    fun mostrarDatos(): Unit {
        println("ID: $id")
        println("Nombre cliente: $nombreCliente")
        println("Precio: $precio")
        println("Estado: $estado")
        println("Los ingredientes de la pizza son")
        listaIngrediente.forEach { it.mostrarDatos() }

    }

}