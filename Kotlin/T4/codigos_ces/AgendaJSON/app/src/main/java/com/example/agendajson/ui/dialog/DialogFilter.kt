package com.example.agendajson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogFilter : DialogFragment() {

    private lateinit var opciones: Array<CharSequence>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        opciones = arrayOf("Masculino", "Femenino", "Todos")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Filter")
        builder.setSingleChoiceItems(opciones, -1, { v, p -> {} })
        builder.setPositiveButton("OK", { _, _ -> })

        return builder.create()
    }
}