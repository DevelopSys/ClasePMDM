package com.example.t3_listaapi.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class GeneralDialog: DialogFragment() {

    private lateinit var contexto: Context
    private var listener: OnGeneralDialogoListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context;
        listener = contexto as OnGeneralDialogoListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(contexto)
        builder.setTitle("Filtrar")
        builder.setMessage("Indica por que quieres filrar")
        builder.setPositiveButton("Genero"){_,_->
            listener?.onFiltroSelected("genero")

        }
        builder.setNegativeButton("Numero"){_,_->
            listener?.onFiltroSelected("numero")
        }


        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnGeneralDialogoListener{
        fun onFiltroSelected(tipo: String)
    }
}