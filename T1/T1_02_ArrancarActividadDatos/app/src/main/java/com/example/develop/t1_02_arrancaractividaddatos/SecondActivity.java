package com.example.develop.t1_02_arrancaractividaddatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.develop.t1_02_arrancaractividaddatos.utils.Persona;

public class SecondActivity extends AppCompatActivity {

    TextView textNombre,textApellido,textTelefono;
    EditText editNota;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textNombre = findViewById(R.id.textoNombre);
        textApellido = findViewById(R.id.textoApellido);
        textTelefono = findViewById(R.id.textoTelefono);
        boton = findViewById(R.id.botonVolver);
        recuperarDatos();
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    private void recuperarDatos() {

        Persona p = (Persona) getIntent().getSerializableExtra(MainActivity.TAG_KEY);
        textTelefono.setText(String.valueOf(p.getTelefono()));
        textNombre.setText(p.getNombre());
        textApellido.setText(p.getApellido());
    }


}