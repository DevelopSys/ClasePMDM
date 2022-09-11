package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.res.Configuration;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recycler.adapters.AdaptadorRecycler;
import com.example.recycler.utils.Modelo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements AdaptadorRecycler.OnModeloRecyclerListener {

    private RecyclerView recyclerView;
    private ArrayList<Modelo> listaModelos;
    private AdaptadorRecycler adaptadorRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        rellenarListas();
        asociarElementos();
        acciones();
    }

    private void acciones() {
        /*recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Pulsado",Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    private void asociarElementos() {
        recyclerView.setAdapter(adaptadorRecycler);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        //recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, RecyclerView.VERTICAL));
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        }

    }

    private void rellenarListas() {
        listaModelos.add(new Modelo(R.drawable.a5,"Audi","A5",300));
        listaModelos.add(new Modelo(R.drawable.eqc,"Mercedes","EQC",400));
        listaModelos.add(new Modelo(R.drawable.arteon,"VW","Arteonasdasdas d asd asd as da sd as da sd asd as da sdasd",170));
        listaModelos.add(new Modelo(R.drawable.i8,"BMW","I8",340));
        adaptadorRecycler.notifyDataSetChanged();
    }

    private void instancias() {
        listaModelos = new ArrayList<>();
        adaptadorRecycler =
                new AdaptadorRecycler(listaModelos,MainActivity.this);
        recyclerView = findViewById(R.id.recycler);
    }

    @Override
    public void onModeloSelected(Modelo modelo) {
        Toast.makeText(getApplicationContext(), modelo.getMarca(), Toast.LENGTH_SHORT).show();
    }
}