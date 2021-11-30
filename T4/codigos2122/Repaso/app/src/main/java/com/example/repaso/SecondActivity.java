package com.example.repaso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private String nombreRecuperado;
    private int edadRecuperada;
    private Spinner spinner;
    private ArrayList listaSpinner;
    private BaseAdapter adapterSpinner;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        instancias();
        asociarElementos();
        nombreRecuperado = getIntent().getExtras().getString("nombre");
        edadRecuperada = getIntent().getExtras().getInt("edad");

    }

    private void asociarElementos() {
        listaSpinner.add("Opcion 1");
        listaSpinner.add("Opcion 2");
        listaSpinner.add("Opcion 3");
        spinner.setAdapter(adapterSpinner);
    }

    private void instancias() {
        listaSpinner = new ArrayList();
        adapterSpinner = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item,listaSpinner);
        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.list_view);
    }

    public void rellenarCosas(){
        //por cualquier logica quiero constestar a la actividad main
        Intent intent = new Intent();
        intent.putExtra("examen",6);
        if (true){
            setResult(1, intent);
        } else {
            setResult(2,intent);
        }

        finish();
    }
}