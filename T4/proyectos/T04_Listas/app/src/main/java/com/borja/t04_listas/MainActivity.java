package com.borja.t04_listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.borja.t04_listas.adaptadores.AdaptadorLista;
import com.borja.t04_listas.utils.Marca;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lista;
    ArrayList<Marca> listaMarcas;
    //ArrayAdapter adatadorLista;
    AdaptadorLista adaptadorLista;
    Marca[] marcas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        rellenarLista();
        acciones();
    }

    private void acciones() {
        lista.setOnItemClickListener(this);
    }

    private void rellenarLista() {

        lista.setAdapter(adaptadorLista);
        listaMarcas.add(new Marca("Audi",R.drawable.audi));
        listaMarcas.add(new Marca("BMW",R.drawable.bmw));
        listaMarcas.add(new Marca("Ford",R.drawable.ford));
        listaMarcas.add(new Marca("Mercedes",R.drawable.mercedes));
        listaMarcas.add(new Marca("Mini",R.drawable.mini));
        listaMarcas.add(new Marca("Nissan",R.drawable.nissan));
        listaMarcas.add(new Marca("Toyota",R.drawable.toyota));
        listaMarcas.add(new Marca("Volkwagen",R.drawable.vw));
        listaMarcas.add(new Marca("Lexus",R.drawable.vw,123123123));
        adaptadorLista.notifyDataSetChanged();

    }

    private void instancias() {
        //marcas = new String[]{"Mercedes","Audi","Nissan","BMW","Mini","Ford","VW"};
        lista = findViewById(R.id.lista);
        listaMarcas = new ArrayList();
        /*adatadorLista = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item,
                listaMarcas);*/
        adaptadorLista = new AdaptadorLista(listaMarcas, getApplicationContext());

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Marca m = (Marca) lista.getAdapter().getItem(i);
        Toast.makeText(getApplicationContext(),m.getMarca(),Toast.LENGTH_SHORT).show();
    }
}
