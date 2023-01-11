package com.develop.t5_dialogos.dialogs

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoListaSimple: DialogFragment() {

    private lateinit var listener: OnListaSimpleListener;
    private  var elementoSeleccionado: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnListaSimpleListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        val elementos = arrayOf("Opcion 1", "Opcion 2", "Opcion 3")
        builder.setTitle("Titulo de lista")
        builder.setSingleChoiceItems(elementos, -1,
            DialogInterface.OnClickListener { _, i ->
                elementoSeleccionado = elementos[i]
            })
        builder.setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialogInterface, i ->
            // como comunico la seleccion a la activity
            listener.onListaSelected(elementoSeleccionado)
        })

        builder.setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialogInterface, i ->
            // como comunico la seleccion a la activity
            dismiss()
        })

        return builder.create()
    }


    interface OnListaSimpleListener{
        fun onListaSelected(elemento: String?)
    }
}