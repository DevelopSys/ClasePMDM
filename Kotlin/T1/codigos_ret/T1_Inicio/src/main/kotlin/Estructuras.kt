import kotlin.random.Random

fun estructuraIf() {
    var numero = 10;

    if (numero > 0 && numero < 10) {
        println("El numero esta en rango")
    } else {
        println("El numero esta fuera de rango")
    }
}

fun conRetorno(): Int {
    return 7;
}

fun estructuraWhen(): Unit {

    var numero = 6
    when (numero) {
        !in 1..5 -> {
            println("Caso no en rango")
        }

        4 -> {}
        conRetorno() -> {}
        else -> {
            println("Caso defecto")
        }
    }
}

fun estructuraFor(): Unit {
    // recorrer - trabajar colecciones
    // ejecuciones iterativas
    // for foreach
    /*for -> cuando quiera la posicion
    * for( Tipo item : coleccion ){} -> coleccion
    * */
    /*for (i in 1..10 step 5){
        println("$i")
    }

    for (i in 10 downTo 1 step 5){
        println("$i")
    }*/
    (10..20).forEach { println("el elemento es $it") }
    (10..20).forEachIndexed { index, element ->
        if (index % 2 == 0) {
            println("En la posicion $index esta el elemento $element")
        }
    }

}

fun aleatorios() {


    println("Cuantos numeros quieres generar")
    var nNumeros: Int = readln().toInt();
    println("Cual es el número más pequeño")
    var nInferior: Int = readln().toInt();
    println("Cual es el número más grande")
    var nSuperior: Int = readln().toInt();
    var minimo: Int = nSuperior + 1;
    var maximo: Int = nInferior - 1;
    var sumatorio: Int = 0;


    var opcion = 0
    do {

        var aleatorio = (nInferior..nSuperior).random()
        if (aleatorio > maximo) {
            maximo = aleatorio
        }
        if (aleatorio < minimo) {
            minimo = aleatorio
        }
        sumatorio += aleatorio
        println("1. Ver maximos")
        println("2. Ver minimos")
        println("3. Ver sumatorio")
        println("4. Ver media")
        println("5. Salir")
        println("Que quieres hacer")
        opcion = readln().toInt()
        when (opcion) {
            1 -> {
                println("El máximo es $maximo")
            }

            2 -> {
                println("El minimo es $minimo")
            }

            3 -> {
                println("El sumatorio es $sumatorio")
            }

            4 -> {
                println("La media es ${sumatorio.toDouble() / nNumeros}")
            }
        }
    } while (opcion != 5)

    // 1. Pida cuantos numeros quiero generar:10
    // 2. Pida el rango (inicio y fin): 20 - 50
    // Menu:
    // 1. Mostrar máximo
    // 2. Mostrar mínimo
    // 3. Mostrar media
    // 1: 50
    // 2: 20
    // 3: 34.7

    /*(1..100).forEachIndexed { index, i ->
        println("El elemento generado en la " +
                "poscion $index es ${(20..50).random()}")
    }*/


}

fun main() {
    aleatorios()
    //estructuraFor()
    //estructuraWhen()
}