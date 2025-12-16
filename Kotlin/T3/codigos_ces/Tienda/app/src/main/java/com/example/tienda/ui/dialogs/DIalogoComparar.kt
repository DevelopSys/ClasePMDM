package com.example.tienda.ui.dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DIalogoComparar : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        val opciones: Array<CharSequence> = arrayOf("Precio", "Categoria", "Stock")
        builder.setTitle("Comparar productos")
        builder.setSingleChoiceItems(opciones, -1) { view, position ->

        }

        builder.setPositiveButton("Seleccionar") { view, position ->
            dismiss()
        }
        return builder.create()
    }
}