package com.borja.t02_intents;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.borja.t02_intents.utils.Persona;

import java.io.Serializable;

public class SegundaActivity extends AppCompatActivity {

    private TextView texto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sencond);
        instancias();
        // solo recupero cuando hay datos
        if (getIntent().getExtras() != null) {
            recuperarDatos();
        }

    }

    private void instancias() {
        texto = findViewById(R.id.texto_pantalla_dos);
    }

    private void recuperarDatos() {


        Bundle bundle = getIntent().getExtras();
        /*String nombreRecuperado = bundle.getString("nombre");
        String apellidoRecuperado = bundle.getString("apellido");
        int edadRecuperado = bundle.getInt("edad");
        boolean experienciaRecuperada = bundle.getBoolean("experiencia");*/
        Persona persona = (Persona) bundle.getSerializable("persona");
        texto.setText(persona.getNombre()+" "+persona.getApellido()+" "
                +persona.getTelefono());


    }
}
