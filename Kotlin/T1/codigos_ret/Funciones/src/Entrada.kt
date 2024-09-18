import kotlin.math.cbrt

val sumaFlecha: (Int, Int) -> Int = { op1: Int, op2: Int -> op1 + op2 }
var muliplicacion: ((Int, Int) -> Int)? = null

fun main() {
    // posicionales
    // suma(10,5)
    // nominales
    // suma(operandoDos = 10, operandoUno = 10)
    // operando2 = 10 (defecto)
    //println("La suma resultanto es ${sumaRetorno(operando2 = 20)}")
    // sumaFlecha(3,10)
    // muliplicacion?.invoke(4,10) ?: println("no hay ejecucion")
    // operacionesArray()
    // println(busquedasArray("juanpe") ?: "No encontrado")
}

fun busquedaFind(nombre: String) {
    val alumnos: Array<String> = arrayOf("Borja", "Juan", "Jose", "Juan", "Marcos", "Pedro")
    val cosa: String? = alumnos.find { it.equals(nombre) }
}

// busqueda de n

// crear la funcion que me de TODOs los nombres que cumplen
// la condicion de busqueda
fun busquedaCompletaArray(nombre: String) {
    val lista: ArrayList<String> = ArrayList<String>()
    lista.add("Cosa")
}

// busqueda de 1
fun busquedasArray(nombre: String): String? {
    val alumnos: Array<String> = arrayOf("Borja", "Juan", "Jose", "Juan", "Marcos", "Pedro")
    alumnos.forEach {
        if (it.equals(nombre, true)) {
            return it
        }
    }
    return null
}

fun operacionesArray() {
    // Array -> estatico. Posicion
    // new String[]{"",""}
    // 5
    val alumnos: Array<String> = arrayOf("Borja", "Juan", "Jose", "Marcos", "Pedro")
    // println(alumnos[0]) // Borja
    // println(alumnos.get(0))
    // alumnos[0] = "Juan"
    // alumnos.set(0,"Borja")
    /*for ( i in 0 until alumnos.size ){
        println("El alumno en la posicion ${i+1} es ${alumnos[i]}" )
    }*/
    /*for (item in alumnos){
        println(item)
    }*/
    // alumnos.forEach { println(it) }
    // alumnos.forEachIndexed { index, item -> println("${index + 1} : $item") }


    // null, null, null, null
    val profesores: Array<String?> = arrayOfNulls<String>(4)
    profesores.forEach { println(it ?: "Sin profesor") }

    // TABLAS DE MULTIPLICAR DE 0-10 -> 3-4 lineas de codigo
    val numeros = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    for (i in numeros) {
        for (j in 0..10) {
            println("$i * $j = ${j * i}")
        }
    }
    (0..10).forEach { op1 ->
        (0..10)
            .forEach { op2 -> println("$op1 * $op2 = ${op1 * op2}") }
    }


    // List -> dinamicos. Posicion
    // ArrayList (posiciones)


}

// funcion de bloque
fun suma(operandoUno: Int, operandoDos: Int): Unit {
    println("La suma de ambos paramentos es ${operandoUno + operandoDos}")
}

fun sumaRetorno(operando1: Int = 10, operando2: Int): Int {
    return operando1 + operando2;
}