class Administrador(id: Int, nombre: String,private var clave: Int) : Persona(id,nombre) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Clave: $clave")
    }

    fun setClave(clave: Int){
        this.clave = clave;
    }

    fun getClave(): Int{
        return this.clave
    }

}