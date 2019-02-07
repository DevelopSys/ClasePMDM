package com.system.develop.t4_correxamen;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.system.develop.t4_correxamen.adaptadores.AdaptadorPager;
import com.system.develop.t4_correxamen.adaptadores.AdaptadorRecycer;
import com.system.develop.t4_correxamen.fragments.FragmentEstatico;
import com.system.develop.t4_correxamen.utils.Asignatura;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycer.OnAsignaturaSelectedListener {


    Toolbar toolbar;
    ViewPager pager;
    TabLayout tabs;
    FragmentEstatico fragmentEstatico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        pager = findViewById(R.id.pager);
        tabs = findViewById(R.id.tabs);
        setSupportActionBar(toolbar);
        tabs.setupWithViewPager(pager);
        pager.setAdapter(new AdaptadorPager(getSupportFragmentManager()));
    }

    @Override
    public void onAsignaturaSelected(Asignatura a) {
        fragmentEstatico = (FragmentEstatico) getSupportFragmentManager().findFragmentById(R.id.festatico);
        fragmentEstatico.cambiarDatos(a);
    }
}
