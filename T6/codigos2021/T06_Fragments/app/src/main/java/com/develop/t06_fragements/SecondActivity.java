package com.develop.t06_fragements;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;

import com.develop.t06_fragements.adapters.AdaptadorRecyclerPersonas;
import com.develop.t06_fragements.fragments.FragmentRecyclerPersonas;
import com.develop.t06_fragements.fragments.FragmentUno;

public class SecondActivity extends AppCompatActivity implements AdaptadorRecyclerPersonas.OnPersonaItemListener {

    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        ft.replace(R.id.sitios_fragments_recycler,new FragmentRecyclerPersonas(),"fRecycler");
        ft.addToBackStack("fRecycler");
        ft.commit();

    }

    @Override
    public void onPersonaSelected() {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        ft.replace(R.id.sitios_fragments_recycler,new FragmentUno(),"fUno");
        ft.addToBackStack("fUno");
        ft.commit();
    }
}