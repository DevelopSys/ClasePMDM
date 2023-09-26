fun main() {

    // Array -> new int[]{}
    val arrayNumerosVacio: Array<Int> = emptyArray()
    // Array -> new int[9]
    val arrayNumerosNull: Array<Int?> = arrayOfNulls<Int>(9)
    // Array -> new String[]{"elemento1","elemento2", "elemento3"}
    val arrayElementos: Array<String> = arrayOf("elemento1", "elemento2", "elemento3")
    // Object[10]
    val arrayCosas: Array<Any?> = arrayOfNulls(10)
    val arrayNumeros = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    // cambiar el valor de una posicion
    arrayNumerosNull[0] = 2
    // acceso a una posicion
    println(arrayNumerosNull[0] ?: "sin elemento")
    // sacar todas las posiciones de un array
    /*for (i in arrayElementos){
        println(i)
    }*/
    arrayElementos.forEach { println(it) }
    arrayElementos.forEachIndexed { index, element
        ->
        println("El elemento en la posicion $index es $element")
    }
    val arrayNumerosCompleto: Array<Int?> = arrayOf(1, 23, 123, 123, 21, 21, 32, 1, 23, 43, 23, 43, 21)

    // Buscar si hay un 43
    /*arrayNumerosCompleto.forEach {
        if (it == 43) {
            println("Elemento encontrado")
        }
    }*/

    var numeroEncontrado = arrayNumerosCompleto.find { it==21 }
    println(numeroEncontrado?: "Elemento no encontrado")

    // Sabes cuantos 43 hay en la lista
    /*var contador = 0;
    arrayNumerosCompleto.forEach {
        if (it == 43) {
            contador++
        }
    }
    println(contador);*/
    println("El numero de 21s es ${arrayNumerosCompleto.filter { it == 21 }.size}")

    val listaNumeros: ArrayList<Int> = ArrayList<Int>()
    // add
    listaNumeros.add(20);
    listaNumeros.add(8);
    listaNumeros.add(10);
    listaNumeros.add(8);
    listaNumeros.add(20);
    listaNumeros.add(10);
    // modificar
    listaNumeros.set(0,1)
    listaNumeros[0]= 25

    // borrar el elemento indicado
    listaNumeros.remove(20)
    // borrar el elemento en la posicion
    listaNumeros.removeAt(0)
    // borrar todos los elementos de golpe
    listaNumeros.removeIf { true }


}