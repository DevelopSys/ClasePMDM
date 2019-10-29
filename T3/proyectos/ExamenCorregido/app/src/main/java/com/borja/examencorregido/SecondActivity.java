package com.borja.examencorregido;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tRecupera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        instancias();
        recuperarDatos();
    }

    private void recuperarDatos() {
        if (getIntent().getExtras()!=null){

            String tipo = (String) getIntent().getExtras().get(MainActivity.TAG2);
            int resultado= (int) getIntent().getExtras().get(MainActivity.TAG1);

            tRecupera.setText(String.format("La operación de %s es %d",tipo,resultado));
        }
    }

    private void instancias() {
        tRecupera = findViewById(R.id.texto_recibido);
    }
}
