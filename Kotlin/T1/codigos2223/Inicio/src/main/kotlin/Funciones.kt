fun main() {
    //funcionParametros("Borja",10);
    //funcionParametros(arg2 = 10,arg1 = "Borja");
    //funcionPorDefecto(numeroDos = 10, numeroTres = 20);
    println(funcionLambdaSuma (1,4))
    var funcionLambdaSuma: ((arg1:Int,arg2:Int)->Int)? = null
    funcionLambdaSuma = { arg1: Int, arg2: Int ->
        if (arg1 > 0 && arg2 > 0) {
            var arg5 = "asdad";
            arg1 + arg2
        } else {
            0
        }
    }
    funcionLambdaSuma(3,7)
}

fun funcionSimple() {
    println("Funcion simple ejecutada")

}

fun funcionParametros(arg1: String, arg2: Int) {
    println("$arg1")
    println("$arg2")
}

fun funcionPorDefecto(numeroUno: Int = 100, numeroDos: Int, numeroTres: Int) {
    println("${numeroUno + numeroDos + numeroTres}")
}

fun funcionSuma(num1: Int, num2: Int) = println("${num1 + num2}")
fun funcionRetorno(): String {
    var nombre: String = "Borja"
    return nombre;
}
var funcionLambdaSuma: (arg1:Int,arg2:Int)->Int = { arg1: Int, arg2: Int ->
    if (arg1 > 0 && arg2 > 0) {
        var arg5 = "asdad";
        arg1 + arg2
    } else {
        0
    }


}

