// clase - varible - funciones
// String nombre = "Valor"
// var nombre: String = "Valor"
// var val
// var nombre: String? = null;
var nombre: String? = null
var edad: Int = 18;
val DNI: String = "123A"


fun main(arg: Array<String>): Unit {
    println("Introduce cual es tu nombre")
    nombre = readLine()
    println("Introduce cual es tu edad")
    edad = readLine()!!.toInt()
    //edad = readLine() as Int
    //println(nombre!!.length)
    println("Hola mi nombre es ${nombre} tengo ${edad} años")
    println("La suma del numero 4 y el numero 2 es ${4 + 2}")
    estructurasFor()
}

fun estructurasIf(x: Any) {
// ejecuciones
}

fun estructurasFor() {
// ejecuciones

    when(2){
        is Int ->{
            println("El valor es numero")
        }
        is
    }
}
