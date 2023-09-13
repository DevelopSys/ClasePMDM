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
        !in 1..5 ->{
            println("Caso no en rango")
        }

        4 ->{}
        conRetorno()->{}
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
    /*for (i in 1..10){
        println("$i")
    }*/
    (10..20).forEach { println("el elemento es $it") }
}

fun main() {
    estructuraFor()
    //estructuraWhen()
}