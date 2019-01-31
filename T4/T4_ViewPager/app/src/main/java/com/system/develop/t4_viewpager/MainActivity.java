package com.system.develop.t4_viewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.system.develop.t4_viewpager.adaptadores.AdaptadorPager;
import com.system.develop.t4_viewpager.fragments.FragmentDos;
import com.system.develop.t4_viewpager.fragments.FragmentUno;

public class MainActivity extends AppCompatActivity implements FragmentUno.OnFragmentUnoListener {

    ViewPager pager;
    AdaptadorPager adaptadorPager;
    Toolbar toolbar;
    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.pager);
        toolbar = findViewById(R.id.toolbar);
        tabs = findViewById(R.id.tabs);
        adaptadorPager = new AdaptadorPager(getSupportFragmentManager());
        pager.setAdapter(adaptadorPager);
        setSupportActionBar(toolbar);
        tabs.setupWithViewPager(pager);
        

    }

    @Override
    public void onFragmentUnoSelected() {
        //Toast.makeText(getApplicationContext(),"Comunicación realizada",Toast.LENGTH_SHORT).show();
        //pager.setCurrentItem(1);
        //FragmentDos.newInstance("asd");
        //((AdaptadorPager)pager.getAdapter()).cambiarFragment2("asd");
        //adaptadorPager.cambiarFragment2("comunicación realizada");
        //pager.setCurrentItem(1);
        //adaptadorPager.anadirFg(new FragmentDos());
    }
}
