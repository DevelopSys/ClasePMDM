package com.example.t03_repaso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.t03_repaso.utils.Persona;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    private String nombre, apellido;
    private int telefono;
    private boolean experiencia;
    private Persona personaRecuperada;

    private TextView textNombre, textApellido, textTelefono;
    private CheckBox checkExperiencia;
    private Button btnContestar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        instancias();
        if (getIntent().getExtras() != null) {
            recuperarDatos();
            setearDatos();
        }
        acciones();

    }

    private void acciones() {
        btnContestar.setOnClickListener(this);
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
        btnContestar = findViewById(R.id.boton_constestar);
    }

    private void recuperarDatos() {
        /*nombre = getIntent().getExtras().getString("nombre");
        apellido = getIntent().getExtras().getString("apellido");
        telefono = getIntent().getExtras().getInt("numero");
        experiencia = getIntent().getExtras().getBoolean("experiencia");*/
        personaRecuperada = (Persona) getIntent().getExtras().getSerializable("persona");
        //Log.v("test", nombre);

    }

    @Override
    public void onClick(View v) {
        // contestar a la activity que me ha arrancado
        Intent i = new Intent();
        personaRecuperada.setApellido("Apellido Modificado");
        i.putExtra("dato_contestar",personaRecuperada);
        if (checkExperiencia.isChecked()){
            setResult(1,i);
        } else {
            setResult(0,i);
        }

        finish();
    }
}