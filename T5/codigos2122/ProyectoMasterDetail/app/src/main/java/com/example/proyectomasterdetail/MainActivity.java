package com.example.proyectomasterdetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.proyectomasterdetail.fragments.FragmentDetalle;
import com.example.proyectomasterdetail.fragments.FragmentLista;

public class MainActivity extends AppCompatActivity implements FragmentLista.OnListaListener {

    private FragmentManager fm = null;
    private FragmentTransaction ft = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.sitio_master, new FragmentLista());
        ft.commit();
        ft.addToBackStack(null);
    }

    @Override
    public void onElementoListaSelected(String dato) {
        // en que orientation estas?????
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        if(findViewById(R.id.sitio_detail)!=null){
            ft.replace(R.id.sitio_detail, new FragmentDetalle());

        }else{
            ft.replace(R.id.sitio_master, new FragmentDetalle());
            ft.addToBackStack(null);

        }
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //ejecuto cuando doy atras
    }
}