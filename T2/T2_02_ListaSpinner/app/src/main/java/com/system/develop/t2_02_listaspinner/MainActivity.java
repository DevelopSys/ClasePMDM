package com.system.develop.t2_02_listaspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.system.develop.t2_02_listaspinner.adaptadores.AdaptadorLista;
import com.system.develop.t2_02_listaspinner.adaptadores.AdaptadorSpinner;
import com.system.develop.t2_02_listaspinner.utils.Persona;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerNormal, spinnerAdaptado;
    ListView listaAdaptada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        rellenarSpinners();
        rellenarLista();
        acciones();
    }

    private void acciones() {

        listaAdaptada.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        String.valueOf(((Persona) (parent.getAdapter().getItem(position))).getApellido()),
                        Toast.LENGTH_SHORT).show();
            }
        });
        spinnerNormal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        String.valueOf(((Persona) (parent.getAdapter().getItem(position))).getTelefono()),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void rellenarLista() {
        ArrayList listaPersonas = new ArrayList();
        listaPersonas.add(new Persona("Nombre1", "Apellido", 123));
        listaPersonas.add(new Persona("Nombre2", "Apellido", 123));
        listaPersonas.add(new Persona("Nombre3", "Apellido", 123));
        AdaptadorLista adaptadorLista = new AdaptadorLista(getApplicationContext(), listaPersonas);
        listaAdaptada.setAdapter(adaptadorLista);
    }

    private void rellenarSpinners() {
        String[] lista = {"opción 1", "opción 2", "opción 3", "opción 4"};
        ArrayAdapter arrayAdapterNormal = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, lista);
        //si el recurso está creado
        //ArrayAdapter arrayAdapterNormalRecurso = ArrayAdapter.createFromResource(getApplicationContext(),R.array.recurso_letras,android.R.layout.simple_spinner_item);
        spinnerNormal.setAdapter(arrayAdapterNormal);
        arrayAdapterNormal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        ArrayList listaPersonas = new ArrayList();
        listaPersonas.add(new Persona("Nombre1", "Apellido", 123));
        listaPersonas.add(new Persona("Nombre2", "Apellido", 123));
        listaPersonas.add(new Persona("Nombre3", "Apellido", 123));
        AdaptadorSpinner adaptadorSpinner = new AdaptadorSpinner(getApplicationContext(), listaPersonas);


    }

    private void instancias() {
        spinnerAdaptado = findViewById(R.id.spinnerAdaptador);
        spinnerNormal = findViewById(R.id.spinnerNormal);
        listaAdaptada = findViewById(R.id.listaAdaptada);
    }
}
