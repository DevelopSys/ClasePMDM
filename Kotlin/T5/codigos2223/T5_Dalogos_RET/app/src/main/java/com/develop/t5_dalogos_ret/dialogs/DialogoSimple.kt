package com.develop.t5_dalogos_ret.dialogs

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoSimple: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireContext())
        val elementos = arrayOf("Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4")

        builder.setTitle("Selecciona una opcion")
        builder.setSingleChoiceItems(elementos,-1)
        { _, i ->  }
        //builder.setPositiveButton()



        return builder.create()
    }
}