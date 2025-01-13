package com.example.dialogos.ui.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class InfoDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())

        builder.setTitle("Información")

        // Listas
        builder.setMessage("App realizada por Borja Martin para PMDM")

        builder.setPositiveButton("OK"){ _, _ ->
            Log.v("botones","Pulsado OK")
        }
        builder.setNegativeButton("NO"){ _, _ ->
            Log.v("botones","Pulsado NO")
        }
        builder.setNeutralButton("CANCEL"){ _, _ ->
            Log.v("botones","Pulsado CANCEL")
        }

        return builder.create()
    }

}