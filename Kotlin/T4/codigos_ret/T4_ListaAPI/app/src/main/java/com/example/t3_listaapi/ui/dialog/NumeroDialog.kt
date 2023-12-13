package com.example.t3_listaapi.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t3_listaapi.R

class NumeroDialog : DialogFragment() {

    private lateinit var contexto: Context
    private lateinit var listener: OnNumeroDialogListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context;
        listener = context as OnNumeroDialogListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(contexto)
        val lista = resources.getStringArray(R.array.numeros)

        builder.setTitle("Filtrar")
        builder.setItems(
            lista,
        ) { _, which ->
            listener.onNumeroSelected(lista[which].toInt())
        }

        return builder.create()
    }

    interface OnNumeroDialogListener{
        fun onNumeroSelected(numero: Int)
    }


}