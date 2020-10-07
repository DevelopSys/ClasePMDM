package com.borja.t02_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.borja.t02_intents.utils.Persona;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonArranque, botonDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();

    }

    private void acciones() {
        botonDatos.setOnClickListener(this);
        botonArranque.setOnClickListener(this);
    }

    private void instancias() {

        botonArranque = findViewById(R.id.boton_arrancar_pantalla);
        botonDatos = findViewById(R.id.boton_arrancar_pantalla_dato);

    }

    @Override
    public void onClick(View v) {

        Intent intent = null;

        switch (v.getId()) {
            case R.id.boton_arrancar_pantalla:
                intent = new Intent(getApplicationContext(), SegundaActivity.class);

                break;
            case R.id.boton_arrancar_pantalla_dato:
                intent = new Intent(getApplicationContext(), SegundaActivity.class);
                /*intent.putExtra("nombre","Borja");
                intent.putExtra("apellido","Martin");
                intent.putExtra("edad",18);
                intent.putExtra("experiencia",true);*/
                intent.putExtra("persona", new Persona("Borja","Martin",18,true));

                break;

        }

            startActivity(intent);


    }
}