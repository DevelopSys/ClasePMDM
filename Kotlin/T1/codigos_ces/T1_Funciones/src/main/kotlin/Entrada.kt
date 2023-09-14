fun funcionSuma(operadorUno: Int, operadorDos: Int): Int {
    var suma = operadorDos + operadorUno
    //println("El resultado de suma $operadorUno + $operadorDos es $suma")
    return suma;
}

fun funcionOptativos(param1: String, param2: Int = 0) {
    println("El parametro uno es $param1 y el segundo es $param2")
}

fun funcionOptativos(param1: String, param2: Int?) {
    println("El parametro uno es $param1 y el segundo es $param2")
}

// -> String
fun pedirNombre(): String {
    println("Por favor introduce el nombre que quieres acompañar en el mensaje")
    var nombre = readln()
    return nombre;
}

// String -> Unit
fun imprimirMensaje(mensaje: String): Unit {
    var nombre = pedirNombre();
    println(mensaje + " $nombre")
}

fun funcionParamentoFuncion(param: (() -> String)?, param2: String) {
    var nombre = param?.invoke() ?: "defecto"
    println("$param2 $nombre")
}

var funcionSumaFlecha: ((Int, Int) -> Int) =
    { param1: Int, param2: Int -> param1 + param2 }
var funcionSumaFlechaAsync: ((Int, Int) -> Int) =
    { param1: Int, param2: Int -> param1 + param2 }

fun esPar(x: Int): Boolean = x % 2 == 0
var funcionPar = { x: Int -> x % 2 == 0 }
fun listaNumeros(x: Int) = (1..x).forEach { println(it) }

fun main() {

    listaNumeros(10)
    //println(funcionSumaFlecha(4,8))
    //funcionParamentoFuncion({ pedirNombre() }, "Ejemplo");
    //imprimirMensaje("Esto es un ejemplo de mensaje")
    //funcionOptativos("Uno",null);
    //println(funcionSuma(8,4));
    //println(funcionSuma(operadorDos = 4, operadorUno = 2))
}