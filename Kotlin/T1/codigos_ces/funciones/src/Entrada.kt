fun main() {
    //funcionNormal("Mensaje de bienvenida")
    // println("El resultado de la suma es ${funcionRetorno(6, 9)}")
    // println("El resultado de la suma es ${funcionRetorno(param2 = 5, param1 = 7)}")
    // println("El resultado de la suma es ${funcionRetorno(param2 = 7)}")
    // println("El resultado de la funcion lambda es ${funcionSuma(10,10) ?: "No han defincion de la funcion"}")
    //funcionArrays()
    funcionTabla()
}

fun funcionTabla() {
    (1..10).forEach { op1 ->
        println("Tabla del $op1")
        (1..10).forEach { op2 ->
            println("\t $op1 * $op2 = ${op1 * op2}")
        }
    }
}

fun funcionAleatorios(){

    println("Cuantos numeros quieres guardar")
    val capacidad = readln().toInt()
    val numeros: Array<Int?> = arrayOfNulls<Int>(capacidad)
    println("Indica el valor minimo a generar")
    val minGenerado: Int = readln().toInt()
    println("Indica el valor maximo a generar")
    val maxGenerado: Int = readln().toInt()

    for (i in 0 until numeros.size ){
        val aleatorio = (minGenerado..maxGenerado).random()
        numeros[i]= aleatorio
    }


}

// CREAR UN PROGRAMA QUE TENGA LA SIGUIENTE FUNCIONALIDAD
// PIDE AL USUARIO CUANTOS NUMEROS QUIERES GUARDAR -> 20
// ******* PEDIR AL USUARIO SI QUIERE REPETIR NUMEROS ********
// ******* CONTROLAR EL TAMAÑO DEL ARRAY y EL RANGO *******
// PIDE AL USUARIO UN nª MIN y UN nº MAX -> 10 - 100
// GUARDA EN EL ARRAY TANTOS nºs COMO EL USUARIO DIGA (20) ALEATORIOS
// COMPRENDIDOS ENTRE
// LOS DOS VALORES MIN - MAX

// UNA VEZ GUARDADOS
    // SACAR POR CONSOLA: MAXIMO , MINIMO, SUMA, MEDIA


fun funcionArrays() {
    val usuarios = arrayOf("Alumno 1", "Alumno 2", "Alumno 3", "Profesor 1")

    /*for (item in usuarios){
        println(item)
    }*/

    /*for (i in 0 until usuarios.size){
        println(usuarios[i])
    }*/


    // usuarios.forEach { item->println(item) }
    // usuarios.forEach { println(it) }
    /*usuarios.forEachIndexed { index, value ->
        if (index%2!=0){
            println("$index : $value")
        }
    }*/
    /*usuarios.forEach {
        if (it.contains("1")){
            println(it)
        }
    }*/
    // val numeros = arrayOf(1,2,3,4,5,6)
    val encontrado: String? = usuarios.find { it.contains("4") }
    val lista: List<String> = usuarios.filter { it.contains("Alumno") }
    // println("El usuario encontrado es ${encontrado ?: "No coincidente"}")
    if (!lista.isEmpty()) {
        println("Los usuarios encontrados en la lista son")
        lista.forEach { println(it) }
    }

    // tabla de multiplicar del 1 al 10

}

// TIPO -> FUNCION -> (Int,Int)->Int
val funcionSuma = { param1: Int, param2: Int -> param1 + param2 }
fun funcionRetorno(param1: Int = 0, param2: Int): Int {
    return param1 + param2
}

fun funcionNormal(param1: String): Unit {
    println("El mensaja es $param1")
}