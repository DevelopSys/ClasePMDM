# Índice

- [Índice](#índice)
- [Bases de flutter. Los widgets](#bases-de-flutter-los-widgets)
- [Primer proyecto Flutter](#primer-proyecto-flutter)
- [Widgets](#widgets)
  - [Widgets de colocación](#widgets-de-colocación)
    - [Center](#center)
    - [Container](#container)
    - [Row - Column](#row---column)
      - [Row](#row)
      - [Column](#column)
        - [Convinación](#convinación)
  - [Widgets gráficos](#widgets-gráficos)

# Bases de flutter. Los widgets

Para poder entender un proyecto Flutter, lo primero que hay que hablar es de la composición de una aplicación. Hay un concepto básico en flutter que todo gira alrededor de el, que son los widgets. Se dice que en flutter todos son widgets y en realidad es así. Un widget es cada elemento que se puede ver dentro de la pantalla, desde el elemento más simple (una etiqueta de texto) hasta la propia pantalla. Depende de cual sea el cometido del mismo más adelante veremos que hay widgets con estado y sin estado. Explicado esto, una aplicación de flutter es un arbol de widgets, los cuales combinados forman una aplicación funcional

![árbol de nodos](./images/arbol_widgets.png)

Como se puede ver en la imagen todo parte de un elemento llamado MyApp, terminar en los widgets finales de texto e icono. En esta gerarquía, podemos diferencia entre widgets finales (aquellos que representan un elemento como texto o icono) y widgets contenedores (aquellos que tienen otros wodgets dentro). Esta diferenciación es sobre elementos gráficos, pero en cuanto a funcionalidad existen dos tipos de widgets:

- Stateless: aquellos widgets que no tienen estado, es decir que tan solo se utilizan para mostrar información y no recogerla y/o guardarla para tratarla de alguna forma

- Statefull: aquellos widgets que si tienen estado, por lo que pueden recoger información y guardarla para procesarla. Para ello este tipo de widgets tienen un método especial llamado setState() que modifica esta condición.

En cuanto a rendimiento, el uso de statefull es mucho más pesado ya que cada vez que cambia el estdo de la aplicación se debe recargar internamente, por lo que se recomienda en la medida de lo posible utilizar stateless

Antes de empezar a crear un proyecto, vamos a ver parte de código y en concreto vamos a explicar la creación de un widget. Lo primero que tenemos que saber es que los widgets se pueden representar o bien por clases o bien como objetos que ya están creados (flutter cuenta con una grán cantidad de widgets que se pueden consultar en el siguiente enlace ). Como mínimo tendremos una clase, la cual extenderá o bien de statefull o stateless

```dart
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}
```

En este ejemplo podemos que ver el widget principal el de tipo stateless. Todo widget tienen un método llamado build que admite un contexto y que retorna un widget. Este retorno es un widget ya creado llamdo MaterialApp, el cual tiene como parémtros en el constructor (nominales) un title, un theme y un home (que a su vez es otro widget). MaterialApp es el widget básico creado por Flutter para utilizar elementos de tipo máterial (podemos ver todos en este <a href="https://docs.flutter.dev/ui/widgets/material?gclid=Cj0KCQjwpPKiBhDvARIsACn-gzAn8r2pjhRCK9lIB0JMKytrCxZwRNd1e6sLD9cLcluL3cWnmKWKcTgaAklBEALw_wcB&gclsrc=aw.ds">link</a>)

El siguiente paso sería crear la clase llamada MyHomePage, la cual está situada en el home. Dicha clase será otro widget representado con el siguiente código

```dart
class MyHomePage extends StatelessWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text(title)),
      floatingActionButton:
          FloatingActionButton(onPressed: () {}, child: const Icon(Icons.comment)),
      body: const Center(child: Text("Primera app en Flutter"),),
    );
  }
}
```

La clase extiendo de stateless widget por lo que no puede guardar estado. En este caso el widget retornado es un Scaffold, el cual representa el contenedor (a diferencia de MaterialApp que representa la pantalla) del resto de widgets. Como se puede ver, los elementos que se pasan en contructor son: appbar, floatingactionbutton y body.

En el caso de querer poner en el centro elementos que se quieran utilizar para algo, es ncesario utilizar un statefull widget, el cual tendría la siguiente clase asociada

```dart
class FormState extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    return _FormWidgetState
  }
}

class _FormWidgetState extends State<FormWidgetState> {
  String name = "";
  int number = 0;
}
```

Siempre que se crea un widget StateFull, hay que tener dos clases:

- Una primera clase que extiende de StatefulWidget, la cual representa el widget completo. Este clase tienen que sobreescribir el método createState para retornar un estado
- Una sendunta clase que extiende de State con el tipado de la clase creada en el punto anterior para que se pueda crear un estado. Esta clase actua como los widgets sin estado, sobreescribiendo el método build el cual retorna un widget. La particularidad de esta clase es que tienen un método setState que permite cambiar el valor de alguna de las variables que forman parte de la clase

```dart
class _FormWidgetState extends State<FormState> {
  final nameController = TextEditingController();
  final numberController = TextEditingController();

  String _name = "";
  int _number = 0;

  _changeState() {
    setState(() {
      _name = nameController.text;
      _number = int.parse(numberController.text);
    });
  }
  _validateData(BuildContext context){
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text("Nombre: $_name $_number")
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Container(
        padding: EdgeInsets.all(20),
        child: Column(children: [
          TextField(
            controller: nameController,
            decoration: const InputDecoration(
              border: OutlineInputBorder(),
              labelText: 'Introduce tu nombre',
            ),
          ),
          Padding(padding: EdgeInsets.fromLTRB(0, 10, 0, 10)),
          TextField(
            controller: numberController,
            decoration: const InputDecoration(
              border: OutlineInputBorder(),
              labelText: 'Introduce un número del 1 al 10',
            ),
          ),
          ElevatedButton(
              onPressed: () => {_changeState()},
              child: Text("Pulsar para añadir")),
          ElevatedButton(
              onPressed: () => {_validateData(context)},
              child: Text("Pulsar para validar")),
        ]));
  }
}
```

Una vez se tiene todo este código generado, el último paso para poder crearlo todo es lanzar la aplicación. Para ello se utiliza el método main, sobre el cual se ejecuta el método runApp pasando como parámetros un objeto de tipo widget.

```dart
void main() {
  runApp(const MyApp());
}
```

Más adelante detallaremos el uso de cada uno de los elementos dentro de la aplicación, pero a modo introductorio es posible que en alguna de las constucciones de elementos veamos tanto elementos con const o sin el. Esto dependerá de la posibilidad de ponerlo (si los widgets que hay dentro nunca cambian es muy recomendable ponerlo). También, veremos que a la hora de crear un widgets, los constructores que se utilizan son nominales, siempre incluyendo en ellos un key

```dart
  const MyHomePage({super.key, required this.title});
```

# Primer proyecto Flutter

Como ya se ha comentado en los puntos anteriores, para poder desarrollar un proyecto flutter existen principalmente dos IDEs: Android Studio y Visual Studio Code. Ambor requieren de extensiones o plugin. En nuestro caso optaremos por utilizar Android Studio ya que para poder utilizar Flutter es necesaria su intalación, así como la creación de un dispositivo virtual para la emulación

A la hora de crear un proyecto desde Android Studio, basta con seguir el asistente que ofrece el IDE como se puede ver en las siguientes imagenes

|                  Selección SDK                  |              Selección plataformas              |
| :---------------------------------------------: | :---------------------------------------------: |
| ![alt-text-1](./images/proyecto1.png "title-1") | ![alt-text-2](./images/proyecto2.png "title-2") |

En el primer paso, es necesario indicar cual es el la ruta donde está ubicado el sdk de dart. En el segundo paso además de indicar el nombre del proyecto y la ruta donde se va a guardar, es necesairo indicar cuales son las plataformas para las que se va a realizar el desarrollo. Recordemos que flutter permite un desarrollo crossplatform, siendo el código común para todas las plataformas. Podremos seleccionar ios, android, linux, windows, macos y web. Una vez se ha creado el proyecto se generan una serie de carpetas, cada una de las cuales tiene el código correspondiente a la plataforma determinada. En especial hay una que es con la que vamos a trabajar de momento y es la carepta lib. En esta carpeta se ubica el código común a todas las plataformas por lo que será compilado para cada una de ellas. Por defecto, se incluye un fichero llamado main.dart. Para poder entender mejor el código, vamos a explicar paso a paso en contenido del fichero.

1. Lo primero que nos encontramos es el método mail(). Al igual que en java, dicho método es el punto de entrada de la aplicación y será ejecutado tras darle al play en el IDE. Dentro de este método se ejecuta el método runApp, el cual arranca la llamada a la aplicación flutter

```dart
void main() {
  runApp(const MyApp());
}
```

Como parámetro del método runApp hay que dar un objeto de tipo Widget. Por defecto hay uno creado, estando representado por una clase que exitende de StatelessWidget o de StatefullWidget

2. Creación del Widget principal de la aplicación. Hay que recordad que tal y como se ha comentado en puntos anteriores, en flutter todos los elementos que se ven en la pantalla son widgets, incluso la propia pantalla. Precisamente este widget es el acargado de montar el escenario donde se albergarán el resto de componentes (de tipo MaterialApp). Para su creación, podría ser desde un fichero externo (previa importación) o directamente en una clase declarada dentro del mismo fichero

```dart
class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    //TODO: implement build
    throw UnimplementedError();
  }
}
```

Esta es la sintaxis básica, donde se extiende de StatelessWidget y por lo tanto se sobreescribe el método build que será en encargado de devolver el widget a pintar (MaterialApp en nuestro caso)

```dart
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    //TODO: implement build
    return MaterialApp(
      title: "Hello World",
      theme: ThemeData(primaryColor: Colors.blueGrey),
      home: Center(),
    );
  }
}
```

Se ha incorporado un constructor (para poder llamar al widget desde cualquier parte) donde como parámetro principal pune un super.key, obtenido desde la superclase. Este código permitirá acceder más adelante al componente. El retorno del método build lo que se está indicando es que el método build retorna un widget de tipo MaterialApp con las características de title (título que aparecerá en la parte superior), theme (esquema de colores) y el atributo home (que representa el widget principal que se mostrará nada más arrancar la aplicación). En es código se pueden ver solo tres atributos pero se puede ver todo es el siguiente <a href="https://api.flutter.dev/flutter/material/MaterialApp-class.html" target="_black" >link</a>. En el caso del home, en el ejemplo se ha puesto un widget por defecto (Center) pero lo normal es que esté configurado por un wodget que represente una pantalla completa. Para ello vamos a crear un nuevo fichero donde poder crear una pantalla con sus configuraciones.

```dart
class HomePage extends StatelessWidget{

  const HomePage({super.key, required this.title});
  final String title;

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Scaffold();
  }
}
```

En este caso, para poder construir el widget HomePage es necesario pasar además del key que lo da la superclase, un String que se guardará en la variable title (en este ejemplo se ha querido pasar este dato, pero podría ser cualquiera). El método build retorna un widget que en este caso es un scaffold. El scaffold es un contenedor que representa la estructura básica de una aplicación Material donde aparece la parte superior AppBar, la parte central o body y un boton flotante. El código quedaría de la siguiente forma:

```dart
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Scaffold(
      appBar: AppBar(title: Text(title)),
      floatingActionButton: FloatingActionButton(onPressed: () => {}, child: const Icon(Icons.add)),
      body: Center(),
    );
  }
```

**\* Para poder ver todos los atributos del Scaffold pulsar el siguiente <a href="https://api.flutter.dev/flutter/material/Scaffold-class.html" target="_black" >link</a> \***

En este caso, se han configurado tres atributos del scaffold:

- appBar: representa la parte superior. Este barra tiene configurado un texto, por lo que es necesario incluirlo dentro de un wodget de tipo Text, donde se pasa como parámetro la variable title
- floatingActionButton: representa un botón ubicado por defecto en la parte inferior derecha. De forma obligatoria hay que sobreescribír el atributo onPressed, el cual indica la función que se ejecutará cuando el botón sea pulsado. En el caso de querer ponerle un icono habrá que realizarlo de la misma forma que en el appBar, anidando un Widget en el atributo child.
- home: representa la parte central de la pantalla. En esta parte central se suele poner un contenedor que permita incluir varios elementos de forma ordenada. Para este ejemplo vamos a siguar un texto en el centro de la pantalla

```dart
Widget build(BuildContext context) {
    // TODO: implement build
    return Scaffold(
      appBar: AppBar(title: Text(title)),
      floatingActionButton: FloatingActionButton(onPressed: () => {}, child: const Icon(Icons.add)),
      body: const Center(child: Text("Hellow World")),
    );
  }
```

El body se ha configurado con un contenedor Center, el cual tiene un atributo child donde se indica cual es el hijo que tiene dentro. En este caso se ha configurado un widget Text.

El árbol de widget de esta primera aplicación quedaría de la siguiente forma

[<img src="./images/esquema1.png" width="50%"/>]

# Widgets

Una vez se ha entendido la creación del proyecto y la forma en la que se estructura la aplicación, es momento de hablar de los diferentes tipos de widgets. Antes de empezar con la definción de los tipos, recordemos que existen dos grandes tipos de widgets: stateless y statefull. Ámbos se diferencian en la capacidad de mantener tener datos para que sean utiliados. A lo largo de esta sección veremos como utilizar ámbos tipos

Para empezar a ver los principales widgets que existe, haremos diferenciación entre los elementos gráficos (aquellos que tienen una GUI) y elementos de colocación (aquellos que sirven como contenedores de otros widgets y los colocan de una forma determinada). Para todos los ejemplos se va a partir de la aplicaión realizada en el punto anterior, representando dentro del body del scaffold los elementos a mostrar

## Widgets de colocación 

Como se ha dicho antes, los wodgets de colocación son aquellos que tienen la capacidad de contener otros widgets y colocarlos de tal forma que queden en una disposicion concreta. Una cosa muy importante es que todos ellos se pueden anidar entre sí, pero para explicarlo de forma más sencilla vamos a utilizarlos de forma indifidualizada. Para todos los ejemplos nos vamos a utilizar como base un MaterialApp con un scaffold con el siguiente código

```dart
Widget build(BuildContext context) {
    // TODO: implement build
    return Scaffold(
      appBar: AppBar(title: Text(title)),
      floatingActionButton: FloatingActionButton(onPressed: () => {}, child: const Icon(Icons.add)),
      body: 
    );
  }
```

### Center

Se trata del layout más sencillo. Como su propio nombre indica, se encarga de centrar el elemento que tiene marcado como hijo. En el caso de no indicar un ancho y alto, ocupará todo el espacio posible

```dart
body: const Center(child: Text("Hellow World"),heightFactor: 20.0, widthFactor: 40.0),

// ó

body: const Center(child: Text("Hellow World")),
```

Como se puede ver en el código, este widget tiene un atributo que es el de child que indica cual es el elemento que se centrará

### Container

Se trata de un widget parecido al anterior, pero con la capacidad de personalizar mucho más el aspecto y posiciones que tendrán todos los componentes que se metan dentro. En el caso de querer poner un texto dentro de un contenedor quedaría de la siguiente forma:

```dart
      body: Container(
        padding: const EdgeInsets.all(20.0),
        color: Colors.amber,
        child: const Text("Contenedor principal"),
        alignment: Alignment.center,
        width: 200.0,
        height: 200.0,
      ),
```
Con las características configuradas, la colocacion del texto quedaría de la siguiente forma

[<img src="./images/container1.png" width="50%"/>]

Dentro de las características mostradas, además de las que son sencillas de interpretar, existe la de aligment la cual marcará en que posición se pone el child indicado. En el caso de no configurar las características de width y heigth el tamaño que tendrá el widget será el máximo posible, siendo en este caso la apariencia la siguiente

[<img src="./images/container2.png" width="50%"/>]

### Row - Column

En los dos casos anteriores para poder indicar un elemento dentro del layout tan solo podíamos incluir uno al tener una característica llamada child (en singular). En el caso de querer incluir más de un elemento estos no valdrían ya que no tienen esa capacidad y aquí es donde entrar el resto de widgets. El primero de ellos que ofrece dicha capacidad son las row - col. Se trata de una distribución en filas y columnas (o ámbas) las cuales tienen un atributo llamado childs (plural).

#### Row

Se trata de un elemento fila que agrupa widgets en su interior horizontalmente (mainAxis)

```dart
      body: Row(
        children: [
          Text("Texto en posicion 1"),
          Icon(Icons.access_alarm),
          Text("Texto en posicion 2"),
          Expanded(
              child: Image.network("https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Google-flutter-logo.svg/2560px-Google-flutter-logo.svg.png"))
        ],
        
      ),
```

En el caso de querer centrar la fila para que aparezca en la parte central de la pantalla, se tendrán que agregar las siguientes características:

```dart
mainAxisAlignment: MainAxisAlignment.center,
//Center Row contents horizontally,
crossAxisAlignment: CrossAxisAlignment.center 
//Center Row contents vertically,,
```

#### Column

Se trata de un elemento columna que agrupa widgets en su interior verticalmente (mainAxis)

```dart
body: Column(
          children: [
            Text("Texto en posicion 1"),
            Icon(Icons.access_alarm),
            Text("Texto en posicion 2"),
            Expanded(
                child: Image.network(
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Google-flutter-logo.svg/2560px-Google-flutter-logo.svg.png"))
          ]
      ),
```

En el caso de querer centrar la columna para que aparezca en la parte central de la pantalla, se tendrán que agregar las siguientes características:

```dart
mainAxisAlignment: MainAxisAlignment.center,
//Center Row contents horizontally,
crossAxisAlignment: CrossAxisAlignment.center 
//Center Row contents vertically,,
```
##### Convinación

Tal y como se ha explicado antes, se pueden utilizar los elementos de forma individual o también juntarlos. En el siguiente ejemplo se va a realizar la UI de un formulario que junte diferentes row , col

Para empezar, marcamos como elemento principal un column y dentro del mismo un row

```dart
body: Column(
        children: [
          Row(
            children: const [
              Text("Nombre"),
              Padding(padding: EdgeInsets.only(right: 10.0)),
              Expanded(
                  child: TextField(
                decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    hintText: 'por favor introduce tu nombre'),
              ))
            ],
          )
        ],
      ),
```

Si continuamos agregando rows, con elentos dentro, o simplemente elementos tendríamos un código como el siguiente

```dart
body: Column(
        children: [
          Row(
            children: const [
              Text("Nombre"),
              Padding(padding: EdgeInsets.only(right: 10.0)),
              Expanded(
                  child: TextField(
                decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    hintText: 'por favor introduce tu nombre'),
              ))
            ],
          ),
          Row(
            children: const [
              Text("Apellido"),
              Padding(padding: EdgeInsets.only(right: 10.0)),
              Expanded(
                  child: TextField(
                decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    hintText: 'por favor introduce tu apellido'),
              )),
            ],
          ),
          Expanded(
              child: TextField(
            decoration: InputDecoration(
                border: OutlineInputBorder(),
                hintText: 'por favor introduce tu correo'),
          ))
        ],
      ),
```

Con el siguiente resultado

[<img src="./images/rowcol1.png" width="50%"/>]


## Widgets gráficos


