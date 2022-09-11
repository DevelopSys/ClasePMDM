package com.borja.t07_sqlite.fragments;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private static final String[] TAB_TITLES = new String[]{"Agregar","Borrar","Actualizar", "Consultar"};
    private final Context mContext;
    private final ArrayList<Fragment> lista = new ArrayList();

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        lista.add(new AgregarFragment());
        lista.add(new BorrarFragment());
        lista.add(new ActualizarFragment());
        lista.add(new ConsultarFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return lista.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return TAB_TITLES[position];
    }

    @Override
    public int getCount() {
        return lista.size();
    }
}