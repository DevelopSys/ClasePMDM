package com.borja.t3_spinnerr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.borja.t3_spinnerr.adaptadores.AdaptadorPersoSpinner;
import com.borja.t3_spinnerr.utils.Persona;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Spinner spinnerEdad, spinnerPersonas;
    ArrayAdapter adaptadorPersonas, adaptadorEdad;
    ArrayList listaEdades;
    ArrayList listaPersonas;
    Button botonElemento,boton_seleccionar;
    EditText edit_nombre, edit_apellido;
    CheckBox disponibilidad;
    AdaptadorPersoSpinner adaptadorPersoSpinner;
    final static String TAG_1 = "persona";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        intancias();
        rellenarSpinner();
        acciones();
    }

    private void acciones() {
        botonElemento.setOnClickListener(this);
        boton_seleccionar.setOnClickListener(this);
        spinnerPersonas.setOnItemSelectedListener(this);
    }

    private void rellenarSpinner() {
        for (int i = 0; i < 100; i++) {
            listaEdades.add(i);
            adaptadorEdad.notifyDataSetChanged();
        }
        spinnerEdad.setAdapter(adaptadorEdad);
    }

    private void agregarPersona() {
        listaPersonas.add(new Persona(edit_nombre.getText().toString(),
                edit_apellido.getText().toString(),
                (int) adaptadorEdad.getItem(spinnerEdad.getSelectedItemPosition()),
                disponibilidad.isChecked()));
        adaptadorPersonas.notifyDataSetChanged();

    }

    private void intancias() {
        spinnerEdad = this.findViewById(R.id.spinner_edad);
        listaEdades = new ArrayList();
        listaPersonas = new ArrayList();
        //listaPersonas.add(new Persona("ASD","asd",123,false));
        adaptadorEdad = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item, listaEdades);

        spinnerPersonas = findViewById(R.id.spinner_normal);
        adaptadorPersonas = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item, listaPersonas);
        //spinnerPersonas.setAdapter(adaptadorPersonas);
        botonElemento = findViewById(R.id.boton_elemento);
        edit_nombre = findViewById(R.id.edit_nombre);
        edit_apellido = findViewById(R.id.edit_apellido);
        disponibilidad = findViewById(R.id.chec_disponiblidad);
        boton_seleccionar = findViewById(R.id.boton_seleccionar);

        adaptadorPersoSpinner = new AdaptadorPersoSpinner(listaPersonas,
                getApplicationContext());
        spinnerPersonas.setAdapter(adaptadorPersoSpinner);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.boton_elemento:
                agregarPersona();
                break;
            case R.id.boton_seleccionar:
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                intent.putExtra(TAG_1,(Persona) adaptadorPersonas.getItem(spinnerPersonas.getSelectedItemPosition()));
                startActivity(intent);
                break;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Persona seleccionada = (Persona) adaptadorPersonas.getItem(i);
        Toast.makeText(getApplicationContext(),seleccionada.getApellido(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
