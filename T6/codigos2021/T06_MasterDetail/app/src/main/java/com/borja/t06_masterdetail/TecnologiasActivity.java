package com.borja.t06_masterdetail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.borja.t06_masterdetail.adaptadores.AdaptadorRecyclerTec;
import com.borja.t06_masterdetail.fragments.FragmentDetail;
import com.borja.t06_masterdetail.fragments.FragmentListaTec;
import com.borja.t06_masterdetail.utils.Tecnologia;

public class TecnologiasActivity extends AppCompatActivity implements AdaptadorRecyclerTec.OnFragmentTecnologiaListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private FrameLayout sitioMaster, sitioDetail;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tecnologias);
        instancias();
        personalizarToolBar();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.sitio_master, new FragmentListaTec(), "lista");
        //fragmentTransaction.addToBackStack("lista");
        fragmentTransaction.commit();
    }

    private void personalizarToolBar() {
        this.setSupportActionBar(toolbar);
    }

    private void instancias() {
        sitioDetail = findViewById(R.id.sitio_detail);
        sitioMaster = findViewById(R.id.sitio_master);
        toolbar = findViewById(R.id.toolbar_support);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add:
                Toast.makeText(getApplicationContext(),"Pulsado add",Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
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