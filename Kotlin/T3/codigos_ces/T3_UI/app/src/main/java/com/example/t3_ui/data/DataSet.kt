package com.example.t3_ui.data

import com.example.t3_ui.R
import com.example.t3_ui.model.Modelo

class DataSet {

    // static
    companion object {


        fun getListaModelos(): ArrayList<Modelo> {
            val lista: ArrayList<Modelo> = ArrayList();
            lista.add(Modelo("GT40","Ford",300,100000,"Clasico", R.drawable.fordgt))
            lista.add(Modelo("Mustang","Ford",400,50000,"Deportivo", R.drawable.fordmustang))
            lista.add(Modelo("ETron","Audi",400,60000,"Electrico", R.drawable.audietron))
            lista.add(Modelo("RS6","Audi",400,70000,"Deportivo", R.drawable.audirs6))
            lista.add(Modelo("C220","Mercedes",400,40000,"Familiar", R.drawable.mercedes220))
            lista.add(Modelo("C Coupe","Mercedes",400,90000,"Clasico", R.drawable.mercedesc))
            return lista;
        }

    }

}