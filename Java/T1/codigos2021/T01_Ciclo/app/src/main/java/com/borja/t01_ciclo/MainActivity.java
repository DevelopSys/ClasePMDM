package com.borja.t01_ciclo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button botonPulsar1, botonPulsar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cicloVida();
        instancias();
        acciones();
        //onResume();
        //onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("ciclo_vida", "ejecutado desde onStart()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("ciclo_vida", "ejecutado desde onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("ciclo_vida", "ejecutado desde onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("ciclo_vida", "ejecutado desde onStop()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("ciclo_vida", "ejecutado desde onDestroy()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("ciclo_vida", "ejecutado desde onRestart()");

    }

    private void cicloVida() {
        Log.v("ciclo_vida", "ejecutado desde onCreate()");
    }

    private void instancias() {
        botonPulsar1 = this.findViewById(R.id.boton_pulsar1);
        botonPulsar2 = this.findViewById(R.id.boton_pulsar2);
    }

    private void acciones() {
        /*botonPulsar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("prueba","Esto es un ejemplo del boton 1");
            }
        });

        botonPulsar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("prueba","Esto es un ejemplo del boton 2");
            }
        });*/

        botonPulsar1.setOnClickListener(this);
        botonPulsar2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        // View v es el que ha producido el evento
        switch (v.getId()) {
            case R.id.boton_pulsar1:
                Log.v("prueba","Esto es un ejemplo del boton 1");
                break;
            case R.id.boton_pulsar2:
                Log.v("prueba","Esto es un ejemplo del boton 2");
                break;
        }
    }
}