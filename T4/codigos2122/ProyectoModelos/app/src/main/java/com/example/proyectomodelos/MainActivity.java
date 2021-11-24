package com.example.proyectomodelos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.proyectomodelos.adapters.AdaptadorMarcas;
import com.example.proyectomodelos.utils.Marca;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerMarcas;
    private AdaptadorMarcas adaptadorMarcas;
    private ListView listViewModelos;
    private ArrayList<Marca> listaMarcas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        iniciarListas();
        asociarElementos();
    }

    private void asociarElementos() {
        spinnerMarcas.setAdapter(adaptadorMarcas);
    }

    private void iniciarListas() {
        listaMarcas.add(new Marca("BMW",R.drawable.bmw));
        listaMarcas.add(new Marca("Mercedes",R.drawable.mercedes));
        listaMarcas.add(new Marca("Audi",R.drawable.audi));
        listaMarcas.add(new Marca("VW",R.drawable.vw));
    }

    private void instancias() {
        listaMarcas = new ArrayList<>();
        spinnerMarcas = this.findViewById(R.id.spinner_marcas);
        listViewModelos = findViewById(R.id.lista_modelos);
        adaptadorMarcas = new AdaptadorMarcas(listaMarcas,getApplicationContext());
    }
}