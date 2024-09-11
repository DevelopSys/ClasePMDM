 var numero: Int =0;
fun main() {

    // variables que pueden cambiar -> mutables
    var nombre: String = "Borja"
    var apellido: String? = null
    var edad: Int = 40
    // variables que no pueden cambiar -> no mutables
    val experiancia: Boolean = false
    println("Introduce un numero")
    // string -> int parseInt(nota)
    numero = readln().toInt()

    when (nota % 2) {
        0 -> {
            println("Es par")
        }

        1 -> {
            println("Es impar")
        }
    }


    if (nota % 2 == 0) {
        println("Numero par")
    } else {
        println("Numero impar")
    }

    // println("La nota introducida es $nota")
    // println("El resultante es ${calcularNumero(9)}")

    /*
    when (nota) {
        10 -> {
            println("MH")
        }

        in 1..4 -> {
            println("SS")
        }

        in 5..7 -> {
            println("AP")
        }

        in 8..9 -> {
            println("SB")
        }

        calcularNumero(9) -> {

        }

        !in 11..100 -> {

        }
    }*/

    // for (i in array)

    /*for ( i in 0 until 10 ){
        println(i)
    }*/

    (10..20).forEach {
        println(it)
    }

    (50..60).forEachIndexed { indice, valor ->
        println("El valor $valor esta ubicado en la posicion ${indice + 1}")
    }
}

fun calcularNumero(numero: Int): Int {
    return numero * 2;
}

// for (int i =0; i<10;i++){

