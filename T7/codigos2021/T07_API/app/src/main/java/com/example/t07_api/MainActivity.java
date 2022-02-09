package com.example.t07_api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements AdaptadorPreguntas.OnRecyclerListener, DialogoPregunta.OnDialogoListener {

    private Toolbar toolbar;
    private NavigationView navigation;
    private DrawerLayout drawer;
    private boolean respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        configurarToolbar();
        acciones();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.sitio_fragments, FragmentPreguntas.newInstance("21"));
        getSupportActionBar().setTitle("Deportes");
        ft.commit();

    }

    private void acciones() {
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                switch (item.getItemId()){
                    case R.id.menu_cerrar:
                        finish();
                        break;
                    case R.id.menu_deportes:
                        ft.replace(R.id.sitio_fragments, FragmentPreguntas.newInstance("21"));
                        getSupportActionBar().setTitle("Deportes");
                        break;
                    case R.id.menu_juegos:
                        ft.replace(R.id.sitio_fragments, FragmentPreguntas.newInstance("15"));
                        getSupportActionBar().setTitle("Juegos");
                        break;
                    case R.id.menu_television:
                        ft.replace(R.id.sitio_fragments, FragmentPreguntas.newInstance("11"));
                        getSupportActionBar().setTitle("Television");
                        break;
                }

                drawer.closeDrawer(GravityCompat.START);

                ft.commit();

                return true;
            }
        });
    }

    private void configurarToolbar() {
        setSupportActionBar(toolbar);
    }

    private void instancias() {
        toolbar = findViewById(R.id.toolbar);
        navigation = findViewById(R.id.navigation);
        drawer = findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawer,toolbar,0,0);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onPreguntaSelected(Pregunta p) {
        this.respuesta = p.isRespuesta();
        DialogoPregunta dialogoPregunta = new DialogoPregunta();
        dialogoPregunta.show(getSupportFragmentManager(),"pregunta");

    }

    @Override
    public void onDialogoSelected(boolean respuesta) {
        if (this.respuesta == respuesta){
            Toast.makeText(getApplicationContext(),"Repuesta correcta", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(),"Repuesta incorrecta", Toast.LENGTH_SHORT).show();
        }
    }
}