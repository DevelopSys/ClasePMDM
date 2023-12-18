package com.example.t3_listajson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t3_listajson.R

class PersonalizadoDialog : DialogFragment() {

    private lateinit var context: Context
    private lateinit var listener: OnDialogoPersoListener
    private lateinit var vista: View
    private lateinit var spinnerGeneros: Spinner
    private lateinit var spinnerNumeros: Spinner
    private lateinit var adapterNumeros: ArrayAdapter<Int>
    private lateinit var botonFilrar: Button

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context;
        this.vista = LayoutInflater.from(context).inflate(R.layout.dialogo_filter,
            null)
        this.adapterNumeros = ArrayAdapter(context,android.R.layout.simple_spinner_item
            ,(1..100).toList())
        this.adapterNumeros.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //this.listener = context as OnDialogoPersoListener
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        builder.setView(vista)
        spinnerNumeros = vista.findViewById(R.id.spinner_resultados)
        spinnerNumeros.adapter = adapterNumeros
        spinnerGeneros = vista.findViewById(R.id.spinner_genero)
        botonFilrar = vista.findViewById(R.id.boton_filrar)
        botonFilrar.setOnClickListener {
            dismiss()
        }
        return builder.create()
    }


    override fun onDetach() {
        super.onDetach()
    }

    interface OnDialogoPersoListener {
        fun onPersonalizadoSelected(genero: String, resultados: Int)
    }
}