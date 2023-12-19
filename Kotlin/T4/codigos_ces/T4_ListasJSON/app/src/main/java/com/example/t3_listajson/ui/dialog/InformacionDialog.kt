package com.example.t3_listajson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t3_listajson.R

class InformacionDialog(): DialogFragment() {

    private lateinit var vista: View
    private lateinit var contexto: Context
    private lateinit var texto: TextView;
    private lateinit var textoComunicar: String
    private var edadComunicar: Int = 0

    
    companion object{
        fun newInstance(nombre: String, edad: Int): InformacionDialog {
            val informDialog: InformacionDialog = InformacionDialog();
            val bundle = Bundle()
            bundle.putString("nombre",nombre)
            bundle.putInt("edad",edad)
            informDialog.arguments = bundle
            //  comienza el ciclo de vida
            return informDialog
        }
    }

    /*fun newInstance() {
        val args = Bundle()
        
        val fragment = ()
        fragment.arguments = args
        return fragment
    }*/

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context;
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_info,null)
        textoComunicar = this.arguments?.getString("nombre") ?: "sin nombre"
        edadComunicar = this.arguments?.getInt("edad") ?:0
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.contexto)
        builder.setView(vista)
        texto = vista.findViewById(R.id.nombre_info_usuario)
        texto.text = textoComunicar +" ${edadComunicar.toString()}"
        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
    }
}