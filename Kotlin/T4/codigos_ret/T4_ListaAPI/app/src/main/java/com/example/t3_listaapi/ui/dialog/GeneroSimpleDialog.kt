package com.example.t3_listaapi.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t3_listaapi.R

class GeneroSimpleDialog: DialogFragment() {

    private lateinit var context: Context
    private var listener: OnGeneroSimpleDialogListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
        listener = context as OnGeneroSimpleDialogListener
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var seleccion: String? = null

        val builder: AlertDialog.Builder = AlertDialog.Builder(this.context)

        builder.setTitle("Filtrar por genero")

        builder.setSingleChoiceItems(R.array.generos,0){_,pos->
            seleccion = resources.getStringArray(R.array.generos)[pos]
        }

        builder.setPositiveButton("OK"){_,_->
            listener?.onGeneroSimpleSelected(seleccion?.toLowerCase())
        }

        return builder.create()
    }
    override fun onDetach() {
        super.onDetach()
        listener = null
    }
    interface OnGeneroSimpleDialogListener{
        fun onGeneroSimpleSelected(genero: String?)
    }
}