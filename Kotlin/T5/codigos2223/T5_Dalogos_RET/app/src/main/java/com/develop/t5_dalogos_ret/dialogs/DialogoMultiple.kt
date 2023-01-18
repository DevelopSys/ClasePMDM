package com.develop.t5_dalogos_ret.dialogs

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoMultiple : DialogFragment() {

    lateinit var selecciones: ArrayList<String>

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        selecciones = ArrayList()

        val builder = AlertDialog.Builder(requireContext())
        val elementos = arrayOf("Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4")

        builder.setTitle("Selecciona una opcion")
        builder.setMultiChoiceItems(
            elementos,
            null,
            DialogInterface.OnMultiChoiceClickListener { _, i, b ->
                Log.v("dialogo", "${i} ${b}")
                if (b) {
                    selecciones.add(elementos[i])
                } else {
                    //eliminar de la lista
                    selecciones.remove(elementos[i])
                }
            })

        builder.setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
            // LOG con el nombre del elemento seleccionado
            selecciones.forEach { Log.v("dialogo", it) }
        })



        return builder.create()
    }
}