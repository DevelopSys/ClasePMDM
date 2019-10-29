package com.borja.examencorregido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText tOperando1, tOperando2;
    Button bSuma, bResta, bPasar;
    CheckBox cPermitir;
    int tipoOperacion;
    static String TAG1 = "resultado";
    static String TAG2 = "operacion";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        bResta.setOnClickListener(this);
        bSuma.setOnClickListener(this);
        bPasar.setOnClickListener(this);
    }

    private void instancias() {
        tOperando1 = findViewById(R.id.texto_op1);
        tOperando2 = findViewById(R.id.texto_op2);
        bSuma = findViewById(R.id.boton_suma);
        bResta = findViewById(R.id.boton_resta);
        bPasar = findViewById(R.id.boton_pasar);
        cPermitir = findViewById(R.id.check_permitir);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.boton_pasar:
                Intent pasarActivity = new Intent(getApplicationContext(), SecondActivity.class);
                if (tOperando1.getText().toString().length() > 0 && tOperando2.getText().toString().length() > 0
                        && tipoOperacion != 0 && cPermitir.isChecked()) {

                    int resultado = 0;
                    String tipo="";
                    switch (tipoOperacion) {
                        case 1:
                            tipo ="suma";
                            resultado = Integer.valueOf(tOperando1.getText().toString()) + Integer.valueOf(tOperando2.getText().toString());
                            break;
                        case 2:
                            tipo = "resta";
                            resultado = Integer.valueOf(tOperando1.getText().toString()) - Integer.valueOf(tOperando2.getText().toString());
                            break;
                    }

                    pasarActivity.putExtra(TAG1,resultado );
                    pasarActivity.putExtra(TAG2,tipo);
                    startActivity(pasarActivity);


                } else {
                    Toast.makeText(getApplicationContext(), "Faltan datos", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.boton_suma:
                tipoOperacion = 1;
                break;
            case R.id.boton_resta:
                tipoOperacion = 2;
                break;
        }
    }
}
