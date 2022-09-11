package com.borja.t04_vistarrecicladas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.borja.t04_vistarrecicladas.adaptadores.AdaptadorRecycler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button botonSinCartas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        botonSinCartas.setOnClickListener(this);
    }

    private void instancias() {
        botonSinCartas = findViewById(R.id.boton_sin_cartas);
    }

    @Override
    public void onClick(View view) {
        Intent i = null;
        switch (view.getId()){
            case R.id.boton_sin_cartas:
                i = new Intent(getApplicationContext(), RecyclerNormalActivity.class);
                break;
        }

        startActivity(i);
    }
}
