package com.example.t6_iniciofg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.t6_iniciofg.fragements.FragmentDos;
import com.example.t6_iniciofg.fragements.FragmentUno;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FragmentUno.OnFragmentUnoListener {

    private Button botonF1, botonF2, botonComprobar;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        initFragments();
        acciones();
    }

    private void initFragments() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.sitio_fragments, new FragmentUno());
        fragmentTransaction.addToBackStack("f1");
        fragmentTransaction.commit();
    }

    private void acciones() {
        botonF1.setOnClickListener(this);
        botonF2.setOnClickListener(this);
        botonComprobar.setOnClickListener(this);
    }

    private void instancias() {
        botonF1 = findViewById(R.id.boton_fragment1);
        botonF2 = findViewById(R.id.boton_fragment2);
        botonComprobar = findViewById(R.id.boton_comprobar);

    }

    @Override
    public void onClick(View view) {

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();



        Log.v("fragments", String.valueOf(fragmentManager.getBackStackEntryCount()));

        switch (view.getId()){
            case R.id.boton_comprobar:
                FragmentUno fragmentUno = (FragmentUno) fragmentManager.findFragmentByTag("f1");
                if (fragmentUno!=null){
                    Log.v("fragments","Esta el f1 en la pila");
                }
                break;
            case R.id.boton_fragment1:
                FragmentUno fragmentUno1 = (FragmentUno) fragmentManager.findFragmentByTag("f1");
                fragmentTransaction.replace(R.id.sitio_fragments, new FragmentUno(),"f1");
                if (fragmentUno1==null){
                    fragmentTransaction.addToBackStack("f1");
                }


                break;
            case R.id.boton_fragment2:
                FragmentDos fragmentDos = (FragmentDos) fragmentManager.findFragmentByTag("f2");
                fragmentTransaction.replace(R.id.sitio_fragments, new FragmentDos(),"f2");
                if (fragmentDos==null){
                    fragmentTransaction.addToBackStack("f2");
                }
                break;
        }
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0){
            finish();
        }
        //Log.v("fragments", String.valueOf(getSupportFragmentManager()
        // .getBackStackEntryCount()));
    }

    @Override
    public void onDataSelected(String data) {
        //Toast.makeText(getApplicationContext(), "Dato comunicado "+data, Toast.LENGTH_SHORT).show();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.sitio_fragments, FragmentDos.newInstance(data),"f2");
        if (fragmentManager.findFragmentByTag("f2")==null){
            fragmentTransaction.addToBackStack("f2");
        }
        fragmentTransaction.commit();

        //FragmentDos.newInstance(data);
    }
}