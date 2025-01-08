package com.example.dialogos.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.dialogos.MainActivity

class DialogoLista : DialogFragment() {
    private lateinit var listener: OnDialogoListaListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MainActivity
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var listaOpciones = arrayOf("Opcion 1", "Opcion 2", "Opcion 3")
        var builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())

        builder.setTitle("Selecciona la opcion correcta")
        builder.setItems(listaOpciones) { _, i ->
            listener.onOpcionSelected(listaOpciones[i])
        }
        builder.setNeutralButton("Canceler") { _, _ ->
            dismiss()
        }

        return builder.create()
    }

    interface OnDialogoListaListener {
        fun onOpcionSelected(x: String)
    }
}