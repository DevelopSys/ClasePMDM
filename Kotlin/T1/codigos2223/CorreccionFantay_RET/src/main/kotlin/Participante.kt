class Participante(id: Int, nombre: String) : Persona(id, nombre) {

    lateinit var plantilla: ArrayList<Jugador>
    var puntos: Int = 0;
    var presupuesto: Int = 10000000

    init {
        plantilla = ArrayList();
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Puntos: $puntos")
        println("Presupuesto: $presupuesto")
        println("Plantilla: ")
        plantilla.forEach ({ jugador: Jugador -> jugador.mostrarDatos() } )
    }

    fun anadirJugador(jugador: Jugador){
        // hay que verificar
        if ((jugador.posicion == "Portero" || jugador.posicion == "Delantero")
            && verificarJugador(jugador.posicion)<1){
            plantilla.add(jugador)
            presupuesto -= jugador.valor
        } else if ((jugador.posicion == "Mediocentro" || jugador.posicion == "Defensa")
            && verificarJugador(jugador.posicion)<2){
            plantilla.add(jugador)
            presupuesto -= jugador.valor
        }
    }

    fun verificarJugador(posicion: String): Int{

        if (posicion=="Portero"){
            return plantilla.filter ({ it.posicion == "Portero" }).size;
        } else if(posicion=="Defensa"){
            return plantilla.filter ({ it.posicion == "Defensa" }).size;
        } else if(posicion=="Mediocentro"){
            return plantilla.filter ({ it.posicion == "Mediocentro" }).size;
        } else if(posicion=="Delantero"){
            return plantilla.filter ({ it.posicion == "Delantero" }).size;
        }

        return 0;
    }

}