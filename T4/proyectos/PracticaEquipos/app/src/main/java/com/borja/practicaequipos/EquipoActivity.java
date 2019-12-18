package com.borja.practicaequipos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.borja.practicaequipos.adaptadores.AdaptadorEquipos;
import com.borja.practicaequipos.adaptadores.AdaptadorJugador;
import com.borja.practicaequipos.adaptadores.AdaptadorJugadorR;
import com.borja.practicaequipos.dataset.DataSet;

import java.util.ArrayList;

public class EquipoActivity extends AppCompatActivity {

    RecyclerView listaJugadores;
    ArrayList plantilla;
    ArrayAdapter adaptadorEquipo;
    AdaptadorJugadorR adaptadorJugador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo);
        recuperarDatos();
        instancias();
    }

    private void recuperarDatos() {
        String equipo = null;
        if (getIntent().getExtras().get("equipo") != null) {
            equipo = (String) getIntent().getExtras().get("equipo");
        }

        switch (equipo) {
            case "FC.Barcelona":
                plantilla = DataSet.newInstance().listaJugadoresBarsa();
                break;
            case "Real Madrid":
                plantilla = DataSet.newInstance().listaJugadoresMadrid();
                break;
            case "Atletico de Madrid":
                plantilla = DataSet.newInstance().listaJugadoresAtleti();
                break;
            case "M.City":
                plantilla = DataSet.newInstance().listaJugadoresCity();
                break;
        }
    }

    private void instancias() {
        listaJugadores = findViewById(R.id.lista_jugadores);
        listaJugadores.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adaptadorJugador = new AdaptadorJugadorR(plantilla, getApplicationContext());
        listaJugadores.setAdapter(adaptadorJugador);
    }
}
