package com.borja.proyectoequipos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.borja.proyectoequipos.utils.DataSet;
import com.borja.proyectoequipos.utils.Equipo;

import java.util.ArrayList;

public class DetalleActivity extends AppCompatActivity {

    Equipo equipoRecuperado;
    ArrayAdapter adapter;
    ListView lista;
    ArrayList jugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        instancias();
        recuperarDatos();
    }

    private void instancias() {
        lista = findViewById(R.id.lista_jugadores);
    }

    private void recuperarDatos() {
        if (getIntent().getExtras() != null) {
            equipoRecuperado = (Equipo) getIntent().getExtras().get(MainActivity.TAG_EQ);
            switch (equipoRecuperado.getNombre()) {
                case "Real Madrid":
                    jugadores = DataSet.newInstance().getJugadoresMadrid();
                    adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, jugadores);
                    lista.setAdapter(adapter);
                    break;

                case "FC Barcelona":
                    jugadores = DataSet.newInstance().getJugadoresBarsa();
                    adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, jugadores);
                    lista.setAdapter(adapter);
                    break;
            }
        }
    }
}
