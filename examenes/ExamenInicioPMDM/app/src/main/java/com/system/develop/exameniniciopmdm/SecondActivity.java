package com.system.develop.exameniniciopmdm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SecondActivity extends AppCompatActivity {

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        texto = findViewById(R.id.textoResultadoOperaciones);

        if (getIntent()!=null){
            int resultado = getIntent().getIntExtra(MainActivity.TAG_RESULTADO,0);
            Log.v("test", String.valueOf(resultado));
            texto.setText(String.valueOf(resultado));
        }
    }
}
