package com.example.dialogos.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.dialogos.MainActivity

class ConfirmDialog : DialogFragment() {

    private lateinit var listener: OnDialogoConfirmacionListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogoConfirmacionListener
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())

        builder.setTitle("Confirmación")
        builder.setMessage("Estás seguro que quieres continuar")
        builder.setNeutralButton("CANCEL") { _, _ ->
            //sacar una notificacion de datos pendientes
        }

        builder.setPositiveButton("OK") { _, _ ->
            listener.onConfirmacionSelected("OK")
        }
        builder.setNegativeButton("NO") { _, _ ->
            listener.onConfirmacionSelected("NO")
        }

        return builder.create()
    }
    interface OnDialogoConfirmacionListener{
        fun onConfirmacionSelected(resultado: String)
    }

}