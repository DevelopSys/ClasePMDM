package com.example.t3_listaapi.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class GeneroSimpleDialog: DialogFragment() {

    private lateinit var context: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(this.context)



        return super.onCreateDialog(savedInstanceState)
    }

    override fun onDetach() {
        super.onDetach()
    }

    interface OnGeneroSimpleDialog{
        fun onGeneroSimpleSelected(genero: String)
    }
}