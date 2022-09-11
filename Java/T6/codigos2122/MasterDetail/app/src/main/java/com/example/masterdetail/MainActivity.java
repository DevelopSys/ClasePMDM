package com.example.masterdetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.masterdetail.fragments.FragmentDetail;
import com.example.masterdetail.fragments.FragmentMaster;

public class MainActivity extends AppCompatActivity implements FragmentMaster.OnElementoListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private FrameLayout frameDetalle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameDetalle = findViewById(R.id.sitio_detail);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.sitio_master, new FragmentMaster());
        fragmentTransaction.commit();


    }

    @Override
    public void onElementoSelected(String elemento) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        if (frameDetalle!=null){


            fragmentTransaction.replace(R.id.sitio_detail, FragmentDetail.newInstance(elemento));
        } else {

            fragmentTransaction.replace(R.id.sitio_master, FragmentDetail.newInstance(elemento));
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }

    /*public void onMasterSelected(String s){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        if (frameDetalle!=null){


            fragmentTransaction.replace(R.id.sitio_detail, new FragmentDetail());
        } else {

            fragmentTransaction.replace(R.id.sitio_master, new FragmentDetail());
        }

        fragmentTransaction.commit();
    */
}