package com.system.develop.t4_correxamen.utils;

import android.os.Bundle;

import com.system.develop.t4_correxamen.R;

import java.util.ArrayList;

public class DataSet {

    public static DataSet newInstance() {

        DataSet dataSet = new DataSet();
        return dataSet;

    }

    public ArrayList<Asignatura> darAf() {

        ArrayList<Asignatura> listaAF = new ArrayList<>();

        Object[] objeto = {R.drawable.af,"asdasd"};
        listaAF.add(new Asignatura("af", R.drawable.af));
        listaAF.add(new Asignatura("", R.drawable.af));
        listaAF.add(new Asignatura("", R.drawable.af));
        listaAF.add(new Asignatura("", R.drawable.af));
        listaAF.add(new Asignatura("", R.drawable.af));
        listaAF.add(new Asignatura("", R.drawable.af));
        return listaAF;
    }

    public ArrayList<Asignatura> darAsir() {

        ArrayList<Asignatura> listaAF = new ArrayList<>();
        listaAF.add(new Asignatura("asir", R.drawable.asir));
        listaAF.add(new Asignatura("", R.drawable.asir));
        listaAF.add(new Asignatura("", R.drawable.asir));
        listaAF.add(new Asignatura("", R.drawable.asir));
        listaAF.add(new Asignatura("", R.drawable.asir));
        listaAF.add(new Asignatura("", R.drawable.asir));
        return listaAF;
    }

    public ArrayList<Asignatura> darDam() {

        ArrayList<Asignatura> listaAF = new ArrayList<>();
        listaAF.add(new Asignatura("dam", R.drawable.dam));
        listaAF.add(new Asignatura("", R.drawable.dam));
        listaAF.add(new Asignatura("", R.drawable.dam));
        listaAF.add(new Asignatura("", R.drawable.dam));
        listaAF.add(new Asignatura("", R.drawable.dam));
        listaAF.add(new Asignatura("", R.drawable.dam));
        return listaAF;
    }

}
