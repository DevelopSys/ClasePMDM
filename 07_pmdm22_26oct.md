# Septima semana

## TEMA 2 VISTAS

### MARTES - http://www.developandsys.es/layout/

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

**FrameLayout**
***
Utilizado para dividir la pantalla en "capas" las cuales se van superponiendo. Este tipo de layout se suele utilizar en conjunto con alguno de los explicados anteriormente

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
### MIÉRCOLES 

**Spinner** - http://www.developandsys.es/elementos-graficos-spinner/
***
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
````
3. Crear un objeto de tipo ArrayAdapter()
````
ArrayList listaDatos = new ArrayList();
for (int i = 1; i<11;i++){
   listaDatos.add("Opción "+String.valueOf(i));
}
````
4. Crear un objeto de tipo ArrayAdapter y asociarlo con el spinner
````
ArrayAdapter adapterSpinner =
        new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaDatos);
adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinner.setAdapter(adapterSpinner);
````
5. Obtener información de los elementos asociados al spinner 
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
6. Evaluar la pulsación del spinner
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

### PRÁCTICAS A ENTREGAR

