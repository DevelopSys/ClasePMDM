import kotlin.random.Random

var nombre: String = "Borja"
    get() {
        return field
    }


var edad: Int = 39
    get() {
        return field
    }
    set(value) {
        field = field + value
    }

fun estructuraIf(): Unit {

    var numero: Int = 6
    if (numero > 0) {
        println("El numero es positivo")
    } else {
        println("El numero es negativo")
    }
}

fun estructuraWhen(): Unit {
    var numero = 7
    when (numero) {
        !in 1..10 -> {
            println("Caso 1 - 10")
        }

        else -> {
            println("Caso resto")
        }
    }
}

fun estructuraFor(): Unit {
    // for (int i =0;i<10;i++){}
    /*for (i in 0..10 step 2){
        println(i)
    }*/
    //(1..10).forEach { println(it) }
    /*(5..20).forEachIndexed { posicion, elemento ->
        println("El elemento $elemento en la posicion $posicion") }*/
    //println("El numero aleatorio generado es ${(1..100).random()}")
    //(1..100).forEach { println((0..50).random()) }
    //(1..100).forEach { println("El generado es ${(0..50).random()}") }
    //(1..100).forEach { println("El generado es ${Random(System.nanoTime()).nextInt(100)}") }
    //var numero: Int = readln().toInt();
    //var numero: String? = readLine()
}

fun main(args: Array<String>) {
    estructuraFor()
    //estructuraWhen()
    //edad = 1
    //println("El nombre guarado es $nombre $edad")
}

