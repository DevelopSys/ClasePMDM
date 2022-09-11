package com.borja.t04_spinnerperso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.borja.t04_spinnerperso.adaptadores.AdaptadorSpinner;
import com.borja.t04_spinnerperso.utils.Marca;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayList<Marca> listaMarcas;
    AdaptadorSpinner adaptadorSpinner;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        rellenarLista();
        acciones();

    }

    private void acciones() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Marca mActual = (Marca) adaptadorSpinner.getItem(i);
                imagen.setImageResource(mActual.getLogo());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void rellenarLista() {
        spinner.setAdapter(adaptadorSpinner);
        listaMarcas.add(new Marca("Ford",R.drawable.ford));
        listaMarcas.add(new Marca("Audi",R.drawable.audi));
        listaMarcas.add(new Marca("Mercedes",R.drawable.mercedes));
        listaMarcas.add(new Marca("Nissan",R.drawable.nissan));
        listaMarcas.add(new Marca("Mini",R.drawable.mini));
        listaMarcas.add(new Marca("Toyota",R.drawable.toyota));
        listaMarcas.add(new Marca("VW",R.drawable.vw));
        listaMarcas.add(new Marca("BMW",R.drawable.bmw));
        listaMarcas.add(new Marca("Otra",R.drawable.car_other));
        adaptadorSpinner.notifyDataSetChanged();
    }

    private void instancias() {
        spinner = findViewById(R.id.spinner_personalizado);
        listaMarcas = new ArrayList();
        adaptadorSpinner = new AdaptadorSpinner(listaMarcas, getApplicationContext());
        imagen = findViewById(R.id.imagen_marca);
    }
}
