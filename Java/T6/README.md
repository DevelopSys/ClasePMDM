<a name="tema6"></a>
## Fragments				
a.	Tipo y creación de fragments
- http://www.developandsys.es/fragments/

Los fragments representan un modo diferente de implementar elementos dentro de una interfaz. Surgen como necesidad de repartir el espacio de forma diferente dependiendo del estado en el que se encuentre un dispositivo, como por ejemplo el tamaño de la pantalla. Principalmente existen dos tipos:
- Estáticos: Aquellos definidos directamente en el xml
- Dinámicos: Aquellos que tienen la capacidad de aparecer y desaparecer de la pantalla

Los fragments tienen su propio ciclo de vida:

![Ciclo vida fragment](./images/ciclo.png "fragment")
<img src="./images/ciclo.png">

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

**Manejo del ciclo de vida en un fragment**
***

**Manejo de onBack() con fragments**
***

**Manejo de elementos con fragments**
***

En la mayoría de los casos un fragment tendrá elementos en su parte gráfica. Para poder utilizarlos, estos deben ser instanciados con el método findViewById() ejecutado sobre la vista que es inflada.

1. Declarar la parte gráfica del fragment

````
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <Button
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/botonFg"/>

</LinearLayout>
````

2. Declarar la parte lógica, donde una vez se tiene la vista inflada se utiliza el método findviewById para poder utilizarlo

````
public class FragmentUno extends Fragment {

    View v;
    Button boton;
    Context c;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        c = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_layout,container,false);
        boton = v.findViewById(R.id.botonFg);
        return v;
    }
}
````

3. Utiliza el elemento de forma corriente, como se ha explicado en temas anteriores


**Manejo de un recycler view con fragments**
***

En muchas de las ocasiones dentro de un fragment se debe mostrar una lista de datos. Para ello se suele utilizar un recyclerView. Los pasos para utilizarlos dentro de un fragment son los mismos que en temas anteriores, con la diferencia que el contexto pasado al adaptador es el que se obtiene del método onAttach

1. Declarar el xml que representa el aspecto de cada fila del recycler
````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical">

    <TextView
        android:id="@+id/itemNombre"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

    <TextView
        android:id="@+id/itemApellido"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

</LinearLayout>
````
2. Declarar el adaptador que indica como se debe pintar el recycler. En este ejemplo la lista de personas a representar se declara dentro del adaptador, pero no normal es que provenga desde un servicio de carga de datos externo o sea pasada en constructor
````

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MiHolder> {

    Context c;
    ArrayList<Persona> lista;
    OnElementoAdaptadorListener listener;

    public AdaptadorRecycler(Context c) {
        this.c = c;
        lista = new ArrayList<>();
        lista.add(new Persona("Nombre1", "Apellido", 224));
        lista.add(new Persona("Nombre2", "Apellido", 224));
        lista.add(new Persona("Nombre3", "Apellido", 224));
        lista.add(new Persona("Nombre4", "Apellido", 224));
        lista.add(new Persona("Nombre5", "Apellido", 224));
        lista.add(new Persona("Nombre6", "Apellido", 224));
        listener = (OnElementoAdaptadorListener) c;
    }


    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(c).inflate(R.layout.item_recycler, viewGroup, false);
        return new MiHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder miHolder, int i) {
        final Persona p = lista.get(i);
        miHolder.getNombre().setText(p.getNombre());
        miHolder.getApellido().setText(p.getApellido());
        miHolder.getNombre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onElementoSelected(p.getTelefono());
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public interface OnElementoAdaptadorListener{
        public void onElementoSelected(int telefono);
    }

    class MiHolder extends RecyclerView.ViewHolder {

        TextView nombre, apellido;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.itemNombre);
            apellido = itemView.findViewById(R.id.itemApellido);
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getApellido() {
            return apellido;
        }
    }
}

````

3. Declarar el xml que representa la parte gráfica del fragment

````
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <android.support.v7.widget.RecyclerView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/recyclerFg"/>

</LinearLayout>
````


4. Declarar el java que representa la parte lógica del fragment
````
public class FragmentUno extends Fragment {

    View v;
    RecyclerView recyclerView;
    Context c;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        c = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_layout,container,false);
        recyclerView = v.findViewById(R.id.recyclerFg);
        recyclerView.setAdapter(new AdaptadorRecycler(c));
        // como contexto también puede ser utilizado la variable c igualada en el método onAttach
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        return v;
    }
}
````

5. Declarar la parte gráfica de la actividad
````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/sitioFg"/>

</LinearLayout>
````

6. Declarar el java que representa la parte lógica de la actividad
````
package com.system.develop.ejemplofragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.system.develop.ejemplofragment.adaptadores.AdaptadorRecycler;
import com.system.develop.ejemplofragment.fragments.FragmentUno;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnElementoAdaptadorListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.sitioFg,new FragmentUno());
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onElementoSelected(int telefono) {
        Log.v("fg",String.valueOf(telefono));
    }
}
````

**Si a esto se le quiere unir una comunicación entre el recycler y el fragment (se explicará en los siguientes puntos) se debe realizar de forma muy similar a la explciada hasta ahora**

#### [Volver al índice](#tema6)
***
b.	Manejo: pila de actividades
- http://www.developandsys.es/manejo-fragments-y-la-pila-de-actividades/

#### [Volver al índice](#tema6)
***

c.	Comunicación
- http://www.developandsys.es/comunicacion-entre-fragments/

Para poder realizar la comunicación con fragments se dan dos cosas:

- Comunicación entre fragments estáticos
- Comunicación entre fragments dinámicos

### Comunicación entre fragments estáticos
***

- El primero de los casos en desde el fragment a la actividad

1. Definir la parte gráfica y logíca del fragment
````
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/textFg"/>

    <Button
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/botonFg"/>       

</LinearLayout>
````

````
public class Fragmento1Estatico extends Fragment implements View.OnClickListener {

    TextView textoF1;
    Button botonF1;
    View v;

    public Fragmento1Estatico() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment1_estatico_layout, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
        acciones();
    }

    private void instancias() {
        textoF1 = (TextView) v.findViewById(R.id.text_comunicacionf1);
        botonF1 = (Button) v.findViewById(R.id.button_comunicar_f1);
    }

    private void acciones() {
        botonF1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    }

}
````
2. Declarar una interfaz de CallBack en el fragments, con un método que será utilizado para comunicar con la actividad (al cual se le pasan todos los datos que se quieran). Para instanciar la interfaz se utiliza el método onAttach

````
public class Fragmento1Estatico extends Fragment implements View.OnClickListener {

    OnDataF1SelectedListener onDataF1SelectedListener;
    TextView textoF1;
    Button botonF1;
    View v;

    public Fragmento1Estatico() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            onDataF1SelectedListener = (OnDataF1SelectedListener) context;
        } catch (Exception e) {
            Log.v("Error", "La comunicacion no ha podido llevarse a cabo");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment1_estatico_layout, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
        acciones();
    }

    private void instancias() {
        textoF1 = (TextView) v.findViewById(R.id.text_comunicacionf1);
        botonF1 = (Button) v.findViewById(R.id.button_comunicar_f1);
    }

    private void acciones() {
        botonF1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onDataF1SelectedListener.onDataF1Selected();
    }

    public interface OnDataF1SelectedListener {
        public void onDataF1Selected();
    }
}
````
3. Definir la parte gráfica y lógica de la activity
````
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <fragment
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:name="com.system.develop.t6_fragmentsinicio.fragments.FragmentEstaticoUno"/>
        android:id="@+id/fragmentEstático1"/>
   
    <fragment
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:name="com.system.develop.t6_fragmentsinicio.fragments.FragmentEstaticoDos"/>
        android:id="@+id/fragmentEstático2"/>     

</LinearLayout>
````
````
public class MainFragments extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragments);
    }

````
4. En la activity se implementa la interfaz creada en el punto 2, de forma que los datos han pasado del fragment a la activity

````
public class MainFragments extends AppCompatActivity implements  Fragmento1Estatico.OnDataF1SelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragments);
    }

    @Override
    public void onDataF1Selected() {
    // comunicación con el fragment
    }
````

- Desde la actividad al fragment (se continúa la explicación desde lo creado en el ejemplo anterior)

1. Con los datos en la activity, se busca el fragmente en el FragmentManager mediante el id (aquel declarado en el xml de la actividad)

````
public class MainFragments extends AppCompatActivity implements  Fragmento1Estatico.OnDataF1SelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragments);
    }

    @Override
    public void onDataF1Selected() {
        Fragmento2Estatico f2 = (Fragmento2Estatico) 
        getSupportFragmentManager().findFragmentById(R.id.fragmentEstático2);
    }

````

2. En el fragmento donde se quieren llevar los datos se declara un método que admita como parámetros los elementos que que quieren comunicar, así como la acción que se quiere que ejecute. En el ejemplo es el método metodoComunicar

````
public class Fragmento2Estatico extends Fragment{

    TextView texto;

    public Fragmento1Estatico() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment2_estatico_layout, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
        acciones();
    }

    private void instancias() {
        texto = (TextView) v.findViewById(R.id.text_comunicacionf2);
    }

    private void metodoComunicacion(String dato) {
        Toast.makeText(getContext(), dato, Toast.Length_short).show();
    }

}
````
3. En la actividad, con el fragmento encontrado, se ejecuta el método creado con los datos que se quiere comunicar
````
public class MainFragments extends AppCompatActivity implements  Fragmento1Estatico.OnDataF1SelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragments);
    }

    @Override
    public void onDataF1Selected() {
        Fragmento2Estatico f2 = (Fragmento2Estatico) 
        getSupportFragmentManager().findFragmentById(R.id.fragmentEstático2);
        f2.metodoComunicar("Dato pasado al fragment estático 2");
    }

````
**De estas dos formas se puede comunicar un fragment estático con una activity y/o una activity con un fragment estático. Ambas combinadas dan como resultado la comunicación entre dos fragemnts estáticos. Es importante tener en cuenta que nunca se puede hacer una comunicación directa entre elementos**
#### [Volver al índice](#tema6)
***

### Comunicación entre fragments estáticos
***

Al igual que en el caso anterior, hay  dos posibidades
- El primero de los casos es desde el fragment a la actividad

1. Se define la parte gráfica.
````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android" android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="FRAGMENT UNO"
        android:textSize="30dp"/>

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Pulsar"
        android:textSize="30dp"
        android:id="@+id/botonF1"/>

</LinearLayout>
````
2. Se define la parte lógica del fragmente
````
public class FragmentDinamico extends Fragment {

    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fdinamico_layout,container,false);
        return v;
    }
}

````
3. En el origen de los datos (en este caso el fragment) se declara una interfaz y se implementa en el método onAttach. Se utiliza en el momento en el que sea requerida
````
public class FragmentDinamico extends Fragment implements View.OnClickListener  {

    View v;
    Button b;
    OnDataF1DinamicSelectedListener onDataF1SelectedListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fdinamico_layout,container,false);
        b = v.findViewById(R.id.botonF1);
        b.setOnClickListener(this);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            onDataF1SelectedListener = (OnDataF1SelectedListener) context;
        } catch (Exception e) {
            Log.v("Error", "La comunicacion no ha podido llevarse a cabo");
        }
    }

    @Override
    public void onClick(View v) {
        onDataF1SelectedListener.onDataF1DinamicSelected("texto que se quiere pasar");
    }


    public interface OnDataF1DinamicSelectedListener {
        public void onDataF1DinamicSelected(String texto);
    }
}
````
4. Se declara la parte gráfica de la actividad
````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical">

    <fragment
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:name="com.system.develop.t4_repaso.fragments.FragmentEstatico"
        android:id="@+id/festatico"/>


    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/sitiofg"/>


</LinearLayout>
````
5. Se declara la parte lógica de la actividad
````
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicio();
    }

    public void inicio() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        FragmentDinamico fd = new FragmentDinamico();
        ft.replace(R.id.sitiofg, fd);
        ft.addToBackStack("F1");
        ft.commit();
    }
}

````
6. En el destino de los datos (en este caso la actividad) se implementa la interfaz creada en el punto 4
````
public class MainActivity extends AppCompatActivity implements FragmentDinámico.OnDataF1DinamicSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentEstaticoSelected() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        FragmentDinamico fd = new FragmentDinamico();
        ft.replace(R.id.sitiofg, fd);
        ft.addToBackStack("F1");
        ft.commit();
    }

    @Override
    public void onDataF1DinamicSelected(String texto){
        // los datos pasan de la fragment a la actividad
    }

}
````
 De esta forma los datos han pasado desde el fragment dinámico a la actividad, que los podrá manejar


- El segundo caso es desde el fragment a la actividad (se continúa desde el punto anterior).

1. En el destino de la comunicación (En este caso el fragment) se declara un método estático que devuelve un objeto de la clase y admite como parámetros aquello que se le quiere comunicar
````
public class Fragmento1Dinamico extends Fragment  {

    final String TAG_1 = "key";
    String datoComunicado;
    EditText edit;
    Button botonF1;
    View v;

    public static Fragmento1Dinamico newInstance(String text){
 
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment1_dinamico_layout, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
    }

    private void instancias() {
        edit = (EditText) v.findViewById(R.id.edit_comunicacion_dinamico_f1);
        botonF1 = (Button) v.findViewById(R.id.button_comunicar_dinamico_f1);
    }

}
````
2. En el método creado en el paso anterior, antes de devolver el objeto se agregan los datos admitidos como parámetros mediante argumentos (con formato par clave - valor)
````
public class Fragmento1Dinamico extends Fragment  {

    final String TAG_1 = "key";
    String datoComunicado;
    EditText edit;
    Button botonF1;
    View v;

    public static Fragmento1Dinamico newInstance(String text){
 
        Fragmento1Dinamico fragmento1Dinamico = new Fragmento2Dinamico();
        Bundle b = new Bundle();
        b.putString(TAG_1,text);
        fragmento1Dinamico.setArguments(b);
        return fragmento1Dinamico;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment1_dinamico_layout, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
    }

    private void instancias() {
        edit = (EditText) v.findViewById(R.id.edit_comunicacion_dinamico_f1);
        botonF1 = (Button) v.findViewById(R.id.button_comunicar_dinamico_f1);
    }

}
````
3. Para poder utilizarlos en todo el fragment, en el método onAttach() se recuperan mediante el método getArguments()
````
public class Fragmento1Dinamico extends Fragment  {

    final String TAG_1 = "key";
    String datoComunicado;
    EditText edit;
    Button botonF1;
    View v;

    public static Fragmento1Dinamico newInstance(String text){
 
        Fragmento1Dinamico fragmento1Dinamico = new Fragmento2Dinamico();
        Bundle b = new Bundle();
        b.putString(TAG_1,text);
        fragmento1Dinamico.setArguments(b);
        return fragmento1Dinamico;
    }

    @Override
    public void onAttach(Context context) {
        datoComunicado = this.getArguments().getString(TAG_1));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment1_dinamico_layout, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
    }

    private void instancias() {
        edit = (EditText) v.findViewById(R.id.edit_comunicacion_dinamico_f1);
        botonF1 = (Button) v.findViewById(R.id.button_comunicar_dinamico_f1);
    }

}
````
4. En la actividad, en el momento de querer realizar la comunicación, se llama al método estático en la creación del fragment
````
FragmentManager fm = getSupportFragmentManager();
FragmentTransaction ft = fm.beginTransaction();
ft.replace(R.id.sitio_fragment_dinamic,Fragmento1Dinamico.newInstance(textoAPasar));
ft.commit();
````

**De estas dos formas se puede comunicar un fragment dinámico con una activity y/o una activity con un fragment dinámico. Ambas combinadas dan como resultado la comunicación entre dos fragemnts dinámicos. Es importante tener en cuenta que nunca se puede hacer una comunicación directa entre fragments**

d.	Disposición Máster / Detail
- http://www.developandsys.es/master-detail-fragments/

#### [Volver al índice](#tema6)
***

La disposición master detail sirve para modificar el aspecto de la interfaz gráfica dependiendo de la disposición de la pantalla. Para ello lo que hay que hacer es lo siqguiente:

1. Crear un xml con el nombre activity_main.xml con la disposición que se quiere que tenga en la posición vertical
````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/sitioFMaster"
        android:background="@color/colorPrimary"/>

</LinearLayout>
````
2. Crear un nuevo xml con el mismo nombre, con la diferencia que se le añadirá un cualificador de orientación (land). Este xml representará el aspecto horizontal
````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal">

    <FrameLayout
        android:layout_width="0dp"
        android:layout_height="match_parent"
        android:layout_weight="0.4"
        android:id="@+id/sitioFMaster"
        android:background="@color/colorPrimary"/>

    <FrameLayout
        android:layout_width="0dp"
        android:layout_height="match_parent"
        android:layout_weight="0.6"
        android:id="@+id/sitioFDetail"
        android:background="@color/colorPrimaryDark"/>

</LinearLayout>
````
**Es importante que el elemento que esté presente en las dos disposiciones guarde el mismo id (en este caso el FrameLayout de sitioMaster)**

3. Suponiendo que en la parte de master se cargará un fragment (lista) y en la parte detail se cargará un fragment para mostrar información (composición), según la lógica primero hay que evaluar cual es la posición del teléfono 
````

public class MainActivity extends AppCompatActivity {

    FrameLayout sitioMaster, sitioDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sitioMaster = findViewById(R.id.sitioFMaster);
        sitioDetail = findViewById(R.id.sitioFDetail);

        
        if (sitioDetail == null){
            // estoy en portraint
        }else {
            // estoy en landscape

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount()==0){
            finish();
        }
    }
}

````
**Para esta operación se puede evaluar la presencia del elemento detalle o directamente acceder a las características del dispositivo**

Para ello se ejecuta el siguiente código
````

````

4. Una vez definida la posición por uno de los dos métodos anteriores, se ejecuta la lógica
- Si está en vertical la lista se carga en la parte master
- Si está en horizontal la lista se carga en la parte master y el detalle en la parte detail

````
public class MainActivity extends AppCompatActivity {

    FrameLayout sitioMaster, sitioDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sitioMaster = findViewById(R.id.sitioFMaster);
        sitioDetail = findViewById(R.id.sitioFDetail);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        ft.replace(sitioMaster.getId(),new FragmentUno(),FragmentUno.class.getName());
        ft.addToBackStack(FragmentUno.class.getName());
        ft.commit();
        if (sitioDetail == null){
            // estoy en portraint
        }else {
            // estoy en landscape
            FragmentManager fm2 = getSupportFragmentManager();
            FragmentTransaction ft2 = fm2.beginTransaction();
            ft2.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            ft2.replace(sitioDetail.getId(),new FragmentDos(),FragmentDos.class.getName());
            ft2.addToBackStack(FragmentDos.class.getName());
            ft2.commit();

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount()==0){
            finish();
        }
    }

}

````
5. Programar la pulsción. Para ello desde el fragment de la lista se crea una interfaz de callback, la cual se ejecutará de una forma u otra dependiendo de la disposición del teléfono:

- Si está en vertical el detalle se carga en la parte detail
- Si está en horizontal la lista continúa en la parte master y el detalle se carga en la parte detail

````

public class MainActivity extends AppCompatActivity implements FragmentUno.OnFragmentUnoListener {

    FrameLayout sitioMaster, sitioDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sitioMaster = findViewById(R.id.sitioFMaster);
        sitioDetail = findViewById(R.id.sitioFDetail);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        ft.replace(sitioMaster.getId(),new FragmentUno(),FragmentUno.class.getName());
        ft.addToBackStack(FragmentUno.class.getName());
        ft.commit();
        if (sitioDetail == null){
            // estoy en portraint
        }else {
            // estoy en landscape
            FragmentManager fm2 = getSupportFragmentManager();
            FragmentTransaction ft2 = fm2.beginTransaction();
            ft2.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            ft2.replace(sitioDetail.getId(),new FragmentDos(),FragmentDos.class.getName());
            ft2.addToBackStack(FragmentDos.class.getName());
            ft2.commit();

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount()==0){
            finish();
        }
    }

    @Override
    public void onFragmentUnoSelected() {
        if (sitioDetail==null){
            // estoy en portrait
            FragmentManager fm2 = getSupportFragmentManager();
            FragmentTransaction ft2 = fm2.beginTransaction();
            ft2.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            ft2.replace(sitioMaster.getId(),new FragmentDos(),FragmentDos.class.getName());
            ft2.addToBackStack(FragmentDos.class.getName());
            ft2.commit();
        } else {
            // estoy en landscape
            FragmentManager fm2 = getSupportFragmentManager();
            FragmentTransaction ft2 = fm2.beginTransaction();
            ft2.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            ft2.replace(sitioDetail.getId(),new FragmentDos(),FragmentDos.class.getName());
            ft2.addToBackStack(FragmentDos.class.getName());
            ft2.commit();
            Toast.makeText(getApplicationContext(),"Ya está cargado el f2",Toast.LENGTH_SHORT).show();
        }
    }
}

````
**En este caso hay que tener especual cuidado al presionar el boton back o al girar el dispositivo. Se debe controlar mediante estados o pila**
