package com.example.t3_listajson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t3_listajson.R

class GeneroListaDialog: DialogFragment() {

    private var listener: OnGeneroListaListener? = null
    private lateinit var context: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context;
        listener = context as OnGeneroListaListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(this.context)
        builder.setTitle("Por que genero quieres filtrar")
        builder.setItems(R.array.generos){_,which->
            val genero = resources.getStringArray(R.array.generos)[which]
            Toast.makeText(this.context,genero,Toast.LENGTH_SHORT).show()
        }

        return builder.create()

    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnGeneroListaListener{
        fun onGeneroListaSelected(genero: String)
    }
}