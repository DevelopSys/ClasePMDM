package com.example.t03_repaso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ThirdActivity extends AppCompatActivity {

    private String nombre, apellido;
    private int telefono;
    private boolean experiencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        if (getIntent().getExtras() != null) {
            recuperarDatos();
        }
    }

    private void recuperarDatos() {
        nombre = getIntent().getExtras().getString("nombre");
        apellido = getIntent().getExtras().getString("apellido");
        telefono = getIntent().getExtras().getInt("numero");
        experiencia = getIntent().getExtras().getBoolean("experiencia");
        Log.v("test", nombre);

    }
}