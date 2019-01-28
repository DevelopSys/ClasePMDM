package com.system.develop.t4_masterdetail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.system.develop.t4_masterdetail.fragment.FragmentDos;
import com.system.develop.t4_masterdetail.fragment.FragmentUno;

public class MainActivity extends AppCompatActivity implements FragmentUno.OnFragmentUnoListener {

    FrameLayout sitioMaster, sitioDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sitioMaster = findViewById(R.id.sitioFMaster);
        sitioDetail = findViewById(R.id.sitioFDetail);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        ft.replace(sitioMaster.getId(),new FragmentUno(),FragmentUno.class.getName());
        ft.addToBackStack(FragmentUno.class.getName());
        ft.commit();
        if (sitioDetail == null){
            // estoy en portraint
        }else {
            // estoy en landscape
            FragmentManager fm2 = getSupportFragmentManager();
            FragmentTransaction ft2 = fm2.beginTransaction();
            ft2.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            ft2.replace(sitioDetail.getId(),new FragmentDos(),FragmentDos.class.getName());
            ft2.addToBackStack(FragmentDos.class.getName());
            ft2.commit();

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount()==0){
            finish();
        }
    }

    @Override
    public void onFragmentUnoSelected() {
        if (sitioDetail==null){
            // estoy en portrait
            FragmentManager fm2 = getSupportFragmentManager();
            FragmentTransaction ft2 = fm2.beginTransaction();
            ft2.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            ft2.replace(sitioMaster.getId(),new FragmentDos(),FragmentDos.class.getName());
            ft2.addToBackStack(FragmentDos.class.getName());
            ft2.commit();
        } else {
            // estoy en landscape
            /*FragmentManager fm2 = getSupportFragmentManager();
            FragmentTransaction ft2 = fm2.beginTransaction();
            ft2.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            ft2.replace(sitioDetail.getId(),new FragmentDos(),FragmentDos.class.getName());
            ft2.addToBackStack(FragmentDos.class.getName());
            ft2.commit();*/
            Toast.makeText(getApplicationContext(),"Ya está cargado el f2",Toast.LENGTH_SHORT).show();
        }
    }
}
