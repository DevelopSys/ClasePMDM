fun main() {

    var liga = Fantasy();

    var equipo1 = Participante(1, "equipo1")
    var equipo2 = Participante(2, "equipo1")
    var equipo3 = Participante(3, "equipo1")
    var equipo4 = Participante(4, "equipo1")

    liga.anadirParticipates(equipo1)
    liga.anadirParticipates(equipo2)
    liga.anadirParticipates(equipo3)
    liga.anadirParticipates(equipo4)

    liga.ficharJugador(equipo1, 1)
    liga.ficharJugador(equipo1, 2)
    liga.ficharJugador(equipo1, 3)
    liga.ficharJugador(equipo1, 4)
    liga.ficharJugador(equipo1, 5)
    liga.ficharJugador(equipo1, 6)

    liga.ficharJugador(equipo2, 1)
    liga.ficharJugador(equipo2, 2)
    liga.ficharJugador(equipo2, 3)
    liga.ficharJugador(equipo2, 4)
    liga.ficharJugador(equipo2, 5)
    liga.ficharJugador(equipo2, 6)

    liga.ficharJugador(equipo3, 1)
    liga.ficharJugador(equipo3, 2)
    liga.ficharJugador(equipo3, 3)
    liga.ficharJugador(equipo3, 4)
    liga.ficharJugador(equipo3, 5)
    liga.ficharJugador(equipo3, 6)
    liga.ficharJugador(equipo3, 7)
    liga.ficharJugador(equipo3, 8)
    liga.ficharJugador(equipo3, 9)

    liga.ficharJugador(equipo4, 1)
    liga.ficharJugador(equipo4, 2)
    liga.ficharJugador(equipo4, 3)
    liga.ficharJugador(equipo4, 4)
    liga.ficharJugador(equipo4, 5)

    liga.mostrarParticipates()


}