package com.example.t03_repaso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonUno, botonDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();

        Log.v("ciclo_vida","Pasado por onCreate");
    }

    private void instancias(){
        botonUno = this.findViewById(R.id.boton_uno);
        botonDos = this.findViewById(R.id.boton_dos);
    }

    private void acciones(){
        botonUno.setOnClickListener(this);
        botonDos.setOnClickListener(this);
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
        switch (v.getId()){
            case R.id.boton_uno:
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_toast)+" b1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.boton_dos:
                Toast.makeText(getApplicationContext(), R.string.mensaje_toast+" b2",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}