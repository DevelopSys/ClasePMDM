package com.example.t3_ui.data

import com.example.t3_ui.R
import com.example.t3_ui.model.Marca
import com.example.t3_ui.model.Modelo

class DataSet {

    // static
    companion object {


        fun getListaModelos(): ArrayList<Modelo> {
            val lista: ArrayList<Modelo> = ArrayList();
            lista.add(Modelo("GT40", Marca("Ford",4.0, R.drawable.ford),
                300,100000,"Clasico", R.drawable.fordgt,"https://cdn.motor1.com/images/mgl/BzERe/s3/ford-gt40-p-1075-toolroom-copy.jpg"))
            lista.add(Modelo("Mustang",Marca("Ford",4.0, R.drawable.ford),
                400,50000,"Deportivo", R.drawable.fordmustang,"https://s03.s3c.es/imag/_v0/770x420/1/d/8/MUSTANG-GRANDE.jpg"))
            lista.add(Modelo("ETron",Marca("Audi",4.0, R.drawable.audi),
                400,60000,"Electrico", R.drawable.audietron,""))
            lista.add(Modelo("RS6",Marca("Audi",4.0, R.drawable.audi),
                400,70000,"Deportivo", R.drawable.audirs6,""))
            lista.add(Modelo("C220",Marca("Mercedes",4.0, R.drawable.mercedes),
                400,40000,"Familiar", R.drawable.mercedes220,""))
            lista.add(Modelo("C Coupe",Marca("Mercedes",4.0, R.drawable.mercedes),
                400,90000,"Clasico", R.drawable.mercedesc,""))
            return lista;
        }

    }

}