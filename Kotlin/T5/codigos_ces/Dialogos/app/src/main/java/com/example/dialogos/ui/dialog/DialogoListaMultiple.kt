package com.example.dialogos.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.dialogos.MainActivity

class DialogoListaMultiple : DialogFragment() {

    private lateinit var listener: OnDialogoMultipleListener
    private var posicion: Int? = null
    private var opcion: String? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        // listener = context as MainActivity
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var listaOpciones = arrayOf("Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4")
        var builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())

        builder.setTitle("Selecciona la opcion correcta")

        builder.setMultiChoiceItems(listaOpciones, null) { _, i, b ->
            // se agrega el elemento en el arraylist, solo cuando pase a b true
            // se elimina el elemento en el arraylist, solo cuando pasa a b false
        }

        builder.setNeutralButton("Cancelar") { _, _ ->
            dismiss()
        }
        builder.setPositiveButton("Aceptar") { _, _ ->
            //dismiss()
            // comunico el arraylist completo
        }

        return builder.create()
    }

    interface OnDialogoMultipleListener {
        fun onOpcionMultpleSelected(respuestas: ArrayList<CharSequence>)
    }


}