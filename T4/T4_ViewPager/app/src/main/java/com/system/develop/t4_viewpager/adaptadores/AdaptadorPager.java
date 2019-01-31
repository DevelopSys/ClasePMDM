package com.system.develop.t4_viewpager.adaptadores;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.system.develop.t4_viewpager.fragments.FragmentDos;
import com.system.develop.t4_viewpager.fragments.FragmentUno;

import java.util.ArrayList;

public class AdaptadorPager extends FragmentPagerAdapter {

    ArrayList<Fragment> listaFragments;

    public AdaptadorPager(FragmentManager fm) {
        super(fm);
        listaFragments = new ArrayList<>();
        listaFragments.add(new FragmentUno());
        listaFragments.add(new FragmentDos());
    }

    public void cambiarFragment2(String datos){
        FragmentDos f2 = (FragmentDos) listaFragments.get(1);
        f2.cambiarDatos(datos);
    }

    public void anadirFg(Fragment fragment){
        listaFragments.add(fragment);
        this.notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int i) {
        return listaFragments.get(i);
    }

    @Override
    public int getCount() {
        return listaFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listaFragments.get(position).getTag();
    }
}
