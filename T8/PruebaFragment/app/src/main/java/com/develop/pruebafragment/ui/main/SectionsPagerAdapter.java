package com.develop.pruebafragment.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.develop.pruebafragment.R;

import java.util.ArrayList;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final String[] TAB_TITLES = new String[]{"Agregar","Borrar","Actualizar"};
    private final Context mContext;
    private final ArrayList<Fragment> lista = new ArrayList();

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        lista.add(new AgregarFragment());
        lista.add(new BorrarFragment());
        lista.add(new ActualizarFragment());
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
        // Show 2 total pages.
        return lista.size();
    }
}