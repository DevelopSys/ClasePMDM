package com.example.dialogos.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ListDialog : DialogFragment() {
    private lateinit var listaSeleccion: ArrayList<Int>
    private lateinit var listener: OnListaMultipleListener
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listaSeleccion = ArrayList()
        listener = context as OnListaMultipleListener
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
            if (b){
             listaSeleccion.add(i)
            } else {
                listaSeleccion.remove(i)
            }
        }


        builder.setNeutralButton("Cancelar") { _, _ ->
            // listener.onCancelSelected()
        }

        builder.setPositiveButton("OK") { _, _ ->
            // listener.onOptionSelected(opciones[indexSelected].toString())
            listener.onListaMultipleSelected(listaSeleccion)
        }

        return builder.create()
    }

    interface OnListaMultipleListener{

        fun onListaMultipleSelected(opcionesResultado: ArrayList<Int>)

    }



}