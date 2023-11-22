package com.example.t3_ui.data

import android.graphics.ColorSpace.Model
import com.example.t3_ui.R
import com.example.t3_ui.model.Marca
import com.example.t3_ui.model.Modelo

class DataSet {
    companion object{
        val listaModelos = ArrayList<Modelo>()
        fun obtenerListaCompleta(): ArrayList<Modelo> {

            listaModelos.add(Modelo("Mustang", Marca("Ford",4.0,R.drawable.ford),4,200, R.drawable.fordmustang))
            listaModelos.add(Modelo("GT40",Marca("Ford",4.0,R.drawable.ford),3,300, R.drawable.fordgt))
            listaModelos.add(Modelo("GT40",Marca("Ford",4.0,R.drawable.ford),3,200, R.drawable.audirs6))
            listaModelos.add(Modelo("GT40",Marca("Ford",4.0,R.drawable.ford),3,400, R.drawable.audietron))
            listaModelos.add(Modelo("GT40",Marca("Ford",4.0,R.drawable.ford),3,300, R.drawable.mercedes220))
            listaModelos.add(Modelo("GT40",Marca("Ford",4.0,R.drawable.ford),3,600, R.drawable.mercedesc))


            return listaModelos
        }
    }
}