package com.example.t4_recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.t4_recycler.adaptadores.AdaptadorRecycler;
import com.example.t4_recycler.utils.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnContantoRecyclerListener {

    private RecyclerView recyclerView;
    private AdaptadorRecycler adaptadorRecycler;
    private ArrayList<Contacto> listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        rellenarLista();
        asociarListas();

    }


    private void asociarListas() {
        recyclerView.setAdapter(adaptadorRecycler);
        /*recyclerView.setLayoutManager(
                new LinearLayoutManager(getApplicationContext()
                        ,LinearLayoutManager.VERTICAL,false));*/
        //recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            //recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(
                new LinearLayoutManager(getApplicationContext()
                        ,LinearLayoutManager.VERTICAL,false));
        }
    }

    private void rellenarLista() {
        listaContactos.add(new Contacto("Borja","Martin","Pozuelo",1234));
        listaContactos.add(new Contacto("Pedro","Martin","Getafe",23453));
        listaContactos.add(new Contacto("Celia","Martin","Alcorcon",5432));
        listaContactos.add(new Contacto("Marta","Martin","Majadahonda",56456));
        listaContactos.add(new Contacto("Anaasdasdasdasdasdasdasdasd","Martin","Fuenlabrada",7566));
        listaContactos.add(new Contacto("Jesus","Martin","Aluche",325643));
        adaptadorRecycler.notifyDataSetChanged();
    }

    private void instancias() {
        recyclerView = findViewById(R.id.recycler_view);
        listaContactos = new ArrayList<>();
        adaptadorRecycler = new AdaptadorRecycler(listaContactos,MainActivity.this);

    }


    @Override
    public void onContactoSelected(Contacto contacto) {
        Toast.makeText(getApplicationContext(),String.valueOf(contacto.getTelefono()),Toast.LENGTH_SHORT).show();


    }
}