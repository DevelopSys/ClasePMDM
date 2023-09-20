import model.Usuario
import model.UsuarioExtendido

fun main() {
    var usuario: Usuario = Usuario("Borja","Martin","123123");
    var usuario1: Usuario = Usuario("Borja","Martin");
    var usuario2: UsuarioExtendido = UsuarioExtendido("Borja","Martin","123",123,123);


    usuario2.mostrarDatos()


}