package com.borja.t06_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.borja.t06_fragments.fragments.FragmentDinamicoDos;
import com.borja.t06_fragments.fragments.FragmentDinamicoUno;

public class DinamicosActivity extends AppCompatActivity implements View.OnClickListener {

    Button bF1, bF2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamicos);
        instancias();
        acciones();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.frame_sitio_fragments, new FragmentDinamicoDos());
        ft.commit();
    }

    private void acciones() {

        bF1.setOnClickListener(this);
        bF2.setOnClickListener(this);
    }

    private void instancias() {
        bF1 = findViewById(R.id.button_ir_f1);
        bF2 = findViewById(R.id.button_ir_f2);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_ir_f1:
                break;
            case R.id.button_ir_f2:
                break;
        }
    }
}
