package com.borja.t3_elementos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.borja.t3_elementos.adaptadores.AdaptadorLista;
import com.borja.t3_elementos.adaptadores.AdaptadorSpinner;
import com.borja.t3_elementos.utils.Coche;
import com.borja.t3_elementos.utils.Marca;

import java.util.ArrayList;

public class ListasPersoActivity extends AppCompatActivity {

    private Spinner spinnerMarcas;
    private ListView listViewCoches;

    private ArrayList<Coche> listaCoches;
    private ArrayList<Marca> listaMarcas;

    //private ArrayAdapter adaptadorLista;
    private AdaptadorLista adaptadorListaPerso;
    //private ArrayAdapter adaptadorSpinner;
    private AdaptadorSpinner adaptadorSpinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_perso);
        instancias();
        rellenarListas();
        acciones();
    }

    private void acciones() {
        listViewCoches.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Coche coche = (Coche) adaptadorListaPerso.getItem(position);
                //Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void rellenarListas() {

        spinnerMarcas.setAdapter(adaptadorSpinner);
        //listViewCoches.setAdapter(adaptadorLista);
        listViewCoches.setAdapter(adaptadorListaPerso);

        listaMarcas.add(new Marca("Ford",R.drawable.ford));
        listaMarcas.add(new Marca("Seat", R.drawable.seat));
        listaMarcas.add(new Marca("Volskwagen",R.drawable.vw));
        listaMarcas.add(new Marca("Mercedes",R.drawable.mercedes));
        listaMarcas.add(new Marca("Audi", R.drawable.audi));
        listaMarcas.add(new Marca("Volvo", R.drawable.volvo));
        adaptadorSpinner.notifyDataSetChanged();


        listaCoches.add(new Coche("Kuga", "Ford", 250, 0));
        listaCoches.add(new Coche("Ibiza", "Seat", 120, 0));
        listaCoches.add(new Coche("Leon", "Seat", 90, 0));
        listaCoches.add(new Coche("Focus", "Ford", 100, 0));
        listaCoches.add(new Coche("Golf", "Volskwagen", 200, 0));
        listaCoches.add(new Coche("C220", "Mercedes", 250, 0));
        listaCoches.add(new Coche("CLA220", "Mercedes", 250, 0));
        listaCoches.add(new Coche("C220", "Mercedes", 250, 0));
        listaCoches.add(new Coche("A3", "Audi", 100, 0));
        listaCoches.add(new Coche("A4", "Audi", 100, 0));
        listaCoches.add(new Coche("A6", "Audi", 100, 0));
        listaCoches.add(new Coche("C90", "Volvo", 200, 0));
        listaCoches.add(new Coche("C60", "Volvo", 200, 0));
        //adaptadorLista.notifyDataSetChanged();
        adaptadorListaPerso.notifyDataSetChanged();

    }

    private void instancias() {
        spinnerMarcas = findViewById(R.id.spinner_perso);
        listViewCoches = findViewById(R.id.lista_perso);

        listaCoches = new ArrayList();
        listaMarcas = new ArrayList();

        /*adaptadorSpinner = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item, listaMarcas);*/

        adaptadorSpinner = new AdaptadorSpinner(listaMarcas,getApplicationContext());


        //adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        /*adaptadorLista = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1, listaCoches);*/

        adaptadorListaPerso = new AdaptadorLista(listaCoches, getApplicationContext());
    }
}