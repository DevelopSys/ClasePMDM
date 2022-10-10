class Fantasy {

    lateinit var listaParticipante: ArrayList<Participante>;
    lateinit var listaFutbolistas: ArrayList<Jugador>;

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

    fun iniciarJuego(){
        listaParticipante.filter ({ it.presupuesto>=0 && it.plantilla.size == 6})
    }
}