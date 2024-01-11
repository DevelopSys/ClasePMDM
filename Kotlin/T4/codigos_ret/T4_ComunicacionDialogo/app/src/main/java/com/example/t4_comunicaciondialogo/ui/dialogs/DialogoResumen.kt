package com.example.t4_comunicaciondialogo.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t4_comunicaciondialogo.R

class DialogoResumen : DialogFragment() {

    private lateinit var contexto: Context
    private lateinit var textoNombre: TextView
    private lateinit var textoHora: TextView
    private lateinit var textoFecha: TextView
    private lateinit var boton: Button

    companion object {
        fun newInstance(fecha: String, hora: String, nombre: String)
                : DialogoResumen {

            val dialogoResumen = DialogoResumen()
            val bundle = Bundle()
            bundle.putString("nombre",nombre)
            bundle.putString("hora",hora)
            bundle.putString("fecha",fecha)
            dialogoResumen.arguments = bundle
            return dialogoResumen;
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(contexto)
        val vista = LayoutInflater.from(context).inflate(R.layout.dialogo_resumen, null)
        textoHora = vista.findViewById(R.id.texto_hora)
        textoFecha = vista.findViewById(R.id.texto_fecha)
        textoNombre = vista.findViewById(R.id.texto_nombre)
        boton = vista.findViewById(R.id.boton_dialogo)
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        // recuperar los datos y utilizarlos
        textoNombre.text = this.arguments?.getString("nombre")
        textoFecha.text = this.arguments?.getString("hora")
        textoHora.text = this.arguments?.getString("fecha")
        boton.setOnClickListener { dismiss() }
    }
}