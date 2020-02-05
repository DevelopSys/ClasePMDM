package com.borja.t06masterdetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.borja.t06masterdetail.fragments.FragmentDetalle;
import com.borja.t06masterdetail.fragments.FragmentMaster;

public class MainActivity extends AppCompatActivity implements FragmentMaster.OnFragmentMasterListener {

    FrameLayout frameMaster, frameDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        cargaInicial();

    }

    private void cargaInicial() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.sitio_master, new FragmentMaster());
        ft.commit();

        if (frameDetail!=null) {
            FragmentManager fm2 = getSupportFragmentManager();
            FragmentTransaction ft2 = fm2.beginTransaction();
            ft2.replace(R.id.sitio_detail, FragmentDetalle.newInstance("carga inicial"));
            ft2.commit();
        }
    }

    private void instancias() {
        frameMaster = findViewById(R.id.sitio_master);
        frameDetail = findViewById(R.id.sitio_detail);
    }

    @Override
    public void onFragmentMasterSelected(String opcion) {
        if (frameDetail==null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.sitio_master, FragmentDetalle.newInstance(opcion));
            ft.addToBackStack(null);
            ft.commit();
        }else{
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.sitio_detail,FragmentDetalle.newInstance(opcion));
            ft.commit();
        }

    }
}
