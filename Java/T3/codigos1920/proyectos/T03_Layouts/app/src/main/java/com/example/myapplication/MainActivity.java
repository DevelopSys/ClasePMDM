package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnInicial, btnInicialDos, btnInicialTres;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();

    }

    private void acciones() {
        btnInicial.setOnClickListener(this);
        btnInicialDos.setOnClickListener(this);
        btnInicialTres.setOnClickListener(this);
    }

    private void instancias() {
        btnInicial = this.findViewById(R.id.btnInicialUno);
        btnInicialDos = this.findViewById(R.id.btnInicialDos);
        btnInicialTres = this.findViewById(R.id.btnInicialTres);
        texto = findViewById(R.id.texto);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnInicialUno:
                Toast.makeText(getApplicationContext(),
                        "boton pulsado uno", Toast.LENGTH_SHORT).show();
                texto.setText("BOTON1");
                break;
            case R.id.btnInicialDos:
                Toast.makeText(getApplicationContext(),
                        "boton pulsado dos", Toast.LENGTH_SHORT).show();
                texto.setText("BOTON2");
                break;
            case R.id.btnInicialTres:
                String saludo = texto.getText().toString();
                Toast.makeText(getApplicationContext(),saludo,Toast.LENGTH_SHORT).show();
                break;

        }


    }
}
