package com.example.configuraciones;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMasUno, btnMasDos, btnMenosUno, btnMenosDos, btnResultado, btnBorrar;
    private EditText editResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            accionesHorizontal();
        }
    }

    private void acciones() {
        btnMenosUno.setOnClickListener(this);
        btnMenosDos.setOnClickListener(this);
        btnMasUno.setOnClickListener(this);
        btnMasDos.setOnClickListener(this);
        btnResultado.setOnClickListener(this);

    }

    private void accionesHorizontal(){
        btnBorrar.setOnClickListener(this);
    }

    private void instancias() {
        btnBorrar = findViewById(R.id.boton_borrar);
        btnMasDos = findViewById(R.id.boton_mas_dos);
        btnMasUno = findViewById(R.id.boton_mas_uno);
        btnMenosDos = findViewById(R.id.boton_menos_dos);
        btnMenosUno = findViewById(R.id.boton_menos_uno);
        btnResultado = findViewById(R.id.boton_resultado);
        editResultado = findViewById(R.id.texto_resultado);

    }

    @Override
    public void onClick(View v) {

    }
}