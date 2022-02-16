package com.example.t07_viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationView navigation;
    private DrawerLayout drawer;
    private ViewPager viewPager;
    private AdaptadorPager adaptadorPager;
    private TabLayout tabs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        configurarToolbar();
        configurarPager();
        acciones();
        tabs.setBackgroundColor(getResources().getColor(R.color.white));
        viewPager.setCurrentItem(0);
        // boton pulsado
        //adaptadorPager.addFragment(new FragmentUno());
        //adaptadorPager.eliminarFragment(2);
    }

    private void acciones() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.v("view_prueba",String.valueOf(position));
                Fragment fragment = adaptadorPager.getItem(position);
                View view = fragment.getView();
                Log.v("view_prueba",String.valueOf(view));
                LinearLayout linearLayout = view.findViewById(R.id.linear_fragment);
                Log.v("view_prueba",String.valueOf(linearLayout));
                int color = ((ColorDrawable)linearLayout.getBackground()).getColor();
                tabs.setBackgroundColor(color);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void configurarPager() {
        viewPager.setAdapter(adaptadorPager);
    }
    private void configurarToolbar() {
        setSupportActionBar(toolbar);
        tabs.setupWithViewPager(viewPager);
    }

    private void instancias() {
        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.view_pager);
        navigation = findViewById(R.id.navigation);
        drawer = findViewById(R.id.drawer);
        adaptadorPager = new AdaptadorPager(getSupportFragmentManager());
        tabs = findViewById(R.id.tab);
    }
}