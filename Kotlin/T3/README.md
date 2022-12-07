# Objetivos

- Comprender el concepto de interfaz gráfica y sus elementos
- Entender las formas que hay de vincular un elemento gráfico con un elemento lógico
- Utilizar los principales elementos gráficos de una aplicación y los eventos asociados a estos
- Utilizar los mecanismos necesarios para realizar interfaces gráficas que se adepaten a a diferentes orientaciones

# Contenidos

En unidades anteriores ya hemos vistos algunos conceptos de interfaces gráficas y los métodos necesarios para poder asociar elementos de ficheros xml y ficheros kotlin. Antes de empezar es recomendable recordar los elementos que forman parte de una interfaz:

- Vistas: son cada uno de los elementos que forman parte de la interfaz gráfica de la aplicación. En la mayoría de los casos se trata de elementos que son visible e interactuables como pueden ser botones, campos de texto, inputs, etc... pero también pueden ser elementos que no tienen una representación gráfica como tan y sirven para agrupar diferentes vistas como por ejemplo los layouts. En android todos los elementos que tienen que ver con interfaces gráficas heredan de la clase View
- Grupo de vistas o ViewGroup: como su nombre indica se trata de elementos que junta un conjunto de vistas, pudiendo también definirnos como contenedor. Este es el caso de los layouts (que son vistas de tipo ViewGroup)
- Layouts: ya se han definido en los dos puntos anteriores, pero podemos decir que los layouts son los manejadores del espacio que guardan en su interior un conjunto de vistas y las organizan de una forma determinada. Dentro de la interfaz gráfica se pueden anidar tantos layouts entre si como se quiera (layouts dentro de layouts). Sin embargo no es muy recomendable hacer un anidamiento profundo.

# Vistas: uso y manejo de eventos

Ya se ha visto que toda pantalla en android cuenta tanto con una parte lógica como con un parte gráfica. La lógica está representada por un archivo .kt y la gráfica con un archivo .xml. Esta asociación entre ambas se realiza mediante el método setContentView ejecutado en el método onCreate

```java
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
```

Este método es el encargado de asociar la parte lógica a la parte gráfica. Una vez se ha ejecutado esto, para poder traer elementos del xml y declarados en el archivo es necesario ejecutar el método findViewById, indicando el id de la vista que queramos traer. Por ejemplo si tenemos el siguiente xml asociado a la activity MainActivity

```xml
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
        android:id="@+id/texto_main"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

Podemos ver que el elemento TextView tiene como atributo id `texto_main` indicado como @+id ya que se está creando en ese mismo momento. Con esta vista configurada podríamos declararla dentro del archivo MainACtivity.kt para poder utilizarla como quisiésemos con el método comentado anteriormente

```java
class MainActivity : AppCompatActivity() {
    
    private lateinit var texto: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        texto = findViewById(R.id.texto_main) as TextView
    }
}
```

De esta forma la variable texto guardaría la vista y se podría utilizar como se quisiese 

*Recordar que también podría utilizar el binding de código, lo cual evitaría hacer la inicialización de las variables*

```java
class MainActivity : AppCompatActivity() {

    private lateinit var texto: TextView;
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root;
        setContentView(view)
        binding.textoMain
    }
}
```

Una vez visto el mecanismo para pode asociar una parte lógica con una parte gráfica, vamos a ver ahora cuales son los principales elementos  y el manejo de sus eventos. Los siguientes elementos que se verán a continuación son elementos básicos, es decir se excluyen las listas avanzadas con los adaptadores de datos que se verán en los siguientes temas. Las vistas que se verán son:

- Layouts: principalmente veremos tres; LinearLayout, ConstraintLayout y FrameLayout
- Button: botones normales
- EditText: campos de texto 
- CheckBox: casillas de verificación
- RadioButton: casillas de verificación con interfaz redonda y posibilidad de formar un grupo
- Spinner: desplegable de selección

Antes de empezar a explicar cada una de ellas, vamos a explicar una serie de atributos que tienen todas y son obligatorios. En todos los casos es necesario indicar a cada una de las vistas que tamaño ocupan tanto en alto como en ancho. Estos dos atributos dentro de la definición xml de las vistas son layout_width y layout_height. Las configuraciones posibles para ambos atributos son:

- match_parent: esto indicará que el tamaño será el máximo posible. Por ejemplo si este atributo se lo ponemos a un layout root, esto indicará que se pegará a su padre, siendo este la pantalla. En el caso de declararse a una vista que está dentro del layout, la vista se pegará al tamaño máximo de su padre. 
- wrap_content: se trata de la configuración contraria a la anterior. El elemento que tenga configurado el atributo con wrap_content tan solo ocupará lo necesario para mostrarse es decir el tamaño que necesita, ni más ni menos

## Layouts: tipos y uso

Como se ha comentado anteriormente, los layouts son aquellos elementos invisibles que permiten organizar los elementos en el espacio. Siempre habrá uno que será el componente root del archivo xml, pudiendo utilizar tantos en su interior como se quiera (sin embargo no es muy recomendable hacer un anidamiento profundo). A continuación veremos los principales: 

### LinearLayout

Se trata del layout más sencillo de utilizar, ya que dispone los elementos en una fila única bien sea en horizontal o en vertical

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/texto_main"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Elementos interfaz"
      />

    <Button
        android:id="@+id/boton_pulsar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Pulsar!!"
        />

    <CheckBox
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Opción a seleccionar"
        android:id="@+id/check_seleccionar"
        />

    <RadioButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Seleccionado"
        android:id="@+id/radio_individual"
        />

</LinearLayout>
```

Como se puede ver en el LineaLayout se ha declarado un atributo llamado orientation configurado a vertical. Esto quire decir que todos los componentes que están dentro se colocarán uno debajo del otro. En el caso de haberlo configurado como horizontal, los elementos se colocarían uno a la izquierda del otro.

Otra de las posibilidad tiene este layout es el de utilizar pesos (el atributo es layout_weigth). Este atributo permite indica el % de espacio que se reservará para el elemento el que se configura. Es importante tener en cuenta que la suma de todos los pesos tiene que ser 1 

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="0.5"
        android:text="Etiqueta en 50%"
        android:gravity="center"
        android:textSize="50sp"
        />

    <Button
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="0.5"
        android:text="Boton en 50%"
        android:textSize="40sp"
        />

</LinearLayout>
```

Es importante tener en cuenta que aquel eje donde queramos que le afecte el peso debe estar configurado como 0dp, para que sea el peso el que realmente se aplique. El atributo de gravity aplicado al TextView indica que el contenido debe colocarse en el centro y el atributo de textSize indica el tamaño del texto que tendrá (siempre en sp)

### ConstraintLayout

Se trata del layout que más libertad permite a la hora de generar una interfaz, ya que los elementos se colocan en relación al resto o a los bordes de la pantalla. Para poder indicar estas restricciones se utilizan atributos con la construcción layout_constraint, indicando el id del elemento sobre el que queremos restringir o parent en el caso de querer hacerlo sobre la vista padre. 

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="24dp"
        android:layout_marginTop="24dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:srcCompat="@tools:sample/avatars" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Nombre"
        android:textSize="24sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/imageView"
        app:layout_constraintTop_toTopOf="@+id/imageView" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Apellido"
        android:textSize="24sp"
        app:layout_constraintBottom_toBottomOf="@+id/imageView"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/imageView"
        app:layout_constraintTop_toBottomOf="@+id/textView" />

    <EditText
        android:id="@+id/editTextTextEmailAddress"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="24dp"
        android:ems="10"
        android:hint="introduce email"
        android:inputType="textEmailAddress"
        android:minHeight="48dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageView" />

    <EditText
        android:id="@+id/editTextPhone"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="24dp"
        android:ems="10"
        android:hint="introduce télefono"
        android:inputType="phone"
        android:minHeight="48dp"
        app:layout_constraintEnd_toEndOf="@+id/editTextTextEmailAddress"
        app:layout_constraintStart_toStartOf="@+id/editTextTextEmailAddress"
        app:layout_constraintTop_toBottomOf="@+id/editTextTextEmailAddress" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="24dp"
        android:text="Guardar cambios"
        app:layout_constraintEnd_toEndOf="@+id/editTextPhone"
        app:layout_constraintStart_toStartOf="@+id/editTextPhone"
        app:layout_constraintTop_toBottomOf="@+id/editTextPhone" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

En este ejemplo se muestra una pantalla de perfil donde se muestra una foto, un nombre, un apellido y unos campos de texto para poder meter datos. Como se puede ver en el código todos los elementos tienen configurado layout_constraint, indicando la posición relativa a que elemento se debe colocar. Si bien es importante trabajar siempre con código, al modificar tal cantidad de propiedades como tiene ConstraintLayout es uno de los pocos casos que se puede utilizar el modo diseñador y no perjudicar el tiempo de desarrollo.

## Button

Se trata de una de las vistas más utilizadas dentro de la interfaz. Ya se ha visto alguna de las construcciones en los temas anteriores. 

```xml
    <Button
        android:id="@+id/boton_pulsar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Pulsar!!"
        />
```

En el caso de querer crear un botón con un estilo personalizado se configuraría el atributo style. En el caso de querer ponerle una imagen al botón se utilizaría una vista de tipo ImageButton y se configuraría el atributo src.

El evento que los botones tienen asociados es el evento onClick, disparado cuando el botón es pulsado. Para ello se debe configurar un escuchador de tipo OnClickListener, el cual tan solo tiene el método comentado

```java
        binding.botonPulsar.setOnClickListener { view: View ->
            Snackbar.make(
                view,
                "Bot´´on pulsado",
                Snackbar.LENGTH_SHORT
            ).show()
        }
```

## EditText

Los EditText representan uno de los elementos más utilizados en las interfaces gráficas de android, ya que permiten recoger datos introducidos por el usuario en el campo de texto. Cuando se quiere declarar un elemento xml se realizaría de la siguiente forma:

```xml
    <EditText
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/edit_texto"
        android:hint="Por favor introduce un dato"
        android:inputType="text"
        />
```

El atributo hint representa la pista que pone en el edit nada más arrancar y que desaparecerá cuando se seleccione el elemento. El atributo inputType marca los elementos que se podrán poner dentro de campo (números, letras, etc...). En el caso de querer recoger el texto que tenga dentro el edit se realizará mediante el atributo text de la siguiente forma (al pulsar un botón por ejemplo):

```java
binding.botonPulsar.setOnClickListener { view: View ->
            if (binding.editTexto.text.isEmpty()){
                Snackbar.make(
                    view,
                    "El edit está vacío",
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                Snackbar.make(
                    view,
                    "El contenido del edit es ${binding.editTexto.text}",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
```

A la hora de trabajar con eventos, los Edit son elementos que aunque tienen la capacidad de hacerlo, no es muy práctico escuchar eventos en funcionamiento. Lo que hay veces que si es util es utilizar EditText modificados que dan alguna funcionalidad avanzada como por ejemplo

### EditText autocompletables

Son aquellos que según vas escribiendo se van mostrando las opciones de autocompletado. Este tipo de vistas se llaman AutoCompleteTextView y requieren tanto de parte gráfica (xml) como de parte lógica (los elementos que mostrará en autocompletar). Para empezar a utilizarlo es necesario declararlo en el xml de la siguiente forma

```xml
		<AutoCompleteTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Por favor introduce un pais"
        android:id="@+id/edit_autocomplete"
        />
```

Una vez está declarado el elemento en la parte gráfica ya sería funcional, pudiendo recoger su texto de la misma forma que un edit normal. Sin embargo no autocompletaría según se va escribiendo ya que para eso es necesario agregarle en la parte lógica un adaptador, el cual junta la parte lógica de los datos autocompletables con el elemento gráfico. Para poder declarar este objeto de tipo ArrayAdapter es necesario pasarle en contexto (vale con this), un layout que indica la forma en la que se mostrará la lista de elementos autocompletables y una lista con los elementos que se podrán autocompletar

```java
val paises = arrayOf("Argentina","Brasil","Canada","Dinamarca","España","Francia","Grecia","Hungria","Italia");
val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,paises)
```

Adicionalmente también podríamos incluir aquí un elemento llamado TextInputLayout, pero reservaremos su explicación para el capítulo dedicado a Material Design

## CheckBox

Se trata de una vista que consta de dos vistas: estado seleccionado y estado no seleccionado. Esta vista es un tipo de botón, por lo que muchas de las opciones que se pueden incluir en los button también se pueden utilizar aquí. Para poder utilizarlo se utilizaría el siguiente código xml

```xml
    <CheckBox
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Opción a seleccionar"
        android:id="@+id/check_seleccionar"
        />
```

A la hora de manejar sus eventos, tenemos dos posibilidades principales: actuar cuando el elemento es pulsado para lo que utilizaremos el mismo método onClick que hemos visto antes o actuar cuando la propiedad seleccionado del elemento cambia. Hay que tener en cuenta que el primero de los métodos se ejecutaría cuando el check es pulsado, mientras que el segundo método se ejecutaría cuando la selección del check cambia (que puede no ser con una pulsación del mismo). En el primer caso el código no cambia mucho con respecto al anterior, ya que el listener es exactamente el mismo.

```java
        binding.checkSeleccionar.setOnClickListener { view: View -> Snackbar.make(
            view,
            "El check ha sido selecciondo y su estado es ${binding.checkSeleccionar.isChecked}",
            Snackbar.LENGTH_SHORT
        ).show() }
```

Sin embargo, en el segundo caso el listener si cambia ya que no se ejecutará cuando el check sea pulsado, sino cuando el estado se cambie. Para ello el listener recibe dos parámetros: la visa que genera el evento (siembre será el propio check) y un booleano que representa el estado actual en el que se encuentra

```java
        binding.checkSeleccionar.setOnCheckedChangeListener({ view: CompoundButton, checked: Boolean ->
            Snackbar.make(
                view,
                "El estado del check ha sido cambiado y ahora es $checked",
                Snackbar.LENGTH_SHORT
            ).show()
        })

        binding.botonPulsar.setOnClickListener { view: View ->
            binding.checkSeleccionar.isChecked = !binding.checkSeleccionar.isChecked
        }
```

En este ejemplo el código del listener OnCheckedChange se ejecutará tanto si el listener es pulsado (ya que la pulsación cambia el estado) como si el botón es pulsado ya que también cambia el estado

## RadioButton

Se trata de un componente muy parecido al visto anteriormente. Cuenta con dos posibles estados: seleccionado y no seleccionado. La diferencia con los checkbox es que su uso por lo general está asociado a un grupo y además el usuario tan solo puede seleccionarlo, no deseleccionarlo. En el caso de querer utilizarlo de forma individual se declararía en el xml de la siguiente forma

```xml
    <RadioButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Seleccionado"
        android:id="@+id/radio_individual"
        />
```

Como se puede ver existe la posibilidad de declarlo d¡individualmente, lo que pasa es que no tiene mucho uso real, ya que como se ha dicho en el momento que se selecciona el radio, no podría deseleccionarse. Lo que si tiene mucho uso es declararlo dentro de un grupo de elementos:

```xml
	<RadioGroup
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:id="@+id/grupo_radios">
        
        <RadioButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Opción 1"
            android:id="@+id/radio_uno"/>
        <RadioButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Opción 2"
            android:id="@+id/radio_dos"/>
        <RadioButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Opción 3"
            android:id="@+id/radio_tres"/>
    </RadioGroup>
```

Como se puede ver, todos los elementos de tipo Radio están englobados dentro de una etiqueta de tipo RadioGroup. Tanto los elementos finales como el grupo tienen id, ya que a la hora de trabajar los eventos disponibles se puede: analizar el click en un radio, analizar el cambio de estado de un radio (ambas opciones funcionan exactamente igual que los casos vistos en los componentes anteriores) o también se puede analizar el cambio de selección de algún elemento del RadioGroup. Para ello es necesario utilizar un listerner setOnCheckedChangeListener, el cual tiene como parámetros el RadioGroup que ha generado el evento y un Int que representa el id del RadioButton que ha sido seleccionado

```java
binding.grupoRadios.setOnCheckedChangeListener { radioGroup, i ->  }
```

Con este listener se podría desde sacar cual es el radio seleccionado hasta sacar cual es el texto que tiene el radio seleccionado

```java
binding.grupoRadios.setOnCheckedChangeListener { radioGroup, i ->
            // de esta forma sacaríamos el texto del radio seleccionado
            val radio: RadioButton = findViewById(i);
            Snackbar.make(radio,radio.text,Snackbar.LENGTH_SHORT).show()

            // de esta forma sacaríamos un texto dependiendo de la seleccion realizada
            when(i){
                R.id.radio_uno->{Snackbar.make(radio,"Seleccionado uno",Snackbar.LENGTH_SHORT).show()}
                R.id.radio_dos->{Snackbar.make(radio,"Seleccionado dos",Snackbar.LENGTH_SHORT).show()}
                R.id.radio_tres->{Snackbar.make(radio,"Seleccionado tres",Snackbar.LENGTH_SHORT).show()}
            }
        }
```

## Spinner

Se trata de elementos desplegables que pueden contener tanto elementos de una lista o array declarado en el código como de un recurso de tipo string-array declarado dentro de la carpeta res. Para poder utilizarlo, gráficamente se debería utilizar el siguiente código dentro del fichero xml

```xml
    <Spinner
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/spinner_seleccion"
        />
```

Una vez está declarado elemento, es necesario llevarlo a la parte lógica y añadirle la parte de datos. Esta parte de datos es lo que se conoce como adaptador (ya lo vimos en elementos anteriores) y permite juntar un elemento gráfico con una parte de datos. Para ello es necesario crear el objeto ArrayAdapter y asociarlo mediante el método setAdater

```java
        val paises = arrayOf("Argentina","Brasil","Canada","Dinamarca","España","Estonia","Francia","Grecia","Hungria","Italia");
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,paises)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSeleccion.setAdapter(adapter)
```

Este código asociará la lista de países al spinner cuya id es spinnerSeleccion. En el caso de querer asociar el spinner a unos datos que ya existan como recursos de la aplicación lo primero necesario que dicho recurso exista. Para ello se creará un array de string dentro del fichero string.xml con el siguiente código

```xml
<string-array name="paises">
        <item>España</item>
        <item>Italia</item>
        <item>Francia</item>
        <item>Brasil</item>
        <item>Argentina</item>
</string-array>
```

Una vez hecho esto ya se podrá crear la asociación desde este recurso con el siguiente código

```java
        val adapter = ArrayAdapter.createFromResource(this,R.array.paises,android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSeleccion.setAdapter(adapter)
```

Como se puede ver es una creación muy similar a la anterior, con la diferencia que el array no se declara en la clase, sino que se coge como recurso. 
Una ves se ha creado el array, lo siguiente sería tratar sus eventos. En este caso el tratamiento no sería el de un onClick, ya que no estamos hablando de una pulsación simple, sino que sería el de una selección (que junta desplegar el spinner y seleccionar un elemento). PAra ello se utiliza un listener llamado onItemSelectedListener. En este caso y a diferencia de los vistos anteriormente, la interfaz del escuchador trae varios métodos (en concreto 2), por lo que hay que declararlo de forma diferente igualando el escuchador a un objeto con los dos métodos

```java
        binding.spinnerSeleccion.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
```

Ambos métodos serán ejecutados cuando una acción se produzca sobre el spinner. El primero de ellos se ejecutará cuando algo en el spinner esté seleccionado y el segundo cuando el spinner se desplegado y no cambie la selección del mismo. En el primero de los métodos se reciben como parámetros la vista que ha provocado el evento (p0), la vista que ha sido pulsada (p1), la posición pulsada (p2) y el id de la posición pulsada (p3). En el segundo de los métodos yan solo se recibe la vista que ha provocado el evento (p0)

```java
        binding.spinnerSeleccion.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Snackbar.make(p0!!,"La posición del spinner seleccionada es $p2",Snackbar.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Snackbar.make(p0!!,"El spinner se ha desplegado pero nada ha sido seleccionado",Snackbar.LENGTH_SHORT).show()
            }
        }
```

Ambos métodos se ejecutarán con una acción que se produzca en el spinner directamente, pero en el caso de querer sacar el dato seleccionado del spinner con otra acción diferente (por ejemplo la pulsación de un botón) el código sería el siguiente

```java
        binding.botonPulsar.setOnClickListener { view: View ->
            Snackbar.make(
                view,
                "El elemento seleccionado del spinner es ${binding.spinnerSeleccion.adapter.getItem(binding.spinnerSeleccion.selectedItemPosition)}",
                Snackbar.LENGTH_SHORT
            ).show()

        }
```

# Ejercicios propuestos

1. Realizar una aplicación que permita mediante un formulario:
- introducir dos números mediante un EditText. Como máximo se podrán introducir dos números*
- Seleccionar mediante un RadioGroup si se quiere obtener el resultado con decimales o sin decimales
- Seleccionar de un spinner la operación que se quiere realizar (suma, resta, multiplicación, división, módulo, seno, coseno, tangente). Hay que tener en cuenta que si se selecciona seno, coseno o tangente el segundo operando aparecerá deshabilitado.
- Un botón el cual al ser pulsado mostrará el resultado en un textview de la misma pantalla
- Un textView donde se mostrará el resultado de la operación

2. Realizar una aplicación para poder calcular el IMC de una persona y su estado de salud. Para ello la aplicación constará de dos pantallas: 
- MainActivity: donde aparecerá un formulario (de libre disposicioón y elementos) donde se podrá meter nombre, apellido, edad, altura, edad, sexo
- SecondActivity: donde aparecerá el IMC de la persona según los datos introducidos en la pantalla anterior. Para ello se deben seguir la siguiente fórmula:

IMC = peso (kg) / altura (cm)

Además de poner el IMC también podrá el estado fisico de la persona según lo mostrado en el siguiente enlace https://adultosmayores.info/salud/tablas-imc-por-edad/

Además se podrá modificar el color de la interfaz o adjuntar alguna imagen a un imageView para poder mostrar el resultado obtenido


# Modificación de interfaces en tiempo real: orientaciones

En ocasiones es interesante independizar la interfaz a la configuración del disposición del dispositivo. En unidades anteriores ya se vio este tema con la internacionalización de las cadenas de texto, pero existen otras muchas posibilidades para poder hacer aplicaciones independientes. Una de las más utilizadas es la del cambio de orientación de pantalla, es decir que la aplicación se muestre diferente si el teléfono está en horizontal (landscape) o en vertical (portraint). Para poder hacer esto tendremos que crear tantos recursos xml como configuraciones queramos gestionar. 

Antes de empezar a explicar como se realizan estas tareas, es importante recordar que cada vez que el teléfono sufre un cambio de configuración (bien sea de idioma, de giro, de aplicaciones a segundo plano como pueda ser recibir una llamada entrante), la aplicación vuelve a ejecutar el ciclo de vida, pasando por el método onCreate y volviendo a cargar toda la información. Esto es muy importante tenerlo en cuenta ya que se deberán gestionar estos cambios para que la información sea persistente cada vez que se producen. Para poder ver esto vamos hacer una aplicación que permita realizar pulsaciones con un botón y estas incremente o decrementen en uno un contador que será mostrado en un textview. El proyecto contará con una sola pantalla con el siguiente archivo xml


```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        app:layout_constraintGuide_percent="0.5" />

    <TextView
        android:id="@+id/text_contador"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="0"
        android:textSize="40sp"
        app:layout_constraintBottom_toTopOf="@+id/guideline2"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:text="+"
        android:textSize="40sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@+id/guideline3"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="@+id/guideline2"
        android:id="@+id/button_incremento"
        />

    <Button
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:text="-"
        android:textSize="40sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="@+id/guideline3"
        app:layout_constraintTop_toTopOf="@+id/guideline2"
        android:id="@+id/button_decremento"/>

    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        app:layout_constraintGuide_percent="0.50121653" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

Como se puede ver se han creado dos guías (una horizontal y otra vertical) para poder controlar el aspecto de la parte superior (50%) y la parte inferior (50%)

![activity_main.xml](./images/t3_configuraciones1.png)

Una vez creado la interfaz gráfica se procede a incorporar todos los elementos en la parte lógica, quedando el archivo MainActivity.kt de la siguiente forma:

```java
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        val view: View = binding.root
        setContentView(view)
    }
}
```

A partir de este momento todos los elementos estarán disponibles en la clase. Lo siguiente será detectar las pulsaciones de los botones y setear en el textview un contador que tendrá una cuenta, Para ello se realizan los escuchadores y acciones vistas en los temas anteriores

```java
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var contador: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        val view: View = binding.root
        setContentView(view)
        contador = 0;
        binding.textContador.text = contador.toString()
        acciones()
    }

    private fun acciones() {
        binding.buttonDecremento.setOnClickListener(this@MainActivity)
        binding.buttonIncremento.setOnClickListener(this@MainActivity)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button_decremento -> contador--;
            R.id.button_incremento -> contador++
        }
        binding.textContador.text = contador.toString()
    }
}
```

Nada más arrancar la aplicación se inicializa la variable contador a 0 y se pone en el textView. También se ha programado las pulsaciones de ambos botones para que cada vez que uno se pulsado la cantidad que tiene la variable se incremente o decremente dependiendo del valor y se ponga nuevamente dentro del texto. Con este código funcionaría perfectamente si no realizásemos ningún cambio de configuración (orientación por ejemplo).

![activity_main.xml](./images/t3_configuraciones2.png)


En el caso de realizar un cambio de orientación pasan dos cosas: 

1. Que la disposición de los elementos de la pantalla sigue siendo la misma cuando el tamaño de la pantalla en horizontal ha cambiado
2. Que el contador se ha puesto automáticamente a 0 ya que ha detectado un cambio de configuración. 

Para solucionar ambos casos vamos a ver como hacerlo de forma individual

## Gestionar la orientación

Para poder gestionar los cambios de orientación y que al girar el dispositivo se pueda mostrar de forma adecuada pantalla y no como se hace en vertical, es necesario crear un nuevo archivo xml llamado de la misma forma que el layout (en este caso activity_main.xml). Esto se puede hacer creándolo manualmente o creándolo desde el asistente. Para ello vamos a la carpeta res/layout botón derecho -> new layout resource file he indicamos el mismo nombre del archivo que queremos rotar (en nuestro caso activity_main.xml). Además de esto es necesario indicar en la listar de cualificadores de la parte inferior el de ortientation y dentro de este el de landscape

![activity_main.xml](./images/t3_configuraciones3.png)

Esto lo que hará será crear un archivo idéntico al anterior pero con el sufijo _land_ (indicando que será el que tiene que coger cuando el dispositivo está en horizontal). En el nuevo archivo creado se copiarán los mismos elementos que en el archivo inicial y se realizará la nueva disposición que se quiera.

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        app:layout_constraintGuide_percent="0.5" />

    <TextView
        android:id="@+id/text_contador"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="0"
        android:textSize="40sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@+id/guideline3"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button_incremento"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:text="+"
        android:textSize="40sp"
        app:layout_constraintBottom_toTopOf="@+id/guideline2"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="@+id/guideline3"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button_decremento"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:text="-"
        android:textSize="40sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="@+id/guideline3"
        app:layout_constraintTop_toTopOf="@+id/guideline2" />

    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        app:layout_constraintGuide_percent="0.50121653" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

En este caso se ha realizado el mismo diseño pero cambiando las restricciones para que los botones se muestren en horizontal

![activity_main.xml](./images/t3_configuraciones4.png)

Con este simple cambio ya se ha realizado el ajuste de la pantalla dependiendo de la orientación del teléfono. Esto se debe a que cuando el teléfono cambia de configuración, el ciclo de vida se ejecuta nuevamente y el método onCreate es ejecutado directamente, por lo que el método setContentView asocia el layout nuevamente (en este caso cogiendo el que tiene el sufijo land ya que es el de la orientación que tiene). Lo mismo pasaría con el resto de cambios de configuración (idioma, disposición de teclado, etc...).

Además de ejecutarse el método onCreate, se ejecuta por defecto el método onConfiguracionChanged(), el cual debería ser sobreescrito si se quiere utilizar 

```java
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.v("configuracion", "cambio detectado en la configuración")
        Log.v("configuracion", newConfig.toString())
    }
```

En el caso de no querer que los cambios de configuración le afecten a una activity, sería necesario indicar que cambio no afecta en el fichero AndroidManifest.xml

```xml
        <activity
            android:name=".MainActivity"
            android:configChanges="orientation|locale"
            android:exported="true" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```

Indicando esto tanto los cambios de orientación como los de localización no se verán afectados automáticamente y los tendremos que manejar nosotros en el código

Por último, para terminar este punto vamos a imaginar que en en layout de la parte horizontal hay un botón que no está presente en la parte vertical. Tan solo tendríamos que incluirlo en la parte horizontal

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        app:layout_constraintGuide_percent="0.5" />

    <TextView
        android:id="@+id/text_contador"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="0"
        android:textSize="40sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@+id/guideline3"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button_incremento"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:text="+"
        android:textSize="40sp"
        app:layout_constraintBottom_toTopOf="@+id/button_decremento"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="@+id/guideline3"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button_decremento"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:text="-"
        android:textSize="40sp"
        app:layout_constraintBottom_toTopOf="@+id/button_reset"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="@+id/guideline3"
        app:layout_constraintTop_toBottomOf="@+id/button_incremento" />

    <Button
        android:id="@+id/button_reset"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:text="Reset"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="@+id/guideline3"
        app:layout_constraintTop_toBottomOf="@+id/button_decremento" />

    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        app:layout_constraintGuide_percent="0.50121653" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

En este caso se ha incluido un tercer botón llamado botton_reset que lo que hará será resetear el contador y ponerlo a 0 nuevamente. Una vez se tiene declarado el elemento en la parte gráfica tan solo sería necesario utilizarlo en la parte lógica

```java
    private fun acciones() {
        binding.buttonDecremento.setOnClickListener(this@MainActivity)
        binding.buttonIncremento.setOnClickListener(this@MainActivity)
        binding.buttonReset?.setOnClickListener(this@MainActivity)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button_decremento -> contador--
            R.id.button_incremento -> contador++
            R.id.button_reset -> contador = 0

        }
        binding.textContador.text = contador.toString()
    }
```

En este caso, el método de las acciones ha incluido una nueva línea, indicando que la pulsación del nuevo botón también se regirá sobre el escuchador onClick. La diferencia con antes es que se ha incluido un ? para indicar que puede ser nulo (recordemos que si el móvil está en vertical el botón no estará), de forma que si el botón provoca un null la aplicación no se detendrá.

![activity_main.xml](./images/t3_configuraciones5.png)

## Mantenimiento de datos

Una vez se ha solucionado el problema de la interfaz, vamos ahora al problema de los datos que se pueden resetear. En la aplicación que estamos haciendo, cada vez que el dispositivo detecta un cambio de configuración el contador vuelve a 0. Esto pasa porque como ya se ha comentado el cambio de configuración provoca que se ejecute de nuevo el método onCreate y este inicializa el contador a 0 y lo setea. Si queremos que los datos sean guardados cada vez que se produce un cambio tendremos que hacer dos cosas: 

1. Guardarlos con el método onSavedInstanceState y su objeto de tipo Bundel

Este método sobreescrito es ejecutado justo antes del cambio de configuración. El parámetro outState de tipo Bundel guarda datos con un par clave - valor (tal y como vimos en el paso de parámetros entre pantallas), por lo que si queremos enviar algo para que luego sea recuperado primero debemos guardarlo en este objeto

```java
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador",contador);
    }
```

En este caso cuando se detecte un cambio de configuración se guardará en el estado saliente el valor de la variable contador, que irá asociada a la palabra contador

2. Recuperarlos con el objeto de tipo Bundel del método onCrete

Una vez producido el cambio de configuración se ejecutará el método onCreate. Este método cuenta con un parámetro de tipo Bundel, que representa el estado entrando (por si alguien ha mandado algún estado como en el punto uno) y se utiliza para recuperar los datos con un par clave valor

```java
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        val view: View = binding.root
        setContentView(view)

        /*
        sería lo mismo que en la línea siguiente
        if (savedInstanceState!=null){
            contador = savedInstanceState.getInt("contador")
        }*/

        contador = savedInstanceState?.getInt("contador") ?: 0
        binding.textContador.text = contador.toString()
        acciones()
    }
```

# Ejercicios propuestos

1. Realiza una aplicación que tenga tres botones y un chrometer. Cada uno de los botones servirá para iniciar una cuenta, para una cuenta o reiniciar una cuenta. Cada vez que uno de estos botones sea pulsado deberá mostrarse en el textview un cronometro con su correspondiente cuenta. Esta cuenta deberá "sobrevivir" a los cambios de orientación

2. Realizar una calculadora funcional tanto en horizontal como en vertical. La diferencie entre ambas será que la horizontal mostrará las operaciones básicas mientras que la horizontal mostrará operaciones científicas. Puedes meter tantas operaciones como quieras, cuanto más completa sea la calculadora mejora estará realizado el ejercicio

Puedes basarte en la interfaz de calculadoras de Android/Ios , etc...
