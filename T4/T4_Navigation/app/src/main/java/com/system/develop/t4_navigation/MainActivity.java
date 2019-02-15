package com.system.develop.t4_navigation;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
