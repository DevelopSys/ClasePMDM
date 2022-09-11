package com.borja.t03_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.borja.t03_spinner.utils.Persona;

import java.util.ArrayList;

public class EjemploActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Spinner spinnerEdad, spinnerPersonas;
    ArrayList edades, personas;
    EditText editNombre, editApellido;
    CheckBox checkDispo;
    Button botonAgregar, botonObtener;
    ArrayAdapter adaptadorEdades, adaptadorPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo);
        instancias();
        rellenarEdades();
        acciones();
    }

    private void rellenarEdades() {
        spinnerPersonas.setAdapter(adaptadorPersonas);
        spinnerEdad.setAdapter(adaptadorEdades);
        for (int i = 0; i < 100; i++) {
            edades.add(i);
            adaptadorEdades.notifyDataSetChanged();
        }
    }

    private void acciones() {
        botonAgregar.setOnClickListener(this);
        botonObtener.setOnClickListener(this);
        spinnerPersonas.setOnItemSelectedListener(this);
    }

    private void instancias() {
        spinnerEdad = findViewById(R.id.spinner_edad);
        spinnerPersonas = findViewById(R.id.spinner_personas);
        editApellido = findViewById(R.id.edit_apellido);
        editNombre = findViewById(R.id.edit_nombre);
        checkDispo = findViewById(R.id.check_diponibilidad);
        botonAgregar = findViewById(R.id.boton_agregar);
        botonObtener = findViewById(R.id.boton_obtener);
        edades = new ArrayList();
        personas = new ArrayList();
        adaptadorEdades = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item, edades);
        adaptadorPersonas = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item, personas);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.boton_agregar:

                if (editNombre.getText().toString().isEmpty() || editApellido.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Faltan datos", Toast.LENGTH_SHORT).show();
                } else {
                    String nombre = editNombre.getText().toString();
                    String apellido = editApellido.getText().toString();
                    int edad = (int) adaptadorEdades.getItem(spinnerEdad.getSelectedItemPosition());
                    boolean disponiblidad = checkDispo.isChecked();
                    Persona persona = new Persona(nombre, apellido, edad, disponiblidad);
                    personas.add(persona);
                    adaptadorPersonas.notifyDataSetChanged();
                }
                break;
            case R.id.boton_obtener:
                if (adaptadorPersonas.getCount() > 0) {
                    Persona persona = (Persona) adaptadorPersonas.getItem(spinnerPersonas.getSelectedItemPosition());
                    Toast.makeText(getApplicationContext(), persona.getNombre(), Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Persona persona = (Persona) adaptadorPersonas.getItem(i);
        Toast.makeText(getApplicationContext(), persona.getNombre(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //Persona persona = (Persona) adaptadorPersonas.getItem(spinnerPersonas.getSelectedItemPosition());
        Toast.makeText(getApplicationContext(),"nada seleccionado",Toast.LENGTH_SHORT).show();
    }
}


















