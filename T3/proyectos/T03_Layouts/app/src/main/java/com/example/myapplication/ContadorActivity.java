package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ContadorActivity extends AppCompatActivity implements View.OnClickListener {

    Button botonSumar;
    TextView textoContador ,textoContadorDos;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);
        instancias();
        acciones();

    }


    private void acciones() {
        botonSumar.setOnClickListener(this);
    }

    private void instancias() {
        botonSumar = this.findViewById(R.id.btnSumatorio);
        textoContador = this.findViewById(R.id.textoContador);
        textoContadorDos = this.findViewById(R.id.textoContadorDos);
    }

    @Override
    public void onClick(View view) {
        contador++;
        textoContador.setText(String.valueOf(contador));
        if (contador==4){
            Toast.makeText(getApplicationContext(),
                    getResources().getString(R.string.app_aviso)
                    , Toast.LENGTH_SHORT).show();
        } else if (contador==5){
            finish();
        }

    }
}
