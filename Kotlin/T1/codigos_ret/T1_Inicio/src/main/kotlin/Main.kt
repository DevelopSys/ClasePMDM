import java.util.Objects

// mutables
var nombre: String = "Borja"
    get() {
        if (field.length>0){
            return field
        }
        return "vacio"
    }
lateinit var correo: String
var edad: Int = 39
    set(value) {
        field += value;
    }
var direccion: String? = "Pozuelo"
var cosa: Any = "asd";
// no mutable
val DNI: String = "0987654A"

fun main() {

    println("Ejecucion del primer programa en kotlin")
    println("El valor del nombre es: $nombre")
    edad = 2;
    println("El valor de la edad es: $edad")
    correo = "asd@asd.com"
    println("El valor del correo es: $correo")
    println("La longitud de la direccion es: ${direccion?.length ?: 0}")
}
