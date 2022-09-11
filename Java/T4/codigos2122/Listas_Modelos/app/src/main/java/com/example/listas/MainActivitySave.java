package com.example.listas;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listas.utils.Marca;

import java.util.ArrayList;

public class MainActivitySave extends AppCompatActivity {

    private Spinner spinnerMarcas;
    private ArrayAdapter adapterSpinner;
    private ArrayList listaOpcionesSpinner;
    private ImageView imageMarca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        instancias();
        rellenarListas();
        asociarElementos();
        acciones();
    }

    private void acciones() {
        spinnerMarcas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                /*Toast.makeText(getApplicationContext(),
                        adapterSpinner.getItem(position).toString(),Toast.LENGTH_SHORT).show();*/
                Marca marcaSeleccionada = (Marca) adapterSpinner.getItem(position);
                imageMarca.setImageResource(marcaSeleccionada.getImagen());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void rellenarListas() {
        listaOpcionesSpinner.add(new Marca("Mercedes", R.drawable.mercedes));
        listaOpcionesSpinner.add(new Marca("BMW", R.drawable.bmw));
        listaOpcionesSpinner.add(new Marca("VW", R.drawable.vw));
        listaOpcionesSpinner.add(new Marca("Audi", R.drawable.audi));

        adapterSpinner.notifyDataSetChanged();
    }

    private void asociarElementos() {
        spinnerMarcas.setAdapter(adapterSpinner);
    }

    private void instancias() {
        spinnerMarcas = findViewById(R.id.spinner_marcas);
        imageMarca = findViewById(R.id.imagen_marca);
        listaOpcionesSpinner = new ArrayList();
        adapterSpinner = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item,listaOpcionesSpinner);
    }
}