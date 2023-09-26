import model.Usuario

fun main() {
    var usuario1 = Usuario(nombre = "Borja", apellido = "Martin");
    // usuario1.correo = "cos@correo.com"
    usuario1.mostrarDatos()
    var usuario2 = Usuario("Borja", "Martin", "asd","asd");
    var usuario3 = Usuario("Borja", "Martin", "asd","asd",123);
    //usuario3.mostrarDatos()

}