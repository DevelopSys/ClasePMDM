package com.borja.t07_navigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.borja.t07_navigationview.fragments.FragmentDos;
import com.borja.t07_navigationview.fragments.FragmentUno;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private SearchView barraBusqueda;
    private TextView cabeceraUno, cabecerados;
    private Spinner spinnerCabecera;
    private String[] listaOpciones;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.sitio_fragment, new FragmentUno(), "uno");
        fragmentTransaction.commit();

        configurarSpinner();
        configurarBarra();
        acciones();


    }

    private void configurarSpinner() {
        listaOpciones = new String[]{"AOpcion 1", "BOpcion 2", "COpcion 3"};
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, listaOpciones);
        spinnerCabecera.setAdapter(adapter);
    }

    private void acciones() {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();

                switch (item.getItemId()) {
                    case R.id.menu_opcion_uno:
                        cabeceraUno.setText("Elemento uno");
                        fragmentTransaction.replace(R.id.sitio_fragment, FragmentUno.newInstance("futbol"), "uno");


                        break;
                    case R.id.menu_opcion_dos:
                        fragmentTransaction.replace(R.id.sitio_fragment, FragmentUno.newInstance("pelicula"), "uno");
                        cabeceraUno.setText("Elemento dos");
                        break;
                    case R.id.menu_opcion_tres:
                        fragmentTransaction.replace(R.id.sitio_fragment, FragmentUno.newInstance("juego"), "uno");
                        cabeceraUno.setText("Elemento tres");
                        break;

                    case R.id.menu_opcion_cuatro:
                        fragmentTransaction.replace(R.id.sitio_fragment, new FragmentUno(), "uno");
                        cabeceraUno.setText("Elemento tres");
                        break;

                }

                fragmentTransaction.commit();
                drawerLayout.closeDrawers();

                return true;
            }
        });
        spinnerCabecera.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion = listaOpciones[i];
                cabeceraUno.setText(String.valueOf(seleccion.charAt(0)));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    private void configurarBarra() {
        this.setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar
                , R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }

    private void instancias() {
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.menu_navigation);
        cabeceraUno = navigationView.getHeaderView(0).findViewById(R.id.texto_cabecera);
        spinnerCabecera = navigationView.getHeaderView(0).findViewById(R.id.cabecera_spinner);
        //cabeceraUno = this.findViewById()
        //cabeceraUno.setText("Elemento cambiado");
        //barraBusqueda = (SearchView) navigationView.getMenu().getItem(R.id.menu_opcion_busqueda).getActionView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_lateral,menu);
        return true;
    }
}