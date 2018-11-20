package com.system.develop.exameniniciopmdm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    RadioGroup grupoOperaciones;
    ImageButton botonImagen;
    EditText editOp1, editOp2;
    int operacion, resultado;
    Button b;
    final static String TAG_RESULTADO = "resultado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operacion = -1;

    }

    private void instancias() {
        grupoOperaciones = findViewById(R.id.grupoOperaciones);
        botonImagen = findViewById(R.id.imagenOperación);
        editOp1 = findViewById(R.id.editOp1);
        editOp2 = findViewById(R.id.editOp2);
        b = findViewById(R.id.btnCalcular);
    }

    @Override
    protected void onStart() {
        super.onStart();
        instancias();
    }


    @Override
    protected void onResume() {
        super.onResume();
        acciones();
    }

    private void acciones() {

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(editOp1.getText().toString().isEmpty() || editOp2.getText().toString().isEmpty()) && operacion != -1) {
                    switch (operacion) {
                        case 1:
                            resultado = Integer.valueOf(editOp1.getText().toString()) + Integer.valueOf(editOp2.getText().toString());
                            break;
                        case 2:
                            resultado = Integer.valueOf(editOp1.getText().toString()) - Integer.valueOf(editOp2.getText().toString());
                            break;
                        case 3:
                            resultado = Integer.valueOf(editOp1.getText().toString()) * Integer.valueOf(editOp2.getText().toString());
                            break;
                        case 4:
                            resultado = Integer.valueOf(editOp1.getText().toString()) / Integer.valueOf(editOp2.getText().toString());
                            break;
                    }

                    Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                    Log.v("test", String.valueOf(resultado));
                    i.putExtra(TAG_RESULTADO, resultado);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.texto_toast), Toast.LENGTH_SHORT).show();
                }
            }
        });

        grupoOperaciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int imagen = 0;
                Log.v("test", "producido");
                switch (checkedId) {
                    case R.id.opcionSuma:
                        imagen = R.drawable.suma;
                        operacion = 1;
                        break;
                    case R.id.opcionResta:
                        imagen = R.drawable.resta;
                        operacion = 2;
                        break;
                    case R.id.opcionMult:
                        imagen = R.drawable.multiplicacion;
                        operacion = 3;
                        break;
                    case R.id.opcionDiv:
                        imagen = R.drawable.division;
                        operacion = 4;
                        break;
                }

                botonImagen.setImageResource(imagen);
            }
        });
    }
}
