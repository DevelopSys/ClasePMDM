#Objetivos

- Instalar y configurar Android Studio
- Crear un proyecto y comprender su estructura
- Entender los elementos básicos de una aplicación android
- Asociar elementos gráficos XML a elementos lógicos
- Realizar tareas básicas de programación con eventos

#Instalación y configuración del entorno de desarrollo

#Creación de un dispositivo virtual

#Creación de un proyecto

#Elementos básicos de una aplicación

#Asociar elementos XML a elementos lógicos

Como ya se ha explicado en el punto anterior una pantalla (activity) en android consta principalmente de dos cosas: parte gráfica y parte lógica. La parte gráfica está representada por ficheros xml donde se definen Views (layouts, botones, listas, fragments, etc.). Cada elemento tiene sus propiedades (width y heigth son básicas, id muy recomendable) y se organizan mediante layouts.

```java
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

La parte lógica se representa con un fichero kt, donde se definen las operaciones, gestión de datos, etc. Se trata de una clase que extiende de Activity (ahora AppCompactActivity). Por herencia obtiene todos los métodos asociados a una activity, siendo el único obligatorio y escrito inicialmente `onCreate(Bundel)`

```java
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
```

Si recordamos el ciclo de vida de una aplicación, el método se ejecuta justo antes de que esta comience a ser visible. Precisamente de esto es de lo que se encarga el método, de asociar la parte gráfica a la parte lógica, siendo el método setContentView el encargado de ello. Para ello el método recibe como parámetros el nombre del layout que se asociará, siendo accedido a través de la clase R (la cual guarda todos los recursos de la aplicación). Una vez ejecutado este método todos los elementos gráficos podrán ser accesibles desde el código y tener una referencia de ellos para poder utilizarlo. Para poder ver esto vamos a realizar el siguiente ejemplo: una parte gráfica donde exista un botón y justo debajo una etiqueta con el texto `Primera aplicación Android`. Para ello lo primero que debemos hacer es modificar la parte gráfica (el fichero xml) localizado dentro de la carpeta src - layouts - activity_main.xml. Inicialmente está configurado con un elemento root como `ConstraintLayout` el cual se explicará más adelante pero para poder realizar este ejemplo diremos que este tipo de layout pone los elementos con respecto a otros. Por eso el elemento `TextView`que aparece inicialmente está en el medio de la pantalla ya que tiene una dependencia con los ejes x e y de la pantalla. En este fichero vamos a sustituir el elemento TextView por un elemento llamado Button el cual representa un botón clickable. Adicionalmente a las propiedades que tiene configurada vamos a poner la propiedad id, la cual no permitirá referenciar el elemento desde el código. Esta propiedad no es obligatoria como si lo son la de width y height (y las de constraint en el caso del layout actual) pero su es muy recomendable ya que sin ella es complicado referenciar el elemento en el código .kt (en el caso de hacerlo con el editor gráfico el id se pondrá solo, siendo muy recomendable cambiarlo ya que pone id por defecto y eso puede llevar a errores). El fichero quedará de la siguiente forma 

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Pulsar"
        android:id="@+id/boton_pulsar"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/texto_cambiar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="TextView"
        android:layout_marginTop="16dp"
        app:layout_constraintEnd_toEndOf="@+id/boton_pulsar"
        app:layout_constraintStart_toStartOf="@+id/boton_pulsar"
        app:layout_constraintTop_toBottomOf="@+id/boton_pulsar" />

</androidx.constraintlayout.widget.ConstraintLayout>
```
 
Además de la configuración del botón, se ha creado un `TextView` el cual tiene como restricciones el botón (tanto en el eje de las x como en el eje de las y) y un identificador para poder referenciarlo dentro del código. Una vez esto está configurado, el siguiente paso es obtener ambos elementos desde la parte lógica. Para ello en el fichero MainActivity.kt y dentro del método `onCreate` vamos a referenciarlos

```java
class MainActivity : AppCompatActivity() {
    
    var botonPulsar: Button? = null
    var textoCambiar: TextView?= null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botonPulsar = findViewById<Button>(R.id.boton_pulsar);
        textoCambiar = findViewById<TextView>(R.id.texto_cambiar);
    }
}
```

Para ello se crean dos variables con un ámbito de clase con un nombre representativo (no tiene porque ser el mismo que se ha dado al id del archivo xml). Estas variables serán las referencias de los elementos gráficos, por lo que es necesario utilizar el id otorgado en el archivo anterior para poder juntarlas. Para ello, **y siempre después del método setContentView** se igualan estas variables a las del archivo utilizando el método `findViewById` el cual permite hacer esta asociación gracias a que la activity tiene puesto un layout. Es muy importante hacerlo después ya que de hacerlo antes sería imposible encontrar las vistas al no haber parte gráfica asociada. Si se quiere, para poder hacerlo más organizado, se podría crear un método llamado instancias en el cual se realizarán todas las inicializaciones de las variables 

```java
class MainActivity : AppCompatActivity() {

    private var botonPulsar: Button? = null
    private var textoCambiar: TextView?= null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
    }
    
    fun instancias(){
        botonPulsar = findViewById<Button>(R.id.boton_pulsar);
        textoCambiar = findViewById<TextView>(R.id.texto_cambiar);
    }
}
```

Es importante ver que las dos variables tienen asignado el carácter ?, ya que de inicio no están inicializadas por lo que son nulas (recordad el null safety de java). De esta forma se puede acceder a todas aquellas variables gráficas desde la parte lógica. Además de hacerlo de esta forma, también se podrían declarar como lateinit y así evitaríamos poner el ? de safetynull. El inconveniente de esto reside en el momento en el que el número de variables que se quieren acceder son muy grandes. Para ello existe otra forma mediante la cual obtendremos una referencia a todos los elementos del layout. Para ello debemos activar esta característica en el archivo `build.gradle` con el siguiente código

```java
viewBinding{
        enabled = true;
    }
```

Esto activará la característica de binding directo y creará clases adicionales de bindind. Si en nuestro ejemplo tenemos un layout llamad activity_main, se creará una clase adicional llamada ActivityMainBinding. Para poder utilizar este binding es necesario crear una variable de dicho tipo que será inicializada a posteriori

```java
private lateinit var binding: ActivityMainBinding
```

A la hora de inicializarlo sería necesario acceder al método `inlafte` de la clase generada y pasando como parámetros layoutInflater, el cual representa un acceso al layout que está ligado. Además se creará una variable no mutable de tipo view que será la que se pase por parámetro al método setContentView. 

```java
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)        
    }
}
```

A partir de este momento, la variable binding tendrá el conjunto de todas las variables que tiene el layout, representadas por el id que se le dió en el fichero xml. En nuestro ejemplo se dio los id boton_pulsar y texto_cambiar, por lo que la variable binding tendrá los elementos botonPulsar y textoCambiar ya inicializados directamente

```java
// elemento que hace referencia al TextView
binding.textoCambiar
// elemento que hace referencia al Button
binding.botonPulsar
```

Por lo tanto en este caso el método instancias no sería necesario ya que las variables son accesibles direcamente desde binding directamente. Una vez se tienen referenciadas en el código lógico, tan solo sería necesario utilizar alguno de sus métodos para poder utilizarlos en el proceso lógico. Por ejemplo si se quiere cambiar el texto del TextView de forma directa, tan solo sería necesario ejecutar el método setText() pasando como parámetros el nuevo texto que se quiere poner en la etiqueta

```java
class MainActivity : AppCompatActivity() {

    //var botonPulsar: Button? = null
    //var textoCambiar: TextView?= null;
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            val view: View = binding.root
            setContentView(view)        
        }
    }

    private fun acciones() {
        binding.textoCambiar.setText("Nuevo texto para la etiqueta");
    }
}
```

Otra de las acciones muy comunes dentro de la gestión de elementos en android, es el tratamiento de eventos. Se define evento como la acción que dispara una ejecución. Para ello, al elemento que se quiera controlar (aquel que dispare la acción cuando se produzca algo sobre el, como por ejemplo una pulsación) se le debe ejecutar el método setNombreDelEventoListener, admitiendo como parámetros un objeto dela interfaz que tiene el evento. Depende de la  interfaz tiene como parámetro se tendrá un objeto de tipo View y diferentes elementos (el IDE lo marcará para que la construcción se más sencilla). Como java cuenta con las llamadas funciones lambda, la construcción para controlar cuando un botón es pulsado sería la siguiente:

```java
    private fun acciones() {
        binding.textoCambiar.text = "Cambio"
        binding.botonPulsar.setOnClickListener { v:View ->  binding.textoCambiar.setText("Texto cambiado tras la pulsación")}
    }
```

En este caso el método OnClickListener tan solo admite un parámetros, por lo que la función lambda tendría dicho parámetro, y tan solo cambiaría el texto de la etiqueta al indicado. Si por ejemplo se quiere poner un campo de texto para recoger un dato y mostrarlo en la etiqueta tendríamos que 

1. Añadir un EditText dentro del archivo xml. En este caso se podrá encima del botón, con el id edit_capturar

```xml
    <EditText
        android:id="@+id/edit_capturar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="16dp"
        android:ems="10"
        android:inputType="textPersonName"
        android:hint="Introduce un nombre"
        app:layout_constraintBottom_toTopOf="@+id/boton_pulsar"
        app:layout_constraintEnd_toEndOf="@+id/boton_pulsar"
        app:layout_constraintStart_toStartOf="@+id/boton_pulsar" />
```

2. En la parte lógica, como se tiene la variable binding ya se tiene el accedo a la referencia mediante el ID por lo que si se quiere captura el texto recogido se utiliza el método getText() o atributo texto

```kotlibn
 private fun acciones() {
        binding.textoCambiar.text = "Cambio"
        binding.botonPulsar.setOnClickListener { v: View ->
            var nombreCapturado: String = binding.editCapturar.text.toString();
            if (!nombreCapturado.isEmpty()) binding.textoCambiar.setText(nombreCapturado) else Snackbar.make(
                v,
                "EL nombre está vacío",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
```

Como se puede ver tras la pulsación del botón, se evalúa si el texto capturado es vacío. En caso afirmativo se mostrará en la etiqueta mientras que si el texto recogido es vacío aparecerá una notificación en forma de snackbar avisando del fallo. En el caso de querer darle una acción a la snackbar se podría con el método setAction

```java
    private fun acciones() {
        binding.textoCambiar.text = "Cambio"
        binding.botonPulsar.setOnClickListener { v: View ->
            var snackbar = Snackbar.make(
                v,
                "EL nombre está vacío",
                Toast.LENGTH_SHORT
            )
            var nombreCapturado: String = binding.editCapturar.text.toString();
            if (!nombreCapturado.isEmpty()) binding.textoCambiar.setText(nombreCapturado) else snackbar.setAction("OK",{snackbar.dismiss()}).show()
        }
    }
```

El método setAction admite como parámetros dos elementos, un texto que será el que aparezca dentro de la notificación y una función que admite como parámetros una vista. En este caso al pulsar el texto de la notificación la snackbar desaparecerá ya que se ejecuta el método `dismiss` (por eso se ha guardado la snackbar en una variable). En el caso de tener dos o más elementos sobre los que se quiere controlar una misma acción sería necesario utilizar el argumento `View` de la función de flecha (en el ejemplo anterior es el declarado como v, pero también podría haber sido obviado al ser solo uno y llamado como it). Para poder ver esto, vamos ver esta funcionalidad, al ejemplo anterior vamos a agregarle un botón al ya creado. El primero de los botones realizará el setText en la etiqueta del texto puesto en el edit, mientras que el nuevo botón pondrá `texto por defecto` en la etiqueta. Para ello tendremos que seguir los siguientes pasos

1. Modificar el archivo xml e incorporar un botón nuevo con el id boton_saludar. Para poder colocar el botón al lado del otro, se ha incorporado un LineaLayout que ayuda a poner ambos botones uno a la izquierda del otro

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/texto_cambiar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:text="TextView"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/linearLayout" />

    <EditText

        android:id="@+id/edit_capturar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="60dp"
        android:ems="10"
        android:hint="Introduce un nombre"
        android:inputType="textPersonName"
        android:minHeight="48dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <LinearLayout
        android:id="@+id/linearLayout"
        android:layout_width="409dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:gravity="center"
        android:orientation="horizontal"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/edit_capturar">

        <Button
            android:id="@+id/boton_saludar"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Saludar" />

        <Button
            android:id="@+id/boton_pulsar"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Pulsar" />
    </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
```

2. Una vez se ha incluido el botón como vista en el xml, se accede a el mediante el binding en la parte lógica y se le da la acción tal cual lo hemos hecho antes

```java
binding.botonSaludar.setOnClickListener { binding.textoCambiar.setText("Texto por defecto") }
```

En este caso no se hace ninguna comprobación, ya que tan solo se quiere cambiar el texto que aparece. Si nos fijamos hay partes del código que se repiten, que es toda la función lambda, por lo que podríamos implementar la interfaz y a ambas acciones pasarles como parámetros this

```java
package com.develop.inicio

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.develop.inicio.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        acciones();
    }

    private fun acciones() {
        binding.textoCambiar.text = "Cambio"
        binding.botonSaludar.setOnClickListener(this);
        binding.botonPulsar.setOnClickListener(this);
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.boton_pulsar -> {
                var snackbar = Snackbar.make(
                    p0,
                    "EL nombre está vacío",
                    Toast.LENGTH_SHORT
                )
                var nombreCapturado: String = binding.editCapturar.text.toString();
                if (!nombreCapturado.isEmpty()) binding.textoCambiar.setText(nombreCapturado) else snackbar.setAction(
                    "OK",
                    { snackbar.dismiss() }).show()
            }
            R.id.boton_saludar -> {
                binding.botonSaludar.setOnClickListener { binding.textoCambiar.setText("Texto por defecto") }
            }
        }
    }

}
```

Como se puede ver se ha implementado la interfaz OnClickListener, lo que ha obligado a escribir el método onClick cuyo parámetro es la vista que ha generado el evento. Dependiendo del id (con el estamento when) de la vista que ha generado el evento se realizará una cosa u otra. Por último a ambos botones se pasa como parámetro this como referencia de la clase (ya que ha implementado la interfaz)

Estos son los fundamentos del trabajo en Android Studio. En el siguiente tema se verán el manejo y gestión de los principales elementos de interfaces gráficas y aprenderemos a crearlas con gestores del espacio como son los layouts. 

Antes de dar por cerrado el tema, vamos a ver el acceso a recursos varios (como los String) y la internacionalización. En el punto de creación de un proyecto, se ha comentado que en todo proyecto android se crea por defecto una carpeta llamada res. En ella se ubican todos los recursos de la actividad, y en concreto hay una carpeta donde se guardan los xml asociados a los recursos que forman parte de la aplicación. Esta carpeta es la de res/values y en concreto el fichero string.xml guarda todas las palabras que son susceptibles de ser accedidas desde código. Inicialmente el contenido del archivo es el siguiente:

```xml
<resources>
    <string name="app_name">inicio</string>
</resources>
```

Eso indica que actualmente hay un recurso llamado app_name que hace referencia a la palabra inicio. En nuestro caso todas las palabras que hemos puesto tanto en el xml como en la parte lógica han sido hardcode (lo hemos pulsado nosotros). En casos muy puntuales esto puede ser útil, pero en la mayoría de los casos se recomienda que las palabras se definan en este archivo y luego se referencien desde el código. De esta forma podremos declarar las cadenas de texto que se utilizan en nuestro ejemplo anterior dentro del fichero string.xml

```xml
<resources>
    <string name="app_name">inicio</string>
    <string name="boton_pulsar">Pulsar</string>
    <string name="boton_saludar">Saludar</string>
    <string name="hint_edit">Introduce tu nombre</string>
    <string name="edit_vacio">El nombre está vacio</string>
    <string name="texto_defecto">Texto por defecto</string>
</resources>
```

Una vez está declarado en el fichero, se puede acceder a ellos a traves tanto del fichero activity_main.xml mediante la llamada @string/boton_pulsar (nombre dado en el fichero)

```xml
<Button
    android:id="@+id/boton_saludar"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/boton_saludar" />

 <Button
    android:id="@+id/boton_pulsar"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/boton_pulsar" />
<EditText
    android:id="@+id/edit_capturar"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginTop="60dp"
    android:ems="10"
    android:hint="@string/hint_edit"
    android:inputType="textPersonName"
    android:minHeight="48dp"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```

Como desde el fichero MainActivity.kt mediante R.string.texto_defecto (nombre dado en el fichero)

```java
override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.boton_pulsar -> {
                var snackbar = Snackbar.make(
                    p0,
                    R.string.edit_vacio,
                    Toast.LENGTH_SHORT
                )
                var nombreCapturado: String = binding.editCapturar.text.toString();
                if (!nombreCapturado.isEmpty()) binding.textoCambiar.setText(nombreCapturado) else snackbar.setAction(
                    "OK",
                    { snackbar.dismiss() }).show()
            }
            R.id.boton_saludar -> {
                binding.botonSaludar.setOnClickListener { binding.textoCambiar.setText(R.string.texto_defecto) }
            }
        }
    }
```

En algunas ocasiones es posible que sea necesario acceder mediante el siguiente código (sobre todo en aquellas ocasiones donde se quieran hacer concatenaciones con otras cadenas de texto)

```java
binding.textoCambiar.setText(getString(R.string.texto_defecto))
```

Una vez hecho esto, es posible añadir tantos string como sean necesarios y a la hora de utilizarlos tan solo sería necesario referenciarlos de las dos formas mostradas. Uno de los principales motivos de realizar esto es que si se quiere cambiar la misma palabra que aparece en el mismo sitio, tan solo sería necesario cambiarlo en el archivo string.xml. Otro de los grandes motivos es el de la internacionalización. Cuando se está realizando una aplicación, lo normal es que esta creación se independiente del idioma del dispositivo. Esto quiere decir que si el dispositivo está configurado en inglés el texto debería aparecer en dicho idioma, y si está en español automáticamente el texto debería cambiar. Para ello es necesario realizar una copia exacta del fichero string cualificado, agregándole un _en o _fr (dependiendo del lenguaje que se quiera utilizar). Para poder hacer una copia del fichero, es necesario crear un nuevo fichero en la carpeta values -> new value resource file -> configurar con el nombre strings.xml (exactamente igual que el nombre del fichero que ya existe) -> en la parte inferior sería necesario agregar un cualificador de Locale y seleccionar el idioma al que se quiere traducir. Toda esta acción creará un fichero llamado strings_en.xml donde es necesario poner el mismo contenido que el fichero strings.xml por defecto, pero con las palabras traducidas.

```xml
<!--Fichero strings_en.xml-->

<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="app_name">inicio</string>
    <string name="boton_pulsar">Click</string>
    <string name="boton_saludar">Say hello!!</string>
    <string name="hint_edit">Enter your name</string>
    <string name="edit_vacio">The name is empty</string>
    <string name="texto_defecto">Default text</string>
</resources>

<!--Fichero strings.xml-->
<resources>
    <string name="app_name">inicio</string>
    <string name="boton_pulsar">Pulsar</string>
    <string name="boton_saludar">Saludar!!</string>
    <string name="hint_edit">Introduce tu nombre</string>
    <string name="edit_vacio">El nombre está vacio</string>
    <string name="texto_defecto">Texto por defecto</string>
</resources>
```

#Intents

Otro de los elementos básicos de una aplicación android son los intents. Este tipo de objeto permite desde código realizar tareas como navegar entre pantallas, lanzas aplicaciones del sistema como el navegador, mapas, cámara, etc... en resumen una acción que puede ser definida por el usuario o definida en la URI con la que se configura el intent. Antes de empezar a ver las opciones de este tipo de objetos, comentar que su creación y lanzamiento se puede realizar de forma explicita (creando el objeto y sus datos en la parte lógica con el constructor del intent) o implícitos (definiendo sus acciones en el fichero AndroidManifest.xml o desde la URI que define la acción). A continuación vamos a ver los principales usos que tiene este tipo de objetos

## Navegar a una segunda actividad

Uno de los principales usos de los intents es el de navegar a otra actividad, con o sin datos asociados. Para ello se va a crear un proyecto que conste de dos actividades, cada una de las cuales tendrá los siguientes elementos:

- MainActivity: constará de un botón en el centro de la pantalla con el texto Pasar pantalla.

```xml
<!--activity_mainxml-->

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Pasar pantalla"
        android:id="@+id/boton_pasar"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

```java
// MainActivity.kt
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
```

- SecondActivity: constará de una etiqueta en el centro de la pantalla con el texto Pantalla dos. Para poder crear una segunda pantalla es necesario crear tanto el fichero .java como el .xml que se ha visto y declarar la activity dentro del fichero AndroidManifest.xml. Además de este proceso, también es posible utilizar el asistente de creación pulsando botón derecho new -> activity -> empty activity indicando el nombre de la actividad. Este proceso creará automáticamente todos los ficheros relacionados y actualizará el fichero AndroidManifest con la nueva actividad.

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.develop.intents">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.Intents">
        <activity
            android:name=".SecondActivity"
            android:exported="false" />
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

Una vez hecho esto ya podemos empezar a crear el paso de pantallas. En el caso de querer hacer un cambio de pantalla explicito sería necesario crear una variable de tipo Intent y pasarle como parámetros el origen (la clase donde estamos - this - y el destino - la clase a la que queremos pasar-). Una vez creado este objeto para poder realizar el cambio de pantalla se utiliza el método `startActivity`

```java
// el this se podría poner como this@MainActivity, para poder definir que hacemos referencia al ámbito de la clase entera
val intent: Intent = Intent(this, SecondActivity::class.java)
startActivity(intent)
```

Ejecutando este código la segunda pantalla (en este caso SecondActivity) pasaría a primer plano y la activity actual (MainActivity) pasaría a segundo plano. Con el ejemplo que hemos empezado, podríamos configurar el botón para que al ser pulsado se realice el cambio de pantalla

```java
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        acciones()
    }

    private fun acciones() {
        binding.botonPasar.setOnClickListener {
            val intent: Intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
```

En el caso de querer realizar un intent implícito, es el sistema el que se encarga de decidir que pantalla es la que se tiene que hacer. Generalmente, el sistema realiza esto dependiendo de la acción que se indique y de la URI (Universal Resource Identifier) configurada. Para ellos y al igual que se ha hecho antes es necesario crear una variable de tipo intent, indicando en el constructor la acción (Action_View es la más genérica). Además de esto es necesario indicar los datos que acompañarán a la petición (ya que al abrir una pantalla como por ejemplo el navegador, es necesario indicar la página que será mostrada)

```java
val intent: Intent = Intent(Intent.ACTION_VIEW);
intent.setData(Uri.parse("https://www.developandsys.es"))
startActivity(intent)
```

Al igual que antes si se quiere realizar con la pulsación del botón se realizará mediante el siguiente código

```java
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        acciones()
    }

    private fun acciones() {
        binding.botonPasar.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.developandsys.es"))
            startActivity(intent)
        }
    }
}
```

En este caso la acción indica que la pantalla que se tiene que abrir es un navegador (al utilizar el protocolo https). En el caso de no tener una aplicación que sea capaz de abrir este tipo de acción el código del intent daría error, por lo que sería necesario comprobar antes si existe alguna aplicación capaz de gestionar la petición:

```java
val intent: Intent = Intent(Intent.ACTION_VIEW);
intent.setData(Uri.parse("https://www.developandsys.es"))
if (intent.resolveActivity(packageManager)!=null){
    startActivity(intent)
}
```

En el caso de que el método resolveActivity responda con un objeto diferente de nulo, quiere decir que existe una aplicacion que permite manejar la petición, En caso contrario habría que avisar al usuario que la acción no se podría llevar a cabo.

Las principales acciones asociadas a los intents son:

Como se ha indicado antes, por defecto el sistema es capaz de detectar la aplicación con la que se abrirá el intent, pero en el caso de querer indicar al usuario un mensaje para que el usuario seleccione con que aplicación quiere abrirlo se podría hacer mediante un objeto de tipo IntentChooser, el cual recibe por paramentos el intent con la acción que se quiere realizar y el texto que aparecerá con el selector de aplicaciones

```java
val intent = Intent(Intent.ACTION_VIEW);
intent.setData(Uri.parse("https://www.developandsys.es"))
val intentChooser = Intent.createChooser(intent,"Selecciona la aplicación para abrir la acción")
if (intent.resolveActivity(packageManager)!=null){
    startActivity(intentChooser)
}
```

## Pasar de activity con parámetros

Otra de las funcionalidades que es muy utilizada en los intents es la de arrancar una nueva actividad pero además de realizar ese cambio de pantalla, también pasar una serie de datos. Esto es posible si al intent utilizar para pasar de pantalla se se agregan los datos utilizando el método putExtra(), identificando los datos con un par clave valor al igual que en un Map. A la hora de recuperarlo se utilizará el método getExtra(), indicando la clave con la que se ha asociado el dato.Para poder explicar esto nos vamos a basar en el ejemplo que se ha utilizado anteriormente del paso de dos pantallas. Si recordamos lo visto anteriormente, lo que has ha hecho ha sido crear un Intent donde en constructor se ha declarado origen y destino, y una vez se tiene construido se ha utilizado el método startActivity(). Si seguimos el mismo ejemplo, imaginemos que en en la primera pantalla (MainActivity) se quiere capturar uno o varios datos desde un editText y al pulsar un botón pasarlo a la segunda pantalla para que esta lo recupere los datos y sean mostrados. Para ello poder hacer esto vamos a seguir los siguientes pasos:

1. En el archivo activity_main donde definimos la ui de la primera pantalla se va a incluir un editText con el id editNombre

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/edit_nombre"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Introduce tu nombre"
        android:layout_marginBottom="16dp"
        app:layout_constraintBottom_toTopOf="@+id/boton_pasar"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Pasar pantalla"
        android:id="@+id/boton_pasar"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

2. En la parte lógica de la pantalla (el archivo MainActivity.kt) cuando el botón se pulsado se va a recoger el dato del editText y se va a pasar junto con el intent creado en el ejemplo anterior utilizando el método putExtra()

```java
val intent = Intent(this, SecondActivity::class.java)
intent.putExtra("nombre", binding.editNombre.text.toString())
startActivity(intent)
```

Con este nuevo intent, además de la acción de pasar entre pantalla, se ha agregado un dato que tiene como clave asociada la palabra nombre. Esta clave será utilizada en la pantalla destino para poder capturar el dato. 

3. En el archivo second_activity.xml se va a crear un textView donde se mostrará el dato pasado desde la primera pantalla.

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SecondActivity">

    <TextView
        android:id="@+id/text_recoger"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```
3. Una vez se tiene el elemento preparado, en la segunda pantalla se podrá capturar mediante el intent que ha arrancado la pantalla y el método getExtra, indicando la clave del dato que se quiere recuperar

```java
intent.extras?.getString("nombre").toString();
```

En este caso la ejecución de extras está declarado como null safety ya que es posible que se declara como null. Una vez el dato sea recibido, se puede utilizar para poder ponerlo dentro de la etiqueta declarada en el centro de la pantalla

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SecondActivity">

    <TextView
        android:id="@+id/text_recoger"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

```java
class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var textoRecibido: String;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        capturarDatos()
        acciones()

    }

    private fun capturarDatos() {
        textoRecibido = intent.extras?.getString("nombre").toString();
    }

    private fun acciones() {
        binding.textRecoger.setText(textoRecibido)
    }


}
```
## Arrancar actividad esperando respuesta

Otra de las posibilidades que dan los intents es la de, además de arrancar una segunda pantalla, esperar obtener un resultado. Un ejemplo claro de esto es arrancar la cámara para poder hacer una foto, y volver a la pantalla anterior para poder mostrarla. El flujo sería el siguiente

1. Desde MainActivity (con un imageView y un botón) se pulsa un boton y se abre la cámara con un intent
2. Con la cámara se hace una foto y al hacerla se vuelve a la pantalla inicial
3. Una vez estamos en MainActivity, esta se encargará de recibir el dato (en este caso la foto) y ponerla dentro del image view

Para hacer este ejemplo seguiremos los siguientes pasos

1. Se creará una activity llamada IntentActivity, y en el xml se pondrá un botón con el id boton_camara y un imageview con el id imagen_camara

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".IntentActivity">

    <Button
        android:id="@+id/boton_camara"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hacer foto"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <ImageView
        android:id="@+id/imagen_camara"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/boton_camara"
        tools:srcCompat="@tools:sample/avatars" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

2. En la parte lógica se programa la pulsación del botón para que cuando este sea pulsado se arranque un intent de apertura de la cámara

```java

```


