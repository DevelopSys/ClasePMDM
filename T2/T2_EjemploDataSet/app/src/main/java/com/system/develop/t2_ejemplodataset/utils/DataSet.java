package com.system.develop.t2_ejemplodataset.utils;

import com.system.develop.t2_ejemplodataset.MainActivity;

import java.util.ArrayList;

public class DataSet {

    ArrayList versiones;

    public static DataSet newInstance() {

        DataSet dataSet = new DataSet();
        return dataSet;

    }

    public ArrayList darVersioneS() {
        versiones = new ArrayList();
        versiones.add(new Versiones("asd", "asd", 123));
        versiones.add(new Versiones("asd", "asd", 123));
        versiones.add(new Versiones("asd", "asd", 123));
        versiones.add(new Versiones("asd", "asd", 123));
        versiones.add(new Versiones("asd", "asd", 123));
        versiones.add(new Versiones("asd", "asd", 123));
        return versiones;
    }


}
