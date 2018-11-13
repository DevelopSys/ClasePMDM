package com.example.develop.t1_01_activity_ciclovida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button boton;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();

    }

    private void acciones() {
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),editText.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void instancias() {
        boton = findViewById(R.id.botonEjemplo);
        editText = findViewById(R.id.editNombre);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("test","Actividad en el estado start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("test","Actividad en el estado resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("test","Actividad en el estado stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("test","Actividad en el estado restart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("test","Actividad en el estado pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("test","Actividad en el estado destroy");
    }
}
