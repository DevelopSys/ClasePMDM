package com.example.t03_inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.t03_inicio.utils.Persona;

public class FourActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textNombre, textApellido, textTelefono;
    private CheckBox checkExperiencia;
    private Button botonContestar;
    private String nombre, apellido;
    private int telefono;
    private boolean experiencia;
    private Persona personaRecuperada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        instancias();
        if (getIntent().getExtras() != null ){
            recuperarDatos();
            setearDatos();
        }
        acciones();
    }

    private void acciones() {
       botonContestar.setOnClickListener(this);
    }

    private void setearDatos() {
        textNombre.setText(personaRecuperada.getNombre());
        textApellido.setText(personaRecuperada.getApellido());
        textTelefono.setText(String.valueOf(personaRecuperada.getTelefono()));
        checkExperiencia.setChecked(personaRecuperada.isExperiencia());
    }

    private void instancias() {
        textNombre = findViewById(R.id.nombre_recuperado);
        textApellido = findViewById(R.id.apellido_recuperado);
        textTelefono = findViewById(R.id.telefono_recuperado);
        checkExperiencia = findViewById(R.id.experiencia_recuperado);
        botonContestar = findViewById(R.id.boton_contestar);
    }

    private void recuperarDatos() {
         /*nombre = getIntent().getExtras().getString("nombre");
         apellido = getIntent().getExtras().getString("apellido");
         telefono = getIntent().getExtras().getInt("telefono");
         experiencia = getIntent().getExtras().getBoolean("experiencia");*/

        personaRecuperada = (Persona)getIntent().getExtras().getSerializable("persona");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        personaRecuperada.setApellido("ApellidoModificado");
        personaRecuperada.setExperiencia(checkExperiencia.isChecked());
        intent.putExtra("persona",personaRecuperada);

        if (!checkExperiencia.isChecked()){
            setResult(0,intent);
        } else {
            setResult(1,intent);
        }


        finish();
    }
}