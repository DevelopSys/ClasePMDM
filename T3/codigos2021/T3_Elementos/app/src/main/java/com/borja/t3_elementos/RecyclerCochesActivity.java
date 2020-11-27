package com.borja.t3_elementos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.borja.t3_elementos.adaptadores.AdaptadorRecyclerCoches;
import com.borja.t3_elementos.utils.Coche;

import java.util.ArrayList;

public class RecyclerCochesActivity extends AppCompatActivity
        implements AdaptadorRecyclerCoches.OnCocheRecyclerListener {

    private RecyclerView recyclerView;
    ArrayList<Coche> listaCoches;
    AdaptadorRecyclerCoches adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_coches);
        instancias();
        rellenarLista();
        acciones();
    }

    private void acciones() {
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "asd", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_coches_recycler, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_recycler_numero_coches:
                int numeroCoches = adaptador.getItemCount();
                Toast.makeText(getApplicationContext(),
                        "El numero de coches es: " + String.valueOf(numeroCoches), Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }

    private void rellenarLista() {

        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()
                , RecyclerView.VERTICAL, false));
        //recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

        listaCoches.add(new Coche("ETron", "Audi", 300, 0, R.drawable.etron));
        listaCoches.add(new Coche("C220 Coupe", "Mercedes", 400, 0, R.drawable.coupe));
        listaCoches.add(new Coche("Giulia", "Alfa", 400, 0, R.drawable.gulia));
        listaCoches.add(new Coche("Golf", "Volwagen", 400, 0, R.drawable.golf));
        listaCoches.add(new Coche("Ibiza", "Mercedes", 400, 0, R.drawable.ibiza));
        listaCoches.add(new Coche("Focus", "Mercedes", 400, 0, R.drawable.focus));
        listaCoches.add(new Coche("Kuga", "Mercedes", 400, 0, R.drawable.kuga));
        listaCoches.add(new Coche("Arteon", "Mercedes", 400, 0, R.drawable.arteon));
        adaptador.notifyDataSetChanged();

    }

    private void instancias() {
        recyclerView = findViewById(R.id.recycler_coches);
        listaCoches = new ArrayList<>();
        adaptador = new AdaptadorRecyclerCoches(this, listaCoches);
    }


    @Override
    public void onCocheSelected(Coche coche) {
        Toast.makeText(getApplicationContext(),coche.getModelo(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCocheLongSelected() {
        Toast.makeText(getApplicationContext(),"Elemento seleccionado long",Toast.LENGTH_SHORT).show();

    }
}