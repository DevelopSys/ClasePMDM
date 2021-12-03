package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.listas.adapters.AdaptadorLista;
import com.example.listas.utils.Modelo;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    private ListView lista;
    private ArrayList<Modelo> listaModelos;
    private AdaptadorLista adaptadorLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        instancias();
        rellenarListas();
        asociarElementos();
    }

    private void rellenarListas() {
        listaModelos.add(new Modelo("I8","BMW",R.drawable.i8,300));
        listaModelos.add(new Modelo("EQC","Mercedes",R.drawable.eqc,400));
        listaModelos.add(new Modelo("EQC","Mercedes",R.drawable.eqc,400));
        listaModelos.add(new Modelo("EQC","Mercedes",R.drawable.eqc,400));
        listaModelos.add(new Modelo("EQC","Mercedes",R.drawable.eqc,400));
        listaModelos.add(new Modelo("EQC","Mercedes",R.drawable.eqc,400));
        listaModelos.add(new Modelo("A5","Audi",R.drawable.a5,500));
        listaModelos.add(new Modelo("A5","Audi",R.drawable.a5,500));
        listaModelos.add(new Modelo("A5","Audi",R.drawable.a5,500));
        listaModelos.add(new Modelo("A5","Audi",R.drawable.a5,500));
        listaModelos.add(new Modelo("A5","Audi",R.drawable.a5,500));
        listaModelos.add(new Modelo("Arteon","VW",R.drawable.arteon,200));
        listaModelos.add(new Modelo("Arteon","VW",R.drawable.arteon,200));
        listaModelos.add(new Modelo("Arteon","VW",R.drawable.arteon,200));
        listaModelos.add(new Modelo("Arteon","VW",R.drawable.arteon,200));
        listaModelos.add(new Modelo("Arteon","VW",R.drawable.arteon,200));
        adaptadorLista.notifyDataSetChanged();
    }

    private void asociarElementos() {
        lista.setAdapter(adaptadorLista);
    }

    private void instancias() {
        lista = findViewById(R.id.lista);
        listaModelos = new ArrayList<>();
        adaptadorLista = new AdaptadorLista(listaModelos,getApplicationContext());
    }
}