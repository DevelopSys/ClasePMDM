package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinnerCoches;
    private TextView textoCoches;
    private Button botonComprobar;
    private ArrayAdapter adaptadorSpinner;
    private ArrayList<String> listaMarcas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        iniciarListas();
        iniciarElementos();
        acciones();
    }

    private void acciones() {
        botonComprobar.setOnClickListener(this);
    }

    private void iniciarElementos() {
        spinnerCoches.setAdapter(adaptadorSpinner);
    }

    private void iniciarListas() {
        listaMarcas.add("Mercedes");
        listaMarcas.add("Audi");
        listaMarcas.add("BMW");
        listaMarcas.add("VW");
        listaMarcas.add("Ford");
    }

    private void instancias() {
        spinnerCoches = findViewById(R.id.spinner_coches);
        textoCoches = findViewById(R.id.texto_coche);
        botonComprobar = findViewById(R.id.boton_coches);
        listaMarcas = new ArrayList();
        adaptadorSpinner = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item, listaMarcas);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton_coches:

                //textoCoches.setText(String.valueOf(spinnerCoches.getSelectedItem()));
                // adaptadorSpinner
                //spinnerCoches.getAdapter()
                textoCoches.setText(
                        adaptadorSpinner.
                                getItem(spinnerCoches.getSelectedItemPosition()).toString());

                break;
        }
    }
}