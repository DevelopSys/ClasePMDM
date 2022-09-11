package com.borja.t3_elementos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OtrosActivity extends AppCompatActivity {

    private Spinner spinnerOpciones;
    private TextView textoOpcion;
    private ArrayList<String> listaSpinner;
    private ArrayAdapter adapterSpinner;
    private Button botonSpiner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otros);
        instancias();
        configurarSpinner();
        acciones();
    }

    private void acciones() {
        botonSpiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String opcion = (String) adapterSpinner.getItem(spinnerOpciones.getSelectedItemPosition());
                //String opcion = (String) spinnerOpciones.getSelectedItem();
                Toast.makeText(getApplicationContext(),opcion,Toast.LENGTH_SHORT).show();
            }
        });
        spinnerOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),String.valueOf(position), Toast.LENGTH_SHORT).show();
                textoOpcion.setText(adapterSpinner.getItem(spinnerOpciones.getSelectedItemPosition()).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void configurarSpinner() {
        spinnerOpciones.setPrompt("Selecciona una opción");
        adapterSpinner.add("Opcion Nueva");
        spinnerOpciones.setAdapter(adapterSpinner);
    }

    private void instancias() {
        spinnerOpciones = findViewById(R.id.spinner_opciones);
        textoOpcion = findViewById(R.id.texto_opcion);
        listaSpinner = new ArrayList<>();
        for (int i=1;i<101;i++){
            listaSpinner.add("Opción "+String.valueOf(i));
        }
        adapterSpinner = new ArrayAdapter(getApplicationContext()
                , android.R.layout.simple_spinner_item,listaSpinner);
        botonSpiner = findViewById(R.id.boton_spinner);


    }
}