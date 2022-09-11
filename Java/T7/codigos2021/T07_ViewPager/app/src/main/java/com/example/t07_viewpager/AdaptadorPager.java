package com.example.t07_viewpager;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class AdaptadorPager extends FragmentPagerAdapter{

    ArrayList<Fragment> listaFragments;
    ArrayList<String> listaNombres;

    public AdaptadorPager(@NonNull FragmentManager fm) {
        super(fm);

        listaFragments = new ArrayList<>();
        listaFragments.add(new FragmentUno());
        listaFragments.add(new FragmentDos());
        listaFragments.add(new FragmentTres());
        listaNombres = new ArrayList<>();
        listaNombres.add("F1");
        listaNombres.add("F2");
        listaNombres.add("F3");
    }

    public void cambiarTextoF1(){
        ((FragmentUno)listaFragments.get(0)).cambiarTexto();
    }

    public void eliminarFragment(int posicion){
        listaFragments.remove(posicion);
        notifyDataSetChanged();
    }

    public void addFragment(Fragment fragment){
        listaFragments.add(fragment);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listaFragments.get(position);
    }

    @Override
    public int getCount() {
        return listaFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listaNombres.get(position);
    }
}
