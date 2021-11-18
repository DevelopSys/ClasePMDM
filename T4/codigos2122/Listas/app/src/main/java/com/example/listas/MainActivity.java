package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.listas.adapters.AdaptadorSpinner;
import com.example.listas.utils.Coche;
import com.example.listas.utils.Marca;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinnerCoches;
    private TextView textoCoches;
    private ImageView imagenCoche;
    private Button botonComprobar, botonAnadir;
    private ArrayAdapter adaptadorSpinner;
    private ArrayList<Marca> listaMarcas;
    private ArrayList<Coche> listaCoches;
    private AdaptadorSpinner adaptadorSpinnerAvanzado;

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
        botonAnadir.setOnClickListener(this);
    }

    private void iniciarElementos() {
        //spinnerCoches.setAdapter(adaptadorSpinner);
        spinnerCoches.setAdapter(adaptadorSpinnerAvanzado);

    }

    private void iniciarListas() {

        listaCoches.add(new Coche("C220", "Mercedes", R.drawable.mercedes, 200));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));
        listaCoches.add(new Coche("A6", "Audi", R.drawable.audi, 300));

    }

    private void instancias() {
        spinnerCoches = findViewById(R.id.spinner_coches);
        //textoCoches = findViewById(R.id.texto_coche);
        imagenCoche = findViewById(R.id.imagen_coche);
        botonComprobar = findViewById(R.id.boton_coches);
        botonAnadir = findViewById(R.id.boton_anadir);
        listaMarcas = new ArrayList();
        listaCoches = new ArrayList<>();
        adaptadorSpinner = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item, listaMarcas);
        adaptadorSpinnerAvanzado = new AdaptadorSpinner(listaCoches, getApplicationContext());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boton_coches:

                //textoCoches.setText(String.valueOf(spinnerCoches.getSelectedItem()));
                // adaptadorSpinner
                //spinnerCoches.getAdapter()
                /*textoCoches.setText(
                        adaptadorSpinner.
                                getItem(spinnerCoches.getSelectedItemPosition()).toString());*/
                Marca marcaSeleccionada =
                        (Marca) adaptadorSpinner.getItem(spinnerCoches.getSelectedItemPosition());

                imagenCoche.setImageResource(marcaSeleccionada.getImagen());

                break;

            case R.id.boton_anadir:

                listaMarcas.add(new Marca("MarcaNueva", R.drawable.def));
                adaptadorSpinner.notifyDataSetChanged();


                break;
        }
    }
}