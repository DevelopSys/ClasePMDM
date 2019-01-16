package com.system.develop.t4_ejemploexamenrec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.system.develop.t4_ejemploexamenrec.adaptadores.AdaptadorRecycler;
import com.system.develop.t4_ejemploexamenrec.dialogo.DialogoPelicula;
import com.system.develop.t4_ejemploexamenrec.utils.Peliculas;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnPeliculaListener {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        personalizarRecycler();
        registerForContextMenu(recyclerView);
    }

    private void personalizarRecycler() {
        recyclerView.setAdapter(new AdaptadorRecycler(MainActivity.this));
        //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
        //        LinearLayoutManager.VERTICAL,false));
        //recyclerView
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2, LinearLayoutManager.VERTICAL, false));
    }

    private void instancias() {
        recyclerView = findViewById(R.id.recyclerPeliculas);
    }

    @Override
    public void onPeliculaSelected(Peliculas pelicula) {
        DialogoPelicula dialogoPelicula = DialogoPelicula.newInstance(pelicula);
        dialogoPelicula.show(getSupportFragmentManager(), "PELICULA");
    }

    @Override
    public void onImagenSelected(String imagen) {
        //la imagen pasada
        //Toast.makeText(getApplicationContext(),"Imagen "+ imagen,Toast.LENGTH_SHORT).show();
        //DialogoPelicula dialogoPelicula = new DialogoPelicula();
        DialogoPelicula dialogoPelicula = DialogoPelicula.newInstance(imagen);
        dialogoPelicula.show(getSupportFragmentManager(), "PELICULA");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_ejemplo, menu);

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        switch (v.getId()){
            case R.id.recyclerPeliculas:
                getMenuInflater().inflate(R.menu.menu_ejemplo,menu);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opcionUno:
                finish();
                break;
            case R.id.opcionDos:
                Bundle b = new Bundle();
                onCreate(b);
                break;
        }

        return true;
    }
}
