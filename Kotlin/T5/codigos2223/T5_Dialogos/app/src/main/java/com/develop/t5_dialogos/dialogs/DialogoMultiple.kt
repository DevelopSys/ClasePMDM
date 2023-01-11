package com.develop.t5_dialogos.dialogs

import android.app.Dialog
import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoMultiple : DialogFragment(), OnClickListener{

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val elementos = arrayOf("Opcion 1", "Opcion 2", "Opcion 3")
        //val elementosSelected = arrayOf(true,false,false)

        builder.setTitle("Selección multiple")

        builder.setMultiChoiceItems(elementos,null){ _, posicion, boolean ->
            Log.v("dialogos", "${posicion.toString()} ${boolean.toString()}")
        }

        builder.setPositiveButton("OK") { _, _ ->
            Log.v("dialogos", "realizar comunicacion")
            // se le comunique a la activity el numero de elementos que estan seleccionados
        }

        builder.setNeutralButton("Cerrar") { _, _ ->
            Log.v("dialogos", "cerrando boton")
        }




        return builder.create()
    }

    override fun onClick(p0: DialogInterface?, p1: Int) {
        TODO("Not yet implemented")
    }
}