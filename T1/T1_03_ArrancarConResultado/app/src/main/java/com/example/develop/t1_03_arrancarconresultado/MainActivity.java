package com.example.develop.t1_03_arrancarconresultado;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.develop.t1_03_arrancarconresultado.utils.Persona;

public class MainActivity extends AppCompatActivity {

    Button boton;
    EditText editNombre, editApellido, editTelefono;
    TextView textNota;
    final static String TAG_KEY = "key";
    final static String TAG_KEY_DEV = "key_dev";
    final static int COD_REQ_UNO = 1;
    final static int COD_DEV_UNO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = findViewById(R.id.botonArrancar);
        editNombre = findViewById(R.id.editNombre);
        editApellido = findViewById(R.id.editApellido);
        editTelefono = findViewById(R.id.editTelefono);
        textNota = findViewById(R.id.textoNota);

        // o hago esto o hago en el método
        if (savedInstanceState!=null){
            editNombre.setText(savedInstanceState.getString("dato1"));
            editApellido.setText(savedInstanceState.getString("dato2"));
            editTelefono.setText(savedInstanceState.getString("dato3"));
        }

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Accion de pulsar
                if (!(editNombre.getText().toString().isEmpty() ||
                        editApellido.getText().toString().isEmpty() || editTelefono.getText().toString().isEmpty())) {
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    Persona p = new Persona(editNombre.getText().toString(), editApellido.getText().toString(),
                            Integer.valueOf(editTelefono.getText().toString()));
                    intent.putExtra(TAG_KEY, p);
                    startActivityForResult(intent, COD_REQ_UNO);

                } else
                    Toast.makeText(getApplicationContext(),
                            "No hay nada metido", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == COD_REQ_UNO) {
            if (resultCode == COD_DEV_UNO) {
                if (data != null) {
                    String nota = data.getStringExtra(TAG_KEY_DEV);
                    textNota.setText(nota);
                }
            }
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // recupera los datos previamente guardados
        // es lo mismo que el bundle del onCreate()
        editNombre.setText(savedInstanceState.getString("dato1"));
        editApellido.setText(savedInstanceState.getString("dato2"));
        editTelefono.setText(savedInstanceState.getString("dato3"));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // guarda datos cuando una actividad se pausa
        outState.putString("dato1", editNombre.getText().toString());
        outState.putString("dato2", editTelefono.getText().toString());
        outState.putString("dato3", editApellido.getText().toString());
    }
}


