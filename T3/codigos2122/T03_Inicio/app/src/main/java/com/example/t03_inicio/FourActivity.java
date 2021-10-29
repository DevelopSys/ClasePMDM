package com.example.t03_inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class FourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        if (getIntent().getExtras() != null ){
            recuperarDatos();
        }

    }

    private void recuperarDatos() {
        String nombre = getIntent().getExtras().getString("nombre");
        String apellido = getIntent().getExtras().getString("apellido");
        int telefono = getIntent().getExtras().getInt("telefono");
        boolean experiencia = getIntent().getExtras().getBoolean("experiencia");
        Log.v("test",nombre);
        Log.v("test",apellido);
    }
}