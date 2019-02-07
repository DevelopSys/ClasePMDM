package com.system.develop.t4_correxamen.adaptadores;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.system.develop.t4_correxamen.fragments.FragmentDinamico;

import java.util.ArrayList;

public class AdaptadorPager extends FragmentPagerAdapter {

    ArrayList<Fragment> listaFragment;
    String[] nombres = {"AF","ASIR","DAM"};

    public AdaptadorPager(FragmentManager fm) {
        super(fm);
        listaFragment = new ArrayList<>();
        listaFragment.add(FragmentDinamico.newInstance(0));
        listaFragment.add(FragmentDinamico.newInstance(1));
        listaFragment.add(FragmentDinamico.newInstance(2));
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listaFragment.get(position).getTag();
    }

    @Override
    public Fragment getItem(int i) {
        return listaFragment.get(i);
    }

    @Override
    public int getCount() {
        return listaFragment.size();
    }
}
