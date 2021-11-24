package com.example.proyectomodelos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proyectomodelos.adapters.AdaptadorMarcas;
import com.example.proyectomodelos.adapters.AdatadorModelo;
import com.example.proyectomodelos.utils.Marca;
import com.example.proyectomodelos.utils.Modelo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerMarcas;
    private AdaptadorMarcas adaptadorMarcas;
    private AdatadorModelo adatadorModelo;
    private ListView listViewModelos;
    private ArrayList<Marca> listaMarcas;
    private ArrayList<Modelo> listaModelos;
    private ArrayList<Modelo> listaFiltrada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        iniciarListas();
        asociarElementos();
        acciones();
    }

    private void acciones() {
       spinnerMarcas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               Marca marca = (Marca) adaptadorMarcas.getItem(position);
               String marcaSeleccionada= marca.getMarca();
               listaFiltrada.clear();
               adatadorModelo.notifyDataSetChanged();
               for ( Modelo itemModelo :listaModelos ){
                   if (itemModelo.getMarca().getMarca()
                           .toLowerCase().equals(marcaSeleccionada.toLowerCase())){

                       // el modelo que toca esta en lo que necesito
                       listaFiltrada.add(itemModelo);
                       adatadorModelo.notifyDataSetChanged();

                   }
               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
        listViewModelos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Modelo modeloSeleccionado = (Modelo) listViewModelos.getAdapter().getItem(position);
                Toast.makeText(getApplicationContext(),
                        String.valueOf(modeloSeleccionado.getCv()),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void asociarElementos() {
        spinnerMarcas.setAdapter(adaptadorMarcas);
        listViewModelos.setAdapter(adatadorModelo);
    }

    private void iniciarListas() {
        listaMarcas.add(new Marca("BMW",R.drawable.bmw));
        listaMarcas.add(new Marca("Mercedes",R.drawable.mercedes));
        listaMarcas.add(new Marca("Audi",R.drawable.audi));
        listaMarcas.add(new Marca("VW",R.drawable.vw));

        listaModelos.add(new Modelo("I8",500, R.drawable.i8,new Marca("bmw")));
        listaModelos.add(new Modelo("I8",500, R.drawable.i8,new Marca("bmw")));
        listaModelos.add(new Modelo("I8",500, R.drawable.i8,new Marca("bmw")));
        listaModelos.add(new Modelo("I8",500, R.drawable.i8,new Marca("bmw")));
        listaModelos.add(new Modelo("I8",500, R.drawable.i8,new Marca("bmw")));
        listaModelos.add(new Modelo("EQC",324, R.drawable.eqc,new Marca("mercedes")));
        listaModelos.add(new Modelo("EQC",500, R.drawable.eqc,new Marca("mercedes")));
        listaModelos.add(new Modelo("EQC",234, R.drawable.eqc,new Marca("mercedes")));
        listaModelos.add(new Modelo("EQC",645, R.drawable.eqc,new Marca("mercedes")));
        listaModelos.add(new Modelo("EQC",500, R.drawable.eqc,new Marca("mercedes")));
        listaModelos.add(new Modelo("EQC",500, R.drawable.eqc,new Marca("mercedes")));
        listaModelos.add(new Modelo("Arteon",500, R.drawable.arteon,new Marca("vw")));
        listaModelos.add(new Modelo("Arteon",500, R.drawable.arteon,new Marca("vw")));
        listaModelos.add(new Modelo("Arteon",75, R.drawable.arteon,new Marca("vw")));
        listaModelos.add(new Modelo("Arteon",500, R.drawable.arteon,new Marca("vw")));
        listaModelos.add(new Modelo("Arteon",500, R.drawable.arteon,new Marca("vw")));
        listaModelos.add(new Modelo("A5",678, R.drawable.a5,new Marca("audi")));
        listaModelos.add(new Modelo("A5",500, R.drawable.a5,new Marca("audi")));
        listaModelos.add(new Modelo("A5",345, R.drawable.a5,new Marca("audi")));
        listaModelos.add(new Modelo("A5",500, R.drawable.a5,new Marca("audi")));
        listaModelos.add(new Modelo("A5",500, R.drawable.a5,new Marca("audi")));
    }

    private void instancias() {
        listaMarcas = new ArrayList<>();
        listaModelos = new ArrayList<>();
        listaFiltrada = new ArrayList<>();
        spinnerMarcas = this.findViewById(R.id.spinner_marcas);
        listViewModelos = findViewById(R.id.lista_modelos);
        adaptadorMarcas = new AdaptadorMarcas(listaMarcas,getApplicationContext());
        adatadorModelo = new AdatadorModelo(listaFiltrada,getApplicationContext());
    }
}