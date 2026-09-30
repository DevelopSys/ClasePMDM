class Controller {

    var personas: ArrayList<Persona> = arrayListOf()

    fun addPerson(x: Persona): Unit {
        this.personas.add(x)
    }
}