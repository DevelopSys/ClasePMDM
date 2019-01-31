package com.system.develop.t4_repaso.adaptadores;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.system.develop.t4_repaso.fragments.FragmentDinamico;
import com.system.develop.t4_repaso.fragments.FragmentDinamicoDos;

import java.util.ArrayList;

public class AdaptadorView extends FragmentPagerAdapter {


    ArrayList<Fragment> listaFragments;

    public AdaptadorView(FragmentManager fm) {
        super(fm);
        listaFragments = new ArrayList<>();
        listaFragments.add(new FragmentDinamico());
        listaFragments.add(new FragmentDinamicoDos());
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
        return listaFragments.get(position).getClass().getName();
    }
}
