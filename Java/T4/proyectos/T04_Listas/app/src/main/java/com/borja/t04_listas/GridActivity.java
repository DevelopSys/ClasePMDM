package com.borja.t04_listas;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.borja.t04_listas.adaptadores.AdaptadorLista;
import com.borja.t04_listas.utils.Marca;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    GridView grid;
    ArrayList<Marca> listaMarcas;
    //ArrayAdapter adatadorLista;
    AdaptadorLista adaptadorLista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        instancias();
        rellenarLista();
        acciones();
    }

    private void acciones() {
        grid.setOnItemClickListener(this);
    }

    private void rellenarLista() {
        grid.setAdapter(adaptadorLista);
        listaMarcas.add(new Marca("Mercedes AMG",R.drawable.amggt));
        listaMarcas.add(new Marca("Bentley Continental",R.drawable.continental));
        listaMarcas.add(new Marca("Ford GT 40",R.drawable.gt40));
        listaMarcas.add(new Marca("Nissan GTR",R.drawable.gtr));
        listaMarcas.add(new Marca("Paganni huayra",R.drawable.huayra));
        listaMarcas.add(new Marca("Lexus LC",R.drawable.lc));
        listaMarcas.add(new Marca("Le Ferrari",R.drawable.leferrari));
        listaMarcas.add(new Marca("Masserati",R.drawable.maserattigt));
        listaMarcas.add(new Marca("Toyota Supra",R.drawable.supra,123123123));
        listaMarcas.add(new Marca("Porche Taycan",R.drawable.taycan,123123123));
        adaptadorLista.notifyDataSetChanged();
    }

    private void instancias() {
        //marcas = new String[]{"Mercedes","Audi","Nissan","BMW","Mini","Ford","VW"};
        grid = findViewById(R.id.grid);
        listaMarcas = new ArrayList();
        /*adatadorLista = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item,
                listaMarcas);*/
        adaptadorLista = new AdaptadorLista(listaMarcas, getApplicationContext());

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Marca coche = (Marca) adaptadorLista.getItem(i);
        Toast.makeText(getApplicationContext(),coche.getMarca(),Toast.LENGTH_SHORT).show();

    }
}
