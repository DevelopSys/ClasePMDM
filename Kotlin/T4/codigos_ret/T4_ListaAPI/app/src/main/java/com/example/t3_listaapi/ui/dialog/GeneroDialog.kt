package com.example.t3_listaapi.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t3_listaapi.R

class GeneroDialog: DialogFragment() {

    private lateinit var contexto: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context;
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(contexto)
        val lista = resources.getStringArray(R.array.generos)

        builder.setTitle("Filtrar")
        builder.setItems(lista,
            ){ dialog, which -> Toast.makeText(context,lista[which],Toast.LENGTH_SHORT).show() }
        //builder.setMessage("Por que genero quieres filtar")
        /*builder.setPositiveButton("Femenino"){_,_->{}}
        builder.setNegativeButton("Masculino"){_,_->{}}
        builder.setNeutralButton("Cancelar"){_,_->{}}*/


        return builder.create()
    }


}