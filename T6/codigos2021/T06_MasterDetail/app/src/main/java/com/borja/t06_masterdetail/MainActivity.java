package com.borja.t06_masterdetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.borja.t06_masterdetail.fragments.FragmentDetail;
import com.borja.t06_masterdetail.fragments.FragmentDetailDos;
import com.borja.t06_masterdetail.fragments.FragmentMaster;

public class MainActivity extends AppCompatActivity implements FragmentMaster.OnFragmentMasterListener {

    private FrameLayout sitioMaster, sitioDetail;
    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        iniciarFragments();
    }

    private void iniciarFragments() {

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        ft.replace(R.id.sitio_master,new FragmentMaster(),"master");
        ft.addToBackStack("master");
        ft.commit();

        if (sitioDetail!= null){
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.replace(R.id.sitio_detail,new FragmentDetail(),"detail");
            ft.addToBackStack("detail");
            ft.commit();
        }




    }

    private void instancias() {
        sitioMaster = findViewById(R.id.sitio_master);
        sitioDetail = findViewById(R.id.sitio_detail);

    }

    @Override
    public void onFragmentMasterSelected() {
       fm = getSupportFragmentManager();
       ft = fm.beginTransaction();

       if ( sitioDetail!= null ){
           ft.replace(R.id.sitio_detail, new FragmentDetailDos(),"detalle_dos");
           ft.addToBackStack("detalle_dos");
           ft.commit();
       } else {
           ft.replace(R.id.sitio_master, new FragmentDetail(),"detalle_uno");
           ft.addToBackStack("detalle_uno");
           ft.commit();
       }


    }
}