package model

class UsuarioFP(
    nombre: String,
    apellido: String,
    correo: String,
    val ley: String,
) : Usuario(nombre, apellido, correo) {
    var fcts: Boolean

    init {
        fcts = false;
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Ley: $ley")
        println("FCTS: $fcts")
    }

    override fun imprimirExpediente() {

        println("Imprimiento expediente fp")
        when(ley){
            "nueva"->{
                println("******FP NUEVA ********")
                this.mostrarDatos()
            }
            "antigua"->{
                println("******$ley********")
                this.mostrarDatos()
            }
        }


    }

    fun asignarEmpresa() {
        this.fcts = true;
    }

    fun cancelarEmpresa() {
        this.fcts = false;
    }
}