package com.example.t3_listajson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t3_listajson.R

class GeneroSimpleDialog : DialogFragment() {

    private var listener: OnGeneroSimpleListener? = null
    private lateinit var context: Context
    private var genero: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context;
        listener = context as OnGeneroSimpleListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(this.context)
        builder.setTitle("Por que genero quieres filtrar")
        builder.setSingleChoiceItems(R.array.generos, -1) { _, pos ->
            // la ejecucion
            genero = resources.getStringArray(R.array.generos)[pos]
        }
        builder.setPositiveButton("ok") { _, _ ->
            // la ejecucion
            listener?.onGeneroSimpleSelected(genero)
        }

        return builder.create()

    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnGeneroSimpleListener {
        fun onGeneroSimpleSelected(genero: String?)
    }
}