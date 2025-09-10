fun main() {

    // comentario de linea
    println("Este es mi primer programa Kotlin")
    var nombre:String = "Borja" // String
    var edad:Int = 40 // Int
    var correo:String? = null
    lateinit var direccion: String
    val DNI: String = "123123A"

    // Hola soy Borja, tengo 40 años y mi DNI es 123123A
    println("Hola mi nombre es ${nombre} tengo ${edad} y mi DNI es ${DNI}")
    println("Mi nombr tiene ${nombre.length} letras")
    println("Mi correo es ${correo?.length ?: "sin asignado"}")
    direccion = "Alcorcon"
    println("Mi direccion es $direccion")



}