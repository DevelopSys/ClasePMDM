import model.Usuario

fun main() {
    // instanciar objetos
    var alumno1: Usuario = Usuario("Borja","Martin")
    // nombre = "Borja"
    // apellido = "Martin"
    // correo = null
    var alumno2: Usuario = Usuario("Juan","Gomez")
    // nombre = "Juan"
    // apellido = "Gomez"
    // correo = null
    var alumno3: Usuario = Usuario("Pedro", "Gimenez")
    // nombre = "Pedro"
    // apellido = "Cosa"
    // correo = null
    var alumno4: Usuario = Usuario(null,null)
    // nombre = null
    // apellido = null
    // correo = null
    var alumno5: Usuario = Usuario()
    // nombre = null
    // apellido = null
    // correo = null
    var usuario6: Usuario = Usuario("Luis","Aguado",
        "luis@aguado.com")
    // nombre = Luis
    // apellido = Aguado
    // correo = luis@aguado.com
    var usuario7: Usuario = Usuario("Luis","Aguado",
        91222222)
    // nombre = Luis
    // apellido = Aguado
    // telefono = 91222222
    // correo = null
}