package com.borja.t03_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {


    private Spinner spinnerNormal;
    private ArrayList listaDatos;
    private ArrayAdapter adaptador;
    private Context contexto;
    Button botonValor;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        instancias();
        contexto = getApplicationContext();
        rellenarSpinner();
        recuperarDatos();
        acciones();

    }

    private void acciones() {
        botonValor.setOnClickListener(this);
        spinnerNormal.setOnItemSelectedListener(this);
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
        botonValor = findViewById(R.id.boton_valor);
    }

    private void recuperarDatos() {
        if (getIntent().getExtras() != null){
            String recuperada = getIntent().getExtras().getString(MainActivity.TAG_ELEMENTO);
            String recuperadaDos = (String) getIntent().getExtras().get(MainActivity.TAG_ELEMENTO);
        }
    }

    @Override
    public void onClick(View view) {
        int numero = (int)adaptador.getItem(spinnerNormal.getSelectedItemPosition());
        Toast.makeText(getApplicationContext(),String.valueOf(numero),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int numero = (int)adaptador.getItem(i);
        Toast.makeText(getApplicationContext(),String.valueOf(numero),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
