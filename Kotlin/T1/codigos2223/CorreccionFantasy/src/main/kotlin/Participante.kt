class Participante(id: Int, nombre: String) : Persona(id, nombre) {

    var plantilla: ArrayList<Jugador>;
    var puntos: Int = 0;
    var presupuesto: Int = 10000000

    init {
        plantilla = ArrayList();
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Presupuesto: $presupuesto")
        println("Puntos: $puntos")
        println("Plantilla: ")
        plantilla.forEach { it.mostrarDatos() }
    }

    fun anadirJugador(jugador: Jugador){
        // validarFichaje

        println("Proceso iniciado")
        when(jugador.getPosicion()){
            "Portero" ->{
                if (validarFicha(jugador.getPosicion())<1){
                    this.plantilla.add(jugador)
                    this.presupuesto -= jugador.getValor()
                }
                else{
                    println("Ya tienes un portero, fichaje no valido")
                }
            }
            "Defensa"->{
                if (validarFicha(jugador.getPosicion())<2){
                    this.plantilla.add(jugador)
                    this.presupuesto -= jugador.getValor()
                } else {
                    println("Ya tienes dos defensas, fichaje no valido")
                }
            }
            "Medio"->{
                if (validarFicha(jugador.getPosicion())<2){
                    this.plantilla.add(jugador)
                    this.presupuesto -= jugador.getValor()
                } else{
                    println("Ya tienes dos medios, fichaje no valido")
                }
            }
            "Delantero"->{
                if (validarFicha(jugador.getPosicion())<1){
                    this.plantilla.add(jugador)
                    this.presupuesto -= jugador.getValor()
                } else {
                    println("Ya tienes un delantero, fichaje no valido")
                }
            }
        }

    }

    fun validarFicha(posicion: String): Int{

        if (posicion.equals("Medio") || posicion.equals("Defensa")){
            // dos posibilidades de df o md
            if (posicion == "medio"){
                return plantilla.filter({ it.equals("Medio")}).size
            } else{
                return plantilla.filter({ it.equals("Defensa")}).size
            }

        } else{
            // una posibilidad de pt o dl
            if (posicion.equals("Portero")){
                return plantilla.filter({ it.equals("Portero")}).size
            } else{
                return plantilla.filter({ it.equals("Delantero")}).size
            }
        }
    }

}