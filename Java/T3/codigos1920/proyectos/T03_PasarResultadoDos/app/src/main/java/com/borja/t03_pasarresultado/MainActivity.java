package com.borja.t03_pasarresultado;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.borja.t03_pasarresultado.utils.Persona;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button botonArrancar;
    TextView textoRepuesta;
    final static String TAG_PERSO ="persona";
    final static int REQ_CODE = 1;
    final static int RES_CODE_OK = 1;
    final static int RES_CODE_FAIL= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        botonArrancar.setOnClickListener(this);
    }

    private void instancias() {
        botonArrancar = findViewById(R.id.boton_arrancar);
        textoRepuesta = findViewById(R.id.texto_resultado);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==REQ_CODE && resultCode ==RES_CODE_OK){
            String resultado = (String) data.getExtras().get(SecondActivity.TAG_RES);
            textoRepuesta.setText(resultado);
        } else if (requestCode == REQ_CODE && resultCode == RES_CODE_FAIL){
            textoRepuesta.setText("No se han pasado datos");

        }

    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
        //intent.putExtra(TAG_PERSO,new Persona("asd","asd",123));
        //startActivity(intent);
        startActivityForResult(intent,REQ_CODE);

    }
}
