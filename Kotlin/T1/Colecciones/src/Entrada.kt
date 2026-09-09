fun main() {
    var elementos: Array<Int?> = arrayOfNulls(5)

    /*for (i in 0 until elementos.size){
        println(elementos[i])
    }

    elementos[0] = (10..20).random()

    for (i in elementos){
        println(i)
    }

    /*(0 until elementos.size).forEach {
        println(elementos[it])
    }*/

    elementos[0] = (10..20).random()
    elementos.forEach { println(it)}

    // pedir por consola el tamaño del array
    // pedir el rango de numeros: inicial y final
    // indicar la suma de todos los elementos del array
    // indicar la media de los elementos
    // pedir por consola un numero que este entre el rango indicado
        // continuar pidiendo mientras (while) el numero
        no este en el rango

    // El numero esta presente
    // El numero XXX se repite 7 veces





     */



    println("Indica el tamaño del array")
    val tamanio = readln().toInt()
    println("Indica rango inicial")
    val rangoInicial = readln().toInt()
    println("Indica rango final")
    val rangoFinal = readln().toInt()
    val numeros: Array<Int?> = arrayOfNulls(tamanio)
    var sumatorio: Int = 0

    // (0 until tamanio)
    (0 until numeros.size).forEach {
        // it -> 0 , 1 , 2 , 3 ,4
        numeros[it] = (rangoInicial..rangoFinal).random()
        sumatorio += numeros[it] ?: 0
    }

    println("El total de los numeros es $sumatorio")
    println("La media de los numeros es ${sumatorio.toDouble() / numeros.size}")


    var numeroBuscar: Int = 0
    var rangoOK: Boolean
    do {
        println("Que numero quieres buscar")
        numeroBuscar = readln().toInt()
        rangoOK = numeroBuscar !in rangoInicial..rangoFinal
    } while (rangoOK)

    /*numeros.forEach {
        if (it == numeroBuscar){
            contador++
        }
    }*/

    println("${numeros.find { it==numeroBuscar } ?: "el numero no esta en la lista"} ")

    println("El numero de elementos que coinciden con la busqueda es " +
            "${numeros.filter { numeroBuscar == it }.size} ")

    val opcion = 1
    when(opcion){
        1 ->{}
        2 ->{}
        3 ->{}
        4 ->{}
        5 ->{}
        in 6..10->{}
        else -> {}
    }

    /*
    Realizar una aplicacion que
    decida que alumno de la clase saldra a mostrar la solucion de los ejercicios
    1. Un menu donde tenga las siguientes opciones
        1. Crear clase -> indica cuantos alumnos hay en la clase
        2. Matricular alumnos -> pedirá los nombre de todos los alumnos (puede haber nombres repetidos)
        3. Mostrar alumnos clase -> mostrará los nombres de todos los alumnos disponibles (los nulos no los mostrará)
        4. Sacar alumno a pizarra -> mostrará el nombre del alumno que saldrá a la pizarra. Solo funcionara si todos
        los alumnos están matriculados . En caso de no estar llena, mostrará un aviso

     */

}