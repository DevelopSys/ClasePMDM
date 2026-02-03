package com.example.tienda.ui.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogRegisterFAIL : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder =
            AlertDialog.Builder(requireContext())

        builder.setTitle("Error creando")
        builder.setMessage("Usuario no se ha podido crear correctamente")
        

        return builder.create()
    }

}