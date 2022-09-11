package com.borja.repasorecycler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnPersonaListener {

    private RecyclerView recyclerView;
    private AdaptadorRecycler adaptadorRecycler;
    private ArrayList listaPersonas;
    private ImageView iconoSuperior;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mimenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.opcion1:
                // ACCION A EJECUTAR
                break;

        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_repaso);
        iconoSuperior = findViewById(R.id.icono_superior);
        listaPersonas = new ArrayList();

        iconoSuperior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "asd", Toast.LENGTH_SHORT).show();
            }
        });
        adaptadorRecycler = new AdaptadorRecycler(this, listaPersonas);

        // layout (linear - grid) --> en que disposicion se pintan las filas
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        //recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
        // adaptador (listaDatos, contexto) --> indica como se pintan las filas
        recyclerView.setAdapter(adaptadorRecycler);


        listaPersonas.add(new Persona("fsdfsdf", "asd"));
        listaPersonas.add(new Persona("098765", "asd"));
        listaPersonas.add(new Persona("kyujmnbv", "asd"));
        listaPersonas.add(new Persona("iuytred", "asd"));
        listaPersonas.add(new Persona("lk,mbv", "asd"));
        listaPersonas.add(new Persona("lkhnbgvfc", "asd"));
        listaPersonas.add(new Persona(",mcd", "asd"));
        listaPersonas.add(new Persona("kyui6ytrf", "asd"));
        listaPersonas.add(new Persona("oi6u5terw", "asd"));
        listaPersonas.add(new Persona("786543", "asd"));

        adaptadorRecycler.notifyDataSetChanged();


    }

    @Override
    public void onPersonaSelected(Persona persona) {
        Toast.makeText(getApplicationContext(), "Persona en ACTIVITY", Toast.LENGTH_SHORT).show();
    }
}