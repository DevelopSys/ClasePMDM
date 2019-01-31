package com.system.develop.t4_repaso;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.system.develop.t4_repaso.adaptadores.AdaptadorView;

public class Main2Activity extends AppCompatActivity {

    ViewPager pager;
    TabLayout tabs;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pager = findViewById(R.id.view);
        tabs = findViewById(R.id.pestanias);
        toolbar = findViewById(R.id.toolbar);
        pager.setAdapter(new AdaptadorView(getSupportFragmentManager()));
        setSupportActionBar(toolbar);
        tabs.setupWithViewPager(pager);
    }
}
