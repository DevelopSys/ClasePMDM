package com.develop.t06_fragements;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.FragmentBreadCrumbs;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.develop.t06_fragements.fragments.FragmentDos;
import com.develop.t06_fragements.fragments.FragmentUno;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button boton, bF1, bF2, bF3;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    int cuentaFg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
        // elemento que permite gestionar todos los fragments: más o menos el una pila
        //FragmentManager fm = getSupportFragmentManager();
        // elemento que pemite manejar los fragments. Entrando saliendo quitando
        //FragmentTransaction ft = fm.beginTransaction();
        //ft.replace(R.id.sitio_fragments, new FragmentUno(), "f1");
        //ft.commit();

        //FragmentManager fm2 = getSupportFragmentManager();
        //FragmentTransaction ft2 = fm2.beginTransaction();
        //ft2.replace(R.id.sitio_fragments, new FragmentDos(), "f2");
        //ft2.commit();

    }

    private void acciones() {
        bF1.setOnClickListener(this);
        bF2.setOnClickListener(this);
        bF3.setOnClickListener(this);
    }

    private void instancias() {
        bF1 = findViewById(R.id.button_ir_f1);
        bF2 = findViewById(R.id.button_ir_f2);
        bF3 = findViewById(R.id.button_ir_f3);
    }

    @Override
    public void onClick(View v) {
        // reinstanciar el fm y ft
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        FragmentManager.BackStackEntry backStackEntry = null;
        if (cuentaFg != 0) {
            backStackEntry =
                    fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1);
        }


        switch (v.getId()) {
            // en cada case se realiza la acción
            case R.id.button_ir_f1:
                fragmentTransaction.add(R.id.sitio_fragments, new FragmentUno(), "f1");
                if (cuentaFg > 0) {
                    Log.v("prueba_fg", String.valueOf(backStackEntry.getName()));
                    if (!backStackEntry.getName().equals("f1")) {
                        fragmentTransaction.addToBackStack("f1");
                    }
                } else {
                    fragmentTransaction.addToBackStack("f1");
                }
                cuentaFg++;

                break;
            case R.id.button_ir_f2:
                fragmentTransaction.add(R.id.sitio_fragments, new FragmentDos(), "f2");
                if (cuentaFg > 0) {
                    Log.v("prueba_fg", String.valueOf(backStackEntry.getName()));
                    if (!backStackEntry.getName().equals("f2")) {
                        fragmentTransaction.addToBackStack("f2");
                    }
                } else {
                    fragmentTransaction.addToBackStack("f2");
                }
                cuentaFg++;
                break;
            case R.id.button_ir_f3:
                int cuentaPila = fragmentManager.getBackStackEntryCount();

                FragmentManager.BackStackEntry backStackEntry2 =
                        fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1);

                Log.v("prueba_fg", "Etiqueta estado " + String.valueOf(backStackEntry2.getName()));
                Log.v("prueba_fg", "Numero estados " + String.valueOf(cuentaPila));
                Log.v("prueba_fg", "Numero fragments " + String.valueOf(fragmentManager.getFragments().size()));
                ArrayList<Fragment> listaFragments = (ArrayList<Fragment>) fragmentManager.getFragments();
                for (Fragment fragment:listaFragments) {
                    Log.v("prueba_fg", "Fragment Apilado " + String.valueOf(fragment));
                }
                Fragment fragmentEncontrado = getSupportFragmentManager().findFragmentByTag("f2");
                Log.v("prueba_fg", "FragmentEncontrado " + String.valueOf(fragmentEncontrado));


                break;
        }

        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Log.v("prueba_fg","pulsado onBack");

        /*if (getSupportFragmentManager().getBackStackEntryCount()==0){
            finish();
        } else {
            Toast.makeText(getApplicationContext(),
                    "Te quedan "+getSupportFragmentManager().getBackStackEntryCount(),Toast.LENGTH_SHORT).show();
        }*/
    }
}

/*
* PILA --> BackStack --> Estados {Como está la pila_: qu eelementos hay en la pila}
* inicio pila: nada 0 estados
* replace bf1: (solo con el replace, el addToBackStack "f1" {f1} y el commit) 1 estados --> fragment que se ve: f1
* replace bf2: (solo con el replace, el addToBackStack "f2" {f2} y el commit) 2 estados --> fragment que se ve: f2
* si el estado anterior es f2, no quiero hacer el addToBackStack
* replace bf2: (solo con el replace, y el commit) 2 estados --> fragment que se ve: f2
* si el estado anterior es f1, no quiero hacer el addToBackStack
* * replace bf1: (solo con el replace, el addToBackStack "f1" {f1} y el commit) 3 estados --> fragment que se ve: f1
* * * replace bf1: (solo con el replace, y el commit) 3 estados --> fragment que se ve: f1
 * */