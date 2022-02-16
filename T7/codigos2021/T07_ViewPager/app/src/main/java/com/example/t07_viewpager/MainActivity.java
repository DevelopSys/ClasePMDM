package com.example.t07_viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationView navigation;
    private DrawerLayout drawer;
    private ViewPager viewPager;
    private AdaptadorPager adaptadorPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        configurarToolbar();
        configurarPager();
        // boton pulsado
        adaptadorPager.addFragment(new FragmentUno());
        adaptadorPager.eliminarFragment(2);
    }

    private void configurarPager() {
        viewPager.setAdapter(adaptadorPager);

    }

    private void configurarToolbar() {
        setSupportActionBar(toolbar);
    }


    private void instancias() {
        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.view_pager);
        navigation = findViewById(R.id.navigation);
        drawer = findViewById(R.id.drawer);
        adaptadorPager = new AdaptadorPager(getSupportFragmentManager());
    }
}