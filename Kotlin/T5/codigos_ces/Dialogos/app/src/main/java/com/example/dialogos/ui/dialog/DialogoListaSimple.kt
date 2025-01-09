package com.example.dialogos.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.dialogos.MainActivity

class DialogoListaSimple : DialogFragment() {

    private lateinit var listener: OnDialogoSimpleListener
    private var posicion: Int? = null
    private var opcion: String? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MainActivity
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var listaOpciones = arrayOf("Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4")
        var builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())

        builder.setTitle("Selecciona la opcion correcta")

        builder.setSingleChoiceItems(listaOpciones, -1) { _, i ->
            posicion = i
            opcion = listaOpciones[i]
        }

        builder.setNeutralButton("Cancelar") { _, _ ->
            dismiss()
        }
        builder.setPositiveButton("Aceptar") { _, _ ->
            //dismiss()
            if (opcion != null && posicion !=null){
                listener.onOpcionSimpleSelected(posicion!!,opcion!!)
            }

        }

        return builder.create()
    }

    interface OnDialogoSimpleListener{
        fun onOpcionSimpleSelected(posicion: Int, opcion: String)
    }


}