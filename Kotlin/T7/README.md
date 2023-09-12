# Índice

- [Índice](#índice)
- [Objetivos](#objetivos)
- [Contenidos](#contenidos)
- [Base de datos SQLite](#base-de-datos-sqlite)
  - [Configuración de dependencias.](#configuración-de-dependencias)
  - [Configuración de los elementos](#configuración-de-los-elementos)
    - [Entitys](#entitys)
    - [DAO](#dao)
    - [Database](#database)
  - [Utilización de la base de datos](#utilización-de-la-base-de-datos)
    - [Operaciones sobre la base de datos.](#operaciones-sobre-la-base-de-datos)
      - [Rellenar lista](#rellenar-lista)
    - [Entendiendo las corrutinas](#entendiendo-las-corrutinas)
- [Firebase](#firebase)
  - [Configuraciones necesarias](#configuraciones-necesarias)
  - [RealTime Database](#realtime-database)
    - [Utilizar una acceso a la base de datos](#utilizar-una-acceso-a-la-base-de-datos)
    - [Escribir nodos en la base de datos](#escribir-nodos-en-la-base-de-datos)
    - [Modificar nodos en la base de datos](#modificar-nodos-en-la-base-de-datos)
    - [Selección de datos](#selección-de-datos)
    - [Cargar datos en un recyclerview](#cargar-datos-en-un-recyclerview)


# Objetivos

- Conocer las posibilidades de gestionar bases de datos en Android
- Utilizar SQLite mediante Room en una base de datos interna
- Entender el concepto de base de datos no relacional.
- Aplicar proyectos Firebase con sus correspondientes dependencias
- Utilizar RealTime DB y Colecciones
- Utilizar Autenticación de usuarios

# Contenidos

Toda aplicación se puede diferenciar en dos grandes partes: una parte frontal donde es la que interactúa directamente con el usuario y una parte trasera que es donde se ejecuta toda la lógica de negocio. Es lo que en informática se conoce como front-end y back-end. En este caso vamos a ver como funciona el back-end de una aplicación incorporando bases de datos, de forma que todos los datos sean persistentes en la aplicación y que puedan ser utilizados una vez la aplicación se cierre. Para ello vamos a utilizar un tipo de base de datos que viene incorporada dentro de las librerías por defecto de Android: SQLite. Este motor de base de datos permite incorporar una relación de tablas donde cada una de ellas guarda un conjunto de datos que pueden ser llamados desde cualquier momento.Para su uso utilizaremos un componente llamado Room que facilita la interacción con la base de datos. 

Además de este tipo de base de datos las cuales se pueden denominar como internas (ya que se definen dentro del dispositivo), también veremos alguna que permite lanzar los datos fuera del dispositivo, permitiendo así el acceso a los datos desde diferentes puntos. Este tipo de base de datos se pueden hacer mediante servicios web o aprovechar alguno que otorga esa funcionalidad. En nuestro caso utilizaremos Firebase, servicio que además de base de datos nos permite realizar acciones de autenticación de manera muy sencilla

# Base de datos SQLite
[Volver arriba](#índice)

Para poder trabajar con base de datos SQLite existen dos posibilidades: 

- Utilización de objetos SQLIteOpenHelper y SQLite con ejecución de sentencias querys normales
- Utilización de la librería Room que mete una capa de abstracción al uso de la base de datos

En este caso utilizaremos la librería Room ya que es muy sencilla al eliminar gran parte de la complejidad de la creación y tratamiento de las tablas. 

## Configuración de dependencias. 

Lo primero que debemos hacer para poder utilizar la librería room dentro de nuestro proyecto, es indicar las dependencias dentro del fichero build.gradle. Para ello pondremos las siguientes implementaciónes 

```java
    implementation "androidx.room:room-ktx:2.4.3"
    kapt "androidx.room:room-compiler:2.4.3"
```

y aplicaremos el siguiente plugin

```java
apply plugin: 'kotlin-kapt'
```

Una vez implementada la librería necesaria, podremos utilizarla dentro dentro de nuestro proyecto. El siguiente paso es utilizar y configurar cada uno de los elementos de los que se compone la librería

## Configuración de los elementos

Gracias a que room introduce una capa de abstracción, las tareas de configuración, creación y trabajo sobre una base de datos local se reducen bastante. Pero antes de empezar a trabajar, es necesario entender muy bien cada uno de los objetos que forman parte de dicha configuración. Son los siguientes: 

- Entity: representa cada una de las tablas o entidades que se guardarán dentro de la base de datos. Están representadas por data class
- DAO: representa cada una de las acciones que se pueden realizar sobre la base de datos. Son las querys que se aplicarán sobre las tablas. Están representadas por interfaces
- RoomDatabase: La clase principal que engloba las entitys y DAO los cuales conforman la base de datos.

### Entitys

Como ya se ha definido, las entitys representan las tablas que formarán parte de la base de datos. Para poder crear una entity es necesario crear una clase con el decorador @Entity, donde en el constructor se indicará cada uno de los elementos que formarán parte de la tabla. Para poder definir estos elementos cabe destacar los siguientes configuradores:

- @PrimaryKey: define la propiedad como clave principal. Es posible poner la anotación autogenerate (boolean) para indicar que la clave sea generada automáticamente y por lo tanto autoincremental
- @ColumnInfo: define información adicional acerca de la propiedad donde se configura. En el caso de no poner un column info la columna tomará el nombre de la propiedad
- @Ignore: indica que la propiedad sobre la que se configura no será tomada en cuenta en la base de datos, y lo tanto no la guardará.
- @ForeingKey: Indica que el campo donde se configure tendrá una relación con la clave primaria de otra tabla
Un ejemplo de tabla sería el siguiente:

```java
@Entity
data class Usuario(
    @PrimaryKey (autoGenerate = true) val id: Long, @ColumnInfo (name = "name") val nombre: String, val apellido: String, @ColumnInfo (name = "email") val correo: String)
```

En el caso de querer marcar la primary key como autoincremental, es necesario marcarla fuera del constructor, ya que sino siempre la pedirá al crear un usuario

```java
@Entity
data class Usuario(
    @ColumnInfo(name = "name") val nombre: String, val apellido: String,
    @ColumnInfo(name = "email") var correo: String
) {
@PrimaryKey (autoGenerate = true) var id: Long =0;
}
```

### DAO

En este caso, los DAO representan cada una de las acciones que se pueden hacer sobre las tablas de la base de datos. Lo bueno que tiene este tipo de objetos (representados mediante interfaces) es que en muchos de los casos no es necesario escribir la sentencia, ya que la librería room se encarga de interpretarla. Como ya se ha dicho, para poder crear un DAO es necesario crear una interfaz con el decorador @DAO y tantos métodos como se consideren necesarios, donde cada uno de ellos tiene el decorador @Query con la sentencia que debe ejecutar, a excepción del @insert @delete y @update, los cuales serán explicados más adelante. Un ejemplo de DAO sería el siguiente

```java
@Dao
interface UsuarioDAO{
    @Query("Select * from Usuario")
    fun selectAll(): List<Usuarios>

    @Query("Select * from Usuario Where name = :name")
    fun getByName(name: String): List<Usuario>

    @Query("Delete from Usuario Where name = :name")
    fun deleteByName(name: String)

    @Query("Update Usuario set email= :newMail WHERE email= :oldMail")
    fun updateByEmail(oldMail: String, newMail: String)

    @Insert
    fun insert(usuario: Usuario): Long

    @Delete
    fun delete(usuario: Usuario)
}
```

En aquellas funciones donde no se define una query (como en el @insert o @delete), las operaciones se realizan sobre el id o prímary key del objeto.

### Database

Una vez se han creado tanto las entidades como las operaciones que se pueden hacer sobre ella, el siguiente paso es crear la base de datos PAra ello es necesario crear una clase abstracta que herede de RoomDatabase sobre la cual se aplica el decorador @Database, indicando las entidades que la forman, el número de versión que tiene la base de datos y los dao que se aplicarán sobre la base de datos. Un ejemplo con la clase usuario creada anteriormente sería:

```java
@Database (entities = [Usuario::class], version = 1, exportSchema = false)
abstract class UsuariosBD: RoomDatabase(){
    abstract fun usuarioDAO(): UsuarioDAO
}
```

## Utilización de la base de datos

Con todos los pasos anteriores, el sistema está preparado para crear la base de datos y realizar acciones sobre ella. Es importante antes de continuar tener muy claro que la base de datos aún no se ha creado, y que lo hará en el primer momento en el que se llame al método build que se va a explicar ahora. 

Para poder crear la base de datos, se utiliza un método companion de la librería Room llamado databaseBuilder. Este método tienen como parámetros el contexto, la clase que representa la base de datos y el nombre de la misma. En el caso de no existir la crea en la ruta local, y en el caso de encontrarla no la crea, simplemente la captura para poder utilizarla. Por último se ejecuta el método build para crear la base de datos.

```java
val database = Room.databaseBuilder(applicationContext, UsuariosBD::class.java,"usuarios.db").build()
```

Con todo esto, la variable database tiene el acceso a todos los métodos del dato a partir de las funciones que se han declarado.

```java
database.usuarioDAO().insert(Usuario(1,"Borja", "Martin", "developandsys@gmail.com"))
```

Esta forma de creación es válida, sin embargo no es la mejor. Al tratarse de un objeto complejo (abrir una base de datos requiere de mucho procesamiento), es recomendable utilizar un patrón singleton, el cual indica que en las sucesivas veces que la base de datos sea llamada, no es necesaria su carga sino que tan solo recupera una variable donde ha sido guardada

```java
@Database (entities = [Usuario::class], version = 1, exportSchema = false)
abstract class UsuariosBD: RoomDatabase(){
    abstract fun usuarioDAO(): UsuarioDAO
    companion object DatabaseBuilder{
        private var INSTANCE : UsuariosBD ? = null
        fun getInstance (context: Context): UsuariosBD {
            if (INSTANCE == null) synchronized(Usuario::class) {
                INSTANCE = buildRoomDB(context)
            }
            return INSTANCE!!
        }

        private fun buildRoomDB (contexto : Context) =
            Room.databaseBuilder (
                contexto.applicationContext, UsuariosBD::class.java, "usuarios.db"
            ).build ()
    }

}
```

Como se puede ver, este patrón crea una variable de tipo de la base de datos. La función getInstance, en el caso de ser esta variable null la creará mediante la ejecución del método buildRoomDB, el cual ejecuta el método que habíamos utilizado hasta este momento. En el caso de ser diferente de null (porque ya se haya llamado en algún momento), se devolverá la propia variable. Una vez creado este patrón, para poder obtener una instancia de la base de datos basta con llamar al método getInstance(), el cual devolverá una instancia nueva de la BD o una ya existente

```java
val database = UsuariosBD.getInstance(applicationContext)
```

Este código está bien escrito, pero sin embargo aún no funciona. En android, y en especial en kotlin hay ejecuciones que no deben hacerse en cualquier sitio ya que de hacerse sin control pueden saturar el hilo principal de ejecución. Las bases de datos y sus consultas son un ejemplo típico de esto. Para poder hacer todo de forma asíncrona y que no afecte al hilo principal existe lo que se conoce como corrutinas, las cuales permiten crear ejecuciones paralelas de forma que no afectan al resto de acciones de la aplicación. Para poder ejecutar estas corrutinas es necesario ejecutar el siguiente código

```java
val database = Room.databaseBuilder(applicationContext, UsuariosBD::class.java,"usuarios.db").build()
GlobalScope.launch(Dispatchers.IO){
                database.usuarioDAO().insert(Usuario(1,"Borja", "Martin", "developandsys@gmail.com"))
}
```
### Operaciones sobre la base de datos.

Como se ha visto en el ejemplo anterior, realizar acciones sobre la base de datos es muy sencillo, ya que tan solo es necesario hacer una llamada al DAO correspondiente y al método que se quiera ejecutar (recordad que es ahí donde se han definido las querys). Dentro de las acciones quizá la más interesante es la de rellenar una lista o spinner sobre una consulta realizada.

#### Rellenar lista

Antes de rellenar una lista, vamos a realizar la operación de consulta sobre la base de datos. Como se configuró en el DAO, el método getAll realiza la acción de SELECT *, obteniendo como resultado un conjunto de usuarios en nuestro caso

```java
    @Query("Select * from Usuario")
    fun selectAll(): List<Usuario>
```

Sabiendo esto, sería tan sencillo como llamar al método del DAO y recorrer la lista de resultados para poder mostrarlos (en este caso en un LOG)

```java
GlobalScope.launch(Dispatchers.IO){
            val database = UsuariosBD.getInstance(applicationContext)
            val lista = database.usuarioDAO().selectAll()
            lista.forEach {
                Log.v("usuario", "${it.id} ${it.nombre}")
            }
        }
```

Por lo tanto, si se quiere rellenar una lista con este resultado se podría hacer de la siguiente forma

```java
        GlobalScope.launch(Dispatchers.IO){
            val database = UsuariosBD.getInstance(applicationContext)
            val lista = database.usuarioDAO().selectAll()
            adapter = ArrayAdapter<Usuario>(applicationContext,android.R.layout.simple_list_item_1,lista)
            binding.listaUsaurios.adapter = adapter
        }
```

En el caso de querer hacerlos sobre un recycler sería necesario la creación de un adaptador y un xml que represente el aspecto de las filas

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <TextView
        android:layout_width="0dp"
        android:layout_weight="0.5"
        android:textSize="25dp"
        android:gravity="center"
        android:layout_height="wrap_content"
        android:id="@+id/id_item_fila"/>

    <TextView
        android:layout_width="0dp"
        android:layout_weight="0.5"
        android:gravity="center"
        android:textSize="25dp"
        android:layout_height="wrap_content"
        android:id="@+id/nombre_item_fila"/>

</LinearLayout>
```
El adaptador tendría el siguiente aspecto

```java
class AdaptadorRoom(var lista: List<Usuario>, val context: Context) :
    RecyclerView.Adapter<AdaptadorRoom.MyHolder>() {


    inner class MyHolder(itemView: View) : ViewHolder(itemView) {


        var texto: TextView
        var id: TextView

        init {
            texto = itemView.findViewById(R.id.nombre_item_fila)
            id = itemView.findViewById(R.id.id_item_fila)
        }

    }

    fun changeList(lista: List<Usuario>){
        this.lista = lista;
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false);
        return MyHolder(view);

    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item: Usuario = lista[position]
        holder.texto.text = item.nombre
        holder.id.text = item.id.toString()

    }

    override fun getItemCount(): Int {
        return lista.size
    }
}
```

en este caso no se ha introducido una interfaz de callback, pero sería tan sencillo como seguir los pasos de temas anteriores. Lo único algo diferente es la inclusión de un método adicional que cambia la lista existente por otra que se le pasa por parámetros. Este método se ejecutará cuando hay un filtrado por ejemplo, y se quiere representar un dato nuevo

Por último, a la hora de crear el adaptador desde la activity sería de la siguiente forma

```java
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ArrayAdapter<Usuario>
    private lateinit var adaoterRoom: AdaptadorRoom;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch(Dispatchers.IO) {
            val database = UsuariosBD.getInstance(applicationContext)
            val lista = database.usuarioDAO().selectAll()
            adaoterRoom = AdaptadorRoom(lista, applicationContext)
            binding.listaUsaurios.adapter = adaoterRoom
            binding.listaUsaurios.layoutManager =
                LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        }
    }
}
```

Por último imaginemos que tenemos una acción que agregar elementos dentro de la base de datos. Lo que se querrá es que al mismo tiempo que los agrega los muestre en la lista. Para ello utilizamos corrutinas para hacer la inserción, pero será necesario un cambio de contexto para utilizar elementos de la interfaz gráfica

```java
        binding.botonAgregar.setOnClickListener {

            GlobalScope.launch(Dispatchers.IO) {
            
                val database = UsuariosBD.getInstance(applicationContext)
                database.usuarioDAO()
                    .insert(Usuario("Borja", "Martin", "developandsys@gmail.com"))
                val lista = database.usuarioDAO().selectAll();
                withContext(Dispatchers.Main){
                    adaoterRoom.changeList(lista)
                }
            }

        }
```

El cambio de contexto se debe a que el Dispatcher Main es el encargado de realizar la actualización de la UI, por lo que no podría ser ejecutado desde el Dispatcher IO al hacer este otra tarea. 



### Entendiendo las corrutinas

Como se ha dicho en el punto anterior, las corrutinas son elementos que permiten realizar operaciones simultaneas de forma que ninguna de las dos quede congelada o saturada por la ejecución de la otra. La utilización de corrutinas permite entre otras cosas: 

- Reducir recursos del sistema al evitar la creación de grandes cantidades de hilos
- Facilitar el retorno de datos de una tarea asíncrona
- Facilitar el intercambio de datos entre tareas asíncronas

Para poder utiliza ejecutar las corrutinas y de forma genérica, kotlin nos ofrece tres posibilidades de ejecución "por defecto"

- Global Scope: utilizado para cualquier corrutina que debe continuar su ejecución mientras la aplicación esté activa. Esto quiere decir que no debe estar asociada a ningún elemento de la aplicación, como por ejemplo fragments. Para poder utilizarla es necesario lanzarla de la siguiente forma

```java
GlobalScope.launch(Dispatchers.IO){
                // acción a ejecutar en 2º plano
}
```

Como parámetros del método launch es necesario indicar un Dispatcher, el cual indica en que hilo debe ejecutarse. Por defecto cada scope tiene uno por defecto (que es el indicado en el método launch), aunque puede cambiarse con la ejecución del método whitcontext(). Los tres dispatcher que tiene kotlin configurado por defecto son los siguientes:

- Main: hilo principal de la ejecución. Es el encargado de todo el tema de interfaz gráfica y configuración de los escuchadores
- IO: hilo reservado para aquellas tareas que implican un flujo de datos de entrada / salida como puede ser manejo de base de datos, comunicaciones por red, manejo de ficheros, etc...
- Default: se trata del hilo predeterminado, reservado para tareas de cálculo potentes

```java
GlobalScope.launch(Dispatchers.Main)
GlobalScope.launch(Dispatchers.IO)
GlobalScope.launch(Dispatchers.Default)
```

En el caso de querer cambiar el hilo de ejecución es necesario llamar al método withContext

```java
val resultadoEjecucion = withContext(Dispatchers.Main){
                    // tarea a ejecutar
                }
```

-  LifeCicleScope: En este caso, la ejecución de la tarea que se realiza en paralelo tendrá vida siempre y cuando el ciclo de vida del elemento donde se ha declarado exista. Por ejemplo si se declara dentro de un fragment, cuando el ciclo de vida del fragment haya terminado, la corrutina terminará al mismo tiempo. 
-  ViewModelSCcope: En este caso, la ejecución de la corrutina está asociada al ViewModel. En el momento en el que la asociación termina, la ejecución de la corrutina queda sin efecto

En este tema vamos a ver la ejecución por defecto de GlobalScope, dejando el resto para temas posteriores.

# Firebase

Si bien una de las posibilidades es utilizar una base de datos local como la que hemos visto en el punto anterior, también es posible utilizar un servicio externo que permita las mismas características pero metiendo una capa de abstracción eliminando gran parte de la complejidad. Firebase es uno de esos servicios. 

Desarrollado por google, firebase ofrece multitud de servicios como bases de datos, almacenamiento web, autenticación, notificaciones, etc... En este punto vamos a ver como poder configurar un proyecto para que esá asociado a un servicio firebases y utilizar sus principales características. 

## Configuraciones necesarias

Antes de empezar a utilizar las características del servicio, lo primero que tenemos que hacer es tanto crear el proyecto en la plataforma web como asociarlo a nuestro proyecto de android studio. Para ello tendremos que seguir los siguientes pasos.

1. Crear el proyecto dentro de la consola de firebase. Para ello iremos a la web https://console.firebase.google.com/ iniciando sesión con nuestra cuenta de google
   1. Seleccionaremos add proyect, indicando el título que tendrá el proyecto. En mi caso firebase-develop
   2. Activaremos / desactivaremos analytics para el proyecto. Esto permitirá evaluar rendimiento y uso del proyecto.
   3. Una vez seleccionados estos elementos el proyecto quedara creado, viendo la consola general del proyecto con todas las características disponibles

![Utilización de la base de datos](./images/proyecto_overview.png)

2. Con el proyecto creado el siguiente paso es asociarlo a un proyecto android. Para ello seguimos el asistente que podemos sacar desde android studio en tools -> firebase. Los pasos que tendremos que seguir son los siguientes:
   1. Seleccionar cualquiera de los servicios. En este caso seleccionaremos RealTime Database y le daremos a get started
   2. Pulsando sobre la opción de Connect to Firebase el proyecto descargará las librerías necesarias para ello y mediante el navegador seleccionaremos el proyecto con el que queremos conectar. Este paso en realidad lo que hace es guardar un archivo llamado google-service.json en la raíz del módulo
   3. Por último queda ir seleccionando cada uno de los servicios e ir incorporando dependencias dentro del proyecto

Con todo esto, el proyecto está conectado a nuestro proyecto firebase, por lo que en los siguientes puntos veremos como poder utilizarlos.

## RealTime Database

Uno de los principales servicios de firebase es el de las bases de datos. Cuenta con dos tipos:

- RealTime Database: se trata de bases de datos en tiempo real con una estructura de nodos, por lo tanto no SQL. Es la base de datos más simple pero al mismo tiempo la más efectiva si queremos guardad una cantidad de información pequeña
- Firestore Database: se trata de de una base de datos basada en colecciones, donde cada una de esta guarda documentos con propiedades y valores individuales. Es lo más parecido a una base de datos mongo. Se utiliza cuando la cantidad de información que se quiere guardar es lo suficientemente grande

Hay que recordad que ambas bases de datos son no relacionales, por lo que la información guardada en ellas no tienen ninguna relación, a no ser que nosotros como programadores marquemos la lógica, pero siempre sin claves

Para poder utilizar el servicio de RealTime Database tenemos que primero activarlo desde la consola de Firebase. Para ello iremos a la vista general del proyecto, seleccionaremos RealTime Database y pulsamos a CreateDatabase. Pedirá ubicación del servidor donde quedará alojada la base de datos y las reglas que se aplicarán a la base de datos. Por defecto seleccionaremos test mode, aunque lo cambiaremos más adelante. Con esto nuestra base de datos quedará creada

![Utilización de la base de datos](./images/realtime_database.png)

Como se puede ver en la imagen la base de datos siempre tiene un nodo general que está configurado con una url, siendo este el nodo root. Lo que se puede hacer sobre el es crear nodos y sobre estos crear nodos adicionales donde se guardan valores

![Utilización de la base de datos](./images/nodos.png)

Como se puede ver en la imagen cada uno de los nodos está asociado a una key y a un valor, cada uno de los cuales puede ser de un tipo diferente

Una vez está habilitado el servicio de RealTime Database dentro de la consola, el siguiente paso es la habilitación dentro de nuestro proyecto android. Recordad que previamente ya habíamos conectado los proyectos mediante el asistente. Para poder hablilitar el servicio y desde el mismo asistente que en el punto anterior seleccionamos la opción de Add the realtime database to your app. Este paso lo que hará es incluir en los archivos de gradle todas las dependencias necesarias para que el servicio esté disponible. Una vez hecho esto la base de datos es accesible

Para poder explicar toda la funcionalidad vamos a utilizar un ejemplo sencillo donde utilizaremos botones para poder implementar cada una de las funcionalidades. La parte gráfica de la aplicación quedará de la siguiente manera:

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:id="@+id/linear_acciones"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <Button
            android:id="@+id/boton_agregar"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="0.33"
            android:text="Agregar " />

        <Button
            android:id="@+id/boton_modificar"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="0.33"
            android:text="Modificar " />

        <Button
            android:id="@+id/boton_buscar"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="0.33"
            android:text="Buscar " />


    </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
```

### Utilizar una acceso a la base de datos

Antes de empezar con cualquier acción sobre la base de datos, lo que se necesita es tener acceso a la misma. Para ello se utiliza el siguiente código

```java
val database = Firebase.database("https://fir-develop-2730d-default-rtdb.europe-west1.firebasedatabase.app/")
```

De esta forma la base de datos queda accesible desde el nodo general. Todas las acciones que se realicen sobre ella se produciran en el nodo root. Recordad que cada uno de los nodos tiene un par clave - valor

### Escribir nodos en la base de datos

 Para podre escribir dentro de la base de datos ya accesible, lo que se necesita es crear una referencia. Esto no es más que un puntero al nodo donde se quiere guardar el valor. Por ejemplo si queremos guardar en un nodo llamado nombre un valor determinado utilizaremos el siguiente código

 ```java
val database = Firebase.database("https://fir-develop-2730d-default-rtdb.europe-west1.firebasedatabase.app/")
val ref = database.getReference("nombre")
ref.setValue("Borja")
 ```

Una cosa muy importante es que en el caso de que el nodo no exista (como es este caso), lo crea y le asocia el valor indicado. En el caso de que el nodo exista el valor se modifica por el que se indica. En el caso de querer borrar el nodo se puede poner un valor null y esto eliminará el nodo

 ```java
val database = Firebase.database("https://fir-develop-2730d-default-rtdb.europe-west1.firebasedatabase.app/")
val ref = database.getReference("nombre")
ref.setValue(null)
 ```

 Cuando se produce la acción de guardar, los datos como se han dicho antes pueden ser muchos: Int, Double, String, [], {}. En el caso de ser una estructura compleja como un [] o un {}, firebase interpretar los datos y los agrega de la misma forma que tiene en su construcción

```java
val database = Firebase.database("https://fir-develop-2730d-default-rtdb.europe-west1.firebasedatabase.app/")
val ref = database.getReference("opciones")
val arrayList = ArrayList<String>()
arrayList.add("Opcion1")
arrayList.add("Opcion2")
arrayList.add("Opcion3")
ref.setValue(arrayList)
``` 

En el caso de querer guardad un objeto sería de la siguiente forma

```java
class Usuario (var nombre: String, var apellido: String, var correo: String, var edad: Int ){

    override fun toString(): String {
        return super.toString()
    }

}
```

Esta clase representa el objeto que se quiere guardad en la base de datos. Para poder guardarlo utilizaríamos el siguiente código

```java
val database = Firebase.database("https://fir-develop-2730d-default-rtdb.europe-west1.firebasedatabase.app/")
val ref = database.getReference("usuario")
ref.setValue(Usuario("Borja", "Martin","develop@gmail.com",38))        
```

En el caso de querer situar el elemento en otro nodo y este no exista, se crea. Para poder hacer esto utilizaríamos el método child

```java
val database = Firebase.database("https://fir-develop-2730d-default-rtdb.europe-west1.firebasedatabase.app/")
val ref = database.getReference("datos_app")
val usuario = Usuario("Borja", "Martin","develop@gmail.com",38)
val correo =usuario.correo.replace("@","_").replace(".","_")
ref.child(correo).setValue(Usuario("Borja", "Martin","develop@gmail.com",38))
```

### Modificar nodos en la base de datos

Si bien con el punto anterior podemos hacer tanto inserciones como borrados (poner el valor a null), hacer modificaciones tiene la misma metodología. En el caso de apuntar a un nodo que ya exista, el valor que se indique se sustituirá por el que esté guardado dentro de la base de datos, así en el ejemplo que teníamos del punto anterior, podríamos modificar el nodo edad simplemente apuntando a su key

````java
            ref = database.getReference("datos_app");
            ref.child("develop_gmail_com").child("edad").setValue(39);
````

### Selección de datos

Para poder hacer selecciones en firebase se utiliza una clase especial llamada Query. Aunque el nombre es común a una base de datos SQL, la sentencia no tiene nada que ver, ya que se escribe de forma totalmente diferente. Antes de hacer una query, hay que aplicar dos pasos:

- Ordenar los datos: esto permite indicar mediante que elemento los datos van a quedar ordenados. Se puede hacer por child, por key o por value
- Filtrar los datos: una vez los datos están ordenados el siguiente paso es filtrarlos, indicando alguna característica de los elementos ordenados que cumpla la condición que se desea. Los filtros que se pueden aplicar son: equal, limitToFirst, limitToLast, startAt, startAfter, endAt, endBefore

Para poder hacer ejemplos sobre búsquedas vamos a utilizar un json que guardaremos en la base de datos. Los datos que se utilizarán son los siguientes: https://github.com/annexare/Countries/blob/master/data/countries.json

![Utilización de la base de datos](./images/paises.png)

Como se puede ver en la imagen, la estructura de la base de datos tienen un nodo general que se llama países del cual penden todos. En el caso de querer buscar un país con una siglas concretas (imaginemos que las ha introducido el usuario en un edit) se utilizaría el siguiente código

````java
val database =
                Firebase.database("https://fir-develop-2730d-default-rtdb.europe-west1.firebasedatabase.app/")
                database.getReference("países").orderByChild("name").equalTo("Andorra").addListenerForSingleValueEvent(object:ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.exists()) {
                            /*for (i in snapshot.children) {
                                Log.v("pais", i.value.toString())

                            }*/
                            snapshot.
                        }
                        else {
                            Log.v("pais", "sin resultados")
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                    }
                })

// la salida sería la siguiente --> {continent=EU, capital=Andorra la Vella, languages=[ca], native=Andorra, phone=[376], name=Andorra, currency=[EUR]}

````

En este caso se ha utilizado el métpdp orderByChild, el cual obtiene un child cuyo nombre es el indicado (name) y sonre este busca aquel que tiene como valor Andorra. Una vez encontrado se evalúa el valor del nodo encontrado. Para ello mediante un objeto de tipo ValueEventListener se obtiene el DataSnapshot, que es el nodo encontrado. En el caso de querer recorrer cada uno de los nodos internos sería de la siguiente forma

````java
                database.getReference("países").orderByChild("name").equalTo("Andorra").addListenerForSingleValueEvent(object:ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.exists()) {
                            /*for (i in snapshot.children) {
                                Log.v("pais", i.value.toString())
                            }*/
                            for (i in snapshot.children){
                                for (j in i.children){
                                    Log.v("pais", j.value.toString())
                                }
                            }
                        }
                        else {
                            Log.v("pais", "sin resultados")
                        }
                    }

````

En el caso de querer cambiar el valor de alguna parte del snapshot, es necesario obtener primero su referencia

````java
            val database =
                Firebase.database("https://fir-develop-2730d-default-rtdb.europe-west1.firebasedatabase.app/")
            database.getReference("países").orderByChild("name").equalTo("Andorra")
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.exists()) {
                           for (i in snapshot.children) {
                                for (j in i.children) {
                                    if (j.key.toString() == "capital") {
                                        Log.v("pais", j.value.toString())
                                        j.ref.setValue("LA VELLA")
                                    }
                                }
                            }
                        } else {
                            Log.v("pais", "sin resultados")
                        }
                    }
````

Como se ha visto, en el caso de querer hacer una selección de datos, para poder obtener el valor es necesario acceder al value del hijo/os del snaptshot. Se ha comentado en muchas ocasiones que estos datos pueden ser de muy diferentes tipos. En concreto, si el tipo de dato que tiene un hijo representa un objeto, en vez de recuperar característica a característica y luego crear el objeto, se puede igualar directamente. En el ejemplo de los países un pais consta de los siguientes datos: 

- "name": "Andorra",
- "native": "Andorra"
- "phone": [376]
- "continent": "EU"
- "capital": "Andorra la Vella"
- "currency": ["EUR"]
- "languages": ["ca"]

Todas estas características son las que componen cada uno de los nodos, por lo que representar las propiedades del objeto que se quiere recuperar. Para poder hacerlo de golpe, primero es necesario tener una clase con las mismas características donde cada uno de los atributos está inicializado como null o como dato por defecto en caso de los Int, Double, Bool, etc...

````java
data class Pais(
    var name: String? = null,
    var native: String? = null,
    var phone: Array<String>? = null,
    var continent: String? = null,
    var currency: Array<String>? = null,
    var languages: Array<String>? = null,
)
````

Como se puede ver, la clase Pais es el punto de acceso para que Firebase pueda hacer la traducción entre el contenido del nodo y el elemento que se creará en código. Para poder obtener esta traducción, basta con ejecutar el método getValue() indicando como parámetro la clase que realizará la conversión

```` java
val database =
                Firebase.database("https://fir-develop-2730d-default-rtdb.europe-west1.firebasedatabase.app/")
            database.getReference("países").orderByChild("name").equalTo("Andorra").addListenerForSingleValueEvent(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()){
                        for (i in snapshot.children){
                            val pais = i.getValue(Pais::class.java)
                            Log.v("pais",pais?.name!!)
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
````

** En el caso de haber quitado el equalTo hubiesen salido todos los países **

### Cargar datos en un recyclerview

Para poder cargar los datos dentro de un recycler utilizando firebase tan solo tendríamos que realizar la consulta que hemos hecho en el método anterior y además ir rellenando la lista con los datos que se van obteniendo. El siguiente ejemplo muestra un recycler de todos los paises con sus respectivas capitales.

1. Crear el xml que representará el item de las filas

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.cardview.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="20dp"
    app:cardCornerRadius="10dp"
    app:cardElevation="20dp">

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:padding="10dp">

        <TextView
            android:id="@+id/textview1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginRight="20dp"
            android:text="Nombre"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:id="@+id/text_pais"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginLeft="50dp"
            android:text="TextView"
            app:layout_constraintStart_toEndOf="@+id/textview1"
            app:layout_constraintTop_toTopOf="@+id/textview1" />

        <TextView
            android:id="@+id/textview2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:text="Capital"
            app:layout_constraintStart_toStartOf="@+id/textview1"
            app:layout_constraintTop_toBottomOf="@+id/textview1" />

        <TextView
            android:id="@+id/text_capital"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="TextView"
            app:layout_constraintStart_toStartOf="@+id/text_pais"
            app:layout_constraintTop_toTopOf="@+id/textview2" />

    </androidx.constraintlayout.widget.ConstraintLayout>


</androidx.cardview.widget.CardView>
```

2. Crear un adaptador para poder ponerlo dentro del recycler. En este caso tan solo pedirá como parámetro una lista. Además de los métodos implementados tendrá un método adicional que permitirá agregar un pais de forma individual

```java
class AdapterPais(var listado: List<Pais>) : RecyclerView.Adapter<AdapterPais.MyHolder>() {

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textoPais: TextView
        var textoCapital: TextView

        init {
            textoPais = itemView.findViewById(R.id.text_pais)
            textoCapital = itemView.findViewById(R.id.text_capital)
        }
    }

    fun addaPais(pais: Pais){
        (listado as ArrayList<Pais>).add(pais)
        notifyItemInserted(listado.size -1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val pais = listado[position]
        holder.textoPais.text = pais.name
        holder.textoCapital.text = pais.capital
    }

    override fun getItemCount(): Int {
        return listado.size
    }
}
```

3. Además de poner el adaptador dentro de un recycler, cuando se hacen las consultas a los nodos es necesario además de obtener el objeto de tipo país pasárselo al adaptador mediante el método que acabamos de mencionar en el paso anterior.

```java
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterPais: AdapterPais
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapterPais = AdapterPais(ArrayList<Pais>())
        binding.recyclerPaises.adapter = adapterPais
        binding.recyclerPaises.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)


    override fun onResume() {
        super.onResume()

        val database =
            Firebase.database("https://fir-develop-2730d-default-rtdb.europe-west1.firebasedatabase.app/")
        database.getReference("países").orderByChild("name").addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (i in snapshot.children){
                        adapterPais.addaPais(i.getValue(Pais::class.java) as Pais)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}

```