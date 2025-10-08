import controller.Fantasy
import model.Administrador
import model.Participanta

fun main() {

    var admin= Administrador(1,"Borja",1234)
    var participante1 = Participanta(1,"P1")
    var participante2 = Participanta(2,"P2")
    var participante3 = Participanta(3,"P3")
    var participante4 = Participanta(4,"P4")
    var participante5 = Participanta(5,"P5")
    var fantasy = Fantasy()
    fantasy.anadirParticipante(participante1)
    fantasy.anadirParticipante(participante2)
    fantasy.anadirParticipante(participante3)
    fantasy.anadirParticipante(participante4)
    fantasy.anadirParticipante(participante5)

    fantasy.ficharJugador(1,4)
    fantasy.ficharJugador(1,2)
    fantasy.ficharJugador(1,1)
    fantasy.ficharJugador(1,5)

    admin.iniciarLiga(1234,fantasy)

}