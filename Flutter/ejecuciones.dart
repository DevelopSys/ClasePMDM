import 'dart:io';

Future<String> realizaTarea() async {
  var resultado = await new Future(() => "Tarea realizada");
  return resultado;
}

main() async {
  Jefe jefe = new Jefe(123, "Borja", "Martin", "1234A", 30);
  Accionista accionista = new Accionista(123, "Borja", "Martin", "1234A", 200);
  Operario operario =
      new Operario(123, "Junior", "Luis", "Gómez", "1234A", 30000, 12);

  accionista.emitirVoto(10);
  accionista
      .lanzarComunicado("Este es un comunicado lanzado por un accionista");

  jefe.lanzarComunicado("Este es un comunicado lanzado por el jefe");
  jefe.realizarEntrevista(operario);
  jefe.ejecutarCierre();

  operario.calculoSalario();
  operario.calculoRetenciones();
  operario.ejecutarCierre();

  //print(await realizaTarea());
  //Trabajador trabajador = new Trabajador(1111, "Borja", "Martin", "123");
  //trabajador.mostrarDatos();
  /* var usuario = Usuario(nombre: "Borja", apellido: "Martin", dni: "123123");
  var usuario2 = Usuario.sinDni("Borja", "Martin");
  usuario.mostrarDatos();
  usuario2.mostrarDatos(); */
  /*   print("iniciada tarea");

  print("inicio de registro de usuarios");
  registrarUsuario(new Usuario.sinDni("nombre", "apellido"))
      .then((value) => {print(value)})
      .catchError((onError) => {print("Error")});

  new Future(() => "Resultado de la tarea").then((value) => print(value)); */
}

Future<String> registrarUsuario(Persona usuario) {
  return Future.delayed(new Duration(seconds: 4),
      () => "Usuario ${usuario.nombre} registrado correctamente");
}

abstract class Persona {
  var dni;
  var nombre;
  var apellido;

  Persona({this.nombre, this.apellido, this.dni});
  Persona.sinApellido(this.nombre, this.dni);
  Persona.sinDni(this.nombre, this.apellido);

  void mostrarDatos() {
    print("Nombre: $nombre");

    if (this.apellido.length > 0) print("Apellido: $apellido");
    if (this.dni.toString().length > 0) print("DNI: $dni");
  }
}

abstract class Trabajador extends Persona {
  var NSS;
  var escala;
  var retenciones;
  Trabajador(this.NSS, this.escala, String nombre, String apellido, String dni)
      : super(nombre: nombre, apellido: apellido, dni: dni);

  @override
  void mostrarDatos() {
    super.mostrarDatos();
    print("NSS: $NSS");
    print("NSS: $escala");
    print("NSS: $retenciones");
  }

  void calculoRetenciones() {
    switch (escala) {
      case 'A':
        escala = 0.2;
        break;
      case 'B':
        escala = 0.3;
        break;
      case 'C':
        escala = 0.4;
        break;
      default:
        escala = 0.1;
    }
  }
}

abstract class Directivo extends Persona {
  var puesto;

  Directivo(this.puesto, String nombre, String apellido, String dni)
      : super(nombre: nombre, apellido: apellido, dni: dni);

  @override
  void mostrarDatos() {
    super.mostrarDatos();
    print("Puesto: $puesto");
  }

  void lanzarComunicado(String comunicado) {
    print("Estimados trabajadores se comunica que \n$comunicado");
  }
}

class Operario extends Trabajador with Cierre {
  var salario;
  var pagas;

  Operario(super.NSS, super.escala, super.nombre, super.apellido, super.dni,
      this.salario, this.pagas);

  @override
  void mostrarDatos() {
    super.mostrarDatos();
    print("Salario: $salario");
    print("Pagas: $salario");
  }

  void calculoSalario() {
    double salarioMes = salario / pagas;
    print("El salario mensual es: $salarioMes");
  }
}

class Jefe extends Directivo with Cierre {
  var participaciones;

  Jefe(
      super.NSS, super.nombre, super.apellido, super.dni, this.participaciones);

  @override
  void mostrarDatos() {
    super.mostrarDatos();
    print("Participaciones: $participaciones");
  }

  void realizarEntrevista(Trabajador trabajador) {
    print("Proceso de entrevista al trabajador ${trabajador.nombre} realizado");
  }
}

class Accionista extends Directivo {
  var acciones;

  Accionista(super.NSS, super.nombre, super.apellido, super.dni, this.acciones);

  @override
  void mostrarDatos() {
    super.mostrarDatos();
    print("Acciones: $acciones");
  }

  void emitirVoto(int valoracion) {
    print("Se procede al voto con unas participaciones de $acciones");
    print("Voto emitido: $valoracion");
  }
}

class Cierre {
  void ejecutarCierre() {
    print("Se procede a ejecutar el cierre del ejercicio");
  }
}
