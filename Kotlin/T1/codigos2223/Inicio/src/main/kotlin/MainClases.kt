fun main() {

    /*var coche1 = Coche("Mercedes", "C220",100);
    var coche2: Coche = Coche("Mercedes", "C220",100,"1234A");
    //Thread.sleep(1000)
    coche1.aumentarVelocidad(100);
    coche1.disminucionVelocidad(50)
    coche1.setVelocidad(100)
    var propietario: Propietario = Propietario("Borja","Martin","123A");
    println(propietario.nombre)*/

    var coche: Coche = Coche("Mercedes", "C220");
    var coche1: Coche = Coche("Ford", "Fiesta");
    coche.cv = 200;
/*coche.asignarPropietarios(Propietario("B","M","123A"))
    println(coche.propietario)*/

    var listaCoches = ArrayList<Coche>();
    listaCoches.add(coche1)
    listaCoches.add(coche)

    listaCoches.forEach({
        if (it.cv!! > 100) {
            //it.calcularPar({},10)
        } else {
            //it.calcularPar()
        }
    })

    coche.calcularPar({ item -> (coche.cv!! * 2) / item }, 100);
    coche.calcularPar({ item -> coche.cv!! / item }, 50);

    coche.funcionSinDefinir = {}

}