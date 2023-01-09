package com.develop.t5_dialogos.dialogs


import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoLista : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        val elementos = arrayOf("Opcion 1", "Opcion 2", "Opcion 3")
        builder.setTitle("Titulo de lista")

        //builder.setMessage("Mensaj        e de la lista")
        builder.setItems(elementos, DialogInterface.OnClickListener { dialogInterface, i ->
            // i --> posicion pulsada

        })
        // no hay que poner botones --> como mucho pongo el neutral


        return builder.create();
    }

}