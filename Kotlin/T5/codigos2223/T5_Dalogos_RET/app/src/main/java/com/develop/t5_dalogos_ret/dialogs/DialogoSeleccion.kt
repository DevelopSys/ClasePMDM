package com.develop.t5_dalogos_ret.dialogs

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoSeleccion: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireContext())
        val elementos = arrayOf("Opcion 1","Opcion 2","Opcion 3","Opcion 4")

        builder.setTitle("Selecciona una opcion")

        //builder.setMessage("NO PUEDE TENER")

        builder.setItems(elementos) { _, i ->
            Log.v("dialogos", "Pulsado ${elementos[i]}")
        }

        return builder.create()
    }

}