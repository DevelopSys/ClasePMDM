package com.example.fragmentinicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.fragmentinicio.fragments.FragmentDinamicoDos;
import com.example.fragmentinicio.fragments.FragmentDinamicoUno;
import com.example.fragmentinicio.utils.Usuario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FragmentDinamicoUno.OnFragmentUnoListener {

    private Button bF1, bF2;
    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bF1 = findViewById(R.id.boton_f1);
        bF2 = findViewById(R.id.boton_f2);
        bF2.setOnClickListener(this);
        bF1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        switch (view.getId()){
            case R.id.boton_f1:
                ft.replace(R.id.sitio_fragments,new FragmentDinamicoUno(),"uno");
                ft.addToBackStack("uno");
                break;
            case R.id.boton_f2:
                ft.replace(R.id.sitio_fragments,new FragmentDinamicoDos(),"dos");
                ft.addToBackStack("dos");
                break;
        }

        ft.commit();
    }

    @Override
    public void onPersonaSelected(Usuario usuario) {
        //Log.v("prueba","Desde la ACT: "+usuario.getNombre());
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.sitio_fragments,
                FragmentDinamicoDos.newInstance(usuario));
        ft.commit();
    }
}