val sumaFlecha: (Int,Int)->Int = { op1: Int, op2: Int -> op1 + op2 }
var muliplicacion:((Int,Int)->Int)?=null

fun main() {
    // posicionales
    // suma(10,5)
    // nominales
    // suma(operandoDos = 10, operandoUno = 10)
    // operando2 = 10 (defecto)
    //println("La suma resultanto es ${sumaRetorno(operando2 = 20)}")
    sumaFlecha(3,10)
}

// funcion de bloque
fun suma(operandoUno: Int, operandoDos: Int): Unit {
    println("La suma de ambos paramentos es ${operandoUno + operandoDos}")
}

fun sumaRetorno(operando1: Int = 10, operando2: Int): Int {
    return operando1 + operando2;
}