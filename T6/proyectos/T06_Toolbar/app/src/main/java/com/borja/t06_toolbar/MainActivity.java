package com.borja.t06_toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        personalizarToolbar();
        acciones();
        toolbar.setTitle("Mi titulo");

    }

    private void acciones() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.v("searchview",newText);
                return true;
            }
        });
    }

    private void personalizarToolbar() {
        setSupportActionBar(toolbar);
    }

    private void instancias() {
        searchView = findViewById(R.id.barra_busqueda);
        toolbar = findViewById(R.id.toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(getApplicationContext());
        menuInflater.inflate(R.menu.menu_superior, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_uno:
                Toast.makeText(getApplicationContext(),"uno",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_dos:
                Toast.makeText(getApplicationContext(),"dos",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_tres:
                Toast.makeText(getApplicationContext(),"tres",Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}
