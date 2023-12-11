package com.example.t3_listaapi.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t3_listaapi.R

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

        return builder.create()
    }


}