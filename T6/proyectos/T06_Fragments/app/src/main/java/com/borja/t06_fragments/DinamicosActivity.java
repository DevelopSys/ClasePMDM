package com.borja.t06_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.borja.t06_fragments.fragments.FragmentDinámicoUno;

public class DinamicosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamicos);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.frame_fragments_dinamicos,new FragmentDinámicoUno(),"TAG_FG");
        ft.addToBackStack(null);
        ft.commit();
    }
}
