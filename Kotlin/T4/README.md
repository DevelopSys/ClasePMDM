# Objetivos

- Comprender el concepto de las listas RecyclerView
- Crear adaptadores personalizados para el mostrado de datos
- Mostrar y manejar diferentes tipos de objetos dentro de un RecyclerView
- Manejar la pulsación de cada uno de los items de un RecyclerView

# Contenidos

Uno de los principales elementos dentro de las aplicaciones son los listados de datos. Estos permiten mostrar una gran cantidad de datos con scroll automático, lo que hace que en una sola pantalla se puedan mostrar infinidad de datos. En android son 2 las principales opciones dentro de las listas; los ListView y los RecyclerView. El primero de los elementos si bien es muy sencillo de crear y manejar no es muy optimo a la hora de manejar una cantidad grande de datos, por lo que ya no se recomienda su uso. Estos elementos han sido sustituidos por los RecyclerView, que tienen una apariencia muy similar pero que internamente funcionan mucho mejor, pudiendo representar gran cantidad de datos sin que el hardware del dispositivo se vea afectado. Es por esto que en esta unidad trataremos los RecyclerView junto con los adaptadores, y dejaremos para el final un vistazo general de los ListView.

Lo primero que tenemos que tener en cuenta es que cuando estamos hablando de RecyclerView siempre vamos a tener dos partes muy bien diferenciadas:

- El elemento RecyclerView declarado en el xml de la actividad. Este elemento no contendrá nada dentro, tan solo será una etiqueta. Es lo que denominaremos parte gráfica del listado
- El elemento adaptador, el cual estará representado por una clase kotlin y será la encargada de representar los datos y su funcionalidad. Es lo que denominaremos parte lógica o parte de datos del listado
- El aspecto que tendrán las filas, el cual estará representado por un archivo xml donde se configurará el "bruto" de las finales y que más adelante en el adaptador se podrá personalizar con una lista de datos. Este elemento también estará representado por una clase kotlin que extienda de RecyclerView.Adapter y contará con una clase anidada que servirá de "master" para las filas

# RecyclerView

Para poder mostrar el uso de los recycler vamos a realizar un ejemplo donde se mostrará una lista de lenguajes de programación con su logo y su nombre. Al pulsar en cada uno de ellos aparecerá un snackbar con la versión actual y si se pulsa ok en el snack se mostrará el detalle en otra activity

Lo primero que debemos comprobar es si el elemento RecyclerView está disponible en la parte de diseño del archivo activity_main creado. En versiones antiguas del IDE hay que importarlo como librería dentro del archivo build.gradle, sin embargo en las últimas versiones ya viene incluido en la librería de material. Por lo tanto lo que realizaremos es en el archivo activity_main.xml utilizar el elemento directamente.

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <androidx.recyclerview.widget.RecyclerView
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:id="@+id/recycler_lenguajes"
        />
</androidx.constraintlayout.widget.ConstraintLayout>
```

Al tratarse de un solo elemento no es necesario marcar más que las restricciones sobre el parent y listo. Como se puede ver el elemento tendrá el id de recycler_lenguajes.

Una vez hecho esto es necesario crear la clase que representa el tipo de objeto que se quiere representar dentro del recycler, en nuestro caso un objeto de tipo Lenguaje, el cual conste de nombre, imagen, versión y descripción. Para ello en un paquete llamado model creamos una clase kotlin llamada Lenguaje con el siguiente código en el archivo Lenguaje.kt

```java
data class Lenguaje (var nombre: String, var version: Int, var detalle: Int, var imagen: Int)
```

Como se trata de una clase que tan solo tiene datos y no es necesario tener métodos asociados se puede crear de tipo data. Con el tipo de dato creado vamos a ir a la parte lógica de la activity para poder empezar a trabajar. Lo primero que tendremos que tener es el conjunto de datos a representar. Para ello será necesario crear un ArrayList con todos los lenguajes que queramos mostrar dentro del recyclerview. Esto lo podremos hacer con el siguiente código

```java
class MainActivity : AppCompatActivity() {

    private lateinit var arrayLenguajes: ArrayList<Lenguaje>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rellenarDatos()
    }

    private fun rellenarDatos() {

        arrayLenguajes = ArrayList();
        arrayLenguajes.add(Lenguaje("Kotlin",1.7,"JetBrain",R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin",1.7,"JetBrain",R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin",1.7,"JetBrain",R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin",1.7,"JetBrain",R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin",1.7,"JetBrain",R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin",1.7,"JetBrain",R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin",1.7,"JetBrain",R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin",1.7,"JetBrain",R.drawable.kotlin))

    }
}
```

Hay que recordar que las imágenes de los logos deben estar metidas dentro de la carpeta drawable y por lo tanto son accesibles a traves de la clase R. Es por esto que la clase lenguaje el atributo imagen es de tipo Int ya que android trata a todos los recursos como números. Una ves hecho esto todos los datos estarían metidos dentro de la lista. Hay que tener en cuenta que esta lista de inicio es así, pero podría ir modificándose con la ejecución del programa e ir mostrándose de forma dinámica en la aplicación.

El siguiente paso una ves se tienen los datos que se quieren mostrar, es crear un adaptador. Este objeto actúa como intermediario entre la parte gráfica (el recyclerView que está en el MainActivity) y el conjunto de datos que se quiere representar (el array que acabamos de crear). Para ello lo primero es crear un fichero xml dentro de la carpeta res/layout con el aspecto que se quiere de cada una de las filas (sería impensable crear un fichero con todas las filas que tendrá la lista), el cual será repetido por el adaptador hasta representar todos los datos. Este fichero lo llamaremos fila_recycler y tendrá el siguiente código

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:padding="10dp"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <ImageView
        android:id="@+id/imagen_item"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:srcCompat="@tools:sample/avatars" />

    <TextView
        android:id="@+id/nombre_item"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="30sp"
        android:text="Prueba"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/imagen_item"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

Se trata de un archivo muy simple con una imagen y un texto pero es reseñable dos cosas:

1. El constraint layout tiene como configuración en alto (android:layout_height) wrap_content. Esto se debe a que el tamaño de cada fila será el que se necesite y no más. En el caso de dejarlo como match_parent cada fila ocuparía una pantalla entera
2. El constraint layout tiene un atributo de padding configurado a 10dp. Esto se debe a que es necesario que exista un espacio entre cada una de las filas del recycler. De no ponerlo todas las filas estarían juntas.

Una vez se tiene el aspecto gráfico de las filas (sin estar personalizado con los datos) el siguiente paso será crear la clase adaptador que actué como intermediario entre los datos y el listado. Para ello en un paquete llamado adapters creamos un fichero llamado AdaptadorLenguajes.kt

```java
class AdaptadorLenguajes(var contexto: Context, var listaDatos: List<*>):
    RecyclerView.Adapter<AdaptadorLenguajes.MyHolder>() {

    class MyHolder ( var view: View): RecyclerView.ViewHolder(view) {

        lateinit var nombre: TextView
        lateinit var imagen: ImageView


        init {
            nombre = view.findViewById(R.id.nombre_item)
            imagen = view.findViewById(R.id.imagen_item)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}
```

Expliquemos este archivo por partes. Lo primero que vemos es que la clase AdaptadorLenguajes pide en constructor dos elementos: el contexto donde se ejecutará (será la activity donde se va a declarar) y la lista de datos que debe mostrar.

```java
class AdaptadorLenguajes(var contexto: Context, var listaDatos: List<*>)
```

Lo siguiente que comprobamos es que para que esta clase se un adaptador válido para un recyclerView es necesario que implemente la interfaz de RecyclerView.Adapter (la cual tiene una personalización de datos con una clase anidada que actua como holder)

```java
class AdaptadorLenguajes(var contexto: Context, var listaDatos: List<*>):
    RecyclerView.Adapter<AdaptadorLenguajes.MyHolder>() {
```

Esta clase anidada que actúa como holder (o elemento en bruto) es la que permite manejar gran cantidad de datos, ya que permite "cachear" la información gráfica. Por ello esta clase extiende de ReciclerView.Holder, en constructor necesita una vista (que será el item fila creado anteriormente) y en el inicio postergado (init) inicia cada uno de los elementos de la fila

```java
    class MyHolder ( var view: View): RecyclerView.ViewHolder(view) {

        lateinit var nombre: TextView
        lateinit var imagen: ImageView


        init {
            nombre = view.findViewById(R.id.nombre_item)
            imagen = view.findViewById(R.id.imagen_item)
        }

    }
```

Por último, al haber implementado una interfaz, la clase está obligada a utilizar todos los métodos que no tienen definición que son los siguientes:

1. getItemCount(): encargado de retornar cuantos elementos se deben pintar dentro de la lista. Por defecto se retornará el tamaño de la lista pasada en constructor, ya que son los datos que se quieren representar
2. onCreateViewHolder(): es el método encargado de crear un objeto de la clase anidada, pasando por constructor la vista o xml que tendrá la fila. Este retorno será el que utilice el método siguiente para poder pintar cada uno de los objetos correspondientes.
3. onBindViewHolder(): encargado de representar en cada una de las filas obtenidas del método anterior (holder) el objeto que corresponda.

Vamos a ir rellenando cada uno de los métodos comentados.

En el primero de los casos el getItemCount es el más fácil de todos, ya que no recibe nada por parámetros y se encarga de retornar el tamaño de la lista de datos (la cual ha sido pasada por constructor)

```java
    override fun getItemCount(): Int {
        return listaDatos.size
    }
```

El segundo de los métodos recibe por parámetros un ViewGroup (que es el conjunto de vistas donde se representarán los elementos) y un viewType (por si hay diferentes tipos de vistas). Deberá retornar un objeto de la clase anidada, para lo cual necesita la vista que se creo anteriormente y para lo cual se utiliza un objeto de tipo LayoutInflater para podre obtenerla

```java
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(contexto).inflate(R.layout.fila_recycler,parent,false)
        return MyHolder(view)
    }
```

Por último, el método onBindViewHolder se encarga de juntar la parte que obtiene del método anterior con el objeto que le corresponde en la posición determinada. Es por ello que recibe un objeto de tipo Holder (del método anterior) y un Int (la posición).

```java
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var lenguaje: Lenguaje = listaDatos.get(position) as Lenguaje
        holder.imagen.setImageResource(lenguaje.imagen)
        holder.nombre.setText(lenguaje.nombre)
    }
```

Para poder crear un adaptador básico con esto sería suficiente. El código de la clase completo quedaría de la siguiente forma

```java
class AdaptadorLenguajes(var contexto: Context, var listaDatos: List<*>):
    RecyclerView.Adapter<AdaptadorLenguajes.MyHolder>() {

    class MyHolder ( var view: View): RecyclerView.ViewHolder(view) {

        lateinit var nombre: TextView
        lateinit var imagen: ImageView


        init {
            nombre = view.findViewById(R.id.nombre_item)
            imagen = view.findViewById(R.id.imagen_item)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(contexto).inflate(R.layout.fila_recycler,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var lenguaje: Lenguaje = listaDatos.get(position) as Lenguaje
        holder.imagen.setImageResource(lenguaje.imagen)
        holder.nombre.setText(lenguaje.nombre)
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

}
```

Una vez se tiene creado el adaptador, el último paso es irnos a la activity y juntar la parte gráfica (el recyclerView) con la parte de datos (adaptador). Para ello lo primero que tendremos que hacer es crear un objeto del tipo adaptador, utilizando el constructor al cual se le debe pasar un contexto y una lista (ya creada)

```java
class MainActivity : AppCompatActivity() {

    private lateinit var arrayLenguajes: ArrayList<Lenguaje>
    private lateinit var adaptadorLenguaje: AdaptadorLenguajes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rellenarDatos()
    }

    private fun rellenarDatos() {

        arrayLenguajes = ArrayList();
        arrayLenguajes.add(Lenguaje("Kotlin",1.7,"JetBrain",R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin",1.7,"JetBrain",R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin",1.7,"JetBrain",R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin",1.7,"JetBrain",R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin",1.7,"JetBrain",R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin",1.7,"JetBrain",R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin",1.7,"JetBrain",R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin",1.7,"JetBrain",R.drawable.kotlin))
        adaptadorLenguaje = AdaptadorLenguajes(this, arrayLenguajes)

    }
}
```

Por último para poder asociar adaptador con recycler se debe utilizar el método setAdapter (para indicar el adaptador) y el método setLayout (para indicar como se muestran los datos)

```java
    private fun configurarRecycler() {
        recycler.adapter = adaptadorLenguaje
        recycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }
```

El código completo de la actividad sería el siguiente

```java
class MainActivity : AppCompatActivity() {

    private lateinit var arrayLenguajes: ArrayList<Lenguaje>
    private lateinit var adaptadorLenguaje: AdaptadorLenguajes
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recycler_lenguajes)
        rellenarDatos()
        configurarRecycler()
    }

    private fun configurarRecycler() {
        recycler.adapter = adaptadorLenguaje
        recycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    private fun rellenarDatos() {

        arrayLenguajes = ArrayList();
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        adaptadorLenguaje = AdaptadorLenguajes(this, arrayLenguajes)

    }
}
```

En el ejemplo se a seteado el layout con linearlayout, indicando el contexto, que la disposición de los elements debe ser horizontal (también podría ser vertical) y que no es reversible (en el caso de indicar true el último elemento será el que se muestre el primero). Además de un linear layout que muestra las cosas en horizontal o en vertical también se podría haber configurado:

- GridLayout: única que los elementos se verán en formato cuadrícula, indicando el número de columnas que se quieren utilizar

```java
recycler.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
```

En este caso se ha indicado que se mostrarán dos columnas en formato vertical y sin ser reversible

- StaggeredGriLayout: Se trata de un layout muy parecido al anterior, con la diferencia que la cuadrícula es escalonada, es decir cada carta ocupa lo que necesita

```java
recycler.layoutManager = StaggeredGridLayoutManager(2,GridLayoutManager.VERTICAL)
```

En este caso se indica el número de columnas que se quieren utilizar y la orientación que tendrá. Otra de las cosas que se pueden configurar dentro del aspecto gráfico de un recycler es el decorador (elemento que se sitúa entre dos filas). Si no configuramos nada el decorador aparecerá en blanco, pero si se quiere utilizar uno sería necesario utilizar el método addItemDecoration

```java
recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.HORIZONTAL
            )
        )
```

Otra de las posibles configuraciones es la de animación, la cual se activará cada vez que un elemento sea agregado, eliminado, etc... Para ello se utiliza el método setItemAnimator

```java
recycler.itemAnimator = DefaultItemAnimator()
```

## Gestión de evento en un Recycler

Con todos estos pasos la aplicación queda lista para que aparezca un listado con todos los lenguajes de programación, el siguiente paso es la gestión de las pulsaciones el un elemento de la lista. Desafortunadamente los recycler no cuentan con un listener tipo onclick que recibe como parámetros la posición pulsada (del estilo del visto con los spinner), en este caso los eventos se gestionan directamente desde la clase adaptador, en concreto desde el método onBindViewHolder ya que es ahí donde se personaliza la vista y se hace realizar. Esto otorga mucha flexibilidad ya que no tiene porque ser la pulsación en toda la fila, sino en una parte concreta de la fila, por ejemplo en un botón de ver detalle. Por lo tanto si se quiere configurar que al pulsar en la imagen del lenguaje salte un snackbar se tendría que poner un escuchador al elemento ubicado en la clase AdaptadorLenguajes

```java
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var lenguaje: Lenguaje = listaDatos.get(position) as Lenguaje
        holder.imagen.setImageResource(lenguaje.imagen)
        holder.nombre.setText(lenguaje.nombre)

        holder.imagen.setOnClickListener {
            Snackbar.make(
                holder.imagen,
                "El desarrollador es ${(listaDatos.get(position) as Lenguaje).version.toString()}",
                Snackbar.LENGTH_LONG
            ).show()
        }
    }
```

En este método si se cuenta con un parámetro que indica la posición del item pulsado, por lo que se accede a la posición de lista y se saca el dato que se quiera. De esta forma se podría sacar el item pulsado de la lista, pero el dato no sale de la clase adaptador. Imaginemos ahora que se quiere tener un listener igual que el del spinner y que el dato pueda llevarse a la actividad donde está declarado el recycler. Para ello hay que seguir los siguientes pasos:

1. En el fichero adaptador (origen de los datos) es necesario crear una interfaz con un método que reciba por parámetros el dato que se quiere enviar a la activity. En este caso será OnLenguajeListener

```java
class AdaptadorLenguajes(var contexto: Context, var listaDatos: List<*>) :
    RecyclerView.Adapter<AdaptadorLenguajes.MyHolder>() {

    private lateinit var listener: OnLenguajeListener;

    inner class MyHolder(var view: View) : RecyclerView.ViewHolder(view) {

        var nombre: TextView
        var imagen: ImageView


        init {
            nombre = view.findViewById(R.id.nombre_item)
            imagen = view.findViewById(R.id.imagen_item)
            listener = contexto as OnLenguajeListener;
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View =
            LayoutInflater.from(contexto).inflate(R.layout.fila_recycler, parent, false)

        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var lenguaje: Lenguaje = listaDatos.get(position) as Lenguaje
        holder.imagen.setImageResource(lenguaje.imagen)
        holder.nombre.setText(lenguaje.nombre)
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    interface OnLenguajeListener{
        fun onLenguajeClick(lenguaje: Lenguaje)
    }
}
```

Esta interfaz representará el evento que queremos lanzar con la pulsación de la imagen. Además de esto tendremos que inicializar la variable para que no nos pueda dar un nullpointer, por lo que se hará en el método init

```java
        init {
            nombre = view.findViewById(R.id.nombre_item)
            imagen = view.findViewById(R.id.imagen_item)
            listener = contexto as OnLenguajeListener;
        }
```

Esta igualdad es posible porque en los siguientes pasos se va a implementar la interfaz en la activity, por lo que serían del mismo tipo gracias al polimorfismo

Por último antes de acabar este paso se tendría que configurar el listener en la imagen, para que cuando sea pulsada se ejecute el método de la interfaz, pasando por parámetros los datos que se quiere comunicar. Esto se puede hacer tanto en el método onBindViewHolder como en el método init

```java
class AdaptadorLenguajes(var contexto: Context, var listaDatos: List<*>) :
    RecyclerView.Adapter<AdaptadorLenguajes.MyHolder>() {

    private lateinit var listener: OnLenguajeListener;

    inner class MyHolder(var view: View) : RecyclerView.ViewHolder(view) {

        var nombre: TextView
        var imagen: ImageView


        init {
            nombre = view.findViewById(R.id.nombre_item)
            imagen = view.findViewById(R.id.imagen_item)
            listener = contexto as OnLenguajeListener;
            imagen.setOnClickListener { listener.onLenguajeClick(listaDatos.get(adapterPosition) as Lenguaje) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View =
            LayoutInflater.from(contexto).inflate(R.layout.fila_recycler, parent, false)

        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var lenguaje: Lenguaje = listaDatos.get(position) as Lenguaje
        holder.imagen.setImageResource(lenguaje.imagen)
        holder.nombre.setText(lenguaje.nombre)
        // también es posible declararlo aquí
        holder.imagen.setOnClickListener { listener.onLenguajeClick(listaDatos.get(position) as Lenguaje) }
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    interface OnLenguajeListener{
        fun onLenguajeClick(lenguaje: Lenguaje)
    }
}
```

En este caso y como es una acción muy repetitiva que no aporta nada diferente de pendiendo del lenguaje es recomendable hacerlo en el método init

2. Por último se implementa la interfaz en la activity (destino de los datos, obligando así a tener que sobreescribir el método en dicha clase y por lo tanto el item que se ha pulsado estará disponible en la clase destino

```java
class MainActivity : AppCompatActivity(), AdaptadorLenguajes.OnLenguajeListener{

    private lateinit var arrayLenguajes: ArrayList<Lenguaje>
    private lateinit var adaptadorLenguaje: AdaptadorLenguajes
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recycler_lenguajes)
        rellenarDatos()
        configurarRecycler()
        //acciones()
    }

    private fun acciones() {
        adaptadorLenguaje.onLenguajeClick = { lenguaje ->
            Log.v("prueba", lenguaje.nombre)
        }
    }

    private fun configurarRecycler() {
        recycler.adapter = adaptadorLenguaje
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        //recycler.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        //recycler.layoutManager = StaggeredGridLayoutManager(2,GridLayoutManager.VERTICAL)
        recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.HORIZONTAL
            )
        )
        recycler.itemAnimator = DefaultItemAnimator()
    }

    private fun rellenarDatos() {

        arrayLenguajes = ArrayList();
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("KotlinÚltimo", 1.7, "JetBrain", R.drawable.kotlin))
        adaptadorLenguaje = AdaptadorLenguajes(this, arrayLenguajes)

    }

    override fun onLenguajeClick(lenguaje: Lenguaje) {
        Log.v("prueba", lenguaje.nombre)

    }
}
```

Otra forma de hacerlo también es declarando una función en vez de una interfaz en el adaptador, de forma que estará disponible desde el objeto adaptador de la clase MainActivity. Para ello lo que habría que hacer es lo siguiente:

1. En el Adaptador se declara una función que se inicia como null y se le da valor en el método init

```java
class AdaptadorLenguajes(var contexto: Context, var listaDatos: List<*>) :
    RecyclerView.Adapter<AdaptadorLenguajes.MyHolder>() {

    var onLenguajeClick: ((lenguaje: Lenguaje)-> Unit)? = null

    inner class MyHolder(var view: View) : RecyclerView.ViewHolder(view) {

        var nombre: TextView
        var imagen: ImageView


        init {
            nombre = view.findViewById(R.id.nombre_item)
            imagen = view.findViewById(R.id.imagen_item)
            imagen.setOnClickListener { onLenguajeClick?.invoke(listaDatos.get(adapterPosition) as Lenguaje) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View =
            LayoutInflater.from(contexto).inflate(R.layout.fila_recycler, parent, false)

        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var lenguaje: Lenguaje = listaDatos.get(position) as Lenguaje
        holder.imagen.setImageResource(lenguaje.imagen)
        holder.nombre.setText(lenguaje.nombre)

    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    interface OnLenguajeListener{
        fun onLenguajeClick(lenguaje: Lenguaje)
    }
}
```

Como se puede ver, en la creación de la variable lenguajeClick se define que es de tipo función, recibiendo por parámetros un objeto de tipo Lenguaje y no devolviendo nada (Unit). Más adelante en el método init se configura un listener de click a la imagen y se utiliza el método invoke (ya que se ha declarado como null, recordad el nullsafaty) y se pasa como parámetro el lenguaje que está en la posición que indica el adaptador

2. Por último en el MainActivity no sería necesario implementar nada ya que no hemos creado una interfaz sino que hemos realizado una función, la cual es llamada desde otra función.

```java
class MainActivity : AppCompatActivity(){

    private lateinit var arrayLenguajes: ArrayList<Lenguaje>
    private lateinit var adaptadorLenguaje: AdaptadorLenguajes
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recycler_lenguajes)
        rellenarDatos()
        configurarRecycler()
        acciones()
    }

    private fun acciones() {
        adaptadorLenguaje.onLenguajeClick = { lenguaje ->
            Log.v("prueba", lenguaje.nombre)
        }
    }

    private fun configurarRecycler() {
        recycler.adapter = adaptadorLenguaje
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.HORIZONTAL
            )
        )
        recycler.itemAnimator = DefaultItemAnimator()
    }

    private fun rellenarDatos() {

        arrayLenguajes = ArrayList();
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        arrayLenguajes.add(Lenguaje("KotlinÚltimo", 1.7, "JetBrain", R.drawable.kotlin))
        adaptadorLenguaje = AdaptadorLenguajes(this, arrayLenguajes)

    }


}
```

Como se puede ver en el método acciones la función creada en el adaptador es llamada, teniendo como parámetros el lenguaje que ha sido seleccionado en el listado.

Con esto quedaría completada la funcionalidad básica. A continuación vamos a terminar el ejemplo inicial, el cual decía que tras la selección de un lenguaje tendría que mostrarse en otra activity el detalle del elemento seleccionado. Para ello vamos a crear otra activity llamada DetailActivity que tenga una parte gráfica como la que se muestra

![activity_detail.xml](./images/t4_listado1.png)

El código sería el siguiente

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="20dp"
    tools:context=".DetailActivity">

    <ImageView
        android:id="@+id/imagen_detalle"
        android:layout_width="250dp"
        android:layout_height="250dp"
        android:layout_marginTop="24dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/kotlin" />

    <TextView
        android:id="@+id/nombre_detalle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Nombre"
        android:textSize="30sp"
        app:layout_constraintBottom_toTopOf="@+id/version_detalle"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imagen_detalle" />

    <TextView
        android:id="@+id/version_detalle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Versión"
        android:textSize="30sp"
        app:layout_constraintBottom_toTopOf="@+id/textView3"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/nombre_detalle"
        />

    <ScrollView
        android:id="@+id/textView3"
        android:layout_width="0dp"
        android:layout_height="200dp"
        android:text="TextView"
        android:textSize="30sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/version_detalle">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:id="@+id/text_detalle"
            android:inputType="textMultiLine"
            android:textSize="20sp"
            android:text="Detalle"
            />

    </ScrollView>
</androidx.constraintlayout.widget.ConstraintLayout>
```

El siguiente punto es pasa el lenguaje entre pantallas tras la pulsación del elemento. Para ello se va a utilizar el putExtra que ya vimos en las primeras unidades, pero teniendo en cuenta que ahora vamos a pasar un objeto completo, no una serie de datos. Es por ello que antes de empezar la clase Lenguaje tiene que implementar la interfaz Serializable

```java
data class Lenguaje (var nombre: String, var version: Double, var detalle: String, var imagen: Int) : Serializable
```

A partir de este momento ya se podrá pasar el objeto entre pantallas mediante un putExtra. Para ello se va a utilizar el último método explicado en la pulsación de los recycler. Cuando un elemento se pulsado, aparecerá un snackbar con el el mensaje ¿Ver detalle? y un botón. Al pulsarlo se arrancará la segunda pantalla con los datos del lenguaje. Vayamos por partes. Lo primero será configurar en el MainActivity la pulsación del item

```java
    private fun acciones() {


        adaptadorLenguaje.onLenguajeClick = { lenguaje ->
            var snackbar: Snackbar = Snackbar.make(
                findViewById(R.id.recycler_lenguajes),
                "¿Quieres ver los dataller?",
                Snackbar.LENGTH_SHORT
            )
            snackbar.setAction("ok", View.OnClickListener { view: View ->

            })

            snackbar.show();
        }
    }
```

Como se puede ver en el ejemplo, como dentro del adaptador la pulsación del método lo que hace es invocar a la función onLenguajeClick, esta queda definida en el main activity y por lo tanto se ejecuta tal como se indique aquí, mostrando un snackbar. Recordemos que para poder mostrar un snackbar hay que indicar como primer parámetro el elemento view que ha generado la notificación. En este caso como no existe un view como tal en la activity que lo haya generado, se puede buscar uno de los elementos que está en la pantalla mediante el método findViwById y con eso valdría. Por último para lanzar el dato sería necesario ponerlo como extra dentro del intent con una clave asociada

```java
            snackbar.setAction("ok", View.OnClickListener { view: View ->
                var intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("lenguaje", lenguaje);
                startActivity(intent)
            })
```

Así se pasará a la activity DetailActivity el lenguaje que está como parámetro en la función declarara. El siguiente paso será recepcionar este objeto en la segunda pantalla. Para eso es necesario acceder a los extras del intent que ha arrancado la actividad y al método getSerializable, pasando por parámetros la clave con la que ha sido pasada el lenguaje

```java
        lenguajeRecuperado = intent.extras?.getSerializable("lenguaje") as Lenguaje;

```

Una vez hecho esto tan solo sería necesario ir accediendo a cada uno de los elementos de la interfaz y poner el dato correspondiente al lenguaje recuperado. El código completo de la actividad detalle es el siguiente:

```java
class DetailActivity : AppCompatActivity() {

    private lateinit var lenguajeRecuperado: Lenguaje;
    private lateinit var  binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        recuperarDatos()
    }

    private fun recuperarDatos() {
        lenguajeRecuperado = intent.extras?.getSerializable("lenguaje") as Lenguaje;
        binding.imagenDetalle.setImageResource(lenguajeRecuperado.imagen)
        binding.nombreDetalle.setText(lenguajeRecuperado.nombre)
        binding.versionDetalle.setText(lenguajeRecuperado.version.toString())
        binding.textDetalle.setText(lenguajeRecuperado.detalle)

    }
}
```

Hasta este punto se han cubierto todas las necesidades de creación de un recycler con la interacción de sus elementos. Ahora vamos a ver como poder modificar la lista de datos, agregando o eliminando un elemento de la lista. Para ello vamos a realizar el siguiente ejemplo: basándonos en la aplicación de los lenguajes que ya tenemos, vamos a incorporar dos funcionalidades:

1. Un botón en MainActivity que al ser pulsado agregará un lenguaje por defecto a la lista de ya existentes (y por lo tanto se agregará al recycler)
2. Que tras una pulsación larga en el nombre del lenguaje de la lista, aparezca una snackbar preguntando si queremos eliminar el lenguaje de la lista.

Lo primero que vamos hacer es incorporar un botón en MainActivity en la parte infoerior con el id button_agregar

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recycler_lenguajes"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintBottom_toTopOf="@+id/button_agregar"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button_agregar"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="Agregar"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

El siguiente paso será programar su pulsación dentro de la parte lógica

```java

class MainActivity : AppCompatActivity(), AdaptadorLenguajes.OnLenguajeListener {

    private lateinit var arrayLenguajes: ArrayList<Lenguaje>
    private lateinit var adaptadorLenguaje: AdaptadorLenguajes
    private lateinit var recycler: RecyclerView
    private lateinit var boton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recycler_lenguajes)
        boton = findViewById(R.id.button_agregar)
        rellenarDatos()
        configurarRecycler()
        acciones()
    }

    private fun acciones() {

        boton.setOnClickListener({})
        adaptadorLenguaje.onLenguajeClick = { lenguaje ->
            var snackbar: Snackbar = Snackbar.make(
                findViewById(R.id.recycler_lenguajes),
                "Quieres ver los dataller",
                Snackbar.LENGTH_SHORT
            )
            snackbar.setAction("ok", View.OnClickListener { view: View ->
                var intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("lenguaje", lenguaje);
                startActivity(intent)
            })

            snackbar.show();
        }
    }
}
```

De momento lo único que se ha hecho ha sido agregar el botón mediante el findViewById y programar su pulsación. Ahora lo que se va hacer es crear un lenguaje por defecto y agregarlo a la lista con el método add. Una vez hecho esto es muy importante ejecutar el método notifyDataSetChanged sobre el adaptador, ya que este se encarga de identificar que hay un cambio el los datos y repintar aquellos que sean necesarios

```java
        boton.setOnClickListener {
            var lenguaje: Lenguaje =
                Lenguaje("Por Defecto", 1.0, "detalle del lenguaje por defecto", 0)
            arrayLenguajes.add(lenguaje);
            adaptadorLenguaje.notifyDataSetChanged()
        }
```

Con esto sería suficiente para poder añadir elementos al recyclerview. Sin embargo el método notifyDataSetChanged es demasiado potente, ya que notifica un cambio estructural de todos los elementos. Podríamos detectar la posición del cambio e indicar al método que elemento ha cambiado, siendo esta caso el último

```java
        boton.setOnClickListener {
            var lenguaje: Lenguaje =
                Lenguaje("Por Defecto", 1.0, "detalle del lenguaje por defecto", 0)
            arrayLenguajes.add(lenguaje);
            //adaptadorLenguaje.notifyDataSetChanged()
            adaptadorLenguaje.notifyItemInserted(arrayLenguajes.size)
        }
```

En este caso se ha hecho desde la clase MainActivity, pero también se podría haber hecho un método en el adaptador y ser llamado desde la clase MainActivity

De esta forma solo notifica cambios en la posición indicada. El otro punto a trabajar es el borrado de los datos. PAra ello en el ejemplo que vamos hacer se necesita una pulsación larga en el nombre del lenguaje. Al igual que pasaba en el caso de la selección, se va a crear una función null en el adaptador que reciba una posición y luego será llamada y definida desde el MainActivity.

```java
// creación de la variable función
var onNombreLongClick: ((posicion: Int)-> Unit)? = null

```

```java
nombre.setOnLongClickListener({ view: View ->
                onNombreLongClick?.invoke(adapterPosition)
                return@setOnLongClickListener true
            })
```

El código completo del adaptador es el siguiente

```java
class AdaptadorLenguajes(var contexto: Context, var listaDatos: List<*>) :
    RecyclerView.Adapter<AdaptadorLenguajes.MyHolder>() {

    var onLenguajeClick: ((lenguaje: Lenguaje) -> Unit)? = null
    var onNombreLongClick: ((posicion: Int) -> Unit)? = null
    //private lateinit var listener: OnLenguajeListener;

    inner class MyHolder(var view: View) : RecyclerView.ViewHolder(view) {

        var nombre: TextView
        var imagen: ImageView


        init {
            nombre = view.findViewById(R.id.nombre_item)
            imagen = view.findViewById(R.id.imagen_item)
            //listener = contexto as OnLenguajeListener;
            imagen.setOnClickListener { onLenguajeClick?.invoke(listaDatos.get(adapterPosition) as Lenguaje) }
            nombre.setOnLongClickListener({ view: View ->
                onNombreLongClick?.invoke(adapterPosition)
                return@setOnLongClickListener true
            })
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View =
            LayoutInflater.from(contexto).inflate(R.layout.fila_recycler, parent, false)

        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var lenguaje: Lenguaje = listaDatos.get(position) as Lenguaje
        holder.imagen.setImageResource(lenguaje.imagen)
        holder.nombre.setText(lenguaje.nombre)
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

}
```

En este caso en el método init la pulsación larga del nombre hace una llamada al método onNombreLongClick, pasando como parámetro la posición pulsada. Es importante ver que la llamada del listener onLongClick tiene que retornar en este caso un booleano. Una vez hecho esto en el MainActivity tan solo es necesario llamar al método desde el adaptador y configurar la función onNombreLongClick, realizando el borrado del elemento de la posición indicada. Es importante que una bez se realize el borrado hay que notificar al adaptador un cambio en los datos

```java
        adaptadorLenguaje.onNombreLongClick = { posicion ->
            arrayLenguajes.removeAt(posicion)
            adaptadorLenguaje.notifyItemRemoved(posicion)
        }
```

# ListView

Como se ha dicho antes, los recyclerview son las listas que más se utilizan en android por su eficiencia a la hora de mostrar los datos. Pero también existen otro tipo de listas que también se pueden utilizar. En este caso estaríamos hablando de listas que no muestran una cantidad de datos grandes ya que su capacidad de carga no es muy buena. A diferencia de los recycler, este tipo de listas pueden mostrar datos sin necesidad de un adaptador complejo (como el que creamos en un archivo aparte). Para poder mostrar el uso de los ListView vamos a realizar el ejemplo realizado en el punto anterior. Lo primero que vamos hacer es crear una activity nueva llamado ListadoActivity, junto con un xml que tan solo tenga un objeto de tipo ListView con el id listview_lenguajes

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ListadoActivity">

    <ListView
        android:layout_width="409dp"
        android:layout_height="729dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:id="@+id/listview_lenguajes"
        />
</androidx.constraintlayout.widget.ConstraintLayout>
```

Una vez hecho esto en el archivo xml referente a la parte gráfica, en el archivo de la parte lógica vamos a crear el mismo arraylist de lenguajes del ejercicio anterior.

```java
package com.develop.listasrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.develop.listasrecycler.databinding.ActivityListadoBinding
import com.develop.listasrecycler.model.Lenguaje

class ListadoActivity : AppCompatActivity() {

    private lateinit var listaLenguajes: ArrayList<Lenguaje>
    private lateinit var binding: ActivityListadoBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadoBinding.inflate(layoutInflater)
        val view: View = binding.root;
        setContentView(view)
        rellenarDatos()

    }

    private fun rellenarDatos() {
        listaLenguajes = ArrayList();
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("KotlinÚltimo", 1.7, "JetBrain", R.drawable.kotlin))
    }
}
```

Hasta este momento la diferencia no ha sido ninguna, ya que tan solo se ha creado el arraylist y se ha rellenado con una serie de datos. La diferencia viene a la hora de asociar los datos (parte lógica) con la lista (parte gráfica). Cuando trabajamos con un recyclerview teníamos que crear un adaptador con la creación de una clase que implementase la interfaz RecyclerView.Adapter, pero en el caso del listView existe un adaptador ya creado que puede servir como base, no teniendo la necesidad de crear una clase nueva. Este adaptador es de tipo ArrayAdapter y ya lo vimos cuando el tema anterior hablamos de los spinner. PAra crearlo es necesario indicar el contexto, un layout que nos da android y la lista de datos que se quieren representar

```java

    private lateinit var binding: ActivityListadoBinding;


    private fun configurarLista() {
        adaptadorLista = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaLenguajes)
        binding.listviewLenguajes.adapter = adaptadorLista

    }
```

Si incluimos ese código en la actividad, obtendremos una lista de datos pero en cada uno de los item no aparecerá el nombre, sino que aparecerá el elemento - objeto completo por lo que no nos serviría. Para poder representarlo bien tendríamos que sobreescribir el método toString en la clase Lenguaje. Al tratarse de una clase de datos (ya que así lo representamos para poder ahorra código), el código en una clase normal debería ser el siguiente

```java
class Lenguaje (var nombre: String, var version: Double, var detalle: String, var imagen: Int) : Serializable {
    override fun toString(): String {
        return nombre
    }
}
```

Esto representará cada uno de los item distribuidos en filas. Sin embargo este tipo de adaptador no es muy personalizable, ya que tan solo se puede utilizar un item con un elemento. En código completo de la actividad es el siguiente:

```java
class ListadoActivity : AppCompatActivity() {

    private lateinit var listaLenguajes: ArrayList<Lenguaje>
    private lateinit var binding: ActivityListadoBinding;
    private lateinit var adaptadorLista: ArrayAdapter<Lenguaje>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadoBinding.inflate(layoutInflater)
        val view: View = binding.root;
        setContentView(view)
        rellenarDatos()
        configurarLista()

    }

    private fun configurarLista() {
        //adaptadorLista = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaLenguajes)
        adaptadorLista = ArrayAdapter(this,R.layout.fila_recycler, R.id.nombre_item,listaLenguajes)
        binding.listviewLenguajes.adapter = adaptadorLista

    }

    private fun rellenarDatos() {
        listaLenguajes = ArrayList();
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("KotlinÚltimo", 1.7, "JetBrain", R.drawable.kotlin))
    }
}
```

Otra de las posibilidades de creación del ArrayAdapter es la de indicar un layout creado y el id de la vista donde se colocará el elemento de la lista. Para ello lo primero será crear un layout (utilizaremos el creado anteriormente con el nombre fila_recycler)

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="10dp">

    <ImageView
        android:id="@+id/imagen_item"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:srcCompat="@tools:sample/avatars" />

    <TextView
        android:id="@+id/nombre_item"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Prueba"
        android:textSize="30sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/imagen_item"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

Con este archivo representando el elemento de la lista, el siguiente paso es crear un adaptador dentro de la actividad de tipo ArrayAdapter pero en este caso indicando contexto, layout a utilizar, id de la vista donde se pondrá el elemento y lista de datos

```java
  private fun configurarLista() {
        adaptadorLista = ArrayAdapter(this,R.layout.fila_recycler, R.id.nombre_item,listaLenguajes)
        binding.listviewLenguajes.adapter = adaptadorLista
    }
```

Sin embargo este tipo de adaptador también se queda muy corto ya que tan solo se puede poner uno de los datos. En el caso de querer hacer un adaptador personalizado, es necesario crear una clase adicional que extienda de la clase ArrayAdapter o BaseAdaper. Esta implementación obligará a escribir los siguientes métodos

- getCount: método que será el encargado de indicar el número de elementos que tendrá la lista
- getItem: método encargado de retornar el elemento de la posición indicada como parámetro
- getItemId: método encargado de retornar el id del elemento de la posición indicada como parámetro
- getView: método encargado de traer el layout que se quiera utilizar y rellenar las filas con cada uno de los datos.

Para el ejemplo de la lista de lenguajes la clase quedará de la siguiente forma

```java
class AdaptadorLenguajesLista(var lista: List<Lenguaje>, var context: Context): BaseAdapter() {

    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(p0: Int): Any {
        return lista.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong();
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View = p1?:LayoutInflater.from(context).inflate(R.layout.fila_recycler, p2,false)
        val imagen = view.findViewById<ImageView>(R.id.imagen_item);
        val nombre = view.findViewById<TextView>(R.id.nombre_item);
        imagen.setImageResource(lista.get(p0).imagen)
        nombre.setText(lista.get(p0).nombre)
        return view
    }
}
```

Una vez creado el adaptador será necesario crearlo y setearlo dentro de la activity mediante el método setAdapter

```java
class ListadoActivity : AppCompatActivity() {

    private lateinit var adaptadorLenguajesLista: AdaptadorLenguajesLista;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadoBinding.inflate(layoutInflater)
        val view: View = binding.root;
        setContentView(view)
        rellenarDatos()
        configurarLista()

    }

    private fun configurarLista() {
        adaptadorLenguajesLista = AdaptadorLenguajesLista(listaLenguajes,this)
        binding.listviewLenguajes.adapter = adaptadorLenguajesLista

    }

    private fun rellenarDatos() {
        listaLenguajes = ArrayList();
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("KotlinÚltimo", 1.7, "JetBrain", R.drawable.kotlin))
    }
}
```

## Manejo de eventos en las listas

Otra de las grandes diferencias entre las listas y los recycler es el manejo de eventos. Si recordáis cuando creamos los recycler, para que pudiésemos tratar el item pulsado era necesario declarar una función nula que más tarde era llamada desde la clase de la activity y declarada al mismo tiempo, donde obteníamos como parámetro el dato que queríamos tratar. Esto no pasa en las listas, ya que se puede hacer directamente gracias a su listener onItemCliclListener. Este recibe como parámetros la vista que ha generado el evento (en este caso la lista), la posición del item pulsado y el id del item pulsado (fijaros que son todos los datos que hemos sobreescrito cuando se ha creado el adaptador personalizado)

```java
class ListadoActivity : AppCompatActivity() {

    private lateinit var listaLenguajes: ArrayList<Lenguaje>
    private lateinit var binding: ActivityListadoBinding;
    private lateinit var adaptadorLista: ArrayAdapter<Lenguaje>
    private lateinit var adaptadorLenguajesLista: AdaptadorLenguajesLista;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadoBinding.inflate(layoutInflater)
        val view: View = binding.root;
        setContentView(view)
        rellenarDatos()
        configurarLista()
        acciones()

    }

    private fun acciones() {
        binding.listviewLenguajes.setOnItemClickListener{ parent, view, position, id ->
            Toast.makeText(
                applicationContext,
                "pulsado elemento con nombre ${listaLenguajes.get(position).nombre}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun configurarLista() {
        adaptadorLenguajesLista = AdaptadorLenguajesLista(listaLenguajes, this)
        binding.listviewLenguajes.adapter = adaptadorLenguajesLista

    }

    private fun rellenarDatos() {
        listaLenguajes = ArrayList();
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Kotlin", 1.7, "JetBrain", R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("KotlinÚltimo", 1.7, "JetBrain", R.drawable.kotlin))
    }
}
```

# Ejercicios propuestos.

1. Realiza una modificación del ejercicio anterior para incluir un formulario en la MainActivity en la parte inferior, de modo que se puedan recoger los datos, incluyendo campos para dar la posibilidad al usuario de agregar los datos al final o en una posición que se debe indicar. El botón agregar lenguaje agregará un lenguaje nuevo al recyclerview e nla posición indicada. La aplicación deberá ser configurada para verse bien tanto en vertical como en horizontal
