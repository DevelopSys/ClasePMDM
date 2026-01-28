package com.example.tienda.ui.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DiagloRegistroOK : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Registro correcto")
        builder.setMessage("Quieres iniciar sesion con el usuario")
        builder.setPositiveButton("SI", { _, _ -> })
        builder.setNegativeButton("NO", { _, _ -> })
        return builder.create()
    }
}