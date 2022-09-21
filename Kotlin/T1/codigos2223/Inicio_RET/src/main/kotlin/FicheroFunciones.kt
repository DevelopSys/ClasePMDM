fun main() {

    //funcionNormal();
    //funcionParametros(x="Hola",y=2);
    //funcionParametros(y=2,x="Borja");
    // funcionParamDefecto(5,"Hola",true);
    // funcionParamDefecto(5,"Hola");
    // funcionParamDefecto(5,"Hola");
    //  funcionParamDefecto(numero = 5, acierto = true);
    // funcionSuma(2,5)
    funcionLambda(4,7)


    if (funcionRetorno(4,9)){
        println("La suma es mayor que 10")
    } else {
        println("La suma no llega")
    }
}

fun funcionNormal() {
    println("Funcion normal ejecutada")
}

fun funcionParametros(x: String, y: Int) {

    println("Parametro uno: $x")
    println("Parametro dos: $y")

}

fun funcionParamDefecto(numero: Int,
                        palabra: String = "por defecto",
                        acierto: Boolean){
    println("El numero es: $numero")
    println("La palabra es: $palabra")
    println("El acierto es: $acierto")
}

fun funcionSuma(numeroUno: Int, numeroDos: Int) = println("${numeroUno+numeroDos}")

fun funcionRetorno (x: Int, y: Int): Boolean {
    if ((x + y) > 10) {
        println("El resultado es mas grande que 10")
        return true
    } else {

        return false
    }
}

var funcionLambda: (Int,Int?)->Unit = {numeroUno: Int, numeroDos: Int? -> println("${numeroUno + numeroDos!!}") }