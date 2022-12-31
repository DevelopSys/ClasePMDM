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


# Objetivos

- Conocer las posibilidades de gestionar bases de datos en Android
- Utilizar SQLite mediante Room en una base de datos interna
- Entender el concepto de base de datos no relacional.
- Aplicar proyectos Firebase con sus correspondientes dependencias
- Utilizar RealTime DB y Colecciones
- Utilizar Autenticación de usuarios

# Contenidos
[Volver arriba](#índice)
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
data class Usuario(@PrimaryKey (autoGenerate = true) val id: Long, @ColumnInfo (name = "name") val nombre: String, val apellido: String, @ColumnInfo (name = "email") val correo: String)
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
@Database (entities = [Usuario::class], version = 1)
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

´´´java
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
´´´

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