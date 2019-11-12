package com.borja.t03_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {


    private Spinner spinnerNormal;
    private ArrayList listaDatos;
    private ArrayAdapter adaptador;
    private Context contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        instancias();
        contexto = getApplicationContext();
        rellenarSpinner();
        recuperarDatos();

    }



    private void rellenarSpinner() {
        for (int i =0;i<100;i++){
            listaDatos.add(i);
        }

        adaptador = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item,listaDatos);
        spinnerNormal.setAdapter(adaptador);
        adaptador.getItem(spinnerNormal.getSelectedItemPosition());


    }

    private void instancias() {
        spinnerNormal = this.findViewById(R.id.spinner_normal);
        listaDatos = new ArrayList();
    }

    private void recuperarDatos() {
        if (getIntent().getExtras() != null){
            String recuperada = getIntent().getExtras().getString(MainActivity.TAG_ELEMENTO);
            String recuperadaDos = (String) getIntent().getExtras().get(MainActivity.TAG_ELEMENTO);
        }
    }
}
