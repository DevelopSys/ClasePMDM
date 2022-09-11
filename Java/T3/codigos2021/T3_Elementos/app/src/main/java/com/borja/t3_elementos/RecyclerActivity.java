package com.borja.t3_elementos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.borja.t3_elementos.adaptadores.AdaptadorRecycler;
import com.borja.t3_elementos.utils.Coche;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView listaRecycler;
    private AdaptadorRecycler adaptadorRecycler;
    private ArrayList<Coche> listaCoches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        instancias();
        persoRecycler();
        acciones();
    }

    private void acciones() {
        listaRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("test_pulsacion","pulsado");
            }
        });
    }

    private void persoRecycler() {

        listaRecycler.setAdapter(adaptadorRecycler);
        listaRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()
                ,RecyclerView.VERTICAL,false));
        //listaRecycler.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

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

        adaptadorRecycler.notifyDataSetChanged();

        //listaRecycler.setAdapter();
        //listaRecycler.setLayoutManager();
        //listaRecycler.setItemAnimator();
    }

    private void instancias() {
        listaRecycler = findViewById(R.id.recycler);
        listaCoches = new ArrayList();
        adaptadorRecycler = new AdaptadorRecycler(listaCoches,getApplicationContext());

    }
}