package com.borja.t3_pasodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText textoCaptura;
    private Button btnPaso, btnPasoParam;
    static final String TAG_1 = "texto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        btnPaso.setOnClickListener(this);
        btnPasoParam.setOnClickListener(this);
    }

    private void instancias() {
        textoCaptura = findViewById(R.id.textoCapturar);
        btnPaso = findViewById(R.id.botonPaso);
        btnPasoParam = findViewById(R.id.botonPasoParametros);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.botonPaso:

                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(i);

                /*if(!textoCaptura.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), textoCaptura.getText().toString(), Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getApplicationContext(), "Vacio", Toast.LENGTH_SHORT).show();*/

                break;
            case R.id.botonPasoParametros:

                if (!textoCaptura.getText().toString().isEmpty()) {
                    Intent iPasar = new Intent(getApplicationContext(), SecondActivity.class);
                    iPasar.putExtra(TAG_1,textoCaptura.getText().toString());
                    startActivity(iPasar);
                } else
                    Toast.makeText(getApplicationContext(), "Por favor introduce datos", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
