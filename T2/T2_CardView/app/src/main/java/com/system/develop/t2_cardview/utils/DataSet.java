package com.system.develop.t2_cardview.utils;

import com.system.develop.t2_cardview.R;

import java.util.ArrayList;

public class DataSet {

    public static DataSet newInstance() {
        DataSet dataSet = new DataSet();
        return dataSet;
    }

    public ArrayList darJuegos() {
        ArrayList lista = new ArrayList();

        lista.add(new Juego("Donk", "mono", R.drawable.donk));
        lista.add(new Juego("Sonic", "mono", R.drawable.sonic));
        lista.add(new Juego("Fox", "mono", R.drawable.startfox));
        lista.add(new Juego("Zelda", "mono", R.drawable.zelda));
        lista.add(new Juego("Street", "mono", R.drawable.street));

        return lista;
    }
}
