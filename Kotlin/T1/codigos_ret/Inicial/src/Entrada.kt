fun main(args: Array<String>){

    val DNI = "123123123A"
    var nombre: String = "Borja"
    var edad: Number = 41;
    lateinit var correo: String
    var direccion: String? = null
    var altura: Int = 0;

    val conocimientos = arrayListOf("")
    println("Primer programa de repaso Kotlin")
    correo = "borja@retamar.es"
    println("Hola mi nombre es ${nombre}, tengo $edad " +
            "y mi correo es $correo")
    println("Mi nombre tiene ${nombre.length *2} letras")
    println("Vivo en: ${direccion?.length ?: "sin definir"}")

    println("A quien quieres saludar")
    nombre = readln()
    println("Cuantas veces quieres hacerlo")
    var veces:Int = readln().toInt()
    saludar(nombre = nombre, veces = veces)
    sumaLambda(1,3)
}

fun saludar(nombre: String?=null, veces: Int?=null) {
    // saludar a la persona con el nombre ="Borja"
    // pasado un numero determinado de veces = 2
    for (i in 0..{ veces  }-1){
        println("Hola ${nombre ?: "no name"} que tal estas")
    }
}

var sumaLambda: (Int,Int)-> Int = 

