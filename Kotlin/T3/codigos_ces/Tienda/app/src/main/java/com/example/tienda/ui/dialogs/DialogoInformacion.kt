package com.example.tienda.ui.dialogs

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoInformacion : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val buider: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        buider.setTitle("Informacion de la APP")
        buider.setMessage("Esta app ha sido realizada para analizar datos de recycler view")
        buider.setPositiveButton("OK", { _, _ -> {
            Log.v("dialogo","Pulsado el boton positivo")
        } })
        buider.setNegativeButton("NO", { _, _ -> {
            Log.v("dialogo","Pulsado el boton negativo")
        } })

        buider.setNeutralButton("CANCEL", { _, _ -> {
            Log.v("dialogo","Pulsado el boton cancelar")
        } })

        return buider.create()
    }

}