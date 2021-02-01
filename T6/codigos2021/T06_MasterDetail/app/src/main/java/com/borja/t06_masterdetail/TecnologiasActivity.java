package com.borja.t06_masterdetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.borja.t06_masterdetail.adaptadores.AdaptadorRecyclerTec;
import com.borja.t06_masterdetail.fragments.FragmentDetail;
import com.borja.t06_masterdetail.fragments.FragmentListaTec;
import com.borja.t06_masterdetail.utils.Tecnologia;

public class TecnologiasActivity extends AppCompatActivity implements AdaptadorRecyclerTec.OnFragmentTecnologiaListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private FrameLayout sitioMaster, sitioDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tecnologias);
        instancias();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.sitio_master, new FragmentListaTec(), "lista");
        //fragmentTransaction.addToBackStack("lista");
        fragmentTransaction.commit();
    }

    private void instancias() {
        sitioDetail = findViewById(R.id.sitio_detail);
        sitioMaster = findViewById(R.id.sitio_master);
    }

    @Override
    public void onTecnologiaSelected(Tecnologia tecnologia) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        if (sitioDetail != null) {
            fragmentTransaction.replace(R.id.sitio_detail, FragmentDetail.newInstance(tecnologia), "detalle");
            //fragmentTransaction.addToBackStack("detalle");
            fragmentTransaction.commit();
        } else {
            fragmentTransaction.replace(R.id.sitio_master, FragmentDetail.newInstance(tecnologia), "detalle");
            fragmentTransaction.addToBackStack("detalle");
            fragmentTransaction.commit();
        }
    }
}