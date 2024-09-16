// variables
// simples -> int-> 4, bool, double
// complejas -> string[], ArrayList, Integer -> 4

fun main() {

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

    val nota = 6
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
    }

}

fun calcularValor(numero: Int): Int{
    return numero*2;
}