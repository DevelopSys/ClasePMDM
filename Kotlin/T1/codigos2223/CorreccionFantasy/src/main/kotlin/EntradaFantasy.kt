fun main() {

    var liga: Fantasy = Fantasy();

    var participante1 = Participante(1,"Equipo1")
    var participante2 = Participante(2,"Equipo2")
    var participante3 = Participante(3,"Equipo3")
    var participante4 = Participante(4,"Equipo4")

    liga.agregarParticipante(participante1)
    liga.agregarParticipante(participante2)
    liga.agregarParticipante(participante3)
    liga.agregarParticipante(participante4)

    liga.realizarFichaje(liga.getListaParticipantes().get(0),1);
    liga.realizarFichaje(liga.getListaParticipantes().get(0),2);
    liga.realizarFichaje(liga.getListaParticipantes().get(0),3);
    liga.realizarFichaje(liga.getListaParticipantes().get(0),4);
    liga.realizarFichaje(liga.getListaParticipantes().get(0),5);
    liga.realizarFichaje(liga.getListaParticipantes().get(0),6);

    liga.realizarFichaje(liga.getListaParticipantes().get(1),1);
    liga.realizarFichaje(liga.getListaParticipantes().get(1),2);
    liga.realizarFichaje(liga.getListaParticipantes().get(1),3);
    liga.realizarFichaje(liga.getListaParticipantes().get(1),4);
    liga.realizarFichaje(liga.getListaParticipantes().get(1),5);
    liga.realizarFichaje(liga.getListaParticipantes().get(1),6);

    liga.realizarFichaje(liga.getListaParticipantes().get(2),1);
    liga.realizarFichaje(liga.getListaParticipantes().get(2),2);
    liga.realizarFichaje(liga.getListaParticipantes().get(2),3);
    liga.realizarFichaje(liga.getListaParticipantes().get(2),4);
    liga.realizarFichaje(liga.getListaParticipantes().get(2),5);
    liga.realizarFichaje(liga.getListaParticipantes().get(2),6);

    liga.realizarFichaje(liga.getListaParticipantes().get(3),1);
    liga.realizarFichaje(liga.getListaParticipantes().get(3),2);
    liga.realizarFichaje(liga.getListaParticipantes().get(3),3);
    liga.realizarFichaje(liga.getListaParticipantes().get(3),4);
    liga.realizarFichaje(liga.getListaParticipantes().get(3),5);

    liga.mostrarParticipantes()
    var admin = Administrador(5, "Admin",1234);

    //liga.mostrarJugadoresCaros()

    liga.iniciarJuego(admin)

    liga.mostrarParticipantes()




}