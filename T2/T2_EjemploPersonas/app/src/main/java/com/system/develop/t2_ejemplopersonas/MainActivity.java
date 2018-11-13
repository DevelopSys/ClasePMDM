package com.system.develop.t2_ejemplopersonas;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.system.develop.t2_ejemplopersonas.adaptadores.AdaptadorPersonalizado;
import com.system.develop.t2_ejemplopersonas.utils.Persona;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView lista;
    AdaptadorPersonalizado adaptadorPersonalizado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        personalizarLista();
        acciones();
        agregarPersona();

    }

    private void agregarPersona() {
        adaptadorPersonalizado.agregarPersona(new Persona("NombreIntro", "ApellidoIntro", 2345, 0));
    }

    private void personalizarLista() {

        ArrayList<Persona> personas = new ArrayList<Persona>();
        personas.add(new Persona("Nombre", "Apellido", 123, 1));
        adaptadorPersonalizado = new AdaptadorPersonalizado(personas, getApplicationContext());
        lista.setAdapter(adaptadorPersonalizado);
    }

    private void instancias() {
        lista = findViewById(R.id.lista);

    }

    private void acciones() {
        lista.setOnItemClickListener(this);
        //lista.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Persona p = (Persona) parent.getAdapter().getItem(position);
        //Toast.makeText(getApplicationContext(),String.valueOf(p.getTelefono()),Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        adaptadorPersonalizado.borrarPersona(position);
        return false;
    }
}
