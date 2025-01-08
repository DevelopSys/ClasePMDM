package com.example.dialogos.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.dialogos.MainActivity
import com.google.android.material.snackbar.Snackbar

class DialogoInfo : DialogFragment() {

    lateinit var listener: OnDialogoListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MainActivity

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Ejemplo de cuadro de dialogo")
        builder.setMessage("Cuadro de dialogo para la informacion del sistema")
        builder.setPositiveButton("OK", { _, _ ->
            listener.onDialogoSelected("Comunicacion correcta",1)
        })
        builder.setNegativeButton("NO", { _, _ ->
            //listener.onDialogoSelected("Comunicacion incorrecta",2)
            listener.onDialogoSelectedAll()
        })
        builder.setNeutralButton("Cancel", { _, _ ->
            dismiss()
        })
        return builder.create()
    }

    interface OnDialogoListener{
        fun onDialogoSelected(respuesta: String, respuestaNum: Int)
        fun onDialogoSelectedAll()
    }

}