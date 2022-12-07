# Índice
- [Índice](#índice)
- [Objetivos](#objetivos)
- [Contenidos](#contenidos)
- [Menús](#menús)
  - [Creación de un menu de opciones](#creación-de-un-menu-de-opciones)
  - [Configurar menu en la activity](#configurar-menu-en-la-activity)
  - [Configurar las pulsaciones dentro de un menu](#configurar-las-pulsaciones-dentro-de-un-menu)
  - [Creación de menus contextuales](#creación-de-menus-contextuales)
- [Toolbar](#toolbar)
  - [Configurar el botón home de la barra superior](#configurar-el-botón-home-de-la-barra-superior)
- [Notificaciones de barra](#notificaciones-de-barra)
  - [Crear un canal de notificaciones](#crear-un-canal-de-notificaciones)
  - [Crear y lanzar una notificación](#crear-y-lanzar-una-notificación)


# Objetivos

- Conocer el concepto de menus y sus posibilidades
- Entender la diferencia entre Toolbar y ActionBar
- Conocer como funcionan las notificaciones

# Contenidos
[Volver arriba](#índice)

Una de la parte dentro del desarrollo móvil es la de los menús ya que ofrecen la posibilidad de crear y gestionar acciones desde un mismo sitio colocado en la barra superior (de forma general) o de forma contextual desde cualquier elemento de la interfaz. Estos menús desde la version de android 3.0 se sitúan en la parte superior también llamada ActioBar, pero se pueden cambiar a un elemento llamado ToolBar la cual nos otorgará un control mucho mayor de los elementos que se pueden ejecutar. Por último, en este tema veremos las notificaciones emergentes, que aunque tienen mucho sentido cuando trabajamos con una aplicación con conexión en red, pueden ser útiles en alguno de los escenarios locales.

# Menús 
[Volver arriba](#índice)

Como ya se ha dicho los menus son las herramientas por defecto que permiten añadir funcionalidad extra en un solo sitio, siendo de primeras invisibles. Es importante saber que cada pantalla puede tener asignado un menú diferente

## Creación de un menu de opciones

Para poder trabajar con un menu de opciones, lo primero necesario es crearlos. Se puede crear programaticamente o como recurso. En este caso lo vamos a ver como recurso, ya que de esta forma el menu puede estar disponible para diferentes sitios. Para ello lo primero necesario es crear una carpeta dentro de res donde se vayan a alojar los recurso, por lo que con el botón derecho ya pulsado seleccionamos new --> android resource directory indicando como nombre menu y como tipo menu. Una vez hecho esto se crea una carpeta dentro de res con el nombre indicado. Es aquí donde se van a ubicar todos los recursos de tipo menu. Para poder crear un recurso de tipo menu, seleccionaremos con botón derecho crear un nuevo recurso de menu al cual se indicaremos el nombre, en este caso menu_principal. Esta acción crea un xml con el recurso del menu y si lo abrimos podemos tratarlo tanto gráficamente como por código. Mediante código nos encontraremos con los siguiente:

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
</menu>
```
Dentro de la etiquete menu tendremos que indicar todas las opciones que queramos que tenga nuestro menu, creando un elemento de tipo item para cada una de ellas

```xml
    <item android:title="Información"
        android:id="@+id/menu_informacion"
        />
```

El atributo title es el único obligatorio y es el que recoge el string que aparecerá asociado al elemento (puede estar declarado dentro de string.xml). Ek id es muy recomendable ya que será la forma de asociarlo a la pulsación desde la parte lógica. Además de estas opciones se pueden poner algunas adicionales: 

```xml
    <item android:title="Agregar dato"
        android:id="@+id/menu_agregar"
        android:icon="@android:drawable/ic_dialog_info"
        app:showAsAction="always"
        android:checkable="false"
        />
```

De estas opciones destacar showAsAction que permite poder indicar que la opción aparecerá como icono en la barra superior (las posibles configuraciones son always (siempre) ifRoom (solo si hay espacio) never (nunca)) y la de checkable la cual indica si la opción aparecerá como una opción con estilo RadioButton. Además de esto podemos tener submenus, para lo cual es necesario no autocerrar el item sino dejarlo abierto y meter un elemento de tipo menu dentro. Un ejemplo completo podría ser el siguiente

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <item
        android:id="@+id/menu_agregar"
        android:checkable="false"
        android:icon="@android:drawable/ic_dialog_info"
        android:title="Agregar dato"
        app:showAsAction="always" />
    <item android:title="Navegación">
        <menu>
            <item
                android:id="@+id/menu_navegacion_1"
                android:title="Ir a la pantalla 1"
                />
            <item
                android:id="@+id/menu_navegacion_2"
                android:title="Ir a la pantalla 2"
                />
        </menu>
    </item>
    <item
        android:id="@+id/menu_salir"
        android:title="Salir" />


</menu>
```

## Configurar menu en la activity

Con el recurso creado el siguiente paso sería la configuración dentro de la aplicación del mismo. Para ello existen varias posibilidades, siempre dependiendo del tipo de barra superior con el que cuente la activity. Como se ha dicho el principio, por defecto la barra con la que se cuenta es una barra de ActioBar, la cual tienen una configuración muy sencilla pero tiene una personalización muy baja. Para poder poner un menú dentro de este tipo de barras basta con sobreescribir el método onCreateOptionMenu

```java
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }
```

Este método tiene como parámetro un objeto de tipo menu, el cual es el menu que toda barra tiene, pero que solo es visible cuando se le pone algo. En el momento en el que se le pone el recurso que creamos en el punto anterior directamente aparecerá como menu de la aplicación. Para poder ponerlo, lo primero que se debe hacer es acceder al recurso mediante un objeto de tipo MenuInflater (muy similar al layout inflater que utilizamos constantemente en con binding) e indicar mediante el método inflate lo que queremos inflar (nuestro xml) y donde lo queremos poner (el menu que nos dan como parámetro)

```java
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal,menu)
        return true
    }
```
Como se pude ver en la firma del método el método debe devolver true si se quiere mostrar el menu

Más delante veremos como poder configurar los menus y sus funcionalidades dentro de un Toolbar

## Configurar las pulsaciones dentro de un menu

Para poder configurar las pulsaciones tendremos que sobreescribir el método onOptionsItemSelected

```java
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
```

Dicho método tiene como parámetro un objeto de tipo menuItem, que será el elemento seleccionado dentro del menu que previamente hemos rellenado con el método el punto anterior. Al igual que hacemos con la evaluación de la pulsación de un menu, en este caso evaluaremos el id del menuItem pulsado, para así poder decidir que acción es la que queremos ejecutar

```java
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        
        when(item.itemId){
            R.id.menu_salir->{
                // accion para el menu salir
            }
            R.id.menu_navegacion_1->{
                // accion para el menu nav1
            }
            R.id.menu_navegacion_2->{
                // accion para el menu nav2
            }
            R.id.menu_salir->{
                // accion para el menu salir
            }
        }
        
        return true
    }
```
En cada una de las acciones podemos configurar diferentes acciones, como por ejemplo salir de la aplicación, saltar diálogos, navegar a diferentes pantallas, etc...

## Creación de menus contextuales 

Los menus contextuales son aquellos que aparecen tras la pulsación larga de una vista. En ocasiones pueden ser útiles siempre y cuando cada vista esté vinculada a acciones separadas. Sin embargo su uso puede resultar confuso, ya que el usuario puede no saber de su existencia. Para poder utilizarlo, hay que tener en cuenta que cada menú contextual va asociado a una vista en concreto, y esta asociación es necesaria hacerla en el método onCreate. Imaginemos que tenemos un botón en nuestra interfaz y queremos que al pulsarlo aparezca un menú contextual con varias opciones. Lo primero que debemos hacer es tener creado el xml donde dejamos reflejado el propio menú

```xml
// menu_contextual.xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">

    <item android:title="Opcion 1"
        android:id="@+id/menu_context_1"/>

    <item android:title="Opcion 2"
        android:id="@+id/menu_context_2"/>

</menu>
```

Este archivo representa el menu, por lo que el siguiente paso es asociarlo a una vista en concreto. Para ello ejecutamos el método registerForContextMenu sobre la vista que queramos en el método onCreate

```java
registerForContextMenu(binding.botonContextual)
```
Una vez hecho esto tan solo falta por indicar que menu es el que tiene que sacar. Para ello se sobreescribe el método onCreateContextMenu, el cual recibe como parámetros el menu que será el que se muestre, la vista que ha generado la pulsación para sacar el menu y la información del mismo

```java
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        when(v!!.id){
            R.id.boton_contextual->{
                menuInflater.inflate(R.menu.menu_contextual,menu)
            }
        }
    }
```

El igual que vimos en los menus normales, utilizando el menuinflater podemos asociar el archivo que se ha creado con el menú donde se mostrará. Por último, para poder evaluar la pulsación de la opción del menú contextual se sobreescribe el método onContextItemSelected evaluando el id del menu seleccionado

```java
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_context_1->{}
            R.id.menu_context_2->{}
        }
        return true
    }
```

# Toolbar
[Volver arriba](#índice)

Todo lo explicado anteriormente es válido, pero sin embargo existe una posibilidad cada vez más utilizada que es la de sustituir la parte superior por la de Toolbar. Esto otorgará al programador muchas más posibilidades de funcionalidad además de las que ya tiene el ActionBar. En el caso de querer utilizar un elemento de tipo ToolBar lo primero necesario es quitar el ya existente, ya que sino se duplicaría en espacio. Para ello, dentro de los estilos debemos seleccionar un estilo hijo de NoActionBar

```xml
<style name="Theme.Menus" parent="Theme.MaterialComponents.DayNight.NoActionBar">
```

A partir de este momento nuestra pantalla no mostrará una parte superior. Para incluir un toolbar es necesario agregarlo como elemento gráfico (en el xml), por lo que el layout de la actividad quedará de la siguiente forma

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="?attr/colorPrimary"
        android:minHeight="?attr/actionBarSize"
        android:theme="?attr/actionBarTheme"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Pulsar"
        android:id="@+id/boton_contextual"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
    
</androidx.constraintlayout.widget.ConstraintLayout>
```

Hay que tener en cuenta que dependiendo del layout que utilicemos esta disposición puede cambiar. También es posible incluirlo dentro de un fichero separado e incrustarlo dentro del layout con la etiqueta include (para así poder reutilizarlo). Una vez hecho esto tan solo falta setear esta toolbar como elemento que actúe como parte superior. Para ello es necesario ejecutar el siguiente código

```java
setSupportActionBar(binding.toolbar)
```

Tras la ejecución de este código podremos agregar tantas características y elementos a la barra superior, ya que siempre estaremos haciendo referencia a la parte superior de la activity

```java
setSupportActionBar(binding.toolbar)
```

A partir de este momento, todos lo métodos se creación de menú y gestión de la pulsación de los elementos del menú ser realiza automáticamente, por lo que tendríamos que aplicar los métodos vistos en los puntos anteiores

## Configurar el botón home de la barra superior

Toda action bar tiene por defecto un título que viene puesto por defecto con el nombre del proyecto, un espacio reservado para el menu que hemos utilizado en el punto anterior, y un botón de home para que al ser pulsado realice una acción específica (de forma genérica es volver a la pantalla que ha sido marcada como main). Para poder activar dicho botón es necesario ejecutar el siguiente código

```java
supportActionBar?.setDisplayHomeAsUpEnabled(true)
```

La variable actionBar viene creada por defecto y apunta al action bar de la pantalla. Es necesario indicar que es posible nulo ya que en algunas ocasiones puede no estar presente si el programador la ha quitado intencionadamente. Por último, para poder evaluar su pulsación es necesario indicar un caso dentro del método onOptionsItemSelected, utilizando el id que ofrece Android para poder evaluar su pulsación

```java
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            android.R.id.home ->{
                Snackbar.make(binding.root, "Pulsado boton home", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
```

En el caso de que queramos que la acción correspondiente se la de ir a una actividad padre, es necesario marcar cual es dentro del manifest.

```xml
    <activity
        android:name=".SecondActivity"
        android:label="@string/title_activity"
        android:parentActivityName="com.example.MainActivity" />
```

Una vez hecho esto no sería necesario recoger la pulsación dentro del método onOptionsItemSelected. En el caso de querer hacerlo con pulsación, el código del caso sería el siguiente

```java
var intent = Intent(this, MainActivity::class.java)
intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
startActivity(intent)
```

# Notificaciones de barra
[Volver arriba](#índice)

Otro de los elementos que permiten gestión de la información que de inicio están ocultos, son las notificaciones de barra de estado. Estas notificaciones permiten mostrar un globo con conctenido en momentos concretos de la aplicación. Si bien es cierto que cuando trabajamos con una aplicación que tienen conexión de red este tipo de notificaciones cobran mucho más sentido, también pueden ser útiles cuando trabajamos con una aplicación local. Para poder crear este tipo de notificaciones es necesario cumplir dos pasos: crear el canal de notificaciones y crear/lanzar la propia notificación

## Crear un canal de notificaciones

Desde android 8.0 es obligatorio crear y registrar el canal de notificaciones antes de poder lanzarla. Este canal de notificaciones representa el sitio donde las notificaciones serán mostradas, por lo tanto sin su existencia es literalmente imposible utilizarlas. Para crearlas se utiliza un objeto de tipo NotificationChannel

```java
val canal = NotificationChannel("mi_canal","canal1",NotificationManager.IMPORTANCE_DEFAULT)
```

Los parámetros que admite este constructor son:
- id: nombre sobre el cual luego podremos lanzar las notificaciones
- nombre: nombre que obtendrá el canal
- nivel prioridad: para poder gestionar varios canales en el caso de que están activos al mismo tiempo

Como esto es obligatorio desde la version Android Oreo, es necesario hacer una evaluación antes de crear el canal.

```java
    fun createChannel(): Unit {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val canal = NotificationChannel("mi_canal","canal1",NotificationManager.IMPORTANCE_DEFAULT)
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(canal)
        }
    }
```
El registro se hace a traves del sistema de notificaciones del sistema operativo. Este método creado se tendrá que ejecutar en el método onCreate para que el canal esté disponible nada más arrancar la aplicación (en el caso de que así se quiera)

## Crear y lanzar una notificación

Una vez está el canal creado y activado, tan solo falta crear la notificación y lanzarla sobre el canal que se quiera. Para ello es necesario utilizar un objeto NotificationManager.Builder

```java
val notificacion =  NotificationCompat.Builder(this, "mi_canal");
```

Para poder crearla es necesario indicar el contexto y el id del canal a traves del cual se mostrará la notificación. Una vez creada se pueden utilizar numerosos métodos para configurarla, donde destacan

- setContentTitle: pone el título 
- setContentText: pone el contenido del texto 
- setSmallIcon: pone el icono 
- priority: indica la prioridad
- setContentIntent: pone la acción a realizar al pulsar la notificación. Se hace a través de un objeto de tipo pendingIntent

```java
val notificacion =  NotificationCompat.Builder(this, "mi_canal");
notificacion.setContentTitle("Notificación general")
notificacion.setContentText("Cuerpo de la notificación")
notificacion.setSmallIcon(R.drawable.challenge)
notificacion.priority = NotificationManager.IMPORTANCE_HIGH
val intent = Intent(applicationContext, MainActivity::class.java)
val pedingIntent = PendingIntent.getActivity(this, 0,intent, PendingIntent.FLAG_UPDATE_CURRENT)
notificacion.setContentIntent(pedingIntent)
```

Una vez la notificación se crea, tan solo falta lanzarla mediante un objeto de tipo NotificationManager y el método notify

```java
val notificationManager = NotificationManagerCompat.from(this)
notificationManager.notify(1,notificacion.build())
```

Los parámetros del método notify son un ID para poder gestionar varios tipos de notificaciones y la creación de la propia notificación. Un ejemplo completo de lanzamiento de notificación desde la pulsación de un elemento de menu contextuales el siguiente:

```java
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_context_1->{
                val notificacion =  NotificationCompat.Builder(this, "mi_canal");
                notificacion.setContentTitle("Notificación general")
                notificacion.setContentText("Cuerpo de la notificación")
                notificacion.setSmallIcon(R.drawable.challenge)
                notificacion.priority = NotificationManager.IMPORTANCE_HIGH
                val intent = Intent(applicationContext, MainActivity::class.java)
                val pedingIntent = PendingIntent.getActivity(this, 0,intent, PendingIntent.FLAG_UPDATE_CURRENT)
                notificacion.setContentIntent(pedingIntent)
                lanzarNotificacion(notificacion)
            }
            R.id.menu_context_2->{}
        }
        return true
    }

    fun lanzarNotificacion(notificacion: NotificationCompat.Builder): Unit {
        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(1,notificacion.build())
    }
```

