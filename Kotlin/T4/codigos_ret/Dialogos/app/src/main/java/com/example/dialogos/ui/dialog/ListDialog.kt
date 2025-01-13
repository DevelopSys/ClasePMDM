package com.example.dialogos.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ListDialog : DialogFragment() {

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
        builder.setSingleChoiceItems(opciones, -1) { _, i -> }
        // multiple

        builder.setPositiveButton("Cancelar") { _, _ ->
            listener.onCancelSelected()
        }

        return builder.create()
    }

    interface OnDialogoListListener {
        fun onCancelSelected()
        fun onOptionSelected(opcion: String)
    }


}