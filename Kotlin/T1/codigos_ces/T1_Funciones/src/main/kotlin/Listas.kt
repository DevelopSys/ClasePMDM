
var funcionEj1: (ArrayList<Int>)-> Int = {param1: ArrayList<Int> -> 3 } 
fun ejercicioUno(x: ArrayList<Int>): Int {
    
}

fun main() {

    var listaNumeros = ArrayList<Int>()
    listaNumeros.add(2)
    listaNumeros.add(2)
    listaNumeros.add(2)
    listaNumeros.add(2)
    listaNumeros.forEachIndexed { index, i ->  }
    listaNumeros.forEach { println(it*2) }
    listaNumeros.forEach { println(it*12) }
    listaNumeros.forEach { println("El numero es $it") }
    
    ejercicioUno(listaNumeros)
    
    val lista = ArrayList<String?>();
    lista.add("Uno")
    lista.add("Tres")
    lista.add("Cuatro")
    lista.add("Cinco")
    lista.add(null)
    lista.add("6")

    lista.forEach { println(it?.length ?:0) }


}