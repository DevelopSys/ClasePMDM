package com.borja.t3_spinnerr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.borja.t3_spinnerr.utils.Persona;

public class SecondActivity extends AppCompatActivity {

    TextView txTexto;
    Persona persona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        instancias();
        recuperarPersona();
        anadirTexto();
    }

    private void anadirTexto() {
        txTexto.setText(String.format("La persona pasada es: %s %s %d %b",
                persona.getNombre(), persona.getApellido(), persona.getEdad(),
                persona.isDisponibilidad()
        ));
    }

    private void instancias() {
        txTexto = findViewById(R.id.txTexto);
    }

    private void recuperarPersona() {
        if(!getIntent().getExtras().isEmpty()){
            persona=(Persona) getIntent().getExtras().get(MainActivity.TAG_1);
        }
    }
}
