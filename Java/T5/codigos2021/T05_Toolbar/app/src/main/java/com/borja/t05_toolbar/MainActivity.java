package com.borja.t05_toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        persoActionBar();
        cargaImagenes();
    }

    private void cargaImagenes() {
        Glide.with(getApplicationContext())
                .load("https://cdn.britannica.com/66/154566-050-36E73C15/Times-Square-New-York-City.jpg")
                .error(R.drawable.error)
                .placeholder(R.drawable.cargando)
                .into(imagen);
    }

    private void persoActionBar() {
        setSupportActionBar(toolbar);
    }

    private void instancias() {
        toolbar = findViewById(R.id.toolbar);
        imagen = findViewById(R.id.imagen_glide);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_uno:
                Toast.makeText(getApplicationContext(), "Opcion 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item_dos:
                Toast.makeText(getApplicationContext(), "Opcion 2", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}