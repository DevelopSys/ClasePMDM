# Índice

- [Índice](#índice)
- [Objetivos](#objetivos)
- [Contenidos](#contenidos)
- [Fragments](#fragments)
  - [Ciclo de vida de los fragments](#ciclo-de-vida-de-los-fragments)
  - [Creación de fragments](#creación-de-fragments)
  - [Añadir un fragmento a una actividad](#añadir-un-fragmento-a-una-actividad)
    - [Fragment estáticos](#fragment-estáticos)
    - [Fragments dinámicos](#fragments-dinámicos)
  - [Transición entre fragments](#transición-entre-fragments)
    - [Gestionar el estado de la pila](#gestionar-el-estado-de-la-pila)


# Objetivos

- Conocer el concepto de fragments y los diferentes tipos
- Entender el ciclo de vida de un fragments
- Utilizar fragments, creación, modificación y remplazo
- Comunicar fragments entre activity y otros fragments
- Conocer como funcionan las notificaciones

# Contenidos
[Volver arriba](#índice)
HAsta este punto se ha visto como poder manejar pantallas dentro de una aplicación mediante Activitys comunicadas con Intents. Sin embargo este tipo de diseño imposibilita la modularidad, ya que cada elemento es individual y no tiene mucha relación con el resto más allá de los intents que puedan compartir. Desde la versión 3.0 se introduce el concepto de fragments, los cuales favorecen dicha modularidad. Podemos definir un fragment como una parte de la pantalla que puede ser reutilizada en varias sitios, teniendo un ciclo de vida propio. Una de las grandes capacidades de los fragments es el de permitir que para dispositivos grandes se puedan visualizar elementos de diferente que para dispositivos pequeños. El ejemplo más claro de esto es que una aplicación no debería verse igual en un móvil de 5 pulgadas que en una tablet de 11 pulgadas. Con los fragmentes tendremos la posibilidad de modular la pantalla y decidir que partes se muestran dependiendo del tamaño de la pantalla, siempre mostrando la misma activity pero con diferentes contenido (fragments)


# Fragments 
[Volver arriba](#índice)

Como se ha comentado antes, los fragments son elementos que permiten la modulación dentro de la pantalla. A grandes rasgos, un fragment es un elemento individual (con xml propio) que se incorpora dentro de una activity. Esta incorporación puede ser de dos tipos: estática (se declara el elemento en el xml de la pantalla) o dinámica (no se declara el elemento, sino que puede ser cambiante). Dependiendo de cual sea el uso que se quiera dar, utilizaremos uno u otro. Por ejemplo si todas las pantallas de nuestra aplicación tienen la misma cabecera, podremos crear un fragment estático para agregarlo en cada una de las pantallas

## Ciclo de vida de los fragments

Como se verá más adelante, los fragments son partes de la interfaz que tienen la capacidad de aparecer / desaparecer dependiendo de multitud de factores como pueden ser interacción con el usuario, configuraciones de la pantalla, etc... Muchos de los métodos son compartidos con las activitys, existiendo diferencia con los elementos que asocian / eliminan el fragment con la pantalla. El ciclo de vida comparado con el de las pantallas es el siguiente: 


<img src="../images/t7_ciclovida_fragments.png" alt="drawing" width="400"/>

Dentro del ciclo de vida, cabe destacar los siguientes métodos: 

- onAttach: el fragment se vincula con la actividad. Se suele utilizar para poder trabajar con el contexto, ya que es parámetro dentro del método
- onCreate: el fragmento y está asociado pero cuenta con interfaz gráfica. Se suele utilizar para poder intanciar elementos lógicos
- onCreateView: el fragmento se asocia a la parte gráfica
- onActivityCreated: el fragmento ya está disponible y empieza a ser visto

La misma metodología se produce cuando el fragment deja de ser visto. Para ello existen los métodoso onDestroyView, onDestroy, onDetach

## Creación de fragments

Los fragments, al igual que las activitys están representados por una clase separada, la cual extiende de Fragments. Al ser un elemento lógico, no es necesario declararlo en el AndroidManifest.xml, pero si es necesario que tenga una parte gráfica por lo que los elementos que forman un Fragment son:

- fragment_layout.xml: fichero que representa la parte lógica del fragment 
- MainFragment.kt: fichero que representa la parte lógica del fragment

Para poder crear uno, teniendo en cuenta las dependecias de archivos que acabamos de comentar quedaría de la siguiente forma:

```java
class BlankFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }
    
}
```
Como se puede ver en el código anterior, la clase extiende de Fragment y trae por defecto un método (el único obligatorio) que es el onCreateView (muy similar al método onCreate de las activitys). Esté método se encarga de asocias la parte lógica con la parte gráfica. Además de este método, se pueden utilizar métodos del ciclo de vida del fragment al igual que pasaba en las activtys, poniendo especial interés en el método onAttach() y onDetach(). Ambos métodos se ejecutan cuando el fragment se asocia a la parte de la pantalla que se quiere y cuando se desasocia (recordad que los fragments son partes de la pantalla que pueden aparecer y desaparecer)

## Añadir un fragmento a una actividad

Una vez el fragment está creado, es necesario agregarlo a una activity. Para ello dependeré del tipo de fragment que queramos agregar, ya que agregarlo a la pantalla no se realiza de la misma forma

### Fragment estáticos

Son aquellos que se agregan directamente al xml de la actividad sobre la cual queremos poner el elemento. Es muy importante saber que si se realiza este tipo de añadido, el fragment no se podrá modificar en tiempo de ejecución, ya que siempre aparecerá el mismo. Para poder hacer esto, primero tendremos creada una clase como la que se ha mostrado antes. El nombre de la clase es muy importante ya que será lo que utilizaremos para poder indicar el fragment que se quiere mostrar. En el xml de la activity donde se quiere agregar el fragment, se utiliza la etiqueta <fragment> indicando en el atributo name la clase del fragment que se quiere mostar

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <fragment
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:name="com.develop.t7_fragments.fragments.BlankFragment"
        />

</LinearLayout>
```

Es importante ver que dependiendo de cual sea el tamaño que se indique así se mostrará. En este ejemplo, al mostrarse con un tamaño de wrap_content en alto, ocupará lo que indique el xml asociado en el fragment. Una vez indicado esto, se agregará el fragment a la vista. Como se ha comentado antes, este tipo de fragments tiene un uso limitado, ya que es igual que utilizar una Activity como las que se han utilizado hasta este momento. Puede ser interesante para aquellos casos en que la vista se quiera reutilizar en varios sitios.

### Fragments dinámicos

En el caso de querer hacer la interfaz modulable y que se pueda ver diferente en el caso de pantallas grandes - pequeñas, horizontal - vertical, etc.... el uso de fragments estáticos limita mucho este tipo de casos. Para ello se utilizan los fragments dinámicos, que son aquellos que tienen la capacidad de aparecer y desaparecer en ejecución dentro de una misma activity. Algunas cosas que hay que tener en cuenta a la hora de trabajar con fragments dinámicos son las siguientes: 
- No hay que declararlos en el manifest, ya que son elementos gráficos que se muestran en momentos de ejecución
- Tienen una parte gráfica (.xml) y una parte lógica independiente
- Ya que son mostrados dentro de una pantalla, para poder mostrarlos con la posibilidad de hacerlos visibles o no, es necesario que la activity utilice un frame layout como base, ya que es el único que permite apilar elementos.

Para poder explicar esto, vamos hacer un ejemplo simple de como poder añadir un fragment estático a una pantalla. Para ello se cuenta con el siguiente xml de la activity

```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:id="@+id/ubicacion_fragments"
    tools:context=".MainActivity">
    

</FrameLayout>
```

En este caso tan solo se tiene un frame layout ya que solo se quieren incluir fragments en la pantalla. En el caso de querer poner más elementos como toolbar, navigation, etc... sería necesario combinar este frame layout con otros. 

Es muy importante que el frame layout tenga un id para poder acceder a el desde el código, ya que será la forma mediante la cual indicaremos en que parte se tendrá que situar el fragment. Una vez se tiene la pantalla, vamos ahora a crear un fragment. Como se ha dicho antes, estos elementos tienen tanto parte lógica como parte gráfica independiente, por lo que tendremos los siguientes ficheros:

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">


    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/texto_fragment"
        android:text="FRAGMENT INICIAL"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/boton_fragment"
        android:layout_marginTop="20dp"
        android:text="Iniciar"
        app:layout_constraintEnd_toEndOf="@+id/texto_fragment"
        app:layout_constraintStart_toStartOf="@+id/texto_fragment"
        app:layout_constraintTop_toBottomOf="@+id/texto_fragment" />


</androidx.constraintlayout.widget.ConstraintLayout>
```
Este fichero representa el aspecto gráfico que tendrá el fragment. Es importante que cada uno de los elementos tenga un id, ya que además de utilizarlo para configurar las restricciones, será el elemento a través del cual se pueda acceder en la parte lógica

```java
class FramentInicial : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate( R.layout.inicial_fragment, container, false)

    }

}
```
Este archivo representa la parte lógica. Como se pudo ver en el ciclo de vida, el método onCreteView es el método que se ejecuta cuando el fragment se asocia a una vista. Lo que devuelve el método es lo que el fragment pintará.  En el caso de utilizar el binding para hacer la asociación directa sería de la siguiente forma

```java
class FramentInicial : Fragment() {

    private lateinit var binding: InicialFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = InicialFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

}
```

Con la creación de estos dos ficheros el fragment dinámico quedaría creado. Ahora solo faltaría añadirlo a la actividad (recordad que se ha credo una activity donde el layout general es un frame layout). En los siguientes puntos veremos posibilidades de añadir, pero ahora vemos a utilizar un método genérico. Para ello vamos a utilizar un objeto nuevo: fragment manager. Este objeto es el encargado de gestionar la pila de framents, indicando cuales son los que están en ejecución y cuales son los que están en "pausa". Si recordamos del tema de los diálogos, este concepto ya lo vimos ya que es el mismo objeto el que se encarga de su funcionamiento. 

Para poder crear un objeto de tipo FragmentManager lo podemos hacer a través de la activity y en concreto el objeto supportFragmentManager. A través de este objeto podremos acceder a otro llamado FragmentTransaction, el cual permite los "movimientos" que veremos en el siguiente punto. Por lo tanto para poder poder poner el fragment dentro de la activity utilizaremos el siguiente código

```java
supportFragmentManager.beginTransaction().add(binding.ubicacionFragments.id, FramentInicial()).commit()
```

El método add lo que hace es añadir el fragment en la ubicación indicada a la pila de ejecuciones. Una vez ejecutado esto, el fragment inicial aparecerá en pantalla cargado. 

## Transición entre fragments

Si bien en el punto anterior lo que hemos hecho ha sido agregar un fragment directamente a la pila de ejecución, la tarea no es tan sencilla como el ejemplo anterior. De lo que se trata es de ser capaces de ejecutar movimientos o transiciones entre elementos de tal forma que en una determinada parte de la pantalla (la configurada como FrameLayout) los elementos aparezcan y desaparezcan en función de la actuación del usuario y/o configuraciones del dispositivo. Para poder hacer esto debemos tener en cuenta dos de los elementos nombrados en el punto anterior: 

- FragmentManager: elemento que permite la gestión de los fragments, pudiendo acceder en todo momento a la situación actual del elemento. Es importante saber que este objeto necesita de una instancia por cada vez que lo queramos utilizar, ya que en cada momento su valor cambia

- FragmentTransaction: elemento que permite el movimiento de fragments que queramos ubicar dentro del fragment manager. Para poder obtener un objeto de este tipo, préviamente es necesario obtener un objeto del tipo fragment manager

```java
supportFragmentManager.beginTransaction()
```

Una vez están claros estos conceptos, vamos a ver cuales son los métodos principales a la hora de trabajar con transiciones: 

- add: añade un fragmento a la pila de ejecución 
- remove: elimina un fragmento a la pila de ejecución
- replace: cambia el fragmento existente por otro indicado

PAra explicar la funcionalidad de cada uno de ellos, vamos a realizar un ejemplo donde con la pulsación de tres botones se irán cargando fragmentos en la pila. El xml de dicha actividad será el siguiente: 

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <Button
            android:id="@+id/boton_f1"
            android:layout_width="0dp"
            android:layout_weight="0.3"
            android:layout_height="wrap_content"
            android:text="Cargar f1" />

        <Button
            android:id="@+id/boton_f2"
            android:layout_width="0dp"
            android:layout_weight="0.3"            android:layout_height="wrap_content"
            android:text="Cargar f2" />

        <Button
            android:id="@+id/boton_f3"
            android:layout_width="0dp"
            android:layout_weight="0.3"            android:layout_height="wrap_content"
            android:text="Cargar f3" />
    </LinearLayout>

    <FrameLayout
            android:id="@+id/ubicacion_fragments"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>


</LinearLayout>
```

Para cada uno de los fragments que se cargarán con la pulsación de los botones se utilizará la misma estructura que en el caso anterior, cambiando únicamente el texto de la etiqueta del fragment

Una vez se tiene toda la estructura vamos a proceder a añadir cada fragment con la pulsación de cada botón. Para ello ejecutaremos el siguiente código

```java
class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonF1.setOnClickListener(this)
        binding.botonF2.setOnClickListener(this)
        binding.botonF3.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        var fragmentTransaction = supportFragmentManager.beginTransaction()

        when(p0!!.id){
            binding.botonF1.id ->{
                fragmentManager.add(binding.ubicacionFragments.id, FragmentInicial())
            }
            binding.botonF2.id ->{
                fragmentManager.add(binding.ubicacionFragments.id, FragmentSecond())
            }
            binding.botonF3.id ->{
                fragmentTransaction.add(binding.ubicacionFragments.id, FragmentThird())
            }
        }

        fragmentTransaction.commit();
    }
}
```
Si ejecutamos esto y pulsamos a cada uno de los botones, podemos comprobar que los fragments van apareciendo pero se ván superponeniendo unos con otros. De hecho si despues de agregar un fragment intentamos buscarlo por su tag o por su id en caso de ser estático podríamos encontrarlo

```java
Log.v("numero_fragments",supportFragmentManager.fragments.size.toString() )
```

En este caso sería bastante complicado el agregar y recuperar fragments, ya que tendríamos que estar utilizando el método remove y el método add constantemente. En el caso de querer agregar fragments pero que se sustituyan unos por otros, es muy recomendable utilizar el método replace, donde es necesario indicar el fragment que va a sustituir al actual y el sitio donde lo va a sustituir. En este caso el código anterior quedaría de la siguiente forma: 

```java
    override fun onClick(p0: View?) {
        var fragmentTransaction = supportFragmentManager.beginTransaction()

        when(p0!!.id){
            binding.botonF1.id ->{
                Log.v("test", "pulsado1")
                fragmentTransaction.replace(binding.ubicacionFragments.id, FragmentInicial())
            }
            binding.botonF2.id ->{
                Log.v("test", "pulsado2")
                fragmentTransaction.replace(binding.ubicacionFragments.id, FragmentSecond())
            }
            binding.botonF3.id ->{
                Log.v("test", "pulsado3")
                fragmentTransaction.replace(binding.ubicacionFragments.id, FragmentThird())
            }
        }

        fragmentTransaction.commit();
        Log.v("numero_fragments",supportFragmentManager.fragments.size.toString() )
    }
```

De esta forma siempre habrá un fragment cargado en la pila pero el resto no se irán superponiendo, sino lo que harán será reemplazarlo por el actual. Pero en este caso, ¿Como sería posible recuperar alguno de los fragments que ya han sido cargados previamente? Es aquí donde entra el estado de la pila

### Gestionar el estado de la pila

Hasta este punto hemos visto como poder gestionar las transiciones entre fragments, bien sea con el add o con el replace. Como se ha comentado en el caso anterior, el replace es más útil cuando los movimientos entre fragments son muy constante, siempre manteniendo uno el la pila y haciendo reemplazos constantes. Para poder gestionar estos reemplazos existe lo que se llama el estado de la pila. Al no apilar fragments, es necesario tener algún mecanismo para que en el caso de querer recuperar alguno que ya haya salido no tener que repetir la operación. Esto se controla mediante el método addToBackStack. Dicho método será ejecutado cuando se hace un reemplazo, indicando un tag para más adelante poder hacer la búsqueda para dicho estado. 

```java
    override fun onClick(p0: View?) {
        var fragmentTransaction = supportFragmentManager.beginTransaction()

        when(p0!!.id){
            binding.botonF1.id ->{
                fragmentTransaction.replace(binding.ubicacionFragments.id, FragmentInicial())
                fragmentTransaction.addToBackStack("f1_top")
            }
            binding.botonF2.id ->{
                fragmentTransaction.replace(binding.ubicacionFragments.id, FragmentSecond())
                fragmentTransaction.addToBackStack("f2_top")
            }
            binding.botonF3.id ->{
                fragmentTransaction.replace(binding.ubicacionFragments.id, FragmentThird())
                fragmentTransaction.addToBackStack("f3_top")*/
                
            }
        }

        fragmentTransaction.commit();
        Log.v("estados",supportFragmentManager.backStackEntryCount.toString() )

    }
```

En este caso, al utilizar addToBackStack, la pila irá cargando estado según se realicen pulsaciones. Por ejemplo, en el caso de querer que al pulsar un botón si el fragment ya está cargado no lo vuelva a meter en la pila, habría que buscarlo antes y dependiendo del resultado cargarlo o no en la pila

```java
binding.botonF1.id ->{
                fragmentTransaction.replace(binding.ubicacionFragments.id, FragmentInicial())

                if(supportFragmentManager.findFragmentById(binding.ubicacionFragments.id) as? FragmentInicial == null){
                    fragmentTransaction.addToBackStack("f1_top")
                }

            }
```

Con la búsqueda del fragment se obtendrá true si se encuentra dentro de la pila. En el caso de ser null se cargará dentro de la pila de estados. en caso contrario simplemente se hará un replace sin hacer ninguna carga