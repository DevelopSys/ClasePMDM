package com.system.develop.t2_examen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.system.develop.t2_examen.adaptadores.AdaptadorRecycler;
import com.system.develop.t2_examen.adaptadores.AdaptadorSpinner;
import com.system.develop.t2_examen.utils.Generico;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,AdaptadorRecycler.OnRecyclerListener {

    Spinner spinner;
    RecyclerView recyclerView;
    ImageView imagen;
    TextView nombre, detalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        construirSpinner();
        acciones();
    }

    private void acciones() {
        spinner.setOnItemSelectedListener(this);
    }

    private void construirSpinner() {
        AdaptadorSpinner spinnerAdapter = new AdaptadorSpinner(this);
        spinner.setAdapter(spinnerAdapter);
    }

    private void instancias() {
        spinner = findViewById(R.id.spinner);
        recyclerView = findViewById(R.id.recycler);
        imagen = findViewById(R.id.imagenMain);
        nombre = findViewById(R.id.nombreMain);
        detalle = findViewById(R.id.extraMain);
    }

    @Override
    public void onRecyclerSelected(Generico generico) {
        imagen.setImageResource(generico.getImagen());
        nombre.setText(generico.getNombre());
        detalle.setText(generico.getDetalle());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(this, position);
        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
