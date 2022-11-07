class Trabajador(nombre: String, apellido: String, edad: Int, var nss: Int) : Persona(nombre, apellido, edad),
    Directivo {

    // nombre, apellido, edad, nss
    lateinit var trabajoExtra: String;
    var ejemplo: String = "ejemplo"

    var funcionMostarDatos = {parametroUno: Int, parametroDos: String ->
        {
            println("$parametroUno y $parametroDos")
        }
    }

    fun mostraDatosLambda(param1: Int, param2: String){
        println("$param1 y $param2")
    }

    override fun metodoAbs() {
        println("El numero de la ss del usuario es $nss")
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("NSS: $nss")
    }


    override fun funcionUno() {
        this.trabajoExtra = "Trabajo extra definido"
    }

    override fun funcionDos() {
        TODO("Not yet implemented")
    }

    override fun funcionTre() {
        TODO("Not yet implemented")
    }


}