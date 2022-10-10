class Jugador(id: Int, nombre: String, private var posicion: String, private var valor: Int) : Persona(id, nombre) {

    var puntuacion:Int=0

    constructor(id: Int, nombre: String, puntuacion: Int): this(id,nombre,"",0){
        this.puntuacion = puntuacion;
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Posicion: $posicion")
        println("Valor: $valor")
    }

    fun getValor(): Int{
        return this.valor
    }

    fun getPosicion(): String{
        return this.posicion
    }

}