package com.example.t03_repaso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonUno, botonDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonUno = this.findViewById(R.id.boton_uno);
        botonDos = this.findViewById(R.id.boton_dos);
        botonDos.setOnClickListener(this);
        botonUno.setOnClickListener(this);
        Log.v("ciclo_vida","Pasado por onCreate");
    }
    


    @Override
    protected void onStart() {
        super.onStart();
        Log.v("ciclo_vida","Pasado por onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("ciclo_vida","Pasado por onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("ciclo_vida","Pasado por onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("ciclo_vida","Pasado por onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("ciclo_vida","Pasado por onDestroy");
    }


    @Override
    public void onClick(View v) {

    }
}