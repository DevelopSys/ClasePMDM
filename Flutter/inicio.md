# tipos de datos

- Numéricos: int y double
- Booleanos
- String
- Dinámicos: dynamic, Object

# variables

- const: inicializado en compilación
- final: inicializado en ejecución

# operadores nulos

- ?: se indica que el valor de la variable indicada puede contener un nulo
- ??: se indica el valor que tendrá la variable en el caso de que sea nula

# Listas

## Listas dinámicoas

El tipo es List y se puede inicializar mediante []. En el caso de querer manipular datos, se utilizan los siguientes métodos:
- add
- removeAt
- remove

En el caso de querer recorrer una lista se puede hacer bien por un foreach o bien por un for tradicional 

```dart
  for(var i=0; i<nombres.length;i++){
    print('Posición $i => valor ${nombres[i]}');
  }
```

Tambien es posible utilizar el operador iterator

```dart
  var iter = nombres.iterator;
  while(iter.moveNext()){
    print('El elemento de la lista: ${iter.current}');
  }
```

## Maps

El tipo correspondiente es Map y se puede incializar mediante {}. Se trata de un conjunto de datos que guarda un par clave - valor.

```dart
 Map<String,dynamic> usuario = {
    'nombre' : 'Borja',
    'apellidp' : "Herrera",
    'edad' : 28,
    'departamento' : "informática"
  };
```

En el caso de querer acceder a los valores asignados a una key, se realiza mediante la posición

```dart
print(usuario['nombre']) // Borja
```

Los mapas son dinámicos, por lo que se pueden agregar elementos sobre la variable. Para ello se utiliza el método addAll

```dart
usuario.addAll({'saladio' : 1500, 'puesto' : 'programadro'}); // Añadimos dos entradas
```

En el caso de querer recorrer todos los elementos de un mapa se utilizan los métodos value y entries


```dart
diccionarioUsuarios.keys.forEach((element)=>print(element));
diccionarioUsuarios.keys.forEach((element)=>print(element));
```

# Funciones

Las funciones representan el las parte de código reutilizables que son ejecutadas con la llamada de la misma. Para poder definir una funcion se utiliza la siguiente sintáxis:

```dart
void nombreFuncion(){
  
}
```

Donde void es el tipo de retorno que tendrá. Del mismo modo, las funciones pueden adminitr parámetos los cuales pueden ser llamados de muy diferentes formas

- Parámetros normales

```dart
void main() {
  
    registrarUsuario("Borja", "Informática")
 
}

void registrarUsuario(nombre, departamento){
  print('El usuario con nombre $nombre, ha quedado registrado en el departamento $departamento');
}
```

- Parámetros optativos

```dart

void registrarUsuario(nombre, departamento, [salario=0]){
  print('El usuario con nombre $nombre, ha quedado registrado en el departamento $departamento');
  if (salario!=0){
    print('Con un salario asignado de $salario');
  }
}
```

En ambos casos los parámetros se pueden tipar, para así forzar al compilador a que se asigna un valor de tipo concreto

- Parámetros nominales

En vez de pasar los parámetros por posicion, se pueden pasar mediante nombres. En este caso se engloban entre {}

```dart
oid main() {
  
    registrarUsuario(nombre: "Borja",departamento: "Informática", salario: 100);
 
}

void registrarUsuario({required nombre, required departamento, salario}){
  print('El usuario con nombre $nombre, ha quedado registrado en el departamento $departamento');
  if (salario!=0){
    print('Con un salario asignado de $salario');
  }
}
```

# Clases

A la hora de trabajar con clases, como todo lenguaje programado a objetos, una clase representa el molde de un tipo. Para crear una clase

```dart
class Usuario{
  
  var nombre;
  var apellido;
  var edad;
  
}
```

Para poder utilizar un objeto de forma correcta, es necesario utilizar un constructor. Hay varios tipos de constructores:

- Constructor de clase

```dart
void main() {
  
  var usuario = new Usuario("Borja", "Martin", 39);
  
  print(usuario.nombre);
 
}

class Usuario{
  
  String nombre;
  String apellido;
  int edad;
  int? salario
  
  Usuario(this.nombre, this.apellido, this.edad);
  Usuario.fromName(String nombre, String apellido, int edad , int salario): this.nombre = nombre
  
}
```

- Constructores con nombre:

```dart
void main() {
  
  var usuario1 = new Usuario("Borja", "Martin", 39);
  var usuario2 = Usuario.fromParametros("Borja", "Martin", 39, 30000);
  
  print(usuario1.nombre);
  print(usuario2.salario);
 
}

class Usuario{
  
  String nombre;
  String apellido;
  int edad;
  int? salario;
  
  Usuario(this.nombre, this.apellido, this.edad);
  Usuario.fromParametros(String nombre, String apellido, int edad, int salario):
  this.nombre = nombre, this.apellido = apellido, this.edad = edad, this.salario = salario;
  
}

```


Uno de los métodos más importantes y utilizados dentro de las clases son los getter y setter. Estos métodos proveen de acceso y modificacion de las variables de las clase, los cuales pueden ser privados (colocando un _ antes de la definción de la variable). En el caso de querer accederlas, es necesario utilizar los métodos getter y setter, los cuales se acceden como si fuesen una variabe, aunque son métodos

```dart

void main() {
  
  var usuario1 = new Usuario("Borja", "Martin", 39);
  var usuario2 = Usuario.fromParametros("Borja", "Martin", 39, 30000);

  usuario1.nombre = "ejemplo";
  print(usuario1.nombre);
  
 
}

class Usuario{
  
  String _nombre;
  String _apellido;
  int _edad;
  int? _salario;
  
  Usuario(this._nombre, this._apellido, this._edad);
  Usuario.fromParametros(String nombre, String apellido, int edad, int salario):
  this._nombre = nombre, this._apellido = apellido, this._edad = edad, this._salario = salario;
  

  void set nombre(String nombre){
    this._nombre = nombre;
  }
  
  String get nombre{
    return this._nombre;
  }

}
```

# Herencia 

Para poder trabajar con la herencia, se utiliza la palabra reservada extends

```dart
class Trabajador{
  
  String dni;
  String nss;
  
  Trabajador(this.dni, this.nss);
  
  void mostrarDatos(){
    print("DNI: $dni");
    print("NSS: $nss");
  }
}

class Usuario extends Trabajador{
  
  String _nombre;
  String _apellido;
  int _edad;
  int? _salario;
  
  Usuario(String nss, String dni ,this._nombre,this._apellido, this._edad) : super(dni, nss);
  Usuario.fromParametros(String nss, String dni, String nombre, String apellido, int edad, int salario): this._nombre = nombre, this._apellido = apellido, this._edad = edad, this._salario = salario, super(dni,nss);
  

  void set nombre(String nombre){
    this._nombre = nombre;
  }
  
  String get nombre{
    return this._nombre;
  }

    @override
  void mostrarDatos(){
    super.mostrarDatos();
  print("DNI $dni");
      
  }

}
```

