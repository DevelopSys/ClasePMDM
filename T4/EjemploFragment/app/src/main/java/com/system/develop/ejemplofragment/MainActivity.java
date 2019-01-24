package com.system.develop.ejemplofragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.system.develop.ejemplofragment.adaptadores.AdaptadorRecycler;
import com.system.develop.ejemplofragment.fragments.FragmentUno;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnElementoAdaptadorListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.sitioFg,new FragmentUno());
        ft.addToBackStack(null);
        ft.commit();


    }

    @Override
    public void onElementoSelected(int telefono) {
        Log.v("fg",String.valueOf(telefono));
    }
}
