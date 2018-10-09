# Cuarta semana

##TEMA 2 INTRODUCCION ANDROID STUDIO

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
### JUEVES  
### VIERNES 


### PRÁCTICAS A ENTREGAR

Calculadora
***
Realizar una aplicación que simule el funcionamiento de una calculadora:
1. Estándar si está en posición horizontal


![Práctica calculadora](https://github.com/DevelopSys/clasepmdm/blob/master/practicas/calculadora.png "Práctica calculadora")
