# Conceptos básicos

Alguno de los conceptos básicos de kotlin y que los diferencia con java son:

- Los ficheros tienen una extension de .kt
- Las clases por defecto son privadas, a no ser que se declaren como `open`
- No existe el conepto de static
- El nombre del fichero no tiene porque coincidir con el nombre de la clase.
- Un fichero puede contener una o varias clases
- Un fichero puede contener variables y funciones (únicamente)

Los tipos de modificadores de visibilidad son:

- private
- protected
- internal
- public (por defecto)

## Efecto de modificadores de visibilidad a nivel de **paquete**

Hay 4 elementos que se pueden definir a nivel de paquete: propiedades, funciones, clases y objetos. Asi les afectan los modificadores de visibilidad en este nivel:

- public: visible de manera global, desde cualquier elemento del programa
- internal: visible para los elementos del mismo paquete.
- private: visible solo en el mismo fichero y/o clase.
- protected: visible para las subclases

# Variables

**Documentación oficial:** https://kotlinlang.org/docs/reference/basic-syntax.html#defining-local-variables

Para poder definir variables en kotlin se utiliza el nombre: tipo = valor

```java
var numero: Int = 0;
```

En muchas ocasiones el tipo se puede obviar, ya que el compilador otorgará el tipo más adecuado.

En cuanto a los tipos de variables que pueden existir en kotlin, son principalmente dos las que nos podemos encontrar: var y val. Var se trata de una variable "normal", la cual puede alterar su valor a lo largo del programa, mientras que val se trata de una variable constante que no puede cambiar su valor una vez ha sido asignado

```java
var numero: Int = 0;
val VARIABLE_CONSTANTE = "VALOR FIJO"


fun main(arg: Array<String>) {

	// esto provocaría un fallo de compilación
    VARIABLE_CONSTANTE = "Cambio de valor"
    // esto reasigna el valor de la variable a 9
    numero = 9;
}
```

A la hora de declarar variables, kotlin tiene un mecanismo para evitar las excepciones de nullpointer. Se conoce como null safety y permite asignar un posible valor nulo a una variable sin que al utilizarlo se rompa la ejecución. Para ello se utiliza el símbolo de ? después del tipo de la variable;

```java
var nombre: String? = null
```

Esto indica que la variable tiene asignada un valor de null. Con esta declaración cada vez que se quiera utilizar la variable se tendrá que indicar la posibilidad de obtener un null en la ejecución

```java
var nombre: String? = null
fun main(arg: Array<String>) {
    println(nombre?.length)
}

SALIDA
null
```

Hay en otros casos que no se puede obviar el fallo por uso de null. En estos casos es necesario indicar al compilador que si se encuentra con un elemento null que continue con la ejecución normal

```java
var totalFacturado: Int? = null
fun main(arg: Array<String>) {
    if (totalFacturado!! <0){
        println("Estamos en perdidas");
    }
}
```

En el caso de querer utilizar el null safety indicado anteriormente también se podría, siempre teniendo que llamar a una función después de la variable que puede ser nula

```java
fun main(arg: Array<String>) {
    if (totalFacturado?.compareTo(0) ==0){
        println("Estamos en perdidas");
    }
}
```

En algunas ocasiones puede ser muy interesante sustituir el valor del posible null por otro valor. Para ello se utiliza lo que se conoce como el operador Elvis, poniendo ?: = valor cuando es null

```kotlin
totalFacturado?.compareTo(0) ?: -1
```

En este caso se está intentando utilizar el método comparteTo de la variable totalFacturado y comparándolo con 0. En el caso en el que la variable sea null, el valor se sustituirá por -1. Un ejemplo con un estamento completo sería el siguiente

```java
var totalFacturado: Int? = null;

fun main(arg: Array<String>) {


    println(totalFacturado?.compareTo(0));
    if (totalFacturado?.compareTo(0) ?: -1  ==0){
        print("El valor es nulo")
    } else if (totalFacturado?.compareTo(0)==0){
        println("El total facturado es un número igual al indicado")
    } else {
        println("El total facturado es diferente")
    }
}

// SALIDA

El valor es nulo
```

Las propiedades son elementos que quedan declarados y se puede acceder a ellos gracias a sus métodos get y set. Para declarar esos métodos se hace justo después de crear la propiedad y se definen como un método normal. Hay que tener en cuenta que el uso de la palabra reservada field hace referencia al apropio valor

```java

var propiedad = 0
    get() = field
    set(value) {
        field = value
    }

var variable = "Hola"


fun main(arg: Array<String>) {
    println(propiedad)

    println(variable)
}
```

En el ejemplo la variablo propiedad tiene declarado dos métodos (get y set) el primero de los cuales al tener solo una linea se hace con una función de linea

# Sentencias de control

Las sentencias de control permiten maneja el flujo del programa de forma que el código no se ejecute de forma estructurada, sino que pueda dar "saltos" dependiendo de que es lo que ocurra dentro del programa. Las estructuras de control en Kotlin son muy similares a java, pero podemos encontrar alguna diferencia como por ejemplo la construcción del for o la sentencia switch que es sustituida por la sentencia when

## if

Esta estructura en kotlin es exactamente igual que en java, no existe diferencia

```java
fun main(arguments: Array<String>){
    print("Estructuras de control")
    val comienzo: Boolean = true
    if (comienzo) print("Comenzamos con el curso") else print("No estamos preparados")
}
```

En este caso la salida sera Comenzamos con el curso ya que la variable de la condición es true. Como se puede ver y al igual que pasa en java, si la sentencia if solo tiene una linea de ejecución no es necesario el uso de las llaves

```java
fun main(arg: Array<String>){

    println("Indica cual es tu nombre")
    val nombre: String? = readLine();
    println("Indica cual es tu edad")
    val edad: Int = readLine()!!.toInt();
    val comienzo: Boolean = true;

    if (comienzo && edad >17){
        print("Bienvenido ${nombre} el curso comenzará")
    } else if (comienzo && edad<18) {
        println("Han dado consentimiento tus padres")
        val consentimiento: String? = readLine();
        if (consentimiento.equals("SI")) println("Perfecto ${nombre} podemos empezar")
    } else {
        println("No podemos empezar el curso")
    }

}
```

Como veremos más adelante, kotlin cuenta con un mecanismo de null safety para poder garantizar que no se utiliza ninguna variable que pueda ser nula. De ahí el carácter ? y el carácter !!. Lo veremos más adelante pero para que podamos entender el código el ? indica que la variable puede ser nula y !! indica que se garantiza que la variable nunca va a ser nula. En el caso de estar declarada como posible nula, si se quiere utilizar se tiene que garantizar su no nulo

```java
    if (nombre?.length!! <= 0){
        print("No se ha introducido nada")
    }
```

## when

En kotlin no existe el uso de la sentencia de control swith. Esta ha sido sustituida por el uso de la sentencia when. El uso es muy parecido, cambiando la forma de escribirlo. Para poder utilizarlo se utiliza la siguiente construcción:

```java
when(condición){
    caso -> {ejecuciones}
    else -> {ejecuciones}
}
```

Como podemos ver se parece bastante al switch de java, con la diferencia que en este caso se pueden indicar multitud de posibilidades a la hora de evaluar un caso (además que el default no existe sino que existe un else). Un ejemplo sería el siguiente

```java
    val nota: Int= readLine()?.toInt() ?: 0;
    when (nota){
        !in 0..10 -> {print("Número incorrecto")}
        in 5..9 -> {
            print("Has aprobado")
        }
        in 3..4-> {
            print("Hay que estudiar más")
        }
        10 -> {
            print("Perfecto examen de matrícula")
        }
        else -> {
            print("El examen ha salidao muy mal")
        }
    }
```

En este caso existen cuatro casos

- que el número no esté comprendido entre un rango indicado mediante !in inicio..final
- que el número esté comprendido entre un rango indicado mediante in inicio..final
- que el número sea un caso concreto
- el resto de las posibilidades

Estos casos pueden ser cualquier cosa, incluso la salida de un método, donde uno de los casos sería

```java
        calcularMedia(nota) -> {
            print("El examen no da una media correcta")
        }
```

y la función sería

```java
fun calcularMedia(nota: Int): Int{
    return  nota/2;
}
```


## for

La estructura de repetición for permite realizar una tarea repetitiva un número de veces indicadas y/o recorrer una colección completa o en un rango específico. Para ello existen las siguientes estructuras

- for en un rango concreto creciente

```java
    for (i in 10..20){
        println(i)
    }

// SALIDA
10
11
12
13
14
15
16
17
18
19
20
```

Existe la posibilidad de indicar un numero determinado de paso (cantidad de incremento cada vez que se ejecute el for). Para ello es necesario indicarlo con step

```java
    for (i in 10..20 step 5){
        println(i)
    }

// SALIDA
10
15
20
```

- for en un rango concreto decreciente: es necesario indicar downTo para decir hasta que numero es necesario llegue

```java
    
    for (i in 10 downTo 1){
        println(i)
    }

// SALIDA
10
9
8
7
6
5
4
3
2
1
```

Al igual que en el caso anterior también es posible configurar la cantidad de pasos


- for de una colección de datos: en el caso de tener una colección es posible recorrerla indicando directamente la iteración sobre el elemento
```java
    for (i in (10..15))
    {
        println(i)
    }
// SALIDA
    10
    11
    12
    13
    14
    15
```

- Foreach. Se trata de una función de iteración dentro de una colección. El método nativo tan solo obtiene como parámetro el dato que se está iterando. En el caso de necesitar el índice, es necesario utilizar la función foreachIndexed

```java
(1..5).forEach({ item ->
        println(item)
    })

// SALIDA
1
2
3
4
5
```

```java
(1..5).forEachIndexed { index, value -> println(${index} - ${value} }
// SALIDA
0 - 1
1 - 2
2 - 3
3 - 4
4 - 5
```

## Ejercicios de clase

1. Generar 10 aleatorios entre el 1 y el 100, calculando:
    - la suma de todos
    - el número medio
    - el número max
    - el numero min

modificar el ejercicio anterior para que antes de empezar: 

- pida la edad y compruebe si esta es mayor que 18. En caso de ser así ejecutará lo anterior. En caso de no ser mayor de 18 saltará un aviso de que no se puede ejecutar

2. Crea un programa que pida al usuario que indique cuantas palabras desea meter en un array. Tras introducirlo, el sistema pedirá al usuario tantas palabras como se hayan indicado. Una vez hecho esto se pide que se cree un menú con las siguientes opciones:

    - 1. Listar todas las palabras
    - 2. Listar las de las posiciones pares
    - 3. Listar las de las posiciones impares
    - 4. Listar las de una longitud concreta, donde se pedirá al usuario la longitud y se mostrarán todas las palabras que cumplan dicha condición
    - 5. Salir

# Funciones

**Documentación oficial:** https://kotlinlang.org/docs/reference/functions.html

Las funciones en kotlin se declaran con la palabra reservada `fun`

```kotlin
fun nombreFuncion(){}
```

La pruncipal función y que es el punto de entrada de ejecución es la función main

```kotlin
fun main(arguments: Array<String>) {
}
```

Para poder declarar parámetros dentro de una función se definen con un nombre y el tipo del mismo

```kotlin
fun funcionParamentros(arg1: String, arg2: Int){
    println("$arg1 es el primer parámetro")
    println("$arg2 es el segundo parámetro")
}

fun main(arguments: Array<String>) {
    funcionParametros("Uno",2)
}
```

Una de las cosas que es muy diferente con respecto a java, es que se puede nombrar a los parámetros cuando se llama la función

```kotlin
fun main(arguments: Array<String>) {
    funcionParametros(arg1="Uno",arg2=2);
}
```

Del mismo modo, cuando se declarar argumentos dentro de una función, también se le pueden dar valores por defecto en el caso de que no sean pasados

```kotlin
fun funcionParametros(arg1: String="valor por defecto", arg2: Int=3){
    println("$arg1 es el primer parámetro")
    println("$arg2 es el segundo parámetro")
}

fun main(arguments: Array<String>) {
    funcionParametros()
}

// SALIDA
valor por defecto es el primer parámetro
```

En el caso de que la función solo tenga una linea, se puede crear junto con el operador =

```kotlin
fun sumaParametros (op1: Int, op2: Int) =  println(op1 + op2)
fun main(){
    suma(8,2);
}

// SALIDA
10
```

Si no se define que una función tenga un retorno concreto, este será Unit (es lo mismo que void en Java). En el caso de querer un retorno específico, se define después de los parámetros de la función y antes del cuerpo

```kotlin
fun declaracionFuncion(): String{
 // cuerpo de la funcion
 return "Retorno"
}

fun sumaRetorno(op1: Int, op2:Int): Int{
    return op1 + op2
}

fun main(arguments: Array<String>) {
    println("La función de suma ha retornado "+sumaRetorno(4,5));
}

// SALIDA
La función de suma ha retornado 9

```

## Funciones Lambda

Una función lambda es aquella que se define de forma directa, sin necesidad de declararla como las vistas en el punto anterior. Para ello se puede declarar con la siguiente sintaxis

```kotlin
{arg1: Tipo, arg2: Tipo -> // cuerpo de la funcion}
```

En muchos ede los casos la funcion lambda se suele asociar a una variable. Para ello se puede definir el tipo al que se le asigna.

```kotlin
var lambdaSuma = {arg1: Int, arg2: Int -> print("la suma entre $arg1 y $arg2 es "+arg1.plus(arg2))}
// la misma definición que el anterior, pero declarando el tipo
var lambdaSumaValida: (Int,Int)->Unit = {arg1: Int, arg2: Int -> print("la suma entre $arg1 y $arg2 es "+arg1.plus(arg2))}
```

En el caso de querer que la funcion lambda retorne algo, se puede indicar al igual que las funciones

```kotlin
var funcionLambdaNormal: ((Int) -> Int) = { argumento1: Int ->
    if (argumento1 > 0) {
        1
    } else {
        0
    }
}
```

Algún ejemplo de funciónlambda con diferentes configuraciones es:

```kotlin
// función lambda que tiene un parámetro obligatorio y que puede retornar nulo
var funcionLambdaNull: ((Int)->Int?) = {argumento1: Int-> if (argumento1>0) 6 else null}

// función lambda que tiene un parámetro obligatorio y que puede ser nula la funcion entera
var funcionLambdaNullEntera: ((Int)->Int)? = {argumento1: Int-> if (argumento1>0) 6 else 7}

// en el caso de funcion nula completa hay que utilizar invoke para llamarlo

fun main(arguments: Array<String>) {
    //println(funcionLambdaNull(0))
    println(funcionLambdaNullEntera?.invoke(-1));
}
```

# Arrays

Los arrays en kotlin son elementos de tipo Array. Para poder crear un array existen diferentes posibilidades.

```kotlin
var arrayEmpty = emptyArray<String>();
var arrayNull = arrayOfNulls<String>(5);
var arrayCosas = arrayOf(1,2,3,4,5,6,true);
var arrayNumeros = intArrayOf(1,2,3,4,5,6,7);
```

En el código anterior las inicializaciones son diferentes en los siguientes sentidos:

- La primera inicialización crea un array vario de String, sin ninguna posición y sin un tamaño definido.
- La segunda inicialización crea un array de Nulls (creado para String) con un tamaño de 5 posiciones.
- La tercera inicialización crea un array de cualquier tipo (Any en kotlin) con elementos ya guardados
- La cuarta inicialización crea un array de Int con datos ya guardados. Es importante tener en cuenta que este tipo de inicialización no crea un objeto de tipo Array, sino de IntArray. Pasa exactamente igual con el resto de los tipos

Otra forma de poder inicializar un array con datos ya guardaros es la siguiente:

```kotlin
var arrayInicializado = Array<Int>(6) { (it + 1) };
// 1,2,3,4,5,6
```

De esta forma se puede indicar el tamaño del array (en este caso 6) y con la función indicar el valor de cada uno de los elementos. PAra ello el argumento it es el indice que se utiliza para recorrer

En el caso de querer acceder y modificar las posiciones del array, se utiliza la forma normal que tiene java, pudiendo también utilizar la funcion get y set para acceder y modificar posiciones respectivamente

```kotlin
    println(arrayEmpty[0])
    println(arrayEmpty.get(0))
    println(arrayNull.get(0))
    println(arrayNull.set(0,"Primer elemento"))
```

Si se quiere recorrer de forma completa un array se puede utilizar un for, un foreach o un fereach con indice

```kotlin
for (cosa in arrayCosas) {
        println(cosa);
    }
arrayNumeros.forEach { it -> print(it) }
arrayNumeros.forEachIndexed({index: Int, it:Int->println("$index - $it")})
```

## Operaciones de busqueda en arrays

Cuando se quiere buscar elementos dentro de un array, en java se tiene que recorrer el array de forma completa. Sin embargo en kotlin existen una serie de métodos que realizan todo el trabajo de búsqueda de firma directa. El primero de ellos es el método find. Este método retorna el primer elemento del array que se encuentre con la condición indicada, para lo que se utiliza un argumento dentro de la función lambda

```kotlin
var lenguajes = arrayOf("Java", "Kotlin", "C#", "Python", "JavaScript", "PowerScript");
var encontrado = lenguajes.find { elemento: String -> elemento.contains("Script") }
println(encontrado)

// SALIDA
JavaScript
```

El otro método que permite realizar una búsqueda es filter. En este caso el retorno del método es un array con los elementos que cumplen la condición indicada en el predicado

```kotlin
var busqueda = lenguajes.filter { elemento -> elemento.length> 5 }
busqueda.forEach { println(it) }

// SALIDA
Kotlin
Python
JavaScript
PowerScript
```
# Colecciones
Al igual que pasa en java, los arrays pueden quedar algo cortos debido a su poca mutabilidad. Esto quiere decir que en el caso de tern un array con 5 posiciones, este no puede crecer y tan solo podría ser modificados los valores que están guardados en las posiciones. Para poder paliar este tipo de carencia, existe lo que se conoce como colecciones o listas mutables. En este apartado veremos el uso de los ArrayList

Para poder crear un arraylist, no es necesario indicar cual es el tamaño inicial, ni siquiera que elementos forman parte del mismo. Basta con crear el objecto con su constructor

```java
var lista: ArrayList<String> = ArrayList<String>()
```

Lo que si es obligatorio es indicar el tipo del dato que va a guardad dentro.En el ejemplo anterior se indica que se procede a guardar datos de tipo String. Una vez está creado la colección, los principales métodos que se pueden utilizar son los siguientes:

- add o addAll: Permite agregar un elemento en una posición determinada. En el caso de no indicar cual es la posición donde se agrega el elemento, este se podrá al final de la lista. El tipo de retorno es boolean, indicando si la tarea se ha realizado correctamente.

```java
var lista: ArrayList<String> = ArrayList<String>()
    lista.add("Primer")
    lista.add("elemento")
    lista.add("de")
    lista.add("la")
    lista.add("lista")

// SALIDA
Primer, elemento, de, la, lista
```

-remove o removeAt: Permite borra elemento de la lista indicado. También se puede borrar por posición. El tipo de retorno es booleano, indicando si se ha hecho la acción correctamente.

```java
// siendo lista = Primer, elemento, de, la, lista
    lista.removeAt(0);
    lista.remove("de")
// SALIDA
Primer, elemento, la, lista

```

- get: Permite obtener un elemento concreto, siendo buscado por posición. 

```java
// siendo lista = Primer, elemento, de, la, lista
println(lista.get(0));
// Salida
Primer
```

Otrs métodos interesantes son:

```java
// obtiene el primer elemento que cumple una condición
lista.filter { it.length == 2 }
// elimina de la lista todos aquellos elmeentos que cumplen una condición 
lista.removeIf { it.length == 3 }
```

# Clases

**Documentación oficial:** https://kotlinlang.org/docs/reference/classes.html

Las clases representan la posibilidad de objetos. Una de las cosas más importantes en kotlin es que en una clase se pueden crear varias clases. Al igual que en java toda clase tiene un constructor por defecto, por lo que se puede crear un objeto de la clase

```kotlin
fun main(arg: Array<String>){
    var clase: ClaseA = ClaseA();
}

class ClaseA
```

Si se quiere crear un constructor con parámetros, se utiliza la palabra reservada `constructor`

```kotlin
class ClaseA{
    var nombre: String;
    constructor(nombre: String){
        this.nombre = nombre;
    }
}
```

Si tan solo se quiere utilizar un constructor se puede obviar la palabra `constructor` indicando los parámetros al lado del nombre de la clase, quedando la creación de la clase de la siguiente forma

```kotil
fun main(arg: Array<String>){
    var clase: ClaseA = ClaseA("Ejemplo");
}

class ClaseA (var nombre: String){

}
```

Si se quisieran tener constructores secundarios, si sería necesario utilizar la palabra reservada `constructor`. Hay que recordad que si se utiliza un constructor con parámetros, el constructor por defecto desparecería. Adicionalmente a esto si se utilizan constructores adicionales es necesario que estos devuelven el primer constructor definido

```kotlin

fun main(arg: Array<String>){
var lenguaje = Lenguaje("java","multi",18)
println(lenguaje.plataforma);
}

class Lenguaje{
    var nombre: String
    var plataforma: String;
    var version: Int;
    constructor(nombre: String, plataforma: String, version: Int)  {
        this.nombre = nombre
        this.plataforma = plataforma;
        this.version = version;
    }
}

```

En este primer ejemplo se tiene una clase llamada Lenguaje que para poder crearla se necesita un constructor con tres parámetros que son obligatorios: nombre, plataforma y versión. Sin embargo si se quieren utilizar constructores múltiples se puede pasando por parámetros aquellos que se necesiten, pero teniendo en cuenta que aquellas propiedades que no estén incluidas deberán estar configuradas como null safety

```kotlin
class Lenguaje{
    var nombre: String
    var plataforma: String;
    var version: Int?=null;
    constructor(nombre: String, plataforma: String, version: Int)  {
        this.nombre = nombre
        this.plataforma = plataforma;
        this.version = version;
    }

    constructor(nombre: String, plataforma: String){
        this.nombre = nombre;
        this.plataforma = plataforma;
    }
}

fun main(arg: Array<String>) {
    var java = Lenguaje("java", "multi", 18)
    var kotlin = Lenguaje( nombre="Kotlin", plataforma = "multi")
    println(java.plataforma);
    println(kotlin.version)
}

// SALIDA
multi
null
```

En este ejemplo se ha creado un segundo lenguaje de programación llamado kotlin con el constructor que admite dor parámetros. En este caso la versión es null ya que no se ha especificado. (se ha utilizado la creación del objeto nombrando las variables a modo de prueba para ver más opciones de creación de objetos)

Otra de las posibilidades a la hora de crear varios constructores es la de tener uno base, sobre el cual el resto depende. Para ello se utiliza la notación corta para el constructor "base" y la palabra constructor para el resto de constructores, teniendo en cuenta que todos deberán de devolver un objeto de la clase. En este ejemplo se creará un constructor base que recibe un parámetro String que representará el nombre. Adicionalmente se utilizarán dos constructores, uno que además aportará la plataforma, y otro que aportará la plataforma y la versión

```kotlin
fun main(arg: Array<String>) {
    var java = Lenguaje("java", "multi", 18)
    var kotlin = Lenguaje( nombre="Kotlin", plataforma = "multi")
    var cSharp = Lenguaje ("C#");
    println(java.plataforma);
    println(kotlin.version);
    println(cSharp.plataforma)
}

class Lenguaje (var nombre: String){
    var plataforma: String? = null;
    var version: Int? = null;

    constructor(nombre: String, plataforma: String, version: Int): this(nombre) {
        this.plataforma = plataforma;
        this.version = version;
    }

    constructor(nombre: String, plataforma: String): this(nombre){
        this.plataforma = plataforma;
    }
}
```

En este caso como se ha utilizado un constructor base ocurren dos cosas:

- Todas las propiedades de la case se tienen que inicializar con un valor (existe la posibilidad de utilizar lateinit que se verá más adelante)
- Todos los constructores adicionales tienen que devolver el constructor base, y que además realizarán las acciones que hayan definido en su definición

Al igual que se pueden crear constructores, también se pueden crear tantas funciones como sean necesarias dentro de una clase, para así poder utilizarlo

```kotlin
fun main(arg: Array<String>) {
    var java = Lenguaje("java", "multi", 11)
    var kotlin = Lenguaje( nombre="Kotlin", plataforma = "multi")
    var cSharp = Lenguaje ("C#");
    java.clasificar()
    java.mostrarDatos()
    kotlin.mostrarDatos()
    cSharp.mostrarDatos()
}

class Lenguaje (var nombre: String){
    var plataforma: String? = null;
    var version: Int? = null;

    constructor(nombre: String, plataforma: String, version: Int): this(nombre) {
        this.plataforma = plataforma;
        this.version = version;
    }

    constructor(nombre: String, plataforma: String): this(nombre){
        this.plataforma = plataforma;
    }

    fun clasificar(){
        if (this.nombre.lowercase().equals("java")){
            if (this.version?:12<14){
                println("versión obseleta")
            }
        }
    }

    fun mostrarDatos(){
        println("Nombre ${this.nombre}")
        println("Plataforma ${this.plataforma?: "no definida"}")
        println("Versión ${this.version?: "no definida"}")
    }
}

// SALIDA
versión obseleta
Nombre java
Plaraforma multi
Versión 11
Nombre Kotlin
Plaraforma multi
Versión no definida
Nombre C#
Plaraforma no definida
Versión no definida
```

En este ejemplo, en el método clasificar se evalúa que el nombre del lenguaje sea java. En caso de serlo, si la version es inferior a 14 se mostrará el mensaje de "versión obsoleta". En esta construcción como la propiedad versión se ha inicializado a null (por obligación al utilizar constructores secundarios) se ha realizado una sustitución de en el caso de ser nula se sustituirá por el número 12. Lo mismo pasa en el método mostrarDatos. Como las propiedades plataforma y versión pueden ser nulas, en el caso de serlo se sustituirán por la palabra "no definida"

Por último, existe la posibilidad de inicializar las variables de forma postergada, no en el constructor. Para ello se utiliza la palabra reservada `lateinit`. En el ejemplo de la clase Lenguaje, imaginemos que existe una propiedad llamada propietario, la cual no se quiere inicializar en el constructor ya que no solo no es obligatoria, sino que en necesario que el lenguaje de programación exista para que una vez esté creado tenga un propietario. Para ello se crea la propiedad y se declara como lateinit

```kotlin
class Lenguaje (var nombre: String){
    var plataforma: String? = null;
    var version: Int? = null;
    lateinit var propietario: String

    constructor(nombre: String, plataforma: String, version: Int): this(nombre) {
        this.plataforma = plataforma;
        this.version = version;
    }

    constructor(nombre: String, plataforma: String): this(nombre){
        this.plataforma = plataforma;
    }

    fun clasificar(){
        if (this.nombre.lowercase().equals("java")){
            if (this.version?:12<14){
                println("versión obseleta")
            }
        }
    }

    fun mostrarDatos(){
        println("Nombre ${this.nombre}")
        println("Plaraforma ${this.plataforma?: "no definida"}")
        println("Versión ${this.version?: "no definida"}")
    }
}
```

Es muy importante que esta propiedad no sea inicializada en ninguno de los constructores, ya que con el modificador lateinit se indica que no se hará ahí. Sin embargo si sería necesario un método que inicialice dicha propiedad a modo de setter

```kotlin
class Lenguaje (var nombre: String){
    var plataforma: String? = null;
    var version: Int? = null;
    lateinit var propietario: String

    constructor(nombre: String, plataforma: String, version: Int): this(nombre) {
        this.plataforma = plataforma;
        this.version = version;
    }

    constructor(nombre: String, plataforma: String): this(nombre){
        this.plataforma = plataforma;
    }

    fun asignarPropietario (propietario: String){
        this.propietario = propietario;
    }

    fun clasificar(){
        if (this.nombre.lowercase().equals("java")){
            if (this.version?:12<14){
                println("versión obseleta")
            }
        }
    }

    fun mostrarDatos(){
        println("Nombre ${this.nombre}")
        println("Plaraforma ${this.plataforma?: "no definida"}")
        println("Versión ${this.version?: "no definida"}")
        println("Propietario "+propietario)
    }
}
```

Como en el método mostrarDatos se utiliza la variable, si este es utilizando antes de inicializar la variable propietario, el programa obtendrá una excepción de `UninitializedPropertyAccessException`

```kotlin
fun main(arg: Array<String>) {
    var java = Lenguaje("java", "multi", 11)
    var kotlin = Lenguaje( nombre="Kotlin", plataforma = "multi")
    var cSharp = Lenguaje ("C#");
    // Esta llamada provocaría un error al utiliza una variable no inicializada
    cSharp.mostrarDatos()
    cSharp.asignarPropietario("Microsoft")
    // Esta llamada no provocaría ningún error ya que la variable se ha inicializado antes de utilizarla
    cSharp.mostrarDatos()
}

```

Como se ha visto, se pueden utiliza constructores primarios (aquel definido en la firma del método) o constructores secundarios (aquellos definidos con la palabra `constructor`). En el caso de utilizar primarios, estos tan solo inicializan las variables al valor pasado, pero nada más. En el caso de querer que el constructor (todos, tanto primarios como secundarios) haga algo más, se puede utilizar el bloque reservado `init`

```kotlin
// Archivo diferente
class Lenguaje(var nombre: String) {
    var plataforma: String? = null;
    var version: Int? = null;
    lateinit var propietario: String

    init {

        if (nombre.lowercase() == "java") propietario = "Oracle" else if (nombre.lowercase() == "c#") propietario =
            "Microsoft" else propietario = "din definir"
    }

    constructor(nombre: String, plataforma: String, version: Int) : this(nombre) {
        this.plataforma = plataforma;
        this.version = version;
    }

    constructor(nombre: String, plataforma: String) : this(nombre) {
        this.plataforma = plataforma;
    }

    fun asignarPropietario(propietario: String) {
        this.propietario = propietario;
    }

    fun clasificar() {
        if (this.nombre.lowercase().equals("java")) {
            if (this.version ?: 12 < 14) {
                println("versión obseleta")
            }
        }
    }

    fun mostrarDatos() {
        println("Nombre ${this.nombre}")
        println("Plaraforma ${this.plataforma ?: "no definida"}")
        println("Versión ${this.version ?: "no definida"}")
        println("Propietario " + propietario)
    }
}
//Archivo diferente


fun main(arg: Array<String>) {
    var java = Lenguaje("java")
    var cSharp = Lenguaje("C#");
    var kotlin = Lenguaje(nombre = "Kotlin", plataforma = "multi")
    java.mostrarDatos()
    cSharp.mostrarDatos()
    kotlin.mostrarDatos()

// SALIDA

Nombre java
Plaraforma no definida
Versión no definida
Propietario Oracle
Nombre C#
Plaraforma no definida
Versión no definida
Propietario Microsoft
Nombre Kotlin
Plaraforma multi
Versión no definida
Propietario din definir
}
```

En este ejemplo, se han utilizado tanto constructores primarios como constructores secundario. Los tres utilizados han realizado la inicialización de variables y el bloque `init` se ha encargado de inicializar la variable `lateinit propietario`, por lo que al ejecutar el método mostrarDatos no ha dado ninguna excepción (sin la necesidad de llamar al método asignarPropietario)

Hay otra posibilidad de crear clases. Aquella que solo tienen datos y no funciones y demás pueden ser declaradas como data

```kotlin
data class PersonaData(val nombre : String, val apellido : String)

fun main(args : Array<String>) {
    val persona = PersonaData("Pedro", "Herrera")

```

Para que una clase pueda ser definida como data se deben cumplir los siguientes elementos:

- El constructor primario debe tener como mínimo un parámetro.
- Todos los parámetros del constructor primario deben estar definidas con var o val.
- No pueden ser abstract, open, sealed ni inner.

Una de las cosas importantes que permiten las clases data, es que las variables pueden ser deconstruidas

```kotlin
package herencia_trabajadores
fun main(arg: Array<String>){

    var (nombre,apellido) = personaData;
    println(nombre)
    println(apellido)
}

// SALIDA
Pedro
Herrera
```

## Herencia

Al igual que pasa en java, kotlin es un lenguaje de programación que da la posibilidad de configurar herencia entre clases para que estas aprovechen propiedades y funciones de una clase superior. Sin embargo, a diferencia de java, en kotlin por defecto las clases no pueden heredad entre si a no se que se ponga el modificador `open` antes del nombre de la clase, ya que si no esta será `final`

```kotlin
package herencia_trabajadores

open class Persona (var nombre: String) {

     var apellido: String?=null;
     var dni: String?=null

    constructor(): this("Sin definir"){

    }

    constructor(nombre: String, apellido: String, dni: String): this(nombre){
        this.apellido = apellido;
        this.dni = dni;
    }

    fun mostrarDatos(){
        println("nombre: $nombre")
        println("apellido")
        println("dni: $dni")
    }
}
```

En este caso se ha creado una clase llamada Persona con un constructor base llamado nombre y dos constructores adicionales, uno que es el vacío con un dato por defecto y otro que admite un apellido y un dni. Adicionalmente se identificado que la clase es `open` para que esta pueda ser superclase de otra. El siguiente paso será crear una clase que herede de esta. Para ello se utiliza el operados `:`seguido del nombre de la clase de la que se quiere heredar en un archivo nuevo

```kotlin
class Trabajador: Persona() {

}
```

En este caso la clase Trabajador hereda de la clase Persona y utiliza el constructor por defecto de la misma (ya que se ha indicado con los paréntesis). Si se quieren sobreescribir constructores secundarios, es necesario indicarlo sin los paréntesis en la extensión de la clase

```kotlin
class Trabajador: Persona {
    constructor(): super()
    constructor(nombre: String) : super(nombre)
    constructor(nombre: String, apellido: String, dni: String) : super(nombre, apellido, dni)
}
```

Si se quiere añadir propiedades a la clase se puede hacer e inicializarla en alguno de los constructores que se tengan

```kotlin
class Trabajador : Persona  {
    var numeroSS: Int?=null

    constructor(nombre: String, apellido: String, dni: String, numeroSS: Int) : super(nombre, apellido, dni){
        this.numeroSS = numeroSS;
    }
}
```

En este caso tan solo se sobreescribe el conctructores que admite tres parámetros, al cual se le ha añadido el de la nueva propiedad incluida en la clase. Si se quieren cambiar la definición de algún método de los creados en superclases es necesario dos cosas:

- Que el método cuando se define tenga la palabra reservada `open` (obligatorio aunque la clase sea `open`)
- En el método que se quiera sobreescribir utilizar la palabra reservada override antes de la definición de la función

```kotlin

//Archivo diferente
open class Persona (var nombre: String) {

     var apellido: String?=null;
     var dni: String?=null

    constructor(): this("Sin definir"){

    }

    constructor(nombre: String, apellido: String, dni: String): this(nombre){
        this.apellido = apellido;
        this.dni = dni;
    }

    open fun mostrarDatos(){
        println("nombre: $nombre")
        println("apellido $apellido")
        println("dni: $dni")
    }
}

//Archivo diferente
class Trabajador : Persona  {
    var numeroSS: Int?=null

    constructor(nombre: String, apellido: String, dni: String, numeroSS: Int) : super(nombre, apellido, dni){
        this.numeroSS = numeroSS;
    }

    override fun mostrarDatos(){
        super.mostrarDatos()
        println("Número SS: $numeroSS")
    }

}

//Archivo diferente
fun main(arg: Array<String>){
    var persona = Persona("Pedro")
    //persona.mostrarDatos()
    var trabajador = Trabajador("Pedro","Herrera","123123A",111111);
    trabajador.mostrarDatos()
}
```

En muchas ocasiones no interesa tener una clase para que pueda ser creada como objeto, sino que se necesita como la base para el resto de subclases que irán por debajo en la linea de herencia. Para ello existe el concepto de clase abstracta, la cual puede tener entre 0 y n métodos abstractos (solo con firma y sin definición). Para poder crear una clase abstracta se debe utilizar antes del nombre de la clase la palabra reservada `abstract`, siendo open por defecto. En el caso de tener un método abstracto se utilizar la misma palabra reservada antes de la declaración del método

```kotlin
// Archivo diferente
abstract class Persona (var nombre: String) {

     var apellido: String?=null;
     var dni: String?=null

    constructor(): this("Sin definir"){

    }
    constructor(nombre: String, apellido: String, dni: String): this(nombre){
        this.apellido = apellido;
        this.dni = dni;
    }
    abstract fun mostrarDatos();


// Archivo diferente
class Trabajador : Persona  {
    var numeroSS: Int?=null

    constructor(nombre: String, apellido: String, dni: String, numeroSS: Int) : super(nombre, apellido, dni){
        this.numeroSS = numeroSS;
    }

    override fun mostrarDatos(){
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("DNI: $dni")
        println("Número SS: $numeroSS")
    }

}

```

En este ejemplo la clase persona se ha marcado como abstracta, donde se cuenta con un método abstracto que no tiene definición. En el caso de querer crear un objeto de tipo Persona no se podría al ser abstracta. La clase trabajador extiende de persona y tiene la obligación de sobrescribir el método mostrarDatos ya que en la clase Persona es abstracto.

## Interfaces

**Referencia documentación oficial:** https://kotlinlang.org/docs/reference/interfaces.html

Uno de los puntos que no permite kotlin (al igual que java) es la herencia múltiple. Para paliar esta desventaja existe el concepto de interfaz, utilizando la palabra reservada `interface` en vez del de `class`. Hay que recordad que una interfaz tienen un conjunto de métodos no definidos (por defecto abstractos) que serán declarados en aquellas clases donde sean utilizadas las interfaces.

```kotlin
interface Directivo {

    fun realizarVoto(voto: Int);
}
```

Una vez se tiene declarada la interfaz, en el caso de querer utilizarla se pone detrás de los : que se utiliza para la herencia.

```kotlin
package herencia_trabajadores

class Jefe:Persona, Directivo {

    constructor(nombre: String) : super(nombre)
    constructor() : super()
    constructor(nombre: String, apellido: String, dni: String) : super(nombre, apellido, dni)

    override fun realizarVoto(voto: Int) {
        var numero = (0..10).random()
        println("El vóto emitido es de $voto")
        println("$numero")
        println("El resultado con el random obtenido es de ${numero*voto}")

    }

    override fun mostrarDatos() {
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("DNI: $dni")
    }
}
```

En la clase Jefe, se ha extendido de la superclase Persona, utilizando sus constructores y sobreescribiendo el método mostrar datos que era abstracto. Además se ha implementado la interfaz Directivo, por lo que se ha obligado a sobreescribir el método realizar voto.
