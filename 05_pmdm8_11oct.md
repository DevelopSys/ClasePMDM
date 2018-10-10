# Cuarta semana

## TEMA 2 INTRODUCCION ANDROID STUDIO

### MARTES - http://www.developandsys.es/layout/
**Linearlayout**
***

Un LinearLayout se utiliza para poder los elementos de izquierda a derecha o de arriba a abajo, según una orientacion determinada. Lo más importante en este tipo de layout es configurar la opción orientation (horizontal o vertical). Hay que tener en cuenta que se pueden anidar tantos linearlayout como se necesiten

1. Declarar un linear layour vertical
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity"
    android:layout_margin="20dp"
    android:weightSum="1">
</LinearLayout
```

**TableLayout**
***
Utilizado para mostrar elementos con una disposición de tabla o tubular. Este tipo de layout está formado por un TableLayout que a su vez lo forma TableRow donde estarán incluidos los elementos. Hay que tener en cuenta que los elementos se colocarán de izquierda a derecha
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
5. Hacer que un elemento esté colocado en una posición concreta mediante la opcion layout_column
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
RelativeLayout y ContraintLayout
***
ContraintLayut es la evolución de relativelayout, utilizando restricciones entre elementos para pode colocarlos. Hay que tener en cuenta que para poder utilizar este tipo de layout hay que tener configuradas las id aunque no se vayan a utilizar en el código java

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

### MIÉRCOLES
**Personalizar el color de un botón**
***
1. Para personalizar el color de un boton se utiliza la propiedad background indicando el color correspondiente. Se puede acceder a los colores que otorga android mediante @android:color/nombre
````
<Button
            android:text="Elemento 1"
            android:textSize="15dp"
            android:background="@android:color/holo_orange_light"
            android:textColor="@android:color/white"
            android:id="@+id/boton1"
/>
````
2. También existe la posibilidad de configurar nuestro propio color en el archivo res--values--colors.xml y asignarselo al botón

```
    <color name="colorBoton">#0033ff</color>

```
```
<Button
            android:text="Elemento 2"
            android:textSize="15dp"
            android:background="@color/colorBoton"
            android:id="@+id/boton2"
/>
```

**Asignar escuchador a varios elementos al mismo tiempo**
1. Implementar la interfaz OnClicklistener
```
public class TableActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        b1 = findViewById(R.id.boton1);
        b2 = findViewById(R.id.boton2);
        b3 = findViewById(R.id.boton3);
    }
   

    @Override
    public void onClick(View v) {
     
    }
}
```
2. Asignar el evento a los botones mediante el método setOnClickListener
```
private void acciones() {
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
    }
```
3. Evaluar el elemento pulsado mediante v.getId()
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
### JUEVES  
### VIERNES 


### PRÁCTICAS A ENTREGAR

Calculadora
***
Realizar una aplicación que simule el funcionamiento de una calculadora:
1. Estándar si está en posición horizontal
2. Científica si está en posición vertical

![Práctica calculadora](https://github.com/DevelopSys/clasepmdm/blob/master/practicas/calculadora.png "Práctica calculadora")
![Práctica calculadora](https://github.com/DevelopSys/clasepmdm/blob/master/practicas/calculadora_land.png "Práctica calculadora")

