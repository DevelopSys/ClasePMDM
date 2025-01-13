package com.example.dialogos.ui.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ListDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val opciones: Array<CharSequence> = arrayOf("Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4")
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Selecciona una opcion correcta")
        // items
        builder.setItems(opciones) { _, i ->
            // ejecutado tras la pulsacion de la opcion
        }
        // tras la pulsacion de la opcion, aparecerá lo seleccionado en el texto
        // en el caso de seleccionar cancelar, aparecera un snackbar avisando de
        // la falta de datos

        // single
        // multiple

        builder.setPositiveButton("Cancelar"){_,_->}

        return builder.create()
    }

}