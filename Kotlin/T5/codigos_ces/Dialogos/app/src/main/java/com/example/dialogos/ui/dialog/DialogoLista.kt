package com.example.dialogos.ui.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoLista: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var listaOpciones= arrayOf("Opcion 1","Opcion 1","Opcion 1")
        var builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())

        builder.setTitle("Selecciona la opcion correcta")
        builder.setItems(listaOpciones, DialogInterface.OnClickListener { _, i ->  })
        builder.setNeutralButton("Canceler", DialogInterface.OnClickListener { _, _ ->
            dismiss()
        })

        return builder.create()
    }
}