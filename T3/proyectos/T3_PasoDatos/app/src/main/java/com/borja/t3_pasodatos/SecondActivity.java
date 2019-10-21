package com.borja.t3_pasodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.borja.t3_pasodatos.utils.Persona;

public class SecondActivity extends AppCompatActivity {

    TextView textoRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        instancias();
        recuperarDatos();
    }

    private void recuperarDatos() {
        if (getIntent().getExtras() != null) {
            //String palabraRecuperada = (String) getIntent().getExtras().get(MainActivity.TAG_1);
            Persona pRecuperada = null;
            try{
                pRecuperada = (Persona) getIntent().getExtras().get(MainActivity.TAG_1);
            } catch (ClassCastException e){
                // FALLO
            }

            String saludo = String.format("Perfecto %s %s, tu teléfono es %d",
                    pRecuperada.getNombre(), pRecuperada.getApellido(), pRecuperada.getTelefono());
            textoRecuperar.setText(saludo);
        }
    }

    private void instancias() {
        textoRecuperar = findViewById(R.id.textoRecuperado);
    }
}
