package com.borja.pasarresultado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InicialActivity extends AppCompatActivity {

    final int REQ_COD = 1;
    final static int RES_COD = 1;
    Button botonArrancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
        instancias();
        acciones();
    }

    private void acciones() {
        botonArrancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivityForResult(intent,REQ_COD);
            }
        });
    }

    private void instancias() {
        botonArrancar = findViewById(R.id.boton_iniciar);
    }
}
