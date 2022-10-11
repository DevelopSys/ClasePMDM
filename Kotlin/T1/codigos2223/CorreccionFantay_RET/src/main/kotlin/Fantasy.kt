class Fantasy {

    lateinit var listaParticipante: ArrayList<Participante>;
    lateinit var listaFutbolistas: ArrayList<Jugador>;
    lateinit var listaPuntuaciones: ArrayList<Puntuacion>;

    init {
        listaFutbolistas = ArrayList();
        listaParticipante = ArrayList();
        anadirFutbolistas()
    }

    fun anadirFutbolistas(){
        listaFutbolistas.add(Jugador(1,"Marc-André ter Stegen", "Portero",3000000))
        listaFutbolistas.add(Jugador(2,"Ronald Araújo", "Defensa",4000000))
        listaFutbolistas.add(Jugador(3,"Eric García", "Defensa",1000000))
        listaFutbolistas.add(Jugador(4,"Pedri", "Mediocentro",5000000))
        listaFutbolistas.add(Jugador(5,"Robert Lewandowski", "Delantero",8000000))
        listaFutbolistas.add(Jugador(6,"Courtois", "Portero",3000000))
        listaFutbolistas.add(Jugador(7,"David Alaba", "Defensa",4000000))
        listaFutbolistas.add(Jugador(8,"Jesús Vallejo", "Defensa",500000))
        listaFutbolistas.add(Jugador(9,"Luka Modric", "Mediocentro",5000000))
        listaFutbolistas.add(Jugador(10,"Karim Benzema", "Delantero",8000000))
        listaFutbolistas.add(Jugador(11,"Ledesma", "Portero",500000))
        listaFutbolistas.add(Jugador(12,"Juan Cala", "Defensa",300000))
        listaFutbolistas.add(Jugador(13,"Zaldua", "Defensa",400000))
        listaFutbolistas.add(Jugador(14,"Alez Fernández", "Mediocentro",700000))
        listaFutbolistas.add(Jugador(15, "Choco Lozano", "Delantero", 800000))
        listaFutbolistas.add(Jugador(16,"Rajković", "Portero",300000))
        listaFutbolistas.add(Jugador(17,"Raíllo", "Defensa",200000))
        listaFutbolistas.add(Jugador(18,"Maffeo", "Defensa",300000))
        listaFutbolistas.add(Jugador(19,"Ruiz de Galarreta", "Mediocentro",400000))
        listaFutbolistas.add(Jugador(25,"Ángel", "Delantero", 300000))
        listaFutbolistas.add(Jugador(20,"Remiro", "Portero",1000000))
        listaFutbolistas.add(Jugador(21,"Elustondo", "Defensa",900000))
        listaFutbolistas.add(Jugador(22,"Zubeldia", "Defensa",800000))
        listaFutbolistas.add(Jugador(23,"Zubimendi", "Mediocentro",1000000))
        listaFutbolistas.add(Jugador(24,"Take Kubo", "Delantero", 800000))
    }
    fun getJugadoresCaros(){
        // lista
        this.listaFutbolistas.filter({it.valor>=3000000})
            .forEach({it.mostrarDatos()})
    }
    fun anadirParticipates(participante: Participante){
        this.listaParticipante.add(participante)
    }
    fun agregarTeclado(){
        var nombre: String = readLine() as String
        var id = readLine() as Int
        listaParticipante.add(Participante(id, nombre))
    }
    fun ficharJugador(participante: Participante,id: Int){
        var jugador = listaFutbolistas.find { it.id == id }
        participante.anadirJugador(jugador!!)
    }
    fun mostrarParticipates(){
        listaParticipante.forEach ({it.mostrarDatos()})
    }

    fun agregarPunctuaciones(){
// listaPuntuaciones primera jornada
        listaPuntuaciones = ArrayList();
        listaPuntuaciones.add(Puntuacion(1,"Marc-André ter Stegen", 10))
        listaPuntuaciones.add(Puntuacion(2,"Ronald Araújo",0))
        listaPuntuaciones.add(Puntuacion(3,"Eric García",3))
        listaPuntuaciones.add(Puntuacion(4,"Pedri",23))
        listaPuntuaciones.add(Puntuacion(5,"Robert Lewandowski",15))
        listaPuntuaciones.add(Puntuacion(6,"Courtois",1))
        listaPuntuaciones.add(Puntuacion(7,"David Alaba",5))
        listaPuntuaciones.add(Puntuacion(8,"Jesús Vallejo",10))
        listaPuntuaciones.add(Puntuacion(9,"Luka Modric",5))
        listaPuntuaciones.add(Puntuacion(10,"Karim Benzema",10))
        listaPuntuaciones.add(Puntuacion(11,"Ledesma",6))
        listaPuntuaciones.add(Puntuacion(12,"Juan Cala",3))
        listaPuntuaciones.add(Puntuacion(13,"Zaldua",6))
        listaPuntuaciones.add(Puntuacion(14,"Alez Fernández",9))
        listaPuntuaciones.add(Puntuacion(15, "Choco Lozano", 4))
        listaPuntuaciones.add(Puntuacion(16,"Rajković",3))
        listaPuntuaciones.add(Puntuacion(17,"Raíllo",6))
        listaPuntuaciones.add(Puntuacion(18,"Maffeo",0))
        listaPuntuaciones.add(Puntuacion(19,"Ruiz de Galarreta",7))
        listaPuntuaciones.add(Puntuacion(20,"Ángel", 4))
        listaPuntuaciones.add(Puntuacion(21,"Remiro",3))
        listaPuntuaciones.add(Puntuacion(22,"Elustondo",5))
        listaPuntuaciones.add(Puntuacion(23,"Zubeldia",6))
        listaPuntuaciones.add(Puntuacion(24,"Zubimendi",7))
        listaPuntuaciones.add(Puntuacion(25,"Take Kubo", 4))
// listaPuntuaciones segunda jornada
        listaPuntuaciones.add(Puntuacion(1,"Marc-André ter Stegen", 5))
        listaPuntuaciones.add(Puntuacion(2,"Ronald Araújo",5))
        listaPuntuaciones.add(Puntuacion(3,"Eric García",4))
        listaPuntuaciones.add(Puntuacion(4,"Pedri",10))
        listaPuntuaciones.add(Puntuacion(5,"Robert Lewandowski",10))
        listaPuntuaciones.add(Puntuacion(6,"Courtois",1))
        listaPuntuaciones.add(Puntuacion(7,"David Alaba",7))
        listaPuntuaciones.add(Puntuacion(8,"Jesús Vallejo",5))
        listaPuntuaciones.add(Puntuacion(9,"Luka Modric",15))
        listaPuntuaciones.add(Puntuacion(10,"Karim Benzema",0))
        listaPuntuaciones.add(Puntuacion(11,"Ledesma",9))
        listaPuntuaciones.add(Puntuacion(12,"Juan Cala",3))
        listaPuntuaciones.add(Puntuacion(13,"Zaldua",3))
        listaPuntuaciones.add(Puntuacion(14,"Alez Fernández",7))
        listaPuntuaciones.add(Puntuacion(15, "Choco Lozano", 2))
        listaPuntuaciones.add(Puntuacion(16,"Rajković",8))
        listaPuntuaciones.add(Puntuacion(17,"Raíllo",9))
        listaPuntuaciones.add(Puntuacion(18,"Maffeo",2))
        listaPuntuaciones.add(Puntuacion(19,"Ruiz de Galarreta",10))
        listaPuntuaciones.add(Puntuacion(20,"Ángel", 4))
        listaPuntuaciones.add(Puntuacion(21,"Remiro",5))
        listaPuntuaciones.add(Puntuacion(22,"Elustondo",8))
        listaPuntuaciones.add(Puntuacion(23,"Zubeldia",9))
        listaPuntuaciones.add(Puntuacion(24,"Zubimendi",11))
        listaPuntuaciones.add(Puntuacion(25,"Take Kubo", 10))




    }

    fun iniciarJuego(){
        agregarPunctuaciones()
        var participantesValidos = listaParticipante.filter ({ it.presupuesto>=0 && it.plantilla.size == 6})
        // recorro los participantes

        participantesValidos.forEach({participante: Participante ->
            // recorro la plantilla del jugador
            participante.plantilla.forEach({jugador: Jugador->
                listaPuntuaciones.forEach({puntuacion: Puntuacion ->
                    if (jugador.id == puntuacion.id){
                        participante.puntos += puntuacion.puntos;
                    }
                })
            })
        })

    }
}