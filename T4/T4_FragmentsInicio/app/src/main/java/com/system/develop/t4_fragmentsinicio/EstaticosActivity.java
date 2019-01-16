package com.system.develop.t4_fragmentsinicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.system.develop.t4_fragmentsinicio.fragments.FragmentEstaticoDos;
import com.system.develop.t4_fragmentsinicio.fragments.FragmentEstaticoUno;

public class EstaticosActivity extends AppCompatActivity implements FragmentEstaticoUno.OnFragmentUnoListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estaticos);
        }

    @Override
    public void onFragmentUnoSelected(String s) {
        FragmentEstaticoDos f2 = (FragmentEstaticoDos) getSupportFragmentManager().findFragmentById(R.id.festaticodos);
        f2.cambiarEtiqueta(s);
    }
}
