package com.borja.proyectoequipos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.borja.proyectoequipos.adaptadores.AdaptadorEquipos;
import com.borja.proyectoequipos.adaptadores.AdaptadorLigas;
import com.borja.proyectoequipos.utils.DataSet;
import com.borja.proyectoequipos.utils.Equipo;
import com.borja.proyectoequipos.utils.Liga;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorLigas.OnLigaListener, AdaptadorEquipos.OnEquipoListener {

    RecyclerView recyclerLigas, recyclerEquipos;
    AdaptadorLigas adaptadorLigas;
    AdaptadorEquipos adaptadorEquipos;
    ArrayList<Liga> listaLigas;
    ArrayList<Equipo> listaEquipos;
    final static String TAG_EQ ="equipo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        configurarRecyclerLigas();
        configurarRecyclerEquipos();
        acciones();
    }

    private void configurarRecyclerEquipos() {
        recyclerEquipos.setLayoutManager(new LinearLayoutManager(this,
                RecyclerView.VERTICAL,false));
        recyclerEquipos.setAdapter(adaptadorEquipos);
    }

    private void acciones() {

    }

    private void configurarRecyclerLigas() {
        recyclerLigas.setAdapter(adaptadorLigas);
        recyclerLigas.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,
                false));
    }

    private void instancias() {

        recyclerEquipos = findViewById(R.id.recycler_equipos);
        recyclerLigas = findViewById(R.id.recycler_ligas);

        listaLigas = DataSet.newInstance().getLigas();
        listaEquipos = new ArrayList<>();
        adaptadorLigas = new AdaptadorLigas(listaLigas,MainActivity.this);
        adaptadorEquipos = new AdaptadorEquipos(listaEquipos, MainActivity.this);
    }

    @Override
    public void onLigaSelected(Liga liga) {

        Toast.makeText(getApplicationContext(),"Comuniacion",Toast.LENGTH_SHORT).show();

        switch (liga.getNombre()){
            case "La Liga":
                listaEquipos = DataSet.newInstance().getEquiposEsp();
                break;
            case "Calcio":
                listaEquipos = DataSet.newInstance().getEquiposIt();
                break;
        }

        adaptadorEquipos = new AdaptadorEquipos(listaEquipos, MainActivity.this);
        recyclerEquipos.setAdapter(adaptadorEquipos);
    }


    @Override
    public void onEquipoSelected(Equipo equipo) {
        Intent intent = new Intent(getApplicationContext(),DetalleActivity.class);
        intent.putExtra(TAG_EQ,equipo);
        startActivity(intent);
    }
}












