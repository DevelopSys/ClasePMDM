fun main() {

    funcionSuma(numeroDos = 7, numeroUno = 20)
    funcionSuma(5, 6)
    println(funcionSumaRetorno(6, 9))
    funcionParamentrosDefecto(param2 = 6)
    funcionParamentrosDefecto("Adios", 20)
    funcionParamentrosNull("Parametro nulo")
    funcionLlamadaFlecha { i, i2 -> println("Los parametros de la funcion son $i $i2") }
    //funcionLlamadaFlecha( fun(){},  4,  5)
    funcionSumaVar?.invoke(4,7)
    funcionLlamadaFlecha(funcionSumaVar,6,9)
    funcionLlamadaFlecha({param: Int, param2: Int-> param*param2 },6,9)
    funcionLlamadaFlecha({param: Int, param2: Int-> param/param2 },6,9)
    funcionLlamadaFlecha({param: Int, param2: Int-> param-param2 },6,9)

    // {param: Int, param2: Int-> param+param2 }

    val listaNombres: ArrayList<String> = ArrayList<String>()
    listaNombres.add("ertyu")
    listaNombres[4] = "dfghjklñ´"
    listaNombres.remove("asd")
    listaNombres.removeAt(1)
    listaNombres.get(9)
    listaNombres[9]

}

fun funcionSuma(numeroUno: Int, numeroDos: Int) {
    println("La suma de los dos numeros es: ${numeroUno + numeroDos} ")
}

fun funcionSumaRetorno(numeroUno: Int, numeroDos: Int): Int {
    return numeroUno + numeroDos;
}

fun funcionParamentrosDefecto(param1: String = "Hola", param2: Int) {
    println("El primer paramentro es $param1 el segundo es $param2")
}

fun funcionParamentrosNull(param1: String, param2: Int? = null) {
    //param2 ?: 9
    println("El primer paramentro es $param1 el segundo es $param2")
}

fun funcionParametrosTodos(param1: Any) {

}

fun funcionLlamadaFlecha(param1: (Int, Int) -> Unit) {
    println("Funcion con llamada a flecha ejecutando...")
    param1(4,7)
}

fun funcionLlamadaFlecha(param1: (Int, Int) -> Int, param2:Int, param3: Int) {
    println("Funcion con llamada a flecha ejecutando...")
    param1(param2,param3)
}

var funcionSumaVar: ((Int, Int)->Int) = {param: Int, param2: Int-> param+param2 }
