// VARIABLES - FUNCIONES - CLASE

// FUNCIONES fun nombre(arg: Tipo){
// }

// FUNCIONES fun nombre(arg: Tipo): Tipo_retorno{
// return
// }
// p s v main(){}
fun main(arg: Array<String>) {

    // tipo nombre: Tipo = valor
    // var(normal) val(constante)
    // lateinit

    /*var nombre: String? = null;
    var edad:Int = 18;
    val DNI = "123456789A"

    //nombre = "Borja"
    println(nombre?.length ?: "Ejemplo")

    nombre = readLine();

    println("La longitud del nombre es ${nombre?.length ?: "Pepe"}")
    println("Primera ejecución de Kotlin")
    println("Hola son "+nombre+" y tengo "+edad+" años")
    println("Hola son ${nombre} y tengo ${edad}")
    println("La suma de los numeros 2 y 4 es ${2 + 4}")*/
    //estructuraIf();
    estructuraFor();

}

// fun nombre (parametros): Tipo_retorno --> Unit es el void de java
fun estructuraIf() {
    println("Estructura de control IF")
    // if (c) {} else {}
    // if (c) {} else if (c) {} else
    // var salida = if () else {}
    // no existe el if ternario

    var nombre: String? = null;
    println("Introduce tu nombre")
    nombre = readLine()

    // evaluar si la longitud del nombre es más grande que 5
    // en ese caso sacar por consola un "nombre demasiado grande"
    // en caso contrario sacar por consola "nombre correcto"

    // (null > 5) --> (7>5)
    if (nombre?.length!! > 5){
        println("nombre demasiado largo")
    } else {
        println("nombre correcto")
    }
}
fun estructuraFor(){
    // for (int i=0;i<11;i++){}
    // for (i in 1..10){}
    /*for (i in 1..50 step 5){
        println(i)
        // (int) (Math.random() * 51)
        //var aleatorio = (1..50).random()
        //println(aleatorio)
    }*/
    // 1..10 10..1
    for (i in 10 downTo 0){
        println(i)
    }

    // generar 10 aleatorios entre el 1 y el 100, calculando:
    // la suma de todos
    // el numero medio
    // el nmuero max
    // el numero min

}