var sumaLambda: ((Int, Int) -> Int)? = { op1, op2 -> op1 + op2 }
fun main(args: Array<String>) {

    /*
    val DNI = "123123123A"
    var nombre: String = "Borja"
    var edad: Number = 41;
    lateinit var correo: String
    var direccion: String? = null
    var altura: Int = 0;

    val conocimientos = arrayListOf("")
    println("Primer programa de repaso Kotlin")
    correo = "borja@retamar.es"
    println("Hola mi nombre es ${nombre}, tengo $edad " +
            "y mi correo es $correo")
    println("Mi nombre tiene ${nombre.length *2} letras")
    println("Vivo en: ${direccion?.length ?: "sin definir"}")

    println("A quien quieres saludar")
    nombre = readln()
    println("Cuantas veces quieres hacerlo")
    var veces:Int = readln().toInt()
    saludar(nombre = nombre, veces = veces)
    */
    /*
    println(
        "El resultado de la operacion es ${
            sumaLambda?.invoke(1, 3)
                ?: "No hay definicion de suma"
        }"
    )*/
    sentenciaFor()
}

fun saludar(nombre: String? = null, veces: Int? = 1) {
    // saludar a la persona con el nombre ="Borja"
    // pasado un numero determinado de veces = 2
    for (i in 0..10) {
        println("Hola ${nombre ?: "no name"} que tal estas")
    }
}

fun sentenciaWhen(opcion: Int) {
    when (opcion) {
        1 -> {
            println("Entrando por ejecucion de caso 1")
        }

        in 2..5 -> {
            println("Entrando por ejecucion de caso 2 a 5")
        }

        !in 5..7 -> {
            println("Entrando por ejecucion de caso sin ser entre 5 y 7")
        }

        sumaLambda?.invoke(6, 9) -> {
            println("Entrando por ejecucion de caso 15")
        }

        else -> {
            println("Entrando por caso no conteplado")
        }
    }
}

fun sentenciaFor() {
    /*
    for ( item in 0..10 step 2){
        println(item)
    }
    for ( item in 10 downTo 0 step 2){
        println(item)
    }

    for (item in (10..20) step 8){
        println(item)
    }
    (20..40).forEach {
        println("Mostrando el elemento $it")
    }*/
    (30..40).forEachIndexed { index, item ->
        if (item % 2 == 0) {
            println("El elemento en posicion $index es $item")
        }
    }
    (5..10).random()

}



