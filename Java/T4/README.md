<a name="tema4"></a>
## Interfaces gráficas				

a.	Layouts

- http://www.developandsys.es/layout/

### LinearLayout
- http://www.developandsys.es/layout/
- https://developer.android.com/guide/topics/ui/layout/linear

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
		android:hint:"Introduce texto"
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
- http://www.developandsys.es/layout/
- https://developer.android.com/guide/topics/ui/layout/relative
- https://developer.android.com/training/constraint-layout/index.html
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

- http://www.developandsys.es/elementos-graficos-botones/
- https://developer.android.com/guide/topics/ui/controls/button.html

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
- http://www.developandsys.es/elementos-graficos-botones/
- https://developer.android.com/guide/topics/ui/controls/togglebutton
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
### SwitchButton
- http://www.developandsys.es/elementos-graficos-botones/
- https://developer.android.com/guide/topics/ui/controls/togglebutton
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
- http://www.developandsys.es/elementos-graficos-checkbox-radiobutton-otros/
- https://developer.android.com/guide/topics/ui/controls/checkbox
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

- http://www.developandsys.es/elementos-graficos-checkbox-radiobutton-otros/
- https://developer.android.com/guide/topics/ui/controls/radiobutton

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
***

Los spinners representan un elemento de selección de datos muy sencillo de utilizar. Para poder utilizar un spinner hay que tener en cuenta que tiene dos elementos: parte gráfica (represetado por el elemento en xml y su correspondiente java) y un modelo de datos donde se cargan todos los elementos a mostrar (representado por un adaptador simple o compuesto)

Para poder utilizar un spinner básico:

1. Crear un spinner en el xml
````
<Spinner
android:elevation="20dp"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:id="@+id/spinner"/>
````
2. Instanciar el array en el .java y crear una coleccion de los datos que se quieren representar
````
Spinner sp = findViewById(R.id.spinner);
ArrayList listaDatos = new ArrayList();
for (int i = 1; i<11;i++){
   listaDatos.add("Opción "+String.valueOf(i));
}
````
3. Crear un objeto de tipo ArrayAdapter y asociarlo con el spinner (varios tipos de constructor)
````
ArrayAdapter adapterSpinner =
        new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaDatos);
adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinner.setAdapter(adapterSpinner);
````
4. Obtener información de los elementos asociados al spinner 
````
//obtiene el elemento selecionado en la posición correspondiente;
spinner.getSelectedItemPosition();
//método que notifica al adaptador que algo ha cambiado en la parte de datos
//este método siempre se tienen que ejecuatra cuando se añade/borra/modifican datos
adapterSpinner.notifyDataSetChanged();
//devuelve el numero de elementos asociados
adapterSpinner.getCount();
//devuelve el elementos asociado a una posición concreta
adapterSpinner.getItem();
//devuleve el id del elemento asociado a una posción concreta
adapterSpinner.getItemId();
````
5. Evaluar la pulsación del spinner
````
spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                //Ejecuatado cuando la selección cambie
                Toast.makeText(getApplicationContext(),
                        String.valueOf(parent.getAdapter().getItem(position)),Toast.LENGTH_SHORT).show();
            }
 
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Ejecutado cuando se ejecuta la activity
            }
});
````
** Crear un spinner desde un recurso creado en el proyecto **
***

Los puntos son identicos a los anteriores con la única diferencia de la asociación

1. Crear un array en el fichero localizaco en res -- values -- arrays.xml
````
<resources>
    <integer-array name="numeros">
        <item>4</item>
        <item>8</item>
        <item>1</item>
        <item>2</item>
        <item>4</item>
        <item>5</item>
    </integer-array>
</resources>
````
2. Crear el adaptador mediante el método estático createFromResource()
````
ArrayList adaptaAnidado = ArrayAdapter.createFromResource(getApplicationContext(),R.array.numeros,android.R.layout.simple_spinner_item);                    
````

### ListView
***
Un objeto de tipo listView tiene la misma funcionalidad que un Spinner pero la forma de representación de los datos cambia.
1. Crear el xml de la actividad con el listview
````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".elementos.ListaActivity"
    android:orientation="vertical">

    <ListView
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="0.8"
        android:id="@+id/listaListView" 
        android:divider="@color/colorAccent"
        android:dividerHeight="1dp"/>

</LinearLayout>
````
2. Instanciarlo en el .java de la actividad y crear un adaptador simple con el layout que android ofrece para asociarlo
````
lista = findViewById(R.id.listaListView);
ArrayList listaOpciones= new ArrayList();
for(int i=0;i<101;i++){
   listaOpciones.add("Opción "+String.valueOf(i));
 }
ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,listaOpciones);
lista.setAdapter(adapter);
````
3. Evaluar la pulsación de la lista evaluando la posición
````
lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      Toast.makeText(getApplicationContext(),"Posición: "+String .valueOf(position),Toast.LENGTH_SHORT).show(); 
      parent.getAdapter().getItem(position);     
   }
});
````

### GridView
***



#### [Volver al índice](#tema4)

d.	Listas personalizadas: adaptadores

- http://www.developandsys.es/manejo-avanzado-listview-spinner/
- http://www.developandsys.es/adaptadores-listas-personalizadas/

### Adaptadores personalizados Spinner

En muchas ocasiones no es suficiente con la representación de datos mostrada en el punto anterior, ya que puede ser demasiado simple. Para poder personalizarla se debe crear un adaptador personalizado el cual diga exactamente cual es el comportamiento de cada una de la fila de datos que representa el spinner. Para ello:

1. Se crea un xml con el aspecto que se quiere para una fila (todas las filas tienen el mismo aspecto pero con datos diferentes).

````
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:layout_margin="10dp">

    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/imagenSpinner"
        android:src="@mipmap/ic_launcher"/>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/nombreSpinner"
        android:text=""
        android:textSize="30dp"
        android:gravity="center_vertical|center_horizontal"
        android:textAlignment="center"
        />

</LinearLayout>
````
2. Crear una clase que exienda de BaseAdapter
````
public class AdaptadorSpinnerPerso extends BaseAdapter{

    // número de elementos que tendrá que "renderizar" el adaptador
    @Override
    public int getCount() {
        return null;
    }

    // obtención del un elemento en una posición determinada
    @Override
    public Object getItem(int position) {
        return null;
    }

    // obtención del id de un elemento en una posición determinada
    @Override
    public long getItemId(int position) {
        return null;
    }

    // como se debe renderizar la fila
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null;
    }
}

````
3. Crear un constructor que permita la obtención de una lista de datos y el contexto donde se ejecutan los elementos
````
public class AdaptadorSpinnerPerso extends BaseAdapter{

    List listaDatos;
    Context context;

    public AdaptadorSpinnerPerso(List listaDatos, Context context) {
        this.listaDatos = listaDatos;
        this.context = context;
    }
}
````

4. Rellenar los métodos sobreescritos
4.1 getCount() devuelve el número de filas que se deben pintar en el elemento
4.2 getItemId() devuelve el id del elemento seleccionado
4.3 getItem() devuelve el elemento seleccionado
4.4 getView() devuleve el la vista que será utilizada para representar cada una de las filas del elemento. Para poder "pegar la vista que se ha generado en el punto 1 se utiliza un objeto de tipo inflater"

````

public class AdaptadorSpinnerPerso extends BaseAdapter{

    List listaDatos;
    Context context;

    public AdaptadorSpinnerPerso(List listaDatos, Context context) {
        this.listaDatos = listaDatos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaDatos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaDatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.item_spinner_layout,parent,false);
        return convertView;
    }
}
````

5. Por último quedaría asociar adaptador creado con el spinner

````
Spinner sp = findViewById(R.id.spinner)
ArrayList<Usuarios> listaDatos = new ArrayList<Usuarios>;
AdaptadorSpinnerPerso adaptador = new AdaptadorSpinnerPerso(getApplicationContext(),listaDatos);
sp.setAdapter(adaptador)
````
**Mejorar el funcionamiento del adaptador**
Si se sigue la lógica del objeto de tipo adaptador, este ejecutará el métodos getView tantas veces como elementos existan en la lista de datos que se quieren representar. Según lo antarior, en este método se inflará n veces la vista que se debe representar por lo que esto puede ser bastante poco productovo. Para ello se utiliza el concepto de holder, el cual realiza esta acción solo la primera vez, el resto de veces recupera la información


1. Crear una clase anidada en la clase del adaptador vista anteriormente con los elementos que contiene la vista (fila del elemento) con un constructor e implementarlos
````
public class AdaptadorSpinnerPerso extends BaseAdapter {

    List listaDatos;
    Context context;

    public AdaptadorSpinnerPerso(List listaDatos, Context context) {
        this.listaDatos = listaDatos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaDatos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaDatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

    
        return convertView;
    }

    class HolderAdicional{

        TextView nombre;
        ImageView imagen;

        public HolderAdicional(View view) {
            nombre = view.findViewById(R.id.nombreSpinner);
            imagen = view.findViewById(R.id.imagenSpinner);
        }

        public TextView getNombre() {
            return nombre;
        }

        public ImageView getImagen() {
            return imagen;
        }
    }
}
````
2. Modificar el método getView para que solo se rellene la vista la primera vez que se ejecute y el resto de veces se recuperen los datos
````
@Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HolderAdicional holderAdicional = null;

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_spinner_layout, parent, false);
            holderAdicional = new HolderAdicional(convertView);
            convertView.setTag(holderAdicional);

        }
        else {
            holderAdicional = (HolderAdicional) convertView.getTag();
        }

        Persona p = (Persona) listaDatos.get(position);
        if (p.getSexo() == 0) {
            holderAdicional.getImagen().setImageResource(R.drawable.c1);
        } else if (p.getSexo() == 1) {
            holderAdicional.getImagen().setImageResource(R.drawable.c2);
        }
        holderAdicional.getNombre().setText(p.getNombre());

        holderAdicional.getImagen().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Has pulsado imagen",Toast.LENGTH_SHORT).show();
            }
        });
        holderAdicional.getNombre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Has pulsado nombre",Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
````
###ListView
***
Un objeto de tipo listView tiene la misma funcionalidad que un Spinner pero la forma de representación de los datos cambia.
1. Crear el xml de la actividad con el listview
````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".elementos.ListaActivity"
    android:orientation="vertical">

    <ListView
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="0.8"
        android:id="@+id/listaListView" 
        android:divider="@color/colorAccent"
        android:dividerHeight="1dp"/>

</LinearLayout>
````
2. Instanciarlo en el .java de la actividad y crear un adaptador simple con el layout que android ofrece para asociarlo
````
lista = findViewById(R.id.listaListView);
ArrayList listaOpciones= new ArrayList();
for(int i=0;i<101;i++){
   listaOpciones.add("Opción "+String.valueOf(i));
 }
ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,listaOpciones);
lista.setAdapter(adapter);
````
3. Evaluar la pulsación de la lista evaluando la posición
````
lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      Toast.makeText(getApplicationContext(),"Posición: "+String .valueOf(position),Toast.LENGTH_SHORT).show(); 
      parent.getAdapter().getItem(position);     
   }
});
````
### ListView con un adaptador personalizado
***
1. Crear el xml que representa el aspecto de la fila
````
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:layout_margin="10dp">

    <ImageView
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:scaleType="centerCrop"
        android:id="@+id/imagenLista"
        android:src="@mipmap/ic_launcher"/>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/nombreLista"
        android:text=""
        android:textSize="30dp"
        android:gravity="center_vertical|center_horizontal"
        android:textAlignment="center"
        />

</LinearLayout>
````
2. Crear una clase que extienda de baseadapter y sobreescribir los metodos
````
public class AdaptadorListaPerso extends BaseAdapter {

    @Override
    public int getCount() {
        return null;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null;
    }

}
````
3. Crear un constructor en la misma clase al que se le pasen los parámetros necesarios. Lo normal es que necesite un contexto un una lista de datos
````
    List listaDatos;
    Context context;

    public AdaptadorListaPerso(List listaDatos, Context context) {
        this.listaDatos = listaDatos;
        this.context = context;
    }
````
4. Rellenar los métodos correspondientes que se han sobreescrito en la clase
````
public class AdaptadorListaPerso extends BaseAdapter {

    List listaDatos;
    Context context;

    public AdaptadorListaPerso(List listaDatos, Context context) {
        this.listaDatos = listaDatos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaDatos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaDatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HolderAdicional holderAdicional = null;

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_spinner_layout, parent, false);
            holderAdicional = new HolderAdicional(convertView);
            convertView.setTag(holderAdicional);

        }
        else  
            holderAdicional = (HolderAdicional) convertView.getTag();

        Persona p = (Persona) listaDatos.get(position);
        holderAdicional.getNombre().setText(p.getNombre());
        holderAdicional.getImagen().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Has pulsado imagen",Toast.LENGTH_SHORT).show();
            }
        });
        holderAdicional.getNombre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Has pulsado nombre",Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    class HolderAdicional{

        TextView nombre;
        ImageView imagen;

        public HolderAdicional(View view) {
            nombre = view.findViewById(R.id.nombreSpinner);
            imagen = view.findViewById(R.id.imagenSpinner);
        }

        public TextView getNombre() {
            return nombre;
        }

        public ImageView getImagen() {
            return imagen;
        }
    }
}
````
5. Crear un objeto de tipo adaptador en la clase de la actividad y ponerselo a la lista
````
AdaptadorListaPerso adaptadorListaPerso = new AdaptadorListaPerso(personas,getApplicationContext());
lista.setAdapter(adaptadorLsitaPerso);
````

##RecyclerView
***
El recyclerview representa una lista de datos optimizada, la cual sustituye al elemento listview. Para poder utilizarlo la funionalidad es muy parecida a la de las listas, con la diferencia del adaptador. En el caso de recycler, cuenta con una clase propia con su holder individual: 

1. Importar librerias necesarias en el gradle
````
implementation 'com.android.support:recyclerview-v7:28.0.0'
implementation 'com.android.support:design:28.0.0'
````
2. Crear un objeto recycler en el xml y instanciarlo en el .java
````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <android.support.v7.widget.RecyclerView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/recyclerView"
        />

</LinearLayout>
````
````
recyclerView = findViewById(R.id.recyclerView);
````
3. Crear un xml con el aspecto que tendrá cada una de las filas del recycler

````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:id="@+id/layoutItem">

    <ImageView
        android:layout_width="0dp"
        android:layout_weight="0.2"
        android:layout_height="wrap_content"
        android:src="@mipmap/ic_launcher" />

    <LinearLayout
        android:layout_width="0dp"
        android:layout_weight="0.4"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:weightSum="1">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="0.5"
            android:gravity="center_horizontal|center_vertical"
            android:id="@+id/nombreItem"/>

        <TextView
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="0.5"
            android:gravity="center_horizontal|center_vertical"
            android:id="@+id/apellidItem"/>

    </LinearLayout>

    <TextView
        android:layout_width="0dp"
        android:layout_weight="0.4"
        android:layout_height="wrap_content"
        android:id="@+id/telefonoItem"
        android:layout_gravity="center"/>

</LinearLayout>
````
4. Crear una clase que extienda de RecyclerView.Adapter junto con una clase que exienda de RecyclerView.ViewHolder. Hay que tener en cuenta que el constructor del adaptador puede modificar su forma, tomando aquella que más nos interese
````
public class AdaptadorPersoRecycler extends RecyclerView.Adapter<AdaptadorPersoRecycler.HolderPropio> {

    List<Persona> listaDatos;
    Context context;

    public AdaptadorPersoRecycler(Context context) {
               this.context = context;
    }

    @NonNull
    @Override
    public HolderPropio onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderPropio holderPropio, final int i) {
       
    }

    @Override
    public int getItemCount() {
        return null;
    }

   class HolderPropio extends RecyclerView.ViewHolder {

        public HolderPropio(@NonNull View itemView) {
            super(itemView);
            
        }

    }
}
````
5. Rellenar los métodos
- length: cantidad de elementos que tendrá la lista
````
    @Override
    public int getItemCount() {
        return listaDatos.size();
    }
````
- onCreateViewHolder: creación del objeto de tipo holder que tendrá la vista xml previamente inflada
````
    @NonNull
    @Override
    public HolderPropio onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler, viewGroup, false);
        HolderPropio holderPropio = new HolderPropio(v);
        return holderPropio;
    }
````

- onBindViewHolder: representar cada uno de los objetos que se "pintarán en las filas".
````
    @Override
    public void onBindViewHolder(@NonNull HolderPropio holderPropio, final int i) {
        final Persona p = listaDatos.get(i);
        holderPropio.getNombre().setText(p.getNombre());
        holderPropio.getApellido().setText(p.getApellido());
        holderPropio.getTelefono().setText(String.valueOf(p.getTelefono()));
        holderPropio.getNombre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, p.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }
````
- Clase Holder: representa los objetos del xml, instanciándolos
````
    class HolderPropio extends RecyclerView.ViewHolder {

        TextView nombre, apellido, telefono;
        LinearLayout linearLayout;


        public HolderPropio(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombreItem);
            telefono = itemView.findViewById(R.id.telefonoItem);
            apellido = itemView.findViewById(R.id.apellidItem);
            linearLayout = itemView.findViewById(R.id.layoutItem);
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getApellido() {
            return apellido;
        }

        public TextView getTelefono() {
            return telefono;
        }

        public LinearLayout getLinearLayout() {
            return linearLayout;
        }
    }
````
6. Crear un objeto de tipo adaptador en la clase donde está el recycler
````
adaptadorPersoRecycler = new AdaptadorPersoRecycler(this);
recyclerView.setAdapter(adaptadorPersoRecycler);
````
7. Poner un Layout al recycler y un divisor entre elementos
````
recyclerView.setLayoutManager(
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
recyclerView.addItemDecoration(
                new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
````

**Eventos en un recycler**
***

Para poder actuar ante un evento en un recyclerview hay varias formas de hacerlo. Como se ha visto hasta ahora, se podría dar una acción a cualquiera de los elementos presentes en la fila del recycler simplemente poniendo el escuchador asociado:

````
    @Override
    public void onBindViewHolder(@NonNull HolderPropio holderPropio, final int i) {
        final Persona p = listaDatos.get(i);
        holderPropio.getNombre().setText(p.getNombre());
        holderPropio.getApellido().setText(p.getApellido());
        holderPropio.getTelefono().setText(String.valueOf(p.getTelefono()));
        holderPropio.getNombre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, p.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }
````

Sin enbargo esto puede no ser del todo funcional, ya que los datos no están accesibles desde la Activity o lugar donde se haya renderizado el recycler. Otra posibilidad es declarar un método estático **(ojo con esto)** para poder llamarlo desde la clase adaptador. 
Como es de suponer, el elemento recycler no cuenta con un listener como lo hacía el elemento ListView, el cual me decía la posición pulsada. La solición esta en el uso de las interfaces de CallBack. El concepto es el siguiente:
- Se crea una interfaz en el origen de los datos (clase adaptador), la cual es llamada (ejecutado sus métodos (**sin tenerlos haber implementado**) desde la acción que produce la comunicación (pulsación de un botón)
- Se implementa dicha interfaz en el destino de los datos, obligando a rellenar los métodos creados en el paso anterior
- En el origen de los datos se intancia la interfaz (para poder utilizar los datos), igualándola al contexto (ya que en el contexto ha sido implementada).

De esta forma la interfaz es ejecutada en el adaptador pero donde realmente se ejecutará el método es donde esté implementada, ya que ahí es donde está la definición del método. Los pasos son los siguientes:

1. Crear una interfaz en el origen de los datos con un método que contenga los datos que se quieren pasar. EN este caso la clase del adaptador
````
public class AdaptadorPersoRecycler extends RecyclerView.Adapter<AdaptadorPersoRecycler.HolderPropio> {

    // incluir el resto de métodos explicados anteriormente   
    public interface OnAdaptadorPersoListener{
        public void onAdaptadorPersoSelected(Persona persona);
    }
   
}
````
2. Llamar al método creado en la interfaz cuando se quieran lanzar los datos al destino

````
@Override
    public void onBindViewHolder(@NonNull HolderPropio holderPropio, final int i) {
        final Persona p = listaDatos.get(i);
        holderPropio.getNombre().setText(p.getNombre());
        holderPropio.getApellido().setText(p.getApellido());
        holderPropio.getTelefono().setText(String.valueOf(p.getTelefono()));
        holderPropio.getNombre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, p.getNombre(), Toast.LENGTH_SHORT).show();
                adaptadorPersoListener.onAdaptadorPersoSelected(p);
            }
        });
    }
````

3. Implementar la interfaz en el destino de los datos, obligando a implementar los métodos
````
public class MainActivity extends AppCompatActivity implements AdaptadorPersoRecycler.OnAdaptadorPersoListener {

    RecyclerView recyclerView;
    AdaptadorPersoRecycler adaptadorPersoRecycler;
    Persona p;

   	// incluir todos los métodos de la clase

    @Override
    public void onAdaptadorPersoSelected(Persona persona) {
        p = persona;
        Toast.makeText(getApplicationContext(),"Persona en Activity" + p.getNombre(),Toast.LENGTH_SHORT).show();
    }
}
````

4. Crear un objeto del tipo interfaz e igualarlo al contexto
````
public class AdaptadorPersoRecycler extends RecyclerView.Adapter<AdaptadorPersoRecycler.HolderPropio> {

    Context context;
	OnAdaptadorPersoListener adaptadorPersoListener;
    // incluir el resto de métodos explicados anteriormente   
    
    public AdaptadorPersoRecycler(Context context) {
        
        this.context = context;
        adaptadorPersoListener = (OnAdaptadorPersoListener) context;
    }
    
    public interface OnAdaptadorPersoListener{
        public void onAdaptadorPersoSelected(Persona persona);
    }
 
}
````
###CardView
- http://www.developandsys.es/cardview/
*****

Este elemento se basa en la representación del tipico apartado dentro del play store. Se puede utilizar de forma individual o incluyéndolo en un recylerview (por ejemplo). Para poder utilizar este elemento:

1. Implementar la libreria de cardview y recyclerview
````
implementation 'com.android.support:recyclerview-v7:28.0.0'
implementation 'com.android.support:cardview-v7:28.0.0'
````
2. Crear un xml que configure el item del recycler
````
<?xml version="1.0" encoding="utf-8"?>
<android.support.v7.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/layoutRecycler"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="10dp"
    android:gravity="center"
    android:orientation="vertical"
    android:elevation="50dp"
    app:cardCornerRadius="20dp">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:gravity="center">

        <ImageView
            android:id="@+id/imagenRecyclerItem"
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:src="@mipmap/ic_launcher" />

        <TextView
            android:id="@+id/nombreRecyclerItem"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="10dp"
            android:text="asdasdasda"
            android:gravity="center"/>
        <TextView
            android:id="@+id/detalleRecyclerItem"
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:text="Descripción de un elemento y que solo se ven dos lineas "
            android:lines="2"
            android:maxLines="2"
            android:ellipsize="end"
            android:gravity="center"/>
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/botonItemRecycler"
            android:layout_gravity="center"
            android:text="Pulsar"
            style="@style/Widget.AppCompat.Button.Borderless.Colored"/>

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/botonBorrarItemRecycler"
            android:layout_gravity="center"
            android:text="Borrar"
            style="@style/Widget.AppCompat.Button.Borderless.Colored"/>

    </LinearLayout>

</android.support.v7.widget.CardView>
````
3. Crear un adaptador que infle el xml
````
public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.Holder> {

    OnRecyclerListener onRecyclerListener;
    Context context;
    List<Juego> listaDatos;

    public AdaptadorRecycler(Context context) {
        this.context = context;
        listaDatos = DataSet.newInstance().darJuegos();
        onRecyclerListener = (OnRecyclerListener) context;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler, viewGroup, false);
        Holder h = new Holder(v);
        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        
    }

    public void borrarElemento(Juego juego){
        listaDatos.remove(juego);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }   

}

````
4. Trabajar el elemento como si fuese un elemento normal de RecyclerView

#### [Volver al índice](#tema4)

** RecyclerView con cartas diferentes
