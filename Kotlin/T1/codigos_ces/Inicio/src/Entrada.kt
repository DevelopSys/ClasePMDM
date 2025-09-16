var sumaFlecha: ((Int, Int) -> Unit)? = { p1: Int, p2: Int ->
    println("El resultado de la suma es ${p1 + p2}")
}

fun main() {

    // comentario de linea
    println("Este es mi primer programa Kotlin")
    var nombre: String = "Borja" // String
    var edad: Int = 40 // Int
    var correo: String? = null
    lateinit var direccion: String
    val DNI: String = "123123A"

    /*println("Por favor introduce tu nombre")
    nombre = readln()
    println("Por favor introduce tu edad")
    edad = readln().toInt()
    saludar(vecesParam = 2)*/
    // Hola soy Borja, tengo 40 años y mi DNI es 123123A
    /*
    println("Hola mi nombre es ${nombre} tengo ${edad} y mi DNI es ${DNI}")
    println("Mi nombr tiene ${nombre.length} letras")
    println("Mi correo es ${correo?.length ?: "sin asignado"}")
    direccion = "Alcorcon"
    println("Mi direccion es $direccion")
    */
    //println("El resultado de la operacion es ${sumar(null, null)}")
    // sumaFlecha = null
    // sumaFlecha?.invoke(1, 55) ?: "asdasdasd"
    // decidirWhen(9)
    repetirFor()
}

fun saludar(nombreParam: String = "Sin nombre", vecesParam: Int) {
    println("Hola $nombreParam, acabas de realizar una funcion")
}

fun sumar(op1: Int = 0, op2: Int = 0): Int {
    return op1.and(op2)
}

fun decidirWhen(valor: Int) {
    println("El valor analizado es:")
    when (valor) {
        1 -> {
            println("El caso tiene como valor 1")
        }

        2 -> {
            println("El caso tiene como valor 2")
        }

        3 -> {
            println("El caso tiene como valor 3")
        }

        4 -> {
            println("El caso tiene como valor 4")
        }

        else -> println("Caso no contemplado")

    }
}

fun repetirFor() {

    /*for (i in 0..9){
        println(i)
    }*/

    // si la funcion de flecha solo tiene 1 ARGUMENTO
    // -> este se puede llamar con la palabra reservada it
    //(20..30).forEach { p -> println(p) }
    (20..30).forEachIndexed { index, item ->
        println("Elemento en posicion $index con valor determinado")

        for (i in 10 downTo 1 ){

        }
    }
}
