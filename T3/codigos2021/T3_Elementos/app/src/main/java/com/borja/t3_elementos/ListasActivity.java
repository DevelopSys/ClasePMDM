package com.borja.t3_elementos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.borja.t3_elementos.utils.Coche;

import java.util.ArrayList;

public class ListasActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lista;
    private Spinner spinner;
    private Button botonFitrar;
    ArrayList<Coche> listaListView, listaCoches;
    ArrayList listaSpinner;
    ArrayAdapter adaptadorLista, adaptadorSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);
        instancias();
        rellenarDatos();
        acciones();
    }

    private void acciones() {
        lista.setOnItemClickListener(this);
        botonFitrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cvSelect = Integer.valueOf(adaptadorSpinner.getItem(spinner.getSelectedItemPosition()).toString());
                
                listaListView.clear();
                adaptadorLista.notifyDataSetChanged();
                for (Coche coche:listaCoches) {
                    if (coche.getCv()>=cvSelect){
                        listaListView.add(coche);
                        adaptadorLista.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    private void rellenarDatos() {

        for (int i=50;i<=300;i++){
            listaSpinner.add(i);
            i+=9;
            adaptadorSpinner.notifyDataSetChanged();
        }

        listaCoches.add(new Coche("Focus", "Ford", 100, 0));
        listaCoches.add(new Coche("Fiesta", "Ford", 200, 0));
        listaCoches.add(new Coche("Kuga", "Ford", 250, 0));
        listaCoches.add(new Coche("Ibiza", "Seat", 120, 0));
        listaCoches.add(new Coche("Leon", "Seat", 90, 0));
        listaCoches.add(new Coche("Focus", "Ford", 100, 0));
        listaCoches.add(new Coche("Fiesta", "Ford", 200, 0));
        listaCoches.add(new Coche("Kuga", "Ford", 250, 0));
        listaCoches.add(new Coche("Focus", "Ford", 100, 0));
        listaCoches.add(new Coche("Fiesta", "Ford", 200, 0));
        listaCoches.add(new Coche("Kuga", "Ford", 250, 0));
        listaCoches.add(new Coche("Ibiza", "Seat", 120, 0));
        listaCoches.add(new Coche("Leon", "Seat", 90, 0));
        listaCoches.add(new Coche("Focus", "Ford", 100, 0));
        listaCoches.add(new Coche("Fiesta", "Ford", 200, 0));
        listaCoches.add(new Coche("Kuga", "Ford", 250, 0));
        listaCoches.add(new Coche("Focus", "Ford", 100, 0));
        listaCoches.add(new Coche("Fiesta", "Ford", 200, 0));
        listaCoches.add(new Coche("Kuga", "Ford", 250, 0));
        listaCoches.add(new Coche("Ibiza", "Seat", 120, 0));
        listaCoches.add(new Coche("Leon", "Seat", 60, 0));
        listaCoches.add(new Coche("Focus", "Ford", 100, 0));
        listaCoches.add(new Coche("Fiesta", "Ford", 70, 0));
        listaCoches.add(new Coche("Kuga", "Ford", 250, 0));
        listaCoches.add(new Coche("Focus", "Ford", 70, 0));
        listaCoches.add(new Coche("Fiesta", "Ford", 200, 0));
        listaCoches.add(new Coche("Kuga", "Ford", 250, 0));
        listaCoches.add(new Coche("Ibiza", "Seat", 120, 0));
        listaCoches.add(new Coche("Leon", "Seat", 90, 0));
        listaCoches.add(new Coche("Focus", "Ford", 50, 0));
        listaCoches.add(new Coche("Fiesta", "Ford", 150, 0));
        listaCoches.add(new Coche("Kuga", "Ford", 250, 0));

    }

    private void instancias() {
        lista = findViewById(R.id.lista_simple);
        spinner = findViewById(R.id.spinner_cv);
        botonFitrar = findViewById(R.id.boton_filtrar);

        listaSpinner = new ArrayList();
        listaCoches = new ArrayList();
        listaListView = new ArrayList<>();

        adaptadorSpinner = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item, listaSpinner);
        adaptadorLista = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1, listaListView);

        lista.setAdapter(adaptadorLista);
        spinner.setAdapter(adaptadorSpinner);
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Log.v("lista", String.valueOf(position));
        Coche coche = (Coche) adaptadorLista.getItem(position);
        Log.v("lista", String.valueOf(coche.getCv()));
        Toast.makeText(getApplicationContext(), String.valueOf(coche.getCv()), Toast.LENGTH_SHORT).show();

    }
}










