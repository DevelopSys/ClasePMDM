package com.system.develop.t1_05_gestioneventos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1, b2, b3, b4, b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
    }

    private void instancias() {
        b1 = findViewById(R.id.boton1);
        b2 = findViewById(R.id.boton2);
        b3 = findViewById(R.id.boton3);
        b4 = findViewById(R.id.boton4);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boton1:
                Toast.makeText(getApplicationContext(),"Pulsado boton 1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.boton2:
                Toast.makeText(getApplicationContext(),"Pulsado boton 2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.boton3:
                Toast.makeText(getApplicationContext(),"Pulsado boton 3",Toast.LENGTH_SHORT).show();
                break;
            case R.id.boton4:
                Toast.makeText(getApplicationContext(),"Pulsado boton 4",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void metodoPulsado(View v){
        // metodo para el boton 5 cuando es pulsado
    }
}
