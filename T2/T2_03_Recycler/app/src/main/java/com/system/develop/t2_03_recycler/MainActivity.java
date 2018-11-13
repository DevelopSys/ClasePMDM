package com.system.develop.t2_03_recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.system.develop.t2_03_recycler.adaptadores.AdaptadorPersoRecycler;
import com.system.develop.t2_03_recycler.utils.Persona;

public class MainActivity extends AppCompatActivity implements AdaptadorPersoRecycler.OnAdaptadorPersoListener {

    RecyclerView recyclerView;
    AdaptadorPersoRecycler adaptadorPersoRecycler;
    Persona p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        configurarRecycler();
        acciones();
    }

    private void acciones() {

    }

    private void configurarRecycler() {
        adaptadorPersoRecycler = new AdaptadorPersoRecycler(this);
        recyclerView.setAdapter(adaptadorPersoRecycler);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    private void instancias() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void onAdaptadorPersoSelected(Persona persona) {
        p = persona;
        Toast.makeText(getApplicationContext(),"Persona en Activity" + p.getNombre(),Toast.LENGTH_SHORT).show();
    }
}
