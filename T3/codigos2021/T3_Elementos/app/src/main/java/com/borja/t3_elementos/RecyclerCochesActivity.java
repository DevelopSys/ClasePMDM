package com.borja.t3_elementos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.borja.t3_elementos.adaptadores.AdaptadorRecyclerCoches;
import com.borja.t3_elementos.utils.Coche;

import java.util.ArrayList;

public class RecyclerCochesActivity extends AppCompatActivity
        implements AdaptadorRecyclerCoches.OnBotonRecyclerListener {

    private RecyclerView recyclerView;
    ArrayList<Coche> listaCoches;
    AdaptadorRecyclerCoches adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_coches);
        instancias();
        rellenarLista();
    }

    private void rellenarLista() {

        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()
                ,RecyclerView.VERTICAL,false));
        //recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

        listaCoches.add(new Coche("ETron","Audi",300,0, R.drawable.etron));
        listaCoches.add(new Coche("C220 Coupe","Mercedes",400,0, R.drawable.coupe));
        listaCoches.add(new Coche("Giulia","Alfa",400,0, R.drawable.gulia));
        listaCoches.add(new Coche("Golf","Volwagen",400,0, R.drawable.golf));
        listaCoches.add(new Coche("Ibiza","Mercedes",400,0, R.drawable.ibiza));
        listaCoches.add(new Coche("Focus","Mercedes",400,0, R.drawable.focus));
        listaCoches.add(new Coche("Kuga","Mercedes",400,0, R.drawable.kuga));
        listaCoches.add(new Coche("Arteon","Mercedes",400,0, R.drawable.arteon));

        adaptador.notifyDataSetChanged();


    }

    private void instancias() {
        recyclerView = findViewById(R.id.recycler_coches);
        listaCoches = new ArrayList<>();
        adaptador = new AdaptadorRecyclerCoches(RecyclerCochesActivity.this,listaCoches);
    }

    @Override
    public void onCocheSelected(Coche coche) {
        Log.v("coche",coche.getModelo());

    }

    @Override
    public void onCocheLongClick() {
        Toast.makeText(getApplicationContext(),"Pulsado largo",Toast.LENGTH_SHORT).show();
    }
}