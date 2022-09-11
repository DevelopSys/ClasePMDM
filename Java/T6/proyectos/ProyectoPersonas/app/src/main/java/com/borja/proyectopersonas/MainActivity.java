package com.borja.proyectopersonas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.borja.proyectopersonas.adaptadores.AdaptadorRecycler;
import com.borja.proyectopersonas.fragments.FragmentDetalle;
import com.borja.proyectopersonas.fragments.FragmentListasPersonas;
import com.borja.proyectopersonas.utils.Persona;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnRecyclerListener {

    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        // gestiono
        FragmentManager fm = getSupportFragmentManager();
        // muevo
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.sitio_fragments,new FragmentListasPersonas());
        ft.commit();
    }


    @Override
    public void onPersonaSelected(Persona persona) {
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.sitio_fragments,FragmentDetalle.newInstace(persona));
        ft.addToBackStack(null);
        ft.commit();
    }
}
