# Índice

- [Índice](#índice)
- [Objetivos](#objetivos)
- [Contenidos](#contenidos)
- [Cuadros de diálogo](#cuadros-de-diálogo)
  - [Cuadros de diálogo de aviso](#cuadros-de-diálogo-de-aviso)
  - [Diálogos de confirmación](#diálogos-de-confirmación)
  - [Diálogo de selección](#diálogo-de-selección)
  - [Diálogos de selección simple y múltiple](#diálogos-de-selección-simple-y-múltiple)
    - [Selección simple](#selección-simple)
    - [Selección multiple](#selección-multiple)
  - [Diálogos personalizados](#diálogos-personalizados)
- [Comunicación en los cuadros de diálogo](#comunicación-en-los-cuadros-de-diálogo)
  - [Comunicación diálogo - activity](#comunicación-diálogo---activity)
  - [Comunicación de activity a diálogo](#comunicación-de-activity-a-diálogo)
- [Cuadro de diálogo del sistema](#cuadro-de-diálogo-del-sistema)
  - [Cuadro de diálogo de fecha](#cuadro-de-diálogo-de-fecha)
  - [Cuadro de diálogo de hora](#cuadro-de-diálogo-de-hora)
  - [Personalización de los cuadros](#personalización-de-los-cuadros)

# Objetivos

- Comprender el concepto de los ficheros y notificaciones
- Crear diálogos tanto por defecto con interfaz personalizada
- Mostrar y manejar diferentes tipos de diálogos
- Gestionar la comunicación entre elementos (activity-diálogo, diálogo-activity, diálogo-diálogo)

# Contenidos

Una de las principales formas de comunicación con el usuario dentro de las aplicaciones son los cuadros de diálogo. Estos permiten tanto mostrar al usuario información o introducir datos a la aplicación. A diferencia de las notificaciones Toast y Snackbar, los cuadro de diálogo son modales, por lo que quitan el foco a la aplicación.

Se pueden utilizar muchos tipos de cuadros de diálogo, pudiendo utilizar diálogos por defecto con elementos sencillos (cabeceras, títulos, listas botones), diálogos precargados como por ejemplo los diálogos de fechas y hora hasta diálogos que muestran una vista personalizada utilizando layouts que se crean de forma independiente.

A la hora de crear diálogos, se pueden hacer dentro de las activitys o dentro de los fragments (que empezaremos a ver en el siguiente tema). Para poder crear cuadros de diálogo utilizaremos la clase AlertDialog.Buider

# Cuadros de diálogo
[volver arriba](#índice)

Como se ha dicho, los diálogos son una forma de interactuar con el usuario, bien para dar información a modo información o para pedir algún tipo de dato. Antiguamente se utilizaban diálogos normales, pero desde la aparición de Android 4.0 se utilizan por defecto DialogFragment. Por este motivo el ciclo de vida de un diálogo es idéntico al que se explicará en el siguiente tema de la gestión de los fragments.

Antes de empezar a explicar la creación de diálogos es importante recordar los siguiente elementos:

- getSupportFragmentManager(): elemento que permite manejar los diálogos, mostrarlos y asignarles etiquetas
- DialogFragment: tipo que representa el diálogo como tal. Esta clase tiene sus propios elementos (titulo, contenido, botones) o se le puede inflar una vista propia.
- AlertDialog.Builder: Tipo que permite la creación del diálogo con todos sus elementos

Para poder hacer un ejemplo de diálogos, vamos a crear una aplicación que permita lanzar diferentes tipos. Para ello vamos a crear la siguiente interfaz:

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">


    <Button
        android:id="@+id/boton_dialogo_normal"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="24dp"
        android:layout_marginStart="24dp"
        android:text="Diálogo aviso"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"/>

    <TextView
        android:id="@+id/texto_aviso"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="@+id/boton_dialogo_normal"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/boton_dialogo_normal"
        app:layout_constraintTop_toTopOf="@+id/boton_dialogo_normal" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

Una vez creado la parte gráfica y gestionada de forma correcta, vamos crear y lanzar un cuadro de diálogo. Para ello vamos a gestionar la pulsación del botón.

```java
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones();
    }

    private fun acciones() {
        binding.botonDialogoNormal.setOnClickListener{

        }
    }
}
```

Una vez gestionada la pulsación vamos a lanzar el cuadro de diálogo. Para ello lo primero es crearlo utilizando la clase AlertDialog.Builder() el cual pide como parámetro el contexto de la aplicación, ya que un cuadro de diálogo es mostrado sobre algo:

```java
AlertDialog.Builder(applicationContext)
```

En cuanto a la forma de crearlo existen dos posibilidades:

- Crearlo en el propio código
- Crearlo en una clase independiente

Ambas posibilidades son útiles, dependiendo de cual es el uso se realizará de una forma u otra. Por ejemplo, si queremos reutilizar el diálogo lo crearemos en una clase independiente para que pueda ser llamado desde diferentes sitios sin tener que crear el mismo código n veces. No obstante el código de programación vamos a ver que es el mismo.

Dependiendo de cual sea el cuadro de diálogo que queramos crear las características que se le pondrán son diferentes. Antes de empezar a distinguir cuadros de diálogo, es necesario entender la morfología de los mismos, y en que parte pueden ir los datos. Para ello podemos ver la siguiente imagen

Para explicar esto, vamos a utilizar la creación de los cuadros de diálogo mediante clases independientes. Para ello lo primero es crear una clase kotlin la cual extienda de DialogFragment (de la clase androidx) y sobreescribimos el método onCreateDialgo. Este método del ciclo de vida del cuadro de diálogo permite crear y personalizar el cuadro de forma completa. Si nos fijamos, este método debe retornar un objeto de tiempo Dialog, el cual será construido a través del Builder

```java
class DialogoAviso: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var  builder = AlertDialog.Builder(requireContext())

        return builder.create()
    }
}
```

Una vez visto cuales son las ubicaciones donde se pueden poner las cosas en los cuadros de diálogo y su creación básica, vamos a ver los diferentes tipos

## Cuadros de diálogo de aviso
[volver arriba](#índice)

Se trata de unos cuadros de diálogo que no tienen mucha interacción con el usuario, simplemente muestran un mensaje. Para ello se utiliza el método setTitle y setMessage para indicar ambas posiciones. Para poder crear un cuadro de diálogo de este tipo, vamos a crear una clase tal y como hemos visto en el punto anterior

```java
class DialogoAviso: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return
    }
}
```

Para poder crear el cuadro de diálogo, tan solo es necesario que este método retorne un objeto de tipo diálogo. Para ello hay que instanciar el Builder a través del contexto (sitio donde se ejecuta la aplicación) y utilizar los métodos que se quieran. En este caso utilizaremos los que se comentaron anteriormente

```java
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var  builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Cuadro de aviso")
            .setMessage("Mensaje de aviso para el usuario")
            .setIcon(android.R.drawable.ic_dialog_info)
        return builder.create()
    }
```

Adicionalmente a los métodos anteriores, se ha ejecutado el método setIcon el cual pone un icono al diálogo. Una vez está creado esto y retornado el builder.create(), este cuadro de diálogo puede ser mostrado. Para ello, en la clase donde queramos utilizarlo es necesario crear un objeto de la clase y llamar al método .show(). Este método admite dos parámetros:

- SupportFragmentManager: el elemento que permite gestionar que ventanas se muestran o se ocultan. Hay que recordad que los cuadros de diálogo son fragments
- Tag: Un texto que se le asigna al cuadro para que si se quiere recuperar pueda ser llamado por esta etiqueta. En fragments esta opción es muy útil

```java
private fun acciones() {
        binding.botonDialogoNormal.setOnClickListener {
            DialogoAviso().show(supportFragmentManager,"")
        }
    }
```

Una vez hecho esto el cuadro de diálogo es mostrado, y para poder ocultarlo es necesario pulsar fuera. En el caso de querer poner un botón de confirmación podríamos hacerlo incluyendo el método setPositiveButton dentro de la clase del diálogo

```java
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var  builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Cuadro de aviso")
            .setMessage("Mensaje de aviso para el usuario")
            .setIcon(android.R.drawable.ic_dialog_info)
            .setPositiveButton("OK",null)
        return builder.create()
    }
```

Esta última parte la explicaremos en detalle en el siguiente tipo de cuadro de diálogo

**cuando se trabaja con cuadros de diálogo / fragments siempre hay que mantener una correlación con las clases que se utilizan. Siempre es necesario trabajar con android.x que ofrece clases de soporte (retrocompativilidad), por lo que se utilizará getSuppontFragmentManager en vez de FragmentManager a la hora de mostrarlos**

## Diálogos de confirmación
[volver arriba](#índice)

En el siguiente tipo de cuadro de diálogo, además de poder mostrar un mensaje, se le pide al usuario que pulse un botón para constestar a una pregunta simple. Las opciones serán: respuesta positiva, respuesta negativa o respuesta neutra.

Al igual que antes es necesario crear una clase adicional incluiyendo en el onCreateDialog los métodos de setPostiveButton setNegativeButton o setNeutralButton

```java
class DialogoConfirmacion : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(requireContext());
        builder.setTitle("Cuadro de confirmacion")
            .setMessage("Mensaje de confirmación para el usuario, ¿Confirmas la acción?")
            .setPositiveButton("OK") { dialogInterface, posicion ->
                Log.v(
                    "dialogos",
                    "Pulsado aceptar "+posicion.toString()
                )
            }.setNegativeButton("Cancelar"){ dialogInterface, posicion ->
                Log.v(
                    "dialogos",
                    "Pulsado cancelar "+posicion.toString()
                )
            }.setNeutralButton("Cancelar"){ dialogInterface, posicion ->
                Log.v(
                    "dialogos",
                    "Pulsado neutral "+posicion.toString()
                )
            }

        return builder.create()
    }
}
```

Si nos damos cuenta el código es muy similar al visto anteriormente, tan solo se ha añadido la funcionalidad de los botones. Para ello el método ha pedido dos paramentos: el texto que tendrá el boton y la función de flecha (o listener asociado) la cual admite dos parámetros: la interfaz que ha generado el evento y la posición del boton pulsado:

```java
        builder.setTitle("Cuadro de confirmacion")
            .setMessage("Mensaje de confirmación para el usuario, ¿Confirmas la acción?")
            .setPositiveButton("OK") { dialogInterface, posicion ->
                Log.v(
                    "dialogos",
                    "Pulsado aceptar "+posicion.toString()
                )
            }.setNegativeButton("Cancelar"){ dialogInterface, posicion ->
                Log.v(
                    "dialogos",
                    "Pulsado cancelar "+posicion.toString()
                )
            }.setNeutralButton("Cancelar"){ dialogInterface, posicion ->
                Log.v(
                    "dialogos",
                    "Pulsado neutral "+posicion.toString()
                )
            }

```

En el caso de querer tener más de una opción a seleccionar dentro del cuadro de diálogo, sería necesario utilizar un cuadro de diálogo de selección

## Diálogo de selección
[volver arriba](#índice)

Su construcción es muy similar a los casos anteriores, la única diferencia es que a la hora de trabajar con el builder es necesario incorporar un método nuevo que es el setItems, el cual admite un array de elementos (también objetos de los cuales cuales cogerá el método toString para representar el dato) y quitar el método setMessage ya que ambos elementos ocupan la misma posición. Esto es importante ya que luego a la hora de determinar cual ha sido el seleccionado se utilizará un parámetro que indique la posición, siendo 0 el primer elemento de la lista.

```java
class DialogoSeleccion : DialogFragment() {

    lateinit var elementos: Array<String>

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        elementos = arrayOf("Opción 1", "Opción 2", "Opción 3")

        var builder = AlertDialog.Builder(requireContext());
        builder.setTitle("Cuadro de selección")
            //.setMessage("Que opción quieres hacer")
            .setItems(elementos) { dialgoInterface, posicion ->
                 Toast.makeText(context, elementos.get(posicion), Toast.LENGTH_SHORT).show()
            }


        return builder.create()
    }
}
```

Es importante tener en cuenta que este tipo de cuadro de diálogo no necesita botón, ya que el diálogo se oculta en el momento que se realice una selección. Es posible que queramos agregarle un botón cancelar par que no tengamos necesidad de seleccionar nada, para lo cual tendríamos que agregar un boton negative sin acción en el listener

```java
setNegativeButton("Cerrar"){dialogo, posicion->null}
```

## Diálogos de selección simple y múltiple

### Selección simple
[volver arriba](#índice)

Estos dos tipos de cuadro de diálogo son muy similares. La diferencia entre ellos es el tipo de selección que se puede hacer, solo un elemento y o varios
En el caso de querer tener una selección simple utilizaremos el método setOnSingle tener una selección

```java
class DialogoSingle : DialogFragment() {

    lateinit var elementos: Array<String>

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        elementos = arrayOf("Opción 1", "Opción 2", "Opción 3")

        var builder = AlertDialog.Builder(requireContext());
        builder.setTitle("Cuadro de selección")
            //.setMessage("Que opción quieres hacer")
            .setSingleChoiceItems(elementos, -1) { dialogo, posicion ->
                run {
                    Log.v("seleccion","seleccion realizada "+ elementos[posicion])
                }
            }

        return builder.create()
    }
}
```

En este caso el método setSingleChoiceItems pide tres parámetros: el dialogo, la posición del seleccionado y la interfaz que hace de ejecución. Es importante tener en cuenta que en este tipo de cuadro de diálogo a diferencia de los anteriores, si es necesario tener un botón que permita cerrar el cuadro de diálogo (o un método dismiss() dentro de la pulsación)

```java
class DialogoSingle : DialogFragment() {

    lateinit var elementos: Array<String>
    lateinit var seleccion: String;
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        elementos = arrayOf("Opción 1", "Opció 2", "Opción 3")
        var builder = AlertDialog.Builder(requireContext());
        builder.setTitle("Cuadro de selección")
            //.setMessage("Que opción quieres hacer")
            .setSingleChoiceItems(elementos, -1) { dialogo, posicion ->
                run {
                    Log.v("seleccion", "seleccion realizada " + elementos[posicion])
                    seleccion = elementos[posicion]
                    //dismiss()
                }
            }
            .setPositiveButton("Aceptar") { dialogo, posicion->
                Toast.makeText(
                    context,
                    "Selección: " + seleccion,
                    Toast.LENGTH_SHORT
                ).show()
            }


        return builder.create()
    }
}
```

Como se puede ver, y al igual que en los casos anteriores, la gestión de la pulsación se realiza mediante un listener que trae como parámetros dos elementos: el propio diálogo y la posición del elemento seleccionado.

### Selección multiple
[volver arriba](#índice)

Muy similar al anterior, con la diferencia que el usuario podrá seleccionar más de una opción al mismo tiempo. Para ello es necesario utilizar el método setMultiChoiceItems, pasando como parámetros el conjunto de acciones, un array de booleanos que indican cual de los elementos están marcados por defecto y el listener que en este caso es OnMultiChoiceListener, el cual tiene como parámetros el diálogo, la posición del seleccionado y un booleano que indica el estado del elemento pulsado

```java
setMultiChoiceItems(elementos, null) { dialogo, posicion, boolean ->}
```

```java
class DialogoMulti : DialogFragment() {

    lateinit var elementos: Array<String>
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        elementos = arrayOf("Opción 1", "Opció 2", "Opción 3")
        var builder = AlertDialog.Builder(requireContext());
        builder.setTitle("Cuadro de selección")
            //.setMessage("Que opción quieres hacer")
            .setMultiChoiceItems(elementos, null) { dialogo, posicion, boolean ->
                run {
                    Log.v("multiple","Posición seleccionada: ${posicion.toString()}")
                    Log.v("multiple","Valor del seleccionado: ${boolean}")
                }
            }
            .setPositiveButton("Aceptar") { dialogo, posicion ->
               null
            }


        return builder.create()
    }
}
```

Al igual que pasa en el caso del diálogo de selección simple, es necesario (y en este caso con más sentido) que añadamos un botón aceptar y/o cancelar para cerrar el cuadro de diálogo con el resultado del mismo

```java
class DialogoMulti : DialogFragment() {

    lateinit var elementos: Array<String>
    lateinit var elementosSeleccionados: ArrayList<String>

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        elementosSeleccionados = ArrayList();
        elementos = arrayOf("Opción 1", "Opción 2", "Opción 3")
        var builder = AlertDialog.Builder(requireContext());
        builder.setTitle("Cuadro de selección")
            //.setMessage("Que opción quieres hacer")
            .setMultiChoiceItems(elementos, null) { dialogo, posicion, boolean ->
                run {
                    Log.v("multiple", "Posición seleccionada: ${posicion.toString()}")
                    Log.v("multiple", "Valor del seleccionado: ${boolean}")
                    if (boolean) {
                        elementosSeleccionados.add(elementos[posicion])
                    } else {
                        elementosSeleccionados.remove(elementos[posicion])
                    }
                }
            }
            .setPositiveButton("Aceptar") { dialogo, posicion ->
                run {
                    Log.v(
                        "multiple",
                        "Selección finalizada ${elementosSeleccionados.size.toString()}"
                    )
                    elementosSeleccionados.forEach {Log.v("multiple","$it") }
                }
            }


        return builder.create()
    }
}
```

En este ejemplo, cada vez que un elemento es pulsado y el valor que se captura es un true, el elemento se mete dentro de un ArrayList previamente instanciado. En el caso de capturar un false se elimina del array. Cuando se pulsa el botón de confirmar se muestra el tamaño del mismo y sus elementos

Hasta este punto se han visto todos los cuadros de diálogo que tienen una creación por defecto. Sin embargo hay ocasiones donde no basta con las posibilidades que me dá el sistema operativo, sino que se necesita construir un cuadro de diálogo personalizado, con una vista propia. Para ello y tal y como se verá en el siguiente punto, es necesario crear un archivo xml nuevo que represente la vista y asociarlo a la clase del diálogo.

## Diálogos personalizados
[volver arriba](#índice)

Como se acaba de comentar, hay ocasiones en los que el programador necesita realizar un cuadro de diálogo que se sale de lo estándar, por lo que se necesita una vista especial. Aquí es donde entran los cuadros de diálogo personalizados. Lo primero que es necesario para poder tener un cuadro de diálogo personalizado es la creación de la vista, por lo que se creará un archivo xml con la vista que se quiera utilizar:

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:padding="50dp"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:srcCompat="@tools:sample/avatars" />

    <EditText
        android:hint="Introduce correo de usuario"
        android:layout_marginTop="20dp"
        android:id="@+id/edit_nombre"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="textEmailAddress"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageView" />

    <EditText
        android:hint="Introduce pass de usuario"
        android:layout_marginTop="10dp"
        android:id="@+id/edit_password"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="textPassword"
        app:layout_constraintEnd_toEndOf="@+id/edit_nombre"
        app:layout_constraintStart_toStartOf="@+id/edit_nombre"
        app:layout_constraintTop_toBottomOf="@+id/edit_nombre" />

    <CheckBox
        android:id="@+id/checkBox"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Recordar sesión"
        app:layout_constraintEnd_toEndOf="@+id/edit_password"
        app:layout_constraintTop_toBottomOf="@+id/edit_password" />

    <Button
        android:layout_marginTop="20dp"
        android:id="@+id/button_login"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="LogIn"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/checkBox" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:text="Recordar pass"
        app:layout_constraintEnd_toEndOf="@+id/edit_password"
        app:layout_constraintTop_toBottomOf="@+id/button_login" />

    <TextView
        android:layout_marginTop="20dp"
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Crear cuenta"
        app:layout_constraintStart_toStartOf="@+id/edit_password"
        app:layout_constraintTop_toBottomOf="@+id/button_login" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

Esta vista representa el típico cuadro de diálogo de login. Una vez se tiene la parte gráfica, es necesario crear la parte lógica. En este caso la parte lógica es manejada desde el cuadro de diálogo, por lo que lo primero necesario será asociar ambas partes. Para ello, en una clase que haya extendido de DialogFragment traemos el xml que se ha creado mediante un objeto de tipo LayoutInflater. Este tipo de objetos permite manejar ficheros de tipo layout e incorporarlos dentro de las clases. Esta clase tiene un método estático from() el cual pide un contexto (ya que no se puede crear un cuadro de diálogo de la nada), para lo que es muy útil el método onAttach (primer método del ciclo de vida del diálogo)

```java
class DialogoPerso : DialogFragment() {

    lateinit var vista: View;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialog_perso,null);
    }
}
```

Con el elemento layout traído al código, el siguiente paso es el de ponerlo dentro del diálogo. Para ello se utiliza el método setView dentro del builder que hemos usado en los casos anteriores

```java
class DialogoPerso : DialogFragment() {

    lateinit var vista: View;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialog_perso,null);
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(requireContext())
        builder.setView(vista)
        return builder.create()

    }
}
```

Con esto ya sería suficiente y la vista sería mostrada cuando el cuadro de diálogo sea llamado. El siguiente punto es el recuperar los datos que se metan en los campos o simplemente trabajar con la pulsación del botón. Para ello es necesario instanciar cada uno de los elementos (o utilizar viewBinding). Para ello es necesario utilizar el método findViewById pero no sobre this (que es el diálogo), sino sobre view que es el objeto donde se ha guardado el xml y por lo tanto tiene todos los elementos. Una vez instanciados se puede hacer con ellos lo que se quiera

```java

class DialogoPerso : DialogFragment() {

    private lateinit var vista: View;
    private lateinit var botonLog: Button;
    private lateinit var editNombre: EditText;
    private lateinit var editPass: EditText;


    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialog_perso, null);
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(requireContext())
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        editNombre = vista.findViewById(R.id.edit_nombre);
        editPass = vista.findViewById(R.id.edit_password);
        botonLog = vista.findViewById(R.id.button_login);
    }

    override fun onResume() {
        super.onResume()
        botonLog.setOnClickListener {
            run {
                Log.v("perso", editNombre.text.toString())
                Log.v("perso",editPass.text.toString())
                dismiss()
            }
        }
    }
}
```

# Comunicación en los cuadros de diálogo
[volver arriba](#índice)

En todos los ejemplos que se han mostrado anteriormente, no ha sido necesario ejecutar tareas pesadas o complejas pero imaginemos que se quiere arrancar una tarea con la constestación de un cuadro de diálogo. Para ello es necesario hacer una comunicación bien sea desde el cuadro de diálogo hasta la pantalla o desde la pantalla hasta el cuadro de diálogo. Esto es lo que se conoce como interfaces de callback o también existe la posibilidad de crear funciones posible nulas. Vamos a ver ambas posibilidades.

## Comunicación diálogo - activity
[volver arriba](#índice)

Para poder ilustrar este ejemplo vamos a coger el cuadro de diálogo personalizado. Este será lanzado desde la pulsación de un botón que se ubica en una activity, por lo que es necesario programar su pulsación

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">


    <Button
        android:id="@+id/boton_dialogo_perso"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="24dp"
        android:layout_marginStart="24dp"
        android:text="Diálogo login"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"


        />

    <TextView
        android:id="@+id/texto_perso"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="@+id/boton_dialogo_perso"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/boton_dialogo_perso"
        app:layout_constraintTop_toTopOf="@+id/boton_dialogo_perso" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

```java
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones();
    }

    private fun acciones() {
        binding.botonDialogoPerso.setOnClickListener {

            DialogoPerso().show(supportFragmentManager,"")
        }
    }
}
```

Con este código el cuadro de diálogo es mostrado. Ahora lo que se quiere es, una vez introducidos los datos dentro del cuadro de diálogo, que estos (nombre y pass) sean enviados de vuelta a la activity para allí gestionarlos. Esto se puede hacer de dos formas

- Comunicación mediante interfaces de callback

Por definición, una interfaz es una clase abstracta que tiene un conjunto de métodos que no están implementados. Si nos ceñimos a esta definición una interfaz sirve para que sea implementada en diferentes clases y así poder juntar tipos que inicialmente no tienen nada que ver. Además de esta funcionalidad, las interfaces también sirven para ser ejecutadas desde un sitio (donde se implementan) y llamadas desde otro donde se declaran. Precisamente esto es lo que permite comunicar un diálogo con una interfaz. Vayamos por pasos:

1. Crear una interfaz en el origen de los datos: en aquella clase donde tengamos los datos que queremos comunicar se declara una interfaz con los métodos que se necesiten. Es obvio que tendrá un método cuyos parámetros sean aquellos datos que se quieren comunicar. En este caso esta interfaz será creada en el diálogo, yaq ue es allí donde está el nombre y pass que se quieren comunicar a la activity

```java
class DialogoPerso : DialogFragment() {

    private lateinit var vista: View;
    private lateinit var botonLog: Button;
    private lateinit var editNombre: EditText;
    private lateinit var editPass: EditText;


    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialog_perso, null);
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(requireContext())
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        editNombre = vista.findViewById(R.id.edit_nombre);
        editPass = vista.findViewById(R.id.edit_password);
        botonLog = vista.findViewById(R.id.button_login);
    }

    override fun onResume() {
        super.onResume()
        botonLog.setOnClickListener {

        }
    }

    interface OnLoginListener{
        fun onLoginDataSelected(nombre: String, pass: String)
    }
}
```

2. Una vez está creada la interfaz, es momento de utilizarla. En este caso se utilizará con la pulsación del botón, por lo que se necesita un objeto del tipo de la interfaz en la clase para llamar al método onLoginDataSelected con los parametros que se quieren comunicar. Es necesario declarar esta variable como lateinit porque no se puede inicializar tal cual

```java
class DialogoPerso : DialogFragment() {

    private lateinit var vista: View;
    private lateinit var botonLog: Button;
    private lateinit var editNombre: EditText;
    private lateinit var editPass: EditText;
    private lateinit var listener: OnLoginListener;


    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialog_perso, null);
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(requireContext())
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        editNombre = vista.findViewById(R.id.edit_nombre);
        editPass = vista.findViewById(R.id.edit_password);
        botonLog = vista.findViewById(R.id.button_login);
    }

    override fun onResume() {
        super.onResume()
        botonLog.setOnClickListener {
            listener.onLoginDataSelected(editNombre.text.toString(), editPass.text.toString())
            dismiss()
        }
    }

    interface OnLoginListener{
        fun onLoginDataSelected(nombre: String, pass: String)
    }
}
```

La variable listener es utilizada cuando se pulsa el botón, por lo que como última configuración antes de pasar al siguiente paso es la de instanciar la variable ya que ahora mismo tiene un valor de null. Para poder instanciarla hay que igualarla a algo que sea de tipo OnLoginListener y no sería nada útil hacerlo sobre ella misma

```java
listener = object : OnLoginListener {
            override fun onLoginDataSelected(nombre: String, pass: String) {

            }
        }
```

De esta forma no conseguimos nada ya que los datos no se mueven de la clase donde está declarada la interfaz. Lo que tenemos que hacer es igualarla al contexto dentro del método onAttach() haciendo un casting.

```java
    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialog_perso, null);
        listener = context as OnLoginListener;
        }
    }
```

De esta forma dejamos a la variable preparada para el último paso. Si recordamos de casos anteriores, hemos dicho siempre que el contexto es el ámbito o sitio donde se ejecutan las cosas, por lo que en este caso el contexto es el MainActivity o desde donde se haya sacado el diálogo. Una vez visto esto, ¿como podemos hacer que MainActivity sea también de tipo OnLoginListener? Muy sencillo

3. La respuesta a la pregunta es muy fácil: implementando la interfaz. Con la implementación de la interfaz en el destino de los datos conseguimos que la igualdad que se ha hecho antes en el método onAttach siempre sea verdadera. No solo eso, sino que esta implementación obliga a escribir el método de la interfaz el cual tiene los dos parámetros que son los datos que queremos comunicar desde el diálogo hasta la pantalla

```java
class MainActivity : AppCompatActivity(), DialogoPerso.OnLoginListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones();
    }

    private fun acciones() {
        binding.botonDialogoPerso.setOnClickListener {

            DialogoPerso().show(supportFragmentManager,"")
        }
    }

    override fun onLoginDataSelected(nombre: String, pass: String) {
        TODO("Not yet implemented")
    }
}
```

Por último tan solo quedaría por utilizar los datos que vienen como parámetros y tendremos la comunicación terminada

- Comunicación mediante funciones null

En el caso de no querer utilizar una interfaz de callback, existe la posibilidad de utilizar funciones nulas, ya que kotlin ofrece dicha funcionalidad. En realidad es un proceso muy parecido al que hemos descrito en el punto anterior, ya que el fondo es exactamente igual. Para poder hacer un ejemplo de esto vamos a realizarlo sobre el dialogo de selección multiple, donde al dar al botón de aceptar queremos llevar los datos al la pantalla de origen. Para ello es necesario seguir los siguientes pasos:

1. En el origen de los datos, declaramos una variable de tipo función, la cual admite como parámetros aquellos datos que queremos comunicar. En este caso seré el array de elementos que se vá llenando con la pulsación de cada opción tal y como vimos en los puntos anteriores

```java
    lateinit var funcionComunicar: ((ArrayList<String>)->Unit)? = null
```

Evidentemente esta función es nula, ya que no es aquí donde la queremos definir pero si es donde la queremos utilizar. Al ser un posible nulo (?), para poder utilizarla es necesario el uso de la función invoke donde como parámetros podremos lo que pide la función. En este caso se realizar con la pulsación del botón positivo

```java
class DialogoMulti : DialogFragment() {

    lateinit var elementos: Array<String>
    lateinit var elementosSeleccionados: ArrayList<String>
    var funcionComunicar: ((ArrayList<String>)->Unit)? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        elementosSeleccionados = ArrayList();
        elementos = arrayOf("Opción 1", "Opción 2", "Opción 3")
        var builder = AlertDialog.Builder(requireContext());
        builder.setTitle("Cuadro de selección")
            //.setMessage("Que opción quieres hacer")
            .setMultiChoiceItems(elementos, null) { dialogo, posicion, boolean ->
                run {
                    if (boolean) {
                        elementosSeleccionados.add(elementos[posicion])
                    } else {
                        elementosSeleccionados.remove(elementos[posicion])
                    }
                }
            }
            .setPositiveButton("Aceptar") { dialogo, posicion ->
                    funcionComunicar?.invoke(elementosSeleccionados)
            }


        return builder.create()
    }
}
```

2. Una vez está la llamada hecha, es necesario irse al destino de los datos (en este ejemplo el MainActivity) y declarar un objeto del tipo Dialogo (la clase donde está definida la función) y dentro de instancias al mismo tiempo que se da valor al objeto, se define el comportamiento del la función nula.

```java
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dialogo: DialogoPerso

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias();
        acciones();
    }

    private fun instancias() {

        dialogo = DialogoPerso();
        dialogo.funcionNula = {elementos -> binding.textoPerso.setText(elementos.size.toString())}
    }

    private fun acciones() {

        binding.botonDialogoPerso.setOnClickListener {

            dialogo.show(supportFragmentManager,"")
        }
    }
}
```

## Comunicación de activity a diálogo
[volver arriba](#índice)

Sería el caso contrario al anterior. Si se quiere pasar un dato desde la pantalla al cuadro de diálogo es necesario utilizar un constructor estático, lo que se conoce con el nombre de newInstance. En el caso de kotlin, no existen los métodos estáticos que quedan sustituidos por los objetos de tipo companion. Para poder crear un objeto de este tipo basta con ponerlo en la definición

```java
    companion object{
        
    }
```

Todos los elementos declarados dentro de la definición del objeto companion se podrán ejecutar como static de forma directa. Para poder pasar parámetros desde la activity a la pantalla es necesario un método dentro del companion que llamaremos newInstance. Este método admitirá como parámetros todos aquellos elementos que queremos comunicarle al cuadro de diálogo. En nuestro caso se le comunicará un título y un mensaje, por lo que el código quedará de la siguiente forma: 

```java
class DialogoComunica: DialogFragment() {


    companion object{
        fun newInstance(titulo: String, mensaje: String): DialogoComunica {

        }
    }

}
```

Es importante que este método devuelve un objeto del tipo que se quiere crear, en este caso un DialogoComunica. Este método es el que se utilizará desde la activity para poder arrancar el diálogo. 

Una vez se tiene el método, el siguiente paso es agregar los elementos dentro del diálogo. Para ello se utiliza el concepto de argumentos. Este conceto es muy similar al bundle de los intents, ya que nos permite agregar datos que acompañan al diálogo. Estos argumentos se utilizan mediante el método setArguments, pasando como parámetros un objeto de tipo Bundle el cual tiene puestos todos aquellos datos que se queren hacer parte del diálogo (en nuestro caso los datos pasados por contructor)

```java
class DialogoComunica: DialogFragment() {

    companion object{
        fun newInstance(titulo: String, mensaje: String): DialogoComunica {


            val args = Bundle()
            args.putString("dato1", titulo)
            args.putString("dato2", mensaje)
            val fragment = DialogoComunica()
            fragment.arguments = args
            return fragment
        }
    }
}
```

El método newInstance devuelve un objeto de tipo cuadro de diálogo con los datos ya puestos como argumentos, por lo que el siguiente paso será recuperarlos tras la creación del cuadro de diálogo. Hay que tener en cuente que cuando el método newInstance devuelve el objeto, comienza el ciclo de vida (onAttach, onCreateDialog, onCreateView....)

```java
class DialogoComunica: DialogFragment() {


    companion object{
        fun newInstance(titulo: String, mensaje: String): DialogoComunica {


            val args = Bundle()
            args.putString("dato1", titulo)
            args.putString("dato2", mensaje)
            val fragment = DialogoComunica()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // ejecutado tras la devolución del cuadro de diálogo por parte del método newInstance
    }

}
```

Dentro del método de ciclo de vida que queramos recuperaremos los argumentos y los utilizaremos en el sitio que sea necesario

```java
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(requireActivity())
        var dato1 = this.arguments?.get("dato1")
        var dato2 = this.arguments?.get("dato2")
        builder.setTitle(dato1.toString())
        builder.setMessage(dato2.toString())
        return builder.create()
    }
```

Como se puede ver para poder recuperarlo, se utiliza el método getArguments (arguments) y sobre este el método get, indicando la clave necesaria para capturar el dato. Una vez los datos son capturados, se pueden utilizar donde se quiera.

Por último, para poder crear el cúadro de diálogo con la comunicación que se quiera hacer utilizamos el método newInstance. Ya que este método está dentro de un objeto companion, puede ser llamado directamente sin necesidad de una instancia del objeto. 

```java
        binding.botonDialogoComunica.setOnClickListener { 
            val dialogo = DialogoComunica.newInstance("dato1 comunica", "dato2 comunica")
        }

```

Por últmimo es necesario llamar el método show para mostrar el cuadro de diálogo con los datos que se quiere pasar

```java
        binding.botonDialogoComunica.setOnClickListener { 
            val dialogo = DialogoComunica.newInstance("dato1 comunica", "dato2 comunica")
            dialogo.show()
        }
```

# Cuadro de diálogo del sistema

Existe una última posibilidad de utiliza un par de cuadros de diálogo que ya están definidos dentro del sistema. Se trata de cuadros de diálogo de fecha y hora, donde al seleccionar fecha / hora respectivamente se obtienen los datos de la selección. Ambos ejemplos son cuadros de diálogo de tipo DialogFragment pero que ya tienen todas las interfaces de callback y personalización grafica creada. 

## Cuadro de diálogo de fecha

El cuadro de diálogo de fechas se basa en una clase llamada DatePickerDialog, la cual tiene configurada una interfaz de callback llamada onDateSet que obtiene como parámetros el día, mes y año seleccionado. 

Para poder crear un cuadro de diálogo de fecha, en la clase que representa el cuadro de diálogo es necesario sobreescribir el método onCreateDialogo, retornando un objeto de tipo DatePickerDialog

```java
class DialogoFecha: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogoHora = DatePickerDialog(requireContext(),activity as OnDateSetListener,2020,10,10)
        return dialogoHora
    }
}
```
Como parámetros el constructor tiene el contexto donde se ejecuta, el listener que maneja la accion (la activity desde donde se lanza debe implementarla, el año que se quiere mostrar de inicio, mes y día). En el caso de querer utilizar la fecha actual se puede utilizar desde una variable de tipo Calendar

```java
val anio = Calendar.getInstance().get(Calendar.YEAR)
val mes = Calendar.getInstance().get(Calendar.MONTH)
val day = Calendar.getInstance().get(Calendar.DATE)
```

Para que todo esto funcione, como se ha dicho, es necesario que la clase que lanza el diálogo implemente la interfaz 

```java
class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dialogo: DialogoPerso
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        Snackbar.make(binding.root, " ${p1} ${p2} ${p3}",Snackbar.LENGTH_SHORT ).show()
    }


}
```

## Cuadro de diálogo de hora

El cuadro de diálogo de hora se basa en una clase llamada TimePickerDialog, la cual tiene configurada una interfaz de callback llamada onTimeSet que obtiene como parámetros la hora y minutos seleccionados. 

Para poder crear un cuadro de diálogo de hora, en la clase que representa el cuadro de diálogo es necesario sobreescribir el método onCreateDialogo, retornando un objeto de tipo TimePickerDialog

```java
class DialogoHora: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogo = TimePickerDialog(context, activity as OnTimeSetListener, 0,0,false)
        return dialogo
    }
}
```
Como parámetros el constructor tiene el contexto donde se ejecuta, el listener que maneja la accion (la activity desde donde se lanza debe implementarla, el año que se quiere mostrar de inicio, mes y día). En el caso de querer utilizar la fecha actual se puede utilizar desde una variable de tipo Calendar

```java
val anio = Calendar.getInstance().get(Calendar.HOUR)
val mes = Calendar.getInstance().get(Calendar.MINUTE)
```

Para que todo esto funcione, como se ha dicho, es necesario que la clase que lanza el diálogo implemente la interfaz 

```java
class MainActivity : AppCompatActivity(), TimePickerDialog.OnTimeSetListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dialogo: DialogoPerso
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        Snackbar.make(binding.root, "${p1}: ${p2}",Snackbar.LENGTH_SHORT ).show()
    }
}
```

## Personalización de los cuadros

En ambos casos, los cuádros de diálogo se pueden personalizar en cuanto a colores. Para ello es necesario crear un estilo nuevo que herede de Theme.Material3.Light.Dialog y modificar los colores para que aparezcan los que quieramos

```xml
    <style name="DialogoColores" parent="Theme.Material3.Light.Dialog">
        <item name="colorAccent">
            @color/purple_500
        </item>
    </style>
```

Para poder aplicar este estilo, en el constructor del cuadro de diálogo es necesario llamarlo como segundo parámetro

```java
val dialogoHora = DatePickerDialog(requireContext(), R.style.DialogoColores,activity as OnDateSetListener,2020,10,10)

```