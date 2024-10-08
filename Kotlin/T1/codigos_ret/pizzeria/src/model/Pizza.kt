package model

class Pizza(var id: Int, var nombre: String, var servida: Boolean = false) {

    lateinit var listaIngredientes: ArrayList<Ingrediente>
    var precio: Double =0.0;
    init {
        listaIngredientes = ArrayList();
    }

    fun agregarIngrediente(ingrediente: Ingrediente) {
        if (listaIngredientes.size<10){
            listaIngredientes.add(ingrediente)
            precio+=ingrediente.precio!!;
        } else {
            println("Lista de ingredientes completa")
        }
    }

    fun mostrarDatos(){
        println("Nombre $nombre")
        println("Precio $precio")
        println("Estado $servida")
        println("Id $id")
        if (!listaIngredientes.isEmpty()){
            listaIngredientes.forEach {
                println("${it.nombre}: ${it.precio}")
            }
        } else {
            println("no hay ingredientes")
        }
    }

}