package com.example.develop.t1_02_arrancaractividaddatos;

import android.app.Person;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.develop.t1_02_arrancaractividaddatos.utils.Persona;


public class MainActivity extends AppCompatActivity {

    Button boton;
    EditText editNombre, editApellido, editTelefono;
    TextView textNota;
    final static String TAG_KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = findViewById(R.id.botonArrancar);
        editNombre = findViewById(R.id.editNombre);
        editApellido = findViewById(R.id.editApellido);
        editTelefono = findViewById(R.id.editTelefono);

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
                    startActivity(intent);

                } else
                    Toast.makeText(getApplicationContext(),
                            "No hay nada metido", Toast.LENGTH_SHORT).show();
            }
        });
    }
}





