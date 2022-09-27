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
    coche.comunicacionVelocidad = { valor ->
        println("Definido en el mail")
        println("Pero ejecutado en la clase coche")
        println(valor)
    }
    coche.aumentarVelocidad(7)
    var coche1: Coche = Coche("Ford", "Fiesta");
    /*coche.cv = 200;
    // crear una variable nombre y apellido del propietario del coche -> coche
    coche.asignarPropietarios(Propietario("B", "M", "123A"))
    //var (marcaC, modeloC) = coche;
    var (nombreP, apellidoP,_) = coche.propietario
    println(nombreP)*/


    /*var listaCoches = ArrayList<Coche>();
    listaCoches.add(coche1)
    listaCoches.add(coche)

    /*listaCoches.forEach({
        if (it.cv!! > 100) {
            //it.calcularPar({},10)
        } else {
            //it.calcularPar()
        }
    })*/

    coche.calcularPar({ item -> (coche.cv!! * 2) / item }, 100);
    coche.calcularPar({ item -> coche.cv!! / item }, 50);


    var propietario = Propietario("Borja", "Martin","001A")
    var (nombrePro, _, dniProp) = propietario
    println(nombrePro)
    println(dniProp)*/
}