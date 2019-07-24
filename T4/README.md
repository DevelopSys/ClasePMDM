<a name="tema4"></a>
## Interfaces gráficas				
#### [Volver al índice](#indice)
***

a.	Layouts

- http://www.developandsys.es/layout/

#### [Volver al índice](#tema4)

### LinearLayout
***
Colocación de los elementos de arriba a abajo o izquierda a derecha, dependienndo del atributo orientation

```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity"
    android:layout_margin="20dp">
	<EditText
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		android:hint:"Introcude texto"
	/>
	<Button 
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		android:id="@+id/boton1"
		android:text="Enviar"/>

</LinearLayout
```

Tener en cuenta la suma de pesos:

0dp en aquella posición que se quiere repartir con pesos
weigth de 0.0. a 1.0 identifica el % de espacio que tendrá el elemento

android:layout_width="match_parent"
android:layout_height="0dp"
android:layout_weight="0.5"

### TableLayout
***
Utilizado para mostrar elementos con una disposición de tabla. Este tipo de layout está formado por un TableLayout que a su vez lo forma TableRow donde estarán incluidos los elementos. Hay que tener en cuenta que los elementos se colocarán de izquierda a derecha
1. Declarar un table layout
````
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".TableActivity">
    
</TableLayout>
````

2. Hacer que las columnas aprovechen el espacio en su totalidad mediante la propiedad strechColumn o shrinkColum
````
<?xml version="1.0" encoding="utf-8"?>
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:stretchColumns="*"
    tools:context=".TableActivity">

</TableLayout>
````
3. Declarar un par de filas dentro del layout. Estos elementos tienen como opción la configuración de alto y ancho. En este caso ocuparán en 50% cada una
````
<?xml version="1.0" encoding="utf-8"?>
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:stretchColumns="*"
    tools:context=".TableActivity">

    <TableRow
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="0.5">

    </TableRow>

    <TableRow
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="0.5">

    </TableRow>

</TableLayout>
````

4. Incluir elementos dentro del table las filas
````
<?xml version="1.0" encoding="utf-8"?>
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:stretchColumns="*"
    tools:context=".TableActivity">

    <TableRow
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="0.5">

        <TextView
            android:text="Elemento 1"
            android:textSize="20dp" />

        <TextView
            android:text="Elemento 2"
            android:textSize="20dp" />

        <TextView
            android:text="Elemento 3"
            android:textSize="20dp" />

    </TableRow>

    <TableRow
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="0.5">

        <TextView
            android:text="Elemento 4"
            android:textSize="20dp" />

        <TextView
            android:text="Elemento 4"
            android:textSize="20dp" />

    </TableRow>

</TableLayout>
````
5. Hacer que un elemento esté colocado en una posición concreta mediante la opción layout_column. Si no se indica por defecto aparecerán los elementos de iquierda a derecha
````
<TableRow
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="0.5">

        <TextView
            android:text="Elemento 4"
            android:textSize="20dp" />

        <TextView
            android:text="Elemento 5"
            android:textSize="20dp"
            android:layout_column="2"/>

    </TableRow>
````
6. Hacer que un elemento ocupe dos columnas mediante la propiedad column_span
````
<TableRow
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="0.5">

        <TextView
            android:text="Elemento 4"
            android:textSize="20dp" />

        <TextView
            android:text="Elemento 5"
            android:textSize="20dp"
            android:layout_span="2"
            android:layout_gravity="center_horizontal"/>

    </TableRow>
````

### RelativeLayout y ContraintLayout
***

ContraintLayut es la evolución de relativelayout, utilizando restricciones entre elementos para pode colocarlos. Hay que tener en cuenta que para poder utilizar este tipo de layout hay que tener configuradas las id aunque no se vayan a utilizar en el código java. Este tipo de layout es de la libreria de soporte

1. Declarar un ConstraintLayout

````
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto">

  
</android.support.constraint.ConstraintLayout>
````

2. Crear un elemento inicial situado con respecto a la pantalla mediante las propiedades layout_constraintPosicion

````
<TextView
        android:id="@+id/etiqueta"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="246dp"
        android:layout_marginEnd="162dp"
        android:layout_marginStart="163dp"
        android:layout_marginTop="246dp"
        android:text="Elemento"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
````
2. Crear un elemento y colocarlo con respecto al anterior indicando las restricciones mediante la propiedad layout_constraintPosicion
````
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <TextView
        android:id="@+id/etiqueta"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="246dp"
        android:layout_marginEnd="162dp"
        android:layout_marginStart="163dp"
        android:layout_marginTop="246dp"
        android:text="Elemento"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Etiqeta 2"
        app:layout_constraintTop_toBottomOf="@id/etiqueta" 
        app:layout_constraintStart_toEndOf="@id/etiqueta"/>

</android.support.constraint.ConstraintLayout>
````
### FrameLayout
***
Utilizado para dividir la pantalla en "capas" las cuales se van superponiendo. Este tipo de layout se suele utilizar en conjunto con alguno de los explicados anteriormente. Se utilizará mucho cuando se explique el concepto de fragments

````
<FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
 
    <ImageView android:id="@+id/imagenUno"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:src="@drawable/fondo.png" />

    <ImageView android:id="@+id/imagenDos"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:src="@drawable/capauno.png" />
 
</FrameLayout>
````

#### [Volver al índice](#tema4)


b.	Botones,Textos, EditText, radios, checks

- http://www.developandsys.es/elementos-graficos-botones/
- http://www.developandsys.es/elementos-graficos-textos/
- http://www.developandsys.es/elementos-graficos-checkbox-radiobutton-otros/

Los views representan los elementos de la interfaz gráfica. 

### Button
***
Elemento principal de formulario, utilizado para disparar acciones

```
<Button
            android:text="Elemento 1"
            android:textSize="15sp"
            android:background="@android:color/holo_orange_light"
            android:textColor="@android:color/white"
            android:id="@+id/boton1"
/>
```

Existe la posibilidad de personalizar el aspecto del botón, para ello se utiliza un xml como background, donde se declara mediante un selector cuales son los elemtnso que quedarán represantados en el botón.

1. En drawable crear un selector
````
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
</selector>
````
2. Asociar estados con imagenes en el fichero creado en items
````
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:state_pressed="true" android:drawable="@drawable/up_press"/>
    <item android:state_pressed="false" android:drawable="@drawable/up"/>
</selector>
````
3. Poner el archivo generado como parte del src (o background) del boton 
````
<ImageButton
android:layout_width="0dp"
android:layout_height="match_parent"
android:layout_weight="0.5"
android:src="@drawable/boton_up"
android:background="@null"
android:scaleType="fitCenter"
android:id="@+id/botonUpCartas"
android:alpha="0.1"
/>
````

#### Asignar acciones a un botón
***

Mediante dos metodos:

- Por el atributo onClick definido en el xml

Más sencillo, menos productivo

1. Declarar el atributo onclick en el elemento button del xml

````

````

2. Declarar un método con el mismo nombre que el asignado al atributo en el paso anterior

````
````

3. Asignar al parámetro view la acción que se quiere realizar
````
````

- Por la asignación de un escuchador en la clase java asociada al xml

Más tedioso, más productivo

1. Implementar la interfaz que maneja el evento de pulsado en la clase donde se encuentra el botón


```
public class ActivityMain extends AppCompatActivity implements View.OnClickListener {

    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.boton1);
    }

    @Override
    public void onClick(View v) {
     
    }
}
```

2. Asignar al botón un escuchador de pulsación. El método tendrá que ser llamado en el onCreate()

```
private void acciones() {
        b1.setOnClickListener(this);
    }
```

3. En el método implmententado evaluar el view para asgnar la acción al botón

```
@Override
    public void onClick(View v) {
        int idPulsado = v.getId();
        switch (idPulsado) {
            case R.id.boton1:
                break;
            case R.id.boton2:
                break;
            case R.id.boton3:
                break;
        }
    }
```

*** Mediante un switch se puede evaluar el v.getId() para la asignación de eventos a varios elementos al mismo tiempo ***

### ImageButton
***

### ToogleButton
***

1. Declarar el elemento en el xml
````
    <ToggleButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/togButton"
        android:textOff="Apagado"
        android:textOn="Encendido"
        android:checked="true"/>
````
2. Instanciarlo en el .java
````
tog = findViewById(R.id.togButton);
````
3. Tratar su evento asociado
````
tog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tog.isChecked();
            }
        });
````
### Elemento SwitchButton
***

1. Crear un objeto en el xml
````
<Switch
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:id="@+id/switchButton"/>
````
2. Instanciarlo en el .java
````
aSwitch = findViewById(R.id.switchButton);

````
3. Tratar su evento asociado
````
aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                aSwitch.setChecked(true);
                aSwitch.isChecked();
            }
        });
````

### CheckBox
***
1. Crear un elemento en el xml
````
<CheckBox
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Ejemplo de Check"
        android:id="@+id/checkboxUno"/>
````
2. Instanciarlo en el .java
````
checkBox = findViewById(R.id.checkboxUno);
````
3. Evaluar su cambio en el estado
````
checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getApplicationContext(),String.valueOf(isChecked),Toast.LENGTH_SHORT).show();
                checkBox.isChecked();
                checkBox.setSelected(false);

            }
        });
````

También existe la posibilidad de evaluar el estado del check sin necesidad de esperar a que cambie, por ejemplo en el evio de un formulario

````
boolean seleccionado = checkBox.isChecked();
````

### RadioButton y RadioGroup 
***
Los radiobutton se pueden tratar de forma individual (hay que tener en cuenta que si es pulsado no podrá a ser deseleccinado por parte del usuario)
1. Crear un elemento RadioButton en el xml
````
<RadioButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Radio individual"
        android:id="@+id/radioIndividual"/>
````
2. Instanciarlo en el .java
````
radioInd = findViewById(R.id.radioIndividual);
````
3. Evaluar su pulsación
````
radioInd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                
            }
        });

// ó

radioGrupoUno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
````
Los grupos de radios lo forman varios botones de manera que es imposible que dos botones puedan ser pulsados al mismo tiempo

1. Crear un elemento RadioGroup en el xml junto con los RadioButtons asociados
````
<RadioGroup
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/radioGroup">

        <RadioButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Radio individual"
            android:id="@+id/radioGrupoUno"/>

        <RadioButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Radio individual"
            android:id="@+id/radioGrupoDos"/>

    </RadioGroup>
````
2. Instanciarlo en el .java
````
radioGroup = findViewById(R.id.radioGroup);
````
3. Evaluar su pulsación en conjunto
````
radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Toast.makeText(getApplicationContext(),findViewById(checkedId).toString(),Toast.LENGTH_SHORT).show();
                group.getCheckedRadioButtonId();
            }
});
````

### Elemento SeekBar
***
1. Declarar el elemento en el xml
````
<SeekBar
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/seekBar"/>
````
2. Instanciarlo en el .java
````
barra = findViewById(R.id.seekBar);

````

3. Tratar su evento asociado
````
barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(getApplicationContext(),findViewById(progress).toString(),Toast.LENGTH_SHORT).show();
                seekBar.getProgress();
                seekBar.setMax(100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
````

### ImageView

#### [Volver al índice](#tema4)


c.	Listas básicas: spinner, ListView, GridView, recycler view, CardView

- http://www.developandsys.es/elementos-graficos-spinner/
- http://www.developandsys.es/elementos-graficos-listview-gridview/
- http://www.developandsys.es/recycler-view/
- http://www.developandsys.es/cardview/

***

### Spinner

#### [Volver al índice](#tema4)


d.	Listas personalizadas: adaptadores

- http://www.developandsys.es/manejo-avanzado-listview-spinner/
- http://www.developandsys.es/adaptadores-listas-personalizadas/

#### [Volver al índice](#tema4)
