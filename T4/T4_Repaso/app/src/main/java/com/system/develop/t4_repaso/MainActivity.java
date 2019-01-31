package com.system.develop.t4_repaso;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.system.develop.t4_repaso.fragments.FragmentDinamico;
import com.system.develop.t4_repaso.fragments.FragmentDinamicoDos;
import com.system.develop.t4_repaso.fragments.FragmentEstatico;

public class MainActivity extends AppCompatActivity implements FragmentEstatico.OnFragmentEstaticoListener {


    FrameLayout sitioMaster, sitioDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sitioMaster = findViewById(R.id.sitiofg);
        sitioDetail = findViewById(R.id.sitiofgdet);
    }

    @Override
    public void onFragmentEstaticoSelected() {
        //Toast.makeText(getApplicationContext(),"Comuniación",Toast.LENGTH_SHORT).show();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        FragmentDinamico fd = new FragmentDinamico();
        ft.replace(R.id.sitiofg, fd);
        //ft.replace(R.id.sitiofg,new FragmentDinamico(),"F1");
        ft.addToBackStack(fd.getClass().getName());
        ft.addToBackStack("F1");
        ft.commit();
    }

    @Override
    public void onFragmentEstaticoSelectedDos() {
        //Toast.makeText(getApplicationContext(),"Comuniación",Toast.LENGTH_SHORT).show();
        if (sitioDetail==null){
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            FragmentDinamicoDos fd = new FragmentDinamicoDos();
            ft.replace(R.id.sitiofg, fd);
            //ft.replace(R.id.sitiofg,new FragmentDinamico(),"F1");
            ft.addToBackStack(fd.getClass().getName());
            ft.addToBackStack("F1");
            ft.commit();
        }
        else {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            FragmentDinamicoDos fd = new FragmentDinamicoDos();
            FragmentManager.BackStackEntry entry = getSupportFragmentManager().
                    getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount()-1);
            if(entry.getName()=="F2"){
                ft.add(R.id.sitiofgdet, fd);
            }
            else {
                ft.add(R.id.sitiofgdet, fd);
                ft.addToBackStack("F2");
            }
            //ft.replace(R.id.sitiofg,new FragmentDinamico(),"F1");
            ft.commit();

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
