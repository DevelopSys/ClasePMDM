// public static void main (String[] args){}


fun main() {

    // println("Este es mi primer programa en Kotlin "+" y ahora voy a ver el "+" formateo")
    var nombre: String = "Borja"
    var apellido = "Martin"
    var edad: Int = 42
    var experiencia: Boolean = false
    var localidad: String? = null
    lateinit var pais: String
    val correo = "borja@cesjuanpablo.com"
    //println("Introduce el primer elemento")
    // var n1 = readln().toInt()
    // var n2 = readln().toInt()
    // multiplicar(n1, n2)
    sumaFlecha(2,5)


    /*println("Introduce nombre")
    nombre = readln()
    println("Introduce apellido")
    apellido = readln()
    println("Introduce edad")
    edad= readln().toInt()
    println("Introduce experiencia")
    experiencia = readln().toBoolean()
    println("Introduce localidad")
    localidad = readlnOrNull()
    // leear por consola todas las variables a excepcion del corro
    */
    /*pais = "España"

    println("Mi nombre es $nombre $apellido, tengo ${edad + 1} con experiencia ${experiencia} y mi correo es ${correo.length}")
    println("Telefono: $pais")
    println("Localidad: ${localidad ?: "sin definir" }")
    println("Localidad: ${localidad?.length ?: "no hay definicion" }")
    */
    // parametros posicionales
    // saludar(nombre, apellido)
    // saludar(nombre)
    // saludar()
    // parametros nominales
    // saludar(nombreParam = nombre, apellidoParam = apellido, veces = 2)


}

fun saludar(nombreParam: String? = null, apellidoParam: String? = null, veces: Int = 5): Unit {

    // println("Hola ${nombreParam ?: ""} ${apellidoParam ?: ""}, primer metodo ok")
    /*for (i in 0..veces){
        println("Hola ${nombreParam ?: ""} ${apellidoParam ?: ""}, primer metodo ok")
    }*/
    // (0 until veces)
    // (0 until veces).forEach { println("Hola ${nombreParam ?: ""} ${apellidoParam ?: ""}, primer metodo ok") }
    (0 until veces).forEachIndexed { _, index ->
        println(
            "Saludo nº ${index + 1} : Hola ${nombreParam ?: ""} " +
                    "${apellidoParam ?: ""}, primer metodo ok"
        )
    }


}

// realizar un programa que pida por consola el rango de numeros de los que
// quiero sacar sus tablas de multiplicar y mostrarlas por consola

fun multiplicar(x: Int, y: Int) {
    println("Tablas de multiplicar")
    (x..y).forEach { op -> println("Tabla del $op")
        //(0..10).forEach { println("${op} * ${it} = ${op * it} ") }
        (0..10).forEach { println(resultadoOperacion(op,it)) }
    }

    /*for (i in x..y){
        println("Tabla del $i")
        for (j in 0..10){
            println("\t${i} * ${j} = ${j*i}")
        }
    }*/
}

fun resultadoOperacion(op1: Int, op2: Int): String{
    return "$op1 * $op2 = ${op1 * op2}"
}

var sumaFlecha: (Int, Int) -> Unit = { op1: Int, op2: Int -> println(op1+op2) }
var sumaFlechaOtra: (Int, Int) -> Unit? = { op1: Int, op2: Int -> println(op1+op2) }
var sumaFlechaOtraMas: ((Int, Int) -> Unit?)? = { op1: Int, op2: Int -> println(op1+op2) }
var sumaFlechaOtraUltima: (Int, Int) -> Int = { op1: Int, op2: Int -> op1+op2 }

