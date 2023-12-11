package com.example.t3_listaapi.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t3_listaapi.R
import com.google.android.material.snackbar.Snackbar

class CreditosDialog: DialogFragment() {

    private lateinit var contexto: Context;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context;
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(contexto)
        /*Personalizar el cuadro de dialogo*/
        // titulo
        builder.setTitle(resources.getString(R.string.titulo_dialogo_creditos))
        // contenido
        builder.setMessage("App realizada por BMH en la asignatura PMDM")
        // botones
        builder.setPositiveButton("Ok"){ _, _ ->
            //Snackbar.make(context,"Pulsado ok",Snackbar.LENGTH_SHORT).show
            Toast.makeText(context, "Pulsado ok",Toast.LENGTH_SHORT).show()
        }

        /*builder.setNegativeButton("Cancelar"){ _, _ ->
            //Snackbar.make(context,"Pulsado ok",Snackbar.LENGTH_SHORT).show
            Toast.makeText(context, "Pulsado cancelar",Toast.LENGTH_SHORT).show()
        }

        builder.setNeutralButton("Neutral"){ _, _ ->
            //Snackbar.make(context,"Pulsado ok",Snackbar.LENGTH_SHORT).show
            Toast.makeText(context, "Pulsado neutral",Toast.LENGTH_SHORT).show()
        }*/


        return builder.create()
    }


}