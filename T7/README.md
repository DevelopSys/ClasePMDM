<a name="tema7"></a>
## Material Design				
#### [Volver al índice](#tema7)
***
a.	View Pager
- http://www.developandsys.es/view-pager/
El elemento view pager representa una forma de navegación rápida y limpia, siempre y cuando los elementos entre los que se necesita hacer cambios no sean muy numerosos. Se suele utiliza con fragments y junto con toolbar y pestañas

1. Importar la libreria de diseño
````
implementation 'com.android.support:design:28.0.0'
````

2. Crear el xml donde aparecerá el elemento
- El Toolbar representará la barra de título
- El TabLayout representará las pestañas asociadas a cada elemento
- El ViewPager representaré el espacio donde apareceran los elementos cada vez que se desplace el dedo a izquierda o derecha

````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">


    <android.support.v7.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:background="@color/colorPrimary"
        app:title="View pager con tabs"
        app:titleTextColor="@android:color/white" />

    <android.support.design.widget.TabLayout
        android:id="@+id/tabs"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@color/colorPrimary"
        app:tabIndicatorColor="@android:color/white"
        app:tabTextColor="@android:color/white" />


    <android.support.v4.view.ViewPager
        android:id="@+id/pager"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</LinearLayout>
````
3. Se crearán tantos fragments como se quieran. Estos serán los que aparezcan y desaparezcan cada vez que se realice un movimiento con el dedo
````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android" android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="FRAGMENT UNO"
        android:textSize="30dp"/>

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="PULSAR"
        android:id="@+id/botonf1"
        />

</LinearLayout>
````
````
public class FragmentUno extends Fragment{

    View v;
    Button b;
    OnFragmentUnoListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnFragmentUnoListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fracment_uno_layout,container,false);
        b = v.findViewById(R.id.botonf1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentUnoSelected();
            }
        });
        return v;
    }

    public interface OnFragmentUnoListener{
        public void onFragmentUnoSelected();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}

````

**En el ejemplo se ha preparado una interfaz de callback como se explicó en el tema anterior**


4. Se crea la parte lógica de la actividad, asociandole el xml creado en el punto 1, implementando la interzaf creada en el punto 2

````
package com.system.develop.t4_viewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.system.develop.t4_viewpager.adaptadores.AdaptadorPager;
import com.system.develop.t4_viewpager.fragments.FragmentDos;
import com.system.develop.t4_viewpager.fragments.FragmentUno;

public class MainActivity extends AppCompatActivity implements FragmentUno.OnFragmentUnoListener {

    ViewPager pager;
    AdaptadorPager adaptadorPager;
    Toolbar toolbar;
    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.pager);
        toolbar = findViewById(R.id.toolbar);
        tabs = findViewById(R.id.tabs);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onFragmentUnoSelected() {
       
    }
}

````

5. Se crea un adaptador personalizado para el view pager donde se le indican los elementos que debe mostrar. Como parámetro en el constructor es obligatorio pasarle un objeto de tipo FragmentManager

````
public class AdaptadorPager extends FragmentPagerAdapter {

    ArrayList<Fragment> listaFragments;

    public AdaptadorPager(FragmentManager fm) {
        super(fm);
        listaFragments = new ArrayList<>();
        listaFragments.add(new FragmentUno());
        listaFragments.add(new FragmentDos());
    }

    @Override
    public Fragment getItem(int i) {
        return listaFragments.get(i);
    }

    @Override
    public int getCount() {
        return listaFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listaFragments.get(position).getTag();
    }
}

````

Los métodos getItem y getCount son obligatorios, devolviendo el elemento a postrar según una posición y el número de elementos que se deben mostrar respectivamente.
También se pueden añadir métodos nuevos para agregarle funcionalidad a este adaptador.
````
    public void cambiarFragment2(String datos){
        FragmentDos f2 = (FragmentDos) listaFragments.get(1);
        f2.cambiarDatos(datos);
    }

    public void anadirFg(Fragment fragment){
        listaFragments.add(fragment);
        this.notifyDataSetChanged();
    }
````
6. En la actividad se crea un objeto de tipo adaptador y se asocia al viewpager. Al mismo tiempo se setea el tablayout como elemento que gestiona el view pager (facilita la aparición de pestañas)
````
public class MainActivity extends AppCompatActivity implements FragmentUno.OnFragmentUnoListener {

    ViewPager pager;
    AdaptadorPager adaptadorPager;
    Toolbar toolbar;
    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.pager);
        toolbar = findViewById(R.id.toolbar);
        tabs = findViewById(R.id.tabs);
        adaptadorPager = new AdaptadorPager(getSupportFragmentManager());
        pager.setAdapter(adaptadorPager);
        setSupportActionBar(toolbar);
        tabs.setupWithViewPager(pager);
        

    }
}
````
7. Por último se puede modificar la interfaz para que se comunique diréctamente al pulsar un botón del fragment1
````
public class MainActivity extends AppCompatActivity implements FragmentUno.OnFragmentUnoListener {

    ViewPager pager;
    AdaptadorPager adaptadorPager;
    Toolbar toolbar;
    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.pager);
        toolbar = findViewById(R.id.toolbar);
        tabs = findViewById(R.id.tabs);
        adaptadorPager = new AdaptadorPager(getSupportFragmentManager());
        pager.setAdapter(adaptadorPager);
        setSupportActionBar(toolbar);
        tabs.setupWithViewPager(pager);
        

    }

    @Override
    public void onFragmentUnoSelected() {
        //Toast.makeText(getApplicationContext(),"Comunicación realizada",Toast.LENGTH_SHORT).show();
        //pager.setCurrentItem(1);
        //FragmentDos.newInstance("pasar dato");
        //((AdaptadorPager)pager.getAdapter()).cambiarFragment2("pasar dato");
        //adaptadorPager.cambiarFragment2("comunicación realizada");
        //pager.setCurrentItem(1);
        //adaptadorPager.anadirFg(new FragmentDos());
    }
}
````
#### [Volver al índice](#tema7)

b.	Navigation View
- http://www.developandsys.es/navigation-view/
El navigation view representa una alternativa muy utilizada a los menús tradicionales. Se trata de un menú desplegable lateral (izquierda o derecha) que aparece al deslizar el dedo. Antes de empezar se explicarán los xml a utlizar:
- main_activity.xml: elemento gráfico principal, que incluye el menú navigation y un include con todos los elementos de la pantalla
- main_content.xml: elemento gráfico con todos los elementos de la pantalla principal. De esta forma se separa en dos archivos, siendo mucho mas sencillo su mañejo
- header_nav (opcional): elemento gráfico que representa como aparece la cabecera del menú lateral.
- elemento_adicional.xml (opcional): si en el menú se quiere añadir algún elemento avanzado como por ejemplo un spinner, se debe declarar en un xml separado
- menu.xml: opciones que tendrá el menú.

1. Opcional. Se declara el elemento que representarála parte superior del navigation. Se pueden añadir elementos que despues pueden ser manejados desde la parte lógica de la activity.
````
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content">

    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="200dp"
        android:scaleType="fitXY"
        android:src="@drawable/fondo_m" />

    <TextView
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:id="@+id/textHeader"
        android:background="@drawable/fondo_redondo"
        android:layout_gravity="center"
        android:textSize="30sp"
        android:textAlignment="center"
        android:gravity="center"
        android:layout_marginBottom="60dp"/>

    <Spinner
        android:id="@+id/spinnerHeader"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:background="@color/colorFondo"/>

</FrameLayout>
````
2. Declarar el xml del menú, con todas las opciones que tendrá 
````
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <item
        android:id="@+id/opcion1"
        android:title="Opcion 1"
        android:icon="@android:drawable/btn_star"/>
    <item
        android:id="@+id/opcion2"
        android:title="Opcion 2" />

    <item android:title="Elementos">

        <menu>
            <item android:id="@+id/opcion5"
                android:title=""
                app:actionViewClass="android.support.v7.widget.SearchView"
                />

        </menu>

    </item>
</menu>
````

En el caso de querer un elemento adicional se utiliza el parámetro actionViewClass, bien igualado a un elemento de android (preferiblemente) o a un layout específico

3. Declarar el xml de la actividad. Este tan solo contendrá el principal, el contenedor y el elemento navigation
````
<?xml version="1.0" encoding="utf-8"?>
<android.support.v4.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:id="@+id/drawer">

    <include layout="@layout/main_content" />

    <android.support.design.widget.NavigationView
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:layout_gravity="start"
        android:fitsSystemWindows="true"
        android:id="@+id/navigation"
        app:headerLayout="@layout/header_nav"
        app:menu="@menu/menu_nav"/>


</android.support.v4.widget.DrawerLayout>
````

De las opciones destacar:

- fitsSystemWindows: indica que podrá o no aparecer sin modificar los elementos que están por debajo. Actuará como un elemento flotante
- headerLayout: indica el xml que se utilizará para representar la parte superior del menú
- layout_gravity: indica la posición desde la que sale el menú. start o end
- menu: indica el xml utilizado para cargar todas las opciones de menú

4. Declarar la lógica de la aplicación

````
public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Spinner spinnerHeader;
    TextView textHeader;
    SearchView searchView;
    Toolbar toolbar;
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        persoNavigation();
        persoSpinner();
        acciones();
    }

    private void persoNavigation() {
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    private void acciones() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.opcion1:
                        Toast.makeText(getApplicationContext(),"Pulsado 1",Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                }

                return true;
            }
        });
        spinnerHeader.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textHeader.setText(String.valueOf(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                //Toast.makeText(getApplicationContext(),"Introducido "+s,Toast.LENGTH_SHORT).show();
                searchView.setIconified(true);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //Toast.makeText(getApplicationContext(),"Cambiado "+s,Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }

    private void persoSpinner() {
        String[]opcion = {"Opción 1","Opción 2","Opción 3"};
        ArrayAdapter<CharSequence> adaptadorSpinner =
                new ArrayAdapter<CharSequence>(getApplicationContext(),android.R.layout.simple_spinner_item,opcion);
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHeader.setAdapter(adaptadorSpinner);
    }

    private void instancias() {
        navigationView = findViewById(R.id.navigation);
        drawerLayout = findViewById(R.id.drawer);
        spinnerHeader = navigationView.getHeaderView(0).findViewById(R.id.spinnerHeader);
        textHeader = navigationView.getHeaderView(0).findViewById(R.id.textHeader);
        searchView = (SearchView) navigationView.getMenu().findItem(R.id.opcion5).getActionView();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerToggle = new ActionBarDrawerToggle(MainActivity.this
                ,drawerLayout
                ,toolbar
                ,R.string.abierto
                ,R.string.cerrado){
            @Override
            public void onDrawerClosed(View drawerView) {
                //super.onDrawerClosed(drawerView);
                //searchView.setIconified(true);
                getSupportActionBar().setTitle("Elemento cerrado");

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }
        };
    }
}
````
Del código destacar:

- Para poder instanciar un elemento que está en el hader:
````
spinnerHeader = navigationView.getHeaderView(0).findViewById(R.id.spinnerHeader);
````
El resto de la funcionalidad del spinner será la normal
- Para poder instanciar un elemento que está en el menú:
````
searchView = (SearchView) navigationView.getMenu().findItem(R.id.opcion5).getActionView();
````
- Para poder trabajar con una searchview:
````
searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String s) {
                //Toast.makeText(getApplicationContext(),"Introducido "+s,Toast.LENGTH_SHORT).show();
                searchView.setIconified(true);
                return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
    //Toast.makeText(getApplicationContext(),"Cambiado "+s,Toast.LENGTH_SHORT).show();
    return true;
    }
});
````
- Para que el navigation abra y cierre se crea un drawerToggle que indica como debe comportarse.
````
ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MainActivity.this
                ,drawerLayout
                ,toolbar
                ,R.string.abierto
                ,R.string.cerrado){
            @Override
            public void onDrawerClosed(View drawerView) {
                //super.onDrawerClosed(drawerView);
                //searchView.setIconified(true);
                getSupportActionBar().setTitle("Elemento cerrado");

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }
        };

drawerLayout.addDrawerListener(drawerToggle);
drawerToggle.syncState();
````
#### [Volver al índice](#tema7)

c.	Coordinador Layout
- http://www.developandsys.es/coordinator-layout/
#### [Volver al índice](#tema7)

d.	Preferences Screen
- http://www.developandsys.es/preference-screen/
#### [Volver al índice](#tema7)
