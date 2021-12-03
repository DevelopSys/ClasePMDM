package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listas.adapters.AdaptadorSpinner;
import com.example.listas.utils.Marca;
import com.example.listas.utils.Modelo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerMarcas;
    private ArrayAdapter adapterSpinner;
    private AdaptadorSpinner adaptadorAvanzadoSpinner;
    private ArrayList listaOpcionesSpinner;
    private ArrayList<Modelo> listaModelos;
    private ImageView imageMarca;
    private Button botonAnadir;
    private TextView textoModelo, textoPotencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        instancias();
        rellenarListas();
        asociarElementos();
        acciones();
    }

    private void acciones() {
        botonAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*listaOpcionesSpinner.add(new Marca("Defecto",R.drawable.defecto));
                adaptadorAvanzadoSpinner.notifyDataSetChanged();*/
                adaptadorAvanzadoSpinner.addMarca(new Marca("Defecto",R.drawable.defecto));
            }
        });
        spinnerMarcas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                /*Toast.makeText(getApplicationContext(),
                        adapterSpinner.getItem(position).toString(),Toast.LENGTH_SHORT).show();*/
                Marca marcaSeleccionada = (Marca) adaptadorAvanzadoSpinner.getItem(position);
                //imageMarca.setImageResource(marcaSeleccionada.getImagen());
                for ( Modelo itemModelo : listaModelos ) {
                    if (marcaSeleccionada.getNombre().equalsIgnoreCase(itemModelo.getMarca())){
                        imageMarca.setImageResource(itemModelo.getImagen());
                        textoModelo.setText(itemModelo.getNombre());
                        textoPotencia.setText(String.valueOf(itemModelo.getPotencia()));
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void rellenarListas() {

        listaModelos.add(new Modelo("I8","BMW",R.drawable.i8,300));
        listaModelos.add(new Modelo("EQC","Mercedes",R.drawable.eqc,400));
        listaModelos.add(new Modelo("A5","Audi",R.drawable.a5,500));
        listaModelos.add(new Modelo("Arteon","VW",R.drawable.arteon,200));

        listaOpcionesSpinner.add(new Marca("Mercedes", R.drawable.mercedes));
        listaOpcionesSpinner.add(new Marca("BMW", R.drawable.bmw));
        listaOpcionesSpinner.add(new Marca("VW", R.drawable.vw));
        listaOpcionesSpinner.add(new Marca("Audi", R.drawable.audi));

        adaptadorAvanzadoSpinner.notifyDataSetChanged();
    }

    private void asociarElementos() {

        spinnerMarcas.setAdapter(adaptadorAvanzadoSpinner);
    }

    private void instancias() {
        textoModelo = findViewById(R.id.texto_modelo);
        textoPotencia = findViewById(R.id.texto_potencia);
        listaModelos = new ArrayList();
        botonAnadir = findViewById(R.id.boton_anadir);
        spinnerMarcas = findViewById(R.id.spinner_marcas);
        imageMarca = findViewById(R.id.imagen_marca);
        listaOpcionesSpinner = new ArrayList();

        adaptadorAvanzadoSpinner =
                new AdaptadorSpinner(listaOpcionesSpinner,getApplicationContext());

        /*adapterSpinner = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item,listaOpcionesSpinner);*/
    }
}