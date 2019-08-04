<a name="tema6"></a>
## Fragments				
a.	Tipo y creación de fragments
- http://www.developandsys.es/fragments/

Los fragments representan un modo diferente de implementar elementos dentro de una interfaz. Surgen como necesidad de repartir el espacio de forma diferente dependiendo del estado en el que se encuentre un dispositivo, como por ejemplo el tamaño de la pantalla. Principalmente existen dos tipos:
- Estáticos: Aquellos definidos directamente en el xml
- Dinámicos: Aquellos que tienen la capacidad de aparecer y desaparecer de la pantalla

Los fragments tienen su propio ciclo de vida:

![Texto alternativo](./images/ciclo.png "Título alternativo")

Son importantes los métodos:

- onAttach(): aquí se puede obtener el contexto e igualar muchas de las variables
- onCreateView(): aquí es donde se muestra la interfaz gráfica del fragment y por lo tanto el sitio donde se carga el xml asociado

Partes de un fragment (estático y dinámico):

- representación gráfica: xml asociado, idéntico al que se declara en una activity

````
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical"
    android:gravity="center"
    android:background="@color/colorPrimary"
    tools:context="com.dam.borja.fragmentosweb.Fragmentos.Fragmento1">

    <!-- TODO: Update blank fragment layout -->


    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Fragmento 1"
        android:textAppearance="@style/TextAppearance.AppCompat.Large"
        android:gravity="center_horizontal|center_vertical"
        android:background="@color/colorPrimary"
        android:textColor="@android:color/white"
        android:textstyle="bold|italic"
        android:textSize="40dp"
        android:id="@+id/textView"
        android:layout_marginBottom="20dp"/>

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Comunicar con Fragment 2"
        android:id="@+id/button_comunicar_dinamico_f1"
        android:textSize="24dp"
        android:textstyle="bold"
        android:textColor="#dbff4093"
        style="@style/Base.Widget.AppCompat.Button.Borderless"
        />
    <EditText
        android:background="@drawable/rectangulo"
        android:layout_width="match_parent"
        android:layout_marginRight="20dp"
        android:layout_marginLeft="20dp"
        android:layout_height="wrap_content"
        android:id="@+id/edit_comunicacion_dinamico_f1"
        android:textstyle="bold"
        android:textSize="20dp"
        android:layout_marginTop="20dp"
        app:paddingStart="10dp"
        android:textColor="@android:color/white"/>

</LinearLayout>
````


- representación lógica: .java asociad, el cual extiende de Fragment (ya no de AppCompactActivity)

````
//Clase que instancia el Fragmento
public class MyFragment extends Fragment {
 
@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
View v = inflater.inflate(R.layout.fragment_dinamico1,container,false);
return v;
}
````

Dependiendo del tipo de fragment que sea se mostrá de una forma u otra

###Fragments dinámicos
***

Nunca cambian su aspecto y siempre están colocados en la misma posición dentro de la aplicación. Se suelen utilizar para reutilizar elementos:

1. Crear los archivos xml y java que reperestan el fragment (los mostrados en el punto inicial)
2. En el xml utilizado para la actividad, utiliza la etiqueta fragment, apuntando a la clase anterior para que lo pueda identificaar

````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".EstaticosActivity">

    <fragment
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="0.5"
        android:id="@+id/festaticouno"
        android:name="com.system.develop.t6_fragmentsinicio.fragments.FragmentEstaticoUno"/>
    <fragment
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="0.5"
        android:id="@+id/festaticodos"
        android:name="com.system.develop.t6_fragmentsinicio.fragments.FragmentEstaticoDos"/>

</LinearLayout>
````

De esta forma los fragments aparecerán de en la activity, con la particularidad que nunca podrán cambiar ya que son elementos decladaros en xml de la actividad

### Fragment dinámicos

Se trata de la opción más interesante, ya que se tiene la posibilidad de hacer aparecer - desaparecer fragments dependiendo de la lógica de una aplicación. Para ello antes es necesario entender los siguientes conceptos:

- FragmentManager: elementos que se encarga de gestionar la pila de fragments. Cuando estos son mostrados o desmostrados, se incorporan a una pila (o no) para que puedan ser recurperados en algún momento. De esto se encarga este objeto
- FragmentTransaction: elemento que se encarga de ejecutar las transiciones del elemento anterior. Realiza las acciones de mostrado, sustitución, elminación, etc... de fragments
- FrameLayout: Layout que permite el mostrado de varios elementos, donde se renderizará el último colocado (concepto de pila)
**Es importante tener en cuenta la versión de los fragments y los objetos asociados, siempre se utilzará la versión de soporte**

Para poder utilizar los fragmets dinámicos.

1. Declarar la parte gráfica del fragment
````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/colorPrimary"
    android:orientation="vertical">

</LinearLayout>
````

2. Declarar la parte lógica del fragment
````
public class FragmentDinamicoUno extends Fragment {

    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_uno_layout,container,false);
        return v;
    }
}

````
**Hay que tener en cuenta que cuando se quiera utiliza un elemento declarado en el xml, se podrá utilizar el método findViewById pero llamado desde la vista, nunca desde this**

3. Declarar la parte lógica de la actividad donde será mostrado / desmostrado el fragment. Para ello se utiliza un frame layout, que será la parte de interfaz donde se podrá mostrar el fragment dinámico
````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".DinamicosActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="0.1">

        <Button
            android:id="@+id/botonIrFragmentUnoDinamico"
            style="@style/Widget.AppCompat.Button.Borderless.Colored"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="0.5"
            android:text="Ir al fragment 1" />

        <Button
            android:id="@+id/botonIrFragmentDosDinamico"
            style="@style/Widget.AppCompat.Button.Borderless.Colored"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="0.5"
            android:text="Ir al fragment 2" />

    </LinearLayout>

    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="0.9"
        android:id="@+id/sitioFragments"/>

</LinearLayout>
````

4. En la parte lógica de la activity declarar los elementos FragmentManager y FragmentTransaction

````
FragmentManager fm =  getSupportFragmentManager();
FragmentTransaction ft = fm.beginTransaction();
````

Estos dos objetos deben ser implementados cuando vaya a ser utilizada la pila o bien se quiera modificar el comportamiendo de los fragments

5. Utiliza el método add, replace o show (se explicará la diferencia) para mostra un fragment concreto. En este caso el método replace tiene como parámetros
- id del sitio donde se mostrará el fragment
- fragment que se quiere mostrar
- tag (opcional) que se le asignará al fragment para que puede ser recuperado)

````
btnDinUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm =  getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(sitioFragments.getId(),new FragmentDinamicoUno());
                ft.commit();
            }
        });
````

Siempre que se termine una operación con FragmentTransaction hay que terminar con commit para asegurar la operación. Adicionalmente se puede utilizar el método addtobackstack para incluir al fragment en la pila 

````
btnDinUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm =  getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(sitioFragments.getId(),new FragmentDinamicoUno());
				ft.addtobackstack("TAG");
                ft.commit();
            }
        }
);
````
**Manejo de onBack() con fragments**
***

**Manejo de elementos con fragments**
***

**Manejo de un recycler view con fragments**
***

**Manejo del ciclo de vida en un fragment**
***



#### [Volver al índice](#tema6)
***
b.	Manejo: pila de actividades
- http://www.developandsys.es/manejo-fragments-y-la-pila-de-actividades/

#### [Volver al índice](#tema6)
***

c.	Comunicación
- http://www.developandsys.es/comunicacion-entre-fragments/

#### [Volver al índice](#tema6)
***
d.	Disposición Máster / Detail
- http://www.developandsys.es/master-detail-fragments/

#### [Volver al índice](#tema6)
***