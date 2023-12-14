package com.example.t3_listajson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class GeneralDialog: DialogFragment() {

    private lateinit var contexto: Context
    private var listener: OnGenarlDialogListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context
        this.listener = context as OnGenarlDialogListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(contexto)

        builder.setTitle("Filtrar")
        builder.setMessage("Indica porque quieres")
        builder.setPositiveButton("Numero"){_,_-> listener?.onGeneralSelected("numero")}
        builder.setNegativeButton("Genero"){_,_-> listener?.onGeneralSelected("genero")}
        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
        this.listener = null
    }

    interface OnGenarlDialogListener{
        fun onGeneralSelected(filtro: String): Unit
    }
}