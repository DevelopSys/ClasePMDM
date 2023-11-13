package com.example.t3_ui.data

import android.graphics.ColorSpace.Model
import com.example.t3_ui.R
import com.example.t3_ui.model.Modelo

class DataSet {

    companion object{
        val listaModelos = ArrayList<Modelo>()

        fun obtenerListaCompleta(): ArrayList<Modelo> {

            listaModelos.add(Modelo("Mustang","Ford",4,200, R.drawable.fordmustang))
            listaModelos.add(Modelo("GT40","Ford",3,300, R.drawable.fordgt))
            listaModelos.add(Modelo("Etron","Audi",5,400, R.drawable.audietron))
            listaModelos.add(Modelo("RS6","Audi",4,250, R.drawable.audirs6))
            listaModelos.add(Modelo("C220","Mercedes",4,280, R.drawable.mercedes220))
            listaModelos.add(Modelo("CCoupe","Mercedes",5,300, R.drawable.mercedesc))

            return listaModelos
        }

    }
}