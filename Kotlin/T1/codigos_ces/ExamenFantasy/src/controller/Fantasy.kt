package controller

import model.Jugador
import model.Participanta

class Fantasy() {

    var participantes: ArrayList<Participanta> = arrayListOf()
    var jugadores: ArrayList<Jugador> = arrayListOf()
    var ganador: Participanta? = null
    var puntuaciones: ArrayList<Jugador> = arrayListOf()

    fun inicializaJugadores() {
        jugadores.add(Jugador(1, "Marc-André ter Stegen", "Portero", 3000000))
        jugadores.add(Jugador(2, "Ronald Araújo", "Defensa", 4000000))
        jugadores.add(Jugador(3, "Eric García", "Defensa", 1000000))
        jugadores.add(Jugador(4, "Pedri", "Mediocentro", 5000000))
        jugadores.add(Jugador(5, "Robert Lewandowski", "Delantero", 8000000))
        jugadores.add(Jugador(6, "Courtois", "Portero", 3000000))
        jugadores.add(Jugador(7, "David Alaba", "Defensa", 4000000))
        jugadores.add(Jugador(8, "Jesús Vallejo", "Defensa", 500000))
        jugadores.add(Jugador(9, "Luka Modric", "Mediocentro", 5000000))
        jugadores.add(Jugador(10, "Karim Benzema", "Delantero", 8000000))
        jugadores.add(Jugador(11, "Ledesma", "Portero", 500000))
        jugadores.add(Jugador(12, "Juan Cala", "Defensa", 300000))
        jugadores.add(Jugador(13, "Zaldua", "Defensa", 400000))
        jugadores.add(Jugador(14, "Alez Fernández", "Mediocentro", 700000))
        jugadores.add(Jugador(15, "Choco Lozano", "Delantero", 800000))
        jugadores.add(Jugador(16, "Rajković", "Portero", 300000))
        jugadores.add(Jugador(17, "Raíllo", "Defensa", 200000))
        jugadores.add(Jugador(18, "Maffeo", "Defensa", 300000))
        jugadores.add(Jugador(19, "Ruiz de Galarreta", "Mediocentro", 400000))
        jugadores.add(Jugador(25, "Ángel", "Delantero", 300000))
        jugadores.add(Jugador(20, "Remiro", "Portero", 1000000))
        jugadores.add(Jugador(21, "Elustondo", "Defensa", 900000))
        jugadores.add(Jugador(22, "Zubeldia", "Defensa", 800000))
        jugadores.add(Jugador(23, "Zubimendi", "Mediocentro", 1000000))
        jugadores.add(Jugador(24, "Take Kubo", "Delantero", 800000))


    }

    fun inicializarPuntos() {
        puntuaciones.add(Jugador(1, "Marc-André ter Stegen", puntos = 10))
        puntuaciones.add(Jugador(2, "Ronald Araújo", puntos = 0))
        puntuaciones.add(Jugador(3, "Eric García", puntos = 3))
        puntuaciones.add(Jugador(4, "Pedri", puntos = 23))
        puntuaciones.add(Jugador(5, "Robert Lewandowski", puntos = 15))
        puntuaciones.add(Jugador(6, "Courtois", puntos = 1))
        puntuaciones.add(Jugador(7, "David Alaba", puntos = 5))
        puntuaciones.add(Jugador(8, "Jesús Vallejo", puntos = 10))
        puntuaciones.add(Jugador(9, "Luka Modric", puntos = 5))
        puntuaciones.add(Jugador(10, "Karim Benzema", puntos = 10))
        puntuaciones.add(Jugador(11, "Ledesma", puntos = 6))
        puntuaciones.add(Jugador(12, "Juan Cala", puntos = 3))
        puntuaciones.add(Jugador(13, "Zaldua", puntos = 6))
        puntuaciones.add(Jugador(14, "Alez Fernández", puntos = 9))
        puntuaciones.add(Jugador(15, "Choco Lozano", puntos = 4))
        puntuaciones.add(Jugador(16, "Rajković", puntos = 3))
        puntuaciones.add(Jugador(17, "Raíllo", puntos = 6))
        puntuaciones.add(Jugador(18, "Maffeo", puntos = 0))
        puntuaciones.add(Jugador(19, "Ruiz de Galarreta", puntos = 7))
        puntuaciones.add(Jugador(25, "Ángel", puntos = 4))
        puntuaciones.add(Jugador(20, "Remiro", puntos = 3))
        puntuaciones.add(Jugador(21, "Elustondo", puntos = 5))
        puntuaciones.add(Jugador(22, "Zubeldia", puntos = 6))
        puntuaciones.add(Jugador(23, "Zubimendi", puntos = 7))
        puntuaciones.add(Jugador(24, "Take Kubo", puntos = 4))


    }

    fun anadirParticipante(participante: Participanta) {
        participantes.add(participante)
    }

    fun ficharJugador(idParticipante: Int, idJugador: Int) {

        var participanteEncontra: Participanta? = participantes
            .find { return@find it.id == idParticipante }

        var jugadorEncontrado: Jugador? = jugadores
            .find { return@find it.id == idJugador }

        if (participanteEncontra != null && jugadorEncontrado != null) {
            if (participanteEncontra.presupuesto > jugadorEncontrado.valor!!) {
                participanteEncontra.plantilla.add(jugadorEncontrado)
            }
        }
    }

    fun validarParticipante(): ArrayList<Participanta> {
        // presupuesto>=0
        // 2 defensas
        // 2 medios
        // 1 delantero
        // 1 portero

        var participantesValidos = arrayListOf<Participanta>()

        participantes.forEach {
            var nDefensas = 0
            var nPorteror = 0
            var nMedios = 0
            var nDelanteros = 0
            it.plantilla.forEach {
                if (it.posicion == "Portero")
                    nPorteror++
                if (it.posicion == "Defensa")
                    nDefensas++
                if (it.posicion == "Medio")
                    nMedios++
                if (it.posicion == "Delantero")
                    nDelanteros++
            }

            if (nPorteror == 1 && nDelanteros == 1 && nMedios == 2 && nDefensas == 2 && it.presupuesto > 0) {
                participantesValidos.add(it)
            }
        }
        return participantesValidos
    }

    fun iniciarConteo() {
        
        validarParticipante().forEach {
            it.plantilla.forEach { jugador ->
                it.puntos += puntuaciones.find { jugadorPuntuacion -> jugadorPuntuacion.nombre == jugador.nombre }?.puntos
                    ?: 0
            }
        }
    }

    fun obtenerGanador(){
        participantes.sort { p1,p2->  return@sort 1 }
    }

    fun obtenerJugadoresCaros() {
        jugadores.filter {
            return@filter it.valor!! > 3000000
        }.forEach {
            it.mostrarDatos()
        }
    }
}