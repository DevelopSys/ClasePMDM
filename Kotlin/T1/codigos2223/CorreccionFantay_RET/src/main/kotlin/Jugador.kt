class Jugador(id: Int, nombre: String, var posicion: String, var valor: Int)
    : Persona(id,nombre) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        print("Posición: $posicion")
        print("Valor: $valor")
    }
}