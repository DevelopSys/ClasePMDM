package com.example.t03_repaso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.t03_repaso.utils.Persona;

public class ThirdActivity extends AppCompatActivity {

    private String nombre, apellido;
    private int telefono;
    private boolean experiencia;
    private Persona personaRecuperada;

    private TextView textNombre, textApellido, textTelefono;
    private CheckBox checkExperiencia;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        instancias();
        if (getIntent().getExtras() != null) {
            recuperarDatos();
            setearDatos();
        }
    }

    private void setearDatos() {
        textNombre.setText(personaRecuperada.getNombre());
        textApellido.setText(personaRecuperada.getApellido());
        textTelefono.setText(String.valueOf(personaRecuperada.getTelefono()));
        checkExperiencia.setChecked(personaRecuperada.isExperiencia());
    }

    private void instancias() {
        textNombre = findViewById(R.id.nombre_recuperar);
        textApellido = findViewById(R.id.apellido_recuperar);
        textTelefono = findViewById(R.id.telefono_recuperar);
        checkExperiencia = findViewById(R.id.check_recuperar);
    }

    private void recuperarDatos() {
        /*nombre = getIntent().getExtras().getString("nombre");
        apellido = getIntent().getExtras().getString("apellido");
        telefono = getIntent().getExtras().getInt("numero");
        experiencia = getIntent().getExtras().getBoolean("experiencia");*/
        personaRecuperada = (Persona) getIntent().getExtras().getSerializable("persona");
        //Log.v("test", nombre);

    }
}