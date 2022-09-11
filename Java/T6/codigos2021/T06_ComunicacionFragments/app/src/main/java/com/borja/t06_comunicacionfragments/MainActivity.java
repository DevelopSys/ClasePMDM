package com.borja.t06_comunicacionfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.borja.t06_comunicacionfragments.fragments.FragmentDos;
import com.borja.t06_comunicacionfragments.fragments.FragmentUno;

public class MainActivity extends AppCompatActivity implements FragmentUno.OnFragmentUnoListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.sitio_fragments,new FragmentUno(),"funo");
        fragmentTransaction.commit();

    }

    @Override
    public void onFragmentUnoSelected() {
        //Toast.makeText(getApplicationContext(),"Comunicación OK",Toast.LENGTH_SHORT).show();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.sitio_fragments,new FragmentDos(),"fdos");
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentTextSelected(String texto) {

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.sitio_fragments,FragmentDos.newInstance(texto),"fdos");
        fragmentTransaction.commit();
    }
}