package model

class Directivo(dni: String, nombre: String, apellido: String) :
    Accionista, Persona(dni, nombre, apellido) {
    override fun emitirVotacion(voto: Int): Double {
        println("Registrando voto del directivo por valor de $voto")
        return voto * 0.75;
    }
}