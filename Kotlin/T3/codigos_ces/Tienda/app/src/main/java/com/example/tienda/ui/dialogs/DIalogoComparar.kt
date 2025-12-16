package com.example.tienda.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.tienda.MainActivity

class DIalogoComparar : DialogFragment() {

    private var opcionsSeleccionada: String? = null
    private lateinit var listener: OnCompararListener;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnCompararListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        val opciones: Array<CharSequence> = arrayOf("Precio", "Categoria", "Stock")
        builder.setTitle("Comparar productos")
        builder.setSingleChoiceItems(opciones, -1) { view, position ->
            opcionsSeleccionada = opciones[position].toString()
        }

        builder.setPositiveButton("Seleccionar") { view, position ->
            if (opcionsSeleccionada != null) {
                    listener.onCompararSelected(opcionsSeleccionada!!)
            }
            dismiss()
        }
        return builder.create()
    }

    interface OnCompararListener {
        fun onCompararSelected(opcion: String)
    }
}