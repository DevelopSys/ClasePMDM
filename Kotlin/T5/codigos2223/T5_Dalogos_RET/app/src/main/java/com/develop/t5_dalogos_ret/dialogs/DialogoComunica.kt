package com.develop.t5_dalogos_ret.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoComunica: DialogFragment(){

    private lateinit var nombre: String;
    private lateinit var apellido: String;

    companion object{
        fun newInstance(nombre: String, apellido: String): DialogoComunica {
            val dialogoComunica = DialogoComunica();
            val bundle = Bundle()
            bundle.putString("nombre",nombre)
            bundle.putString("apellido",apellido)
            dialogoComunica.arguments = bundle
            return dialogoComunica;
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        nombre = this.arguments?.getString("nombree","por defecto")?:"asdasd"
        apellido = this.arguments?.getString("apellidoo","por defecto")?:"asdasd"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // recuperar el nombre y ponerlo como titulo
        // recuperar el apellido y ponerlo como mesaje

        val builder = AlertDialog.Builder(requireContext())
        if (nombre.length>0){
            Log.v("prueba","prueba")
        }
        builder.setTitle("Bienvenido "+nombre)
        builder.setMessage("Bienvenido $nombre $apellido este es tu primer cuadro de diálogo con comunicacion")

        return builder.create()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }
}