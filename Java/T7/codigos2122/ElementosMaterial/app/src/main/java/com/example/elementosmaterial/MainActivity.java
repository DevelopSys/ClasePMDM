package com.example.elementosmaterial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elementosmaterial.fragments.FragmentDos;
import com.example.elementosmaterial.fragments.FragmentUno;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button boton;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private TextView textView;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        //configurarToolbar();
        acciones();

        //navigationView.getHeaderView(0).findViewById(R.id.letra_header_nav);
        //navigationView.getHeaderView(0).findViewById(R.id.spinner_header_nav);


    }

    private void acciones() {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                switch (item.getItemId()) {
                    case R.id.menu_nav_f1:
                        // sacar un fragment
                        /*Toast.makeText(getApplicationContext(),
                                "Opcion pulsada",
                                Toast.LENGTH_SHORT).show();*/
                        fragmentTransaction.replace(R.id.sitio_fragment,new FragmentUno());
                        fragmentTransaction.commit();



                        break;
                    case R.id.menu_nav_f2:
                        fragmentTransaction.replace(R.id.sitio_fragment,new FragmentDos());
                        fragmentTransaction.commit();
                        break;
                    case R.id.menu_nav_op1:
                        // scar un dialogo
                        break;
                    case R.id.menu_nav_op2:
                        break;
                    case R.id.menu_nav_op3:
                        break;
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });


        /*toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_pref_1:
                        Toast.makeText(getApplicationContext(), "Opcion 1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_pref_2:
                        Toast.makeText(getApplicationContext(), "Opcion 2", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });*/
    }

    private void configurarToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Nuevo titulo");
    }

    private void instancias() {
        toolbar = findViewById(R.id.toolbar);
        textView = findViewById(R.id.letra_header_nav);
        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        textView = navigationView.getHeaderView(0).findViewById(R.id.letra_header_nav);
        spinner = navigationView.getHeaderView(0).findViewById(R.id.spinner_header_nav);
        //textView.setText("V");

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, new String[]{"Aopcion","Bopcion","Copcion","Dopcion","opcion","opcion","opcion"});
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String s = (String) adapter.getItem(i);
                textView.setText(String.valueOf(s.charAt(0)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        configurarToolbar();
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                0,
                0);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pref, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_pref_1:
                Toast.makeText(getApplicationContext(), "Opcion 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_pref_2:
                Toast.makeText(getApplicationContext(), "Opcion 2", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if (drawerLayout.isOpen()){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
            if (getSupportFragmentManager().getBackStackEntryCount()==0){
                finish();
            } else {
                super.onBackPressed();
            }

        }
    }
}