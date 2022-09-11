package com.borja.t06_viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.borja.t06_viewpager.adaptadores.AdaptadorFragments;
import com.borja.t06_viewpager.fragments.FragmentDos;
import com.borja.t06_viewpager.fragments.FragmentTres;
import com.borja.t06_viewpager.fragments.FragmentUno;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private AdaptadorFragments adaptadorFragments;
    private ArrayList<Fragment> listaFG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        iniciarPager();
        acciones();
    }

    private void personalizarPestanias() {
        for (int i=0;i<=0;i++){
            Fragment fragment = adaptadorFragments.getItem(i);
            System.out.println(fragment.getClass().getSimpleName());
            System.out.println(fragment.getView().getScrollX());

            Drawable drawable = fragment.getView().findViewById(R.id.fondo).getBackground();
            TabLayout.Tab seleccionada = tabLayout.getTabAt(i);
            seleccionada.view.setBackground(drawable);
            tabLayout.selectTab(tabLayout.getTabAt(1));

        }
    }

    private void acciones() {


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.v("scroll",String.valueOf(position));
                Fragment fragment = adaptadorFragments.getItem(position);
                Drawable drawable = fragment.getView().findViewById(R.id.fondo).getBackground();
                tabLayout.setBackground(drawable);
                //TabLayout.Tab seleccionada = tabLayout.getTabAt(position);
                //seleccionada.view.setBackground(drawable);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.getCurrentItem();
    }

    private void iniciarPager() {
        listaFG = new ArrayList();
        listaFG.add(new FragmentUno());
        listaFG.add(new FragmentDos());
        listaFG.add(new FragmentTres());
        adaptadorFragments = new AdaptadorFragments(getSupportFragmentManager(),0,listaFG);
        FragmentUno fragmentUno = new FragmentUno();
        adaptadorFragments.agregarFragment(fragmentUno);
        viewPager.setAdapter(adaptadorFragments);

    }

    private void instancias() {
        viewPager = findViewById(R.id.view_pager);
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tablayout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Aplicación View Pager");
        tabLayout.setupWithViewPager(viewPager);
    }
}
