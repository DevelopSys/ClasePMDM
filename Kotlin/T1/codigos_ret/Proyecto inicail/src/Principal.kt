// variables
    // simples -> int-> 4, bool, double
    // complejas -> string[], ArrayList, Integer -> 4

fun main() {

    // variable no cambian su valor -> no mutable
    val NOMBRE:String = "Borja"
    // varible si cambian su valor -> mutables
    var edad: Int = 40;
    edad += 1;

    kotlin.io.println("Mi nombre es: $NOMBRE y su longitud es ${NOMBRE.length}")


}