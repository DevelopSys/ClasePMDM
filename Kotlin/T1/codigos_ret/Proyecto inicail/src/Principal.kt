// variables
// simples -> int-> 4, bool, double
// complejas -> string[], ArrayList, Integer -> 4

fun main() {

    // ejercicioUno()
    // variable no cambian su valor -> no mutable
    val NOMBRE = "Borja"
    // varible si cambian su valor -> mutables
    lateinit var curso: String
    var direccion: String? = null;
    // lateinit var telefono: Int
    var edad: Int = 40;
    edad += 1;
    kotlin.io.println("Mi nombre es: $NOMBRE y su longitud es ${NOMBRE.length}")
    curso = "DAM2"
    kotlin.io.println("Mi curso es $curso")
    // direccion = "Pozuelo"
    kotlin.io.println("Mi direccion es ${direccion?.length ?: "No hay direccion"}")
    /*
    if (){

    } else {

    }

    if (){

    } else if (){

    } else {

    }*/

    /*val nota = 6
    when (nota) {
        in 0..4 ->{
            println("El examen esta suspenso")
        }
        in 5..9->{
            println("El exame esta aprobado")
        }
        10->{
            println("El examen esta perfecto")
        }
        calcularValor(9)->{
            println("La nota se ha salido de lo normal")
        }
        !in calcularValor(9)..calcularValor(20)->{
            println("No es valida")
        }
    }*/

    // FOR -> recorridos -> for (int i=0 ; i<10;++){}
    // for (String item : coleccion) {  }

    /*for ( i in 1 until 10){
        println(i)
    }*/

    (10..20 step 2).forEach{ println(it) }
    (30..40).forEachIndexed { index, i -> println("El item en la posicion ${index+1} es $i") }
    (60..70).forEachIndexed { _, i -> println("El item es $i") }

    println("Introduce el nombre a evaluar")
    var nombreLectura = readln()
    println("Introduce el numero a evaluar")
    // Integer.valueOf("3")
    var edadLectura = readln().toInt()
    (30..50).random()






}

fun calcularValor(numero: Int): Int{
    return numero*2;
}

fun ejercicioUno(){

}