package com.example.t3_listajson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class VersionDialog : DialogFragment() {

    private lateinit var context: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context;
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(context)

        builder.setTitle("App Listas JSON")
        builder.setMessage("Version 1.0 de la app realizada por BMH")
        builder.setPositiveButton("OK") { _, _ ->
            Toast.makeText(
                this.context,
                "Pulsado ok",
                Toast.LENGTH_SHORT
            ).show()
        }

        return builder.create()

    }

}