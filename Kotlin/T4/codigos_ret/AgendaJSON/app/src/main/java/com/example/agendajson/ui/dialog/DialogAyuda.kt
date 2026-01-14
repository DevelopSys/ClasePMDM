package com.example.agendajson.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogAyuda : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // 1. Crea un builder
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        // titulo
        builder.setTitle("Selecciona un genero a filtrar")
        // mensaje - lista
        builder.setMessage("Esta app es realizada por Borja Martin Herrera")
        // botones ->  neutra       negativo/positivo

        builder.setNeutralButton("CANCELAR", { _, _ ->
            Log.v("dialogo","Pulsado boton CANCELAR")
        })

        builder.setNegativeButton("NO", { _, _ ->
            Log.v("dialogo","Pulsado boton NO")
        })

        builder.setPositiveButton("SI", { _, _ ->
            Log.v("dialogo","Pulsado boton SI")
        })
        // 2. Creo el dialogo
        return builder.create()
    }
}