package com.example.agendajson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.agendajson.MainActivity

class DialogFiltrar : DialogFragment() {

    private lateinit var listaOpciones: Array<CharSequence>
    private lateinit var listener: OnDialogoGeneroListener
    private var seleccion: Int = -1

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listaOpciones = arrayOf("male", "female", "all")
        listener = context as MainActivity
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Selecciona el genero a filtrar")

        // lista de opciones - mensaje
        // builder.setItems() pone todos loe elementos de una lista sin posibilidad de cambiar seleccion
        builder.setSingleChoiceItems(
            listaOpciones, -1,
            { _, p -> seleccion = p })
        // builder.setMultiChoiceItems(listaOpciones, null, { v, p, b -> })

        builder.setPositiveButton("OK", { _, _ ->
            // el elemento que esta seleccionado?
            listener.onGeneroSelected(listaOpciones[seleccion].toString())
        })

        return builder.create()
    }

    interface OnDialogoGeneroListener {
        fun onGeneroSelected(genero: String);
    }

}
