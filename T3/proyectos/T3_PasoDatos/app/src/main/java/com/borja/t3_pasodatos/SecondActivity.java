package com.borja.t3_pasodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textoRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        instancias();
        recuperarDatos();
    }

    private void recuperarDatos() {
        if (getIntent().getExtras() != null) {
            String palabraRecuperada = (String) getIntent().getExtras().get(MainActivity.TAG_1);
            textoRecuperar.setText(palabraRecuperada);
        }
    }

    private void instancias() {
        textoRecuperar = findViewById(R.id.textoRecuperado);
    }
}
