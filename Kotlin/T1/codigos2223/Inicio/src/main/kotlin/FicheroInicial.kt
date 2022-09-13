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

    var nombre: String? = null;
    var edad: Int = 18;
    val DNI = "123456789A"
    println(nombre)
    nombre = readLine();

    println("La longitud del nombre es ${nombre.length}")
    println("Primera ejecución de Kotlin")
    // println("Hola son "+nombre+" y tengo "+edad+" años")
    println("Hola son ${nombre} y tengo ${edad}")
    println("La suma de los numeros 2 y 4 es ${2 + 4}")

}