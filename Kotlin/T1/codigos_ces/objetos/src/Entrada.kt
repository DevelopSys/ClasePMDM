import controller.Colegio
import model.Usuario
import model.UsuarioFP
import model.UsuarioMaster

fun main() {

    /*var usuario1: Usuario = Usuario("Borja", "Martin")
    var usuario2: Usuario = Usuario(nombre = "Borja", apellido = "Martin")
    var usuario3: Usuario = Usuario(nombre = null, apellido = null)
    var usuario4: Usuario = Usuario()
    var usuario5: Usuario = Usuario(apellido = "Lopez")
    var usuario6: Usuario = Usuario(nombre = "Juan")
    var usuario7: Usuario = Usuario("Juan", "Gomez", "juan@gmail.com")
    var usuario9: Usuario = Usuario("Juan", "Gomez", "juan@gmail.com")
    var usuario8: Usuario = Usuario(nombre = null, apellido = null, correo = "juan@gmail.com")*/

    val usuarios: ArrayList<Usuario> = ArrayList()
    // add
    // usuarios.addAll(usuario1,usuario2)
    /*usuarios.add(usuario1)
    usuario2.desmatricular()
    usuarios.add(usuario2)
    usuarios.add(usuario3)
    usuario4.desmatricular()
    usuarios.add(usuario4)
    usuarios.add(usuario5)
    usuarios.add(usuario6)
    usuario7.desmatricular()
    usuarios.add(usuario7)
    usuarios.add(usuario8)
    usuarios.add(usuario9)
    //  get
    val usuario = usuarios[1]
    // remove
    usuarios.removeAt(1)
    // set
    usuarios[0].nombre = "Nombre nuevo"*/
    // recorrer
    /*usuarios.forEach { it.mostrarDatos() }
    usuarios.forEachIndexed { index, usuario ->
        println("En la posicion $index")
        usuario.mostrarDatos()
    }
    for (i in usuarios){
        i.mostrarDatos()
    }
    for(i in 0..usuarios.size-1){
        usuarios[i].mostrarDatos()
    }*/
    // busquedas
    /*var listaDesmatriculados = ArrayList<Usuario>()
    usuarios.forEach {
        if (!it.matriculado){
            listaDesmatriculados.add(it)
        }
    }*/
    /*val listaDesmatriculados: ArrayList<Usuario> =
        usuarios.filter { !it.matriculado } as ArrayList

    // usuarios.filter { !it.matriculado }.forEach { it.mostrarDatos() }
    var usuarioUnico: Usuario? = usuarios.find { it.matriculado }*/
    var usuarioMaster = UsuarioMaster(
        "Borja", "Martin", "correo@gmail.com",
        1, "BigData"
    )

    var usuarioFP = UsuarioFP(
        "Borja", "Martin", "correo@gmail.com",
        "nueva"
    )

    //var usuario10 = Usuario()
    usuarioFP.asignarEmpresa()
    usuarioFP.mostrarDatos()
    // val colegio = Colegio() // CIF -> null
    // colegio.CIF = "asdasd";


}