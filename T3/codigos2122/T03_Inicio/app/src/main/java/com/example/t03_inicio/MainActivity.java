package com.example.t03_inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button botonSaludar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();


    }

    private void acciones() {
        botonSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Primer mensaje",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void instancias() {
        botonSaludar = findViewById(R.id.boton_saludar);
    }

}