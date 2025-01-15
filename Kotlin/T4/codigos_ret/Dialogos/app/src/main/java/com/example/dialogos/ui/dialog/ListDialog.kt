package com.example.dialogos.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ListDialog : DialogFragment() {
    private var indexSelected: Int = -1;
    private lateinit var listener: OnDialogoListListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogoListListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val opciones: Array<CharSequence> = arrayOf("Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4")
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Selecciona una opcion correcta")
        // items
        /*builder.setItems(opciones) { _, i ->
            // ejecutado tras la pulsacion de la opcion
            listener.onOptionSelected(opciones[i].toString())
        }*/

        // single
        /*builder.setSingleChoiceItems(opciones, 2) { _, i ->
            indexSelected = i;
        }*/
        // multiple
        builder.setMultiChoiceItems(opciones, null)
        { _, i, b ->
            Log.v("posicion","posicion ${i} ${b}")
        }


        builder.setNeutralButton("Cancelar") { _, _ ->
            // listener.onCancelSelected()
        }

        builder.setPositiveButton("OK") { _, _ ->
            // listener.onOptionSelected(opciones[indexSelected].toString())
        }

        return builder.create()
    }

    interface OnDialogoListListener {
        fun onCancelSelected()
        fun onOptionSelected(opcion: String)
    }


}