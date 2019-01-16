package com.system.develop.t4_fragmentsinicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bEstaticos, bDinamicos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bEstaticos = findViewById(R.id.btnEstaticos);
        bDinamicos = findViewById(R.id.btnDinámicos);
        bEstaticos.setOnClickListener(this);
        bDinamicos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = null;
        switch (v.getId()){
            case R.id.btnEstaticos:
                i = new Intent(getApplicationContext(),EstaticosActivity.class);
                break;
            case R.id.btnDinámicos:
                i = new Intent(getApplicationContext(),DinamicosActivity.class);
                break;
        }
        startActivity(i);
    }
}
