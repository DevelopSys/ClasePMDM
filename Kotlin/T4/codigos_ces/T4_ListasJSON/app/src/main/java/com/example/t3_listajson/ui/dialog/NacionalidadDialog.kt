package com.example.t3_listajson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t3_listajson.R

class NacionalidadDialog : DialogFragment() {

    private var listaNacionalidades: ArrayList<String> = ArrayList()
    private lateinit var context: Context
    private var listener: OnNacionalidadListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setTitle("Selecciona las nacionalidades a mostrar")
        builder.setMultiChoiceItems(R.array.nacionalidades, null)
        { _, pos, isChecked ->
            // ejecuto
            if (isChecked){
                listaNacionalidades.add(resources.getStringArray(R.array.nacionalidades)[pos])
            } else {
                listaNacionalidades.remove(resources.getStringArray(R.array.nacionalidades)[pos])
            }
        }
        builder.setPositiveButton("OK") { _, _ ->
            // comunico
            listener?.onDialogoNacionalidadSelected(listaNacionalidades)

        }
        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnNacionalidadListener {
        fun onDialogoNacionalidadSelected(nacionalidades: ArrayList<String>)
    }
}