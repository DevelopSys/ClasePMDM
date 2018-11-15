package com.system.develop.t2_ejemplorecycler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.system.develop.t2_ejemplorecycler.adaptadores.AdaptadorRecycler;
import com.system.develop.t2_ejemplorecycler.utils.Persona;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnPersonaRecyclerListener{

    RecyclerView recyclerView;
    Button boton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        construirRecycler();
        acciones();
        finish();
    }

    private void construirRecycler() {
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Nombre 1", R.drawable.juego_01));
        personas.add(new Persona("Nombre 2", R.drawable.juego_02));
        personas.add(new Persona("Nombre 3", R.drawable.juego_03));
        personas.add(new Persona("Nombre 4", R.drawable.juego_04));
        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(personas,this);
        recyclerView.setAdapter(adaptadorRecycler);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2,LinearLayoutManager.VERTICAL,false));
        //recyclerView.addItemDecoration();
    }

    private void acciones() {

    }

    private void instancias() {
        recyclerView = findViewById(R.id.recyclerNombres);
        boton = findViewById(R.id.boton);
        textView = findViewById(R.id.textoNombres);
    }

    @Override
    public void onPersonaRecyclerSelected(Persona persona) {
        textView.append(persona.getNombre());
    }
}
