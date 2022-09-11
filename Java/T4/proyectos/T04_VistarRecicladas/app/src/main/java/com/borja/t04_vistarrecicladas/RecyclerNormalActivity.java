package com.borja.t04_vistarrecicladas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.borja.t04_vistarrecicladas.adaptadores.AdaptadorRecycler;
import com.borja.t04_vistarrecicladas.utils.Persona;

import java.util.ArrayList;

public class RecyclerNormalActivity extends AppCompatActivity implements AdaptadorRecycler.OnMiRecyclerListener {

    RecyclerView recyclerView;
    ArrayList<Persona> listaPersonas;
    AdaptadorRecycler adaptadorRecycler;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_normal);
        instancias();
        rellenarRecycler();
        acciones();
    }

    private void acciones() {

    }

    private void rellenarRecycler() {
        recyclerView.setAdapter(adaptadorRecycler);
        listaPersonas.add(new Persona("Jose","Apellido",123,0));
        listaPersonas.add(new Persona("Maria","Apellido",123,1));
        listaPersonas.add(new Persona("Pepe","Apellido",123,0));
        listaPersonas.add(new Persona("Juan","Apellido",123,0));
        listaPersonas.add(new Persona("Luis","Apellido",123,0));
        listaPersonas.add(new Persona("Marta","Apellido",123,1));
        listaPersonas.add(new Persona("Marta","Apellido",123,1));
        listaPersonas.add(new Persona("?????","Apellido",123,2));
        adaptadorRecycler.notifyDataSetChanged();
        //recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
    }

    private void instancias() {
        recyclerView = findViewById(R.id.recycler_view);
        listaPersonas = new ArrayList();
        adaptadorRecycler = new AdaptadorRecycler(RecyclerNormalActivity.this,
                listaPersonas);

    }

    @Override
    public void onMiRecycler(Persona persona) {
        Toast.makeText(getApplicationContext(),persona.getApellido(),
                Toast.LENGTH_SHORT).show();
    }
}
