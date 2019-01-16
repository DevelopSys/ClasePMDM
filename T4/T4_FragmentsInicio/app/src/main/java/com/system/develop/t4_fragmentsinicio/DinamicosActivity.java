package com.system.develop.t4_fragmentsinicio;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.system.develop.t4_fragmentsinicio.fragments.FragmentDinamicoUno;

public class DinamicosActivity extends AppCompatActivity {

    FrameLayout sitioFragments;
    Button btnDinUno,btnDinDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamicos);
        sitioFragments = findViewById(R.id.sitioFragments);
        btnDinUno = findViewById(R.id.botonIrFragmentUnoDinamico);
        btnDinUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm =  getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(sitioFragments.getId(),new FragmentDinamicoUno());
                ft.commit();
            }
        });
    }
}
