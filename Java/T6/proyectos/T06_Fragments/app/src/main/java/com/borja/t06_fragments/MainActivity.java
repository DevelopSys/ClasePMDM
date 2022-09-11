package com.borja.t06_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Fragment fEstaticoUno, fEstaticoDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
    }

    private void instancias() {
        //fEstaticoUno = findViewById(R.id.fragment_estatico_uno);
        FragmentManager fm = getSupportFragmentManager();

        fEstaticoUno = fm.findFragmentById(R.id.fragment_estatico_uno);
        fEstaticoDos = fm.findFragmentById(R.id.fragment_estatico_dos);
    }
}
