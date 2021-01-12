package com.develop.t06_fragements;

import androidx.appcompat.app.AppCompatActivity;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button boton, bF1, bF2, bF3;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

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


        switch (v.getId()) {
            // en cada case se realiza la acción
            case R.id.button_ir_f1:
                fragmentTransaction.replace(R.id.sitio_fragments, new FragmentUno());
                fragmentTransaction.addToBackStack("f1");

                break;
            case R.id.button_ir_f2:
                fragmentTransaction.replace(R.id.sitio_fragments, new FragmentDos());
                fragmentTransaction.addToBackStack("f2");
                break;
            case R.id.button_ir_f3:
                int cuentaPila = fragmentManager.getBackStackEntryCount();
                FragmentManager.BackStackEntry backStackEntry =
                        fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount()-1);

                Log.v("prueba_fg",String.valueOf(backStackEntry.getName()));
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