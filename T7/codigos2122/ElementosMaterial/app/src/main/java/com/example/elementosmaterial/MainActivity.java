package com.example.elementosmaterial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        configurarToolbar();
        acciones();
    }

    private void acciones() {


        /*toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_pref_1:
                        Toast.makeText(getApplicationContext(), "Opcion 1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_pref_2:
                        Toast.makeText(getApplicationContext(), "Opcion 2", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });*/
    }

    private void configurarToolbar() {
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle("Nuevo titulo");
    }

    private void instancias() {
        //toolbar = findViewById(R.id.toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pref, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_pref_1:
                Toast.makeText(getApplicationContext(), "Opcion 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_pref_2:
                Toast.makeText(getApplicationContext(), "Opcion 2", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}