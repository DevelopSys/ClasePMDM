package com.example.t3_listajson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class FiltradoDialog: DialogFragment() {

    private lateinit var contexto: Context
    private var listener: OnFiltradoDialogListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context
        this.listener = context as OnFiltradoDialogListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(contexto)

        builder.setTitle("Filtrar")
        builder.setMessage("Indica el genero por el que quieres filtar")
        builder.setPositiveButton("Femenino"){_,_-> listener?.onGeneroSelected("female")}
        builder.setNegativeButton("Masculino"){_,_-> listener?.onGeneroSelected("male")}
        builder.setNeutralButton("Todos"){_,_-> listener?.onGeneroSelected("all")}

        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
        this.listener = null
    }

    interface OnFiltradoDialogListener{
        fun onGeneroSelected(genero: String): Unit
    }
}