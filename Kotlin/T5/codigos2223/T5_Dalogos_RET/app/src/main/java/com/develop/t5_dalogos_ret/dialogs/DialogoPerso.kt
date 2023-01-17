package com.develop.t5_dalogos_ret.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.develop.t5_dalogos_ret.R

class DialogoPerso: DialogFragment() {

    private lateinit var vista: View;
    private lateinit var editNombre: EditText
    private lateinit var editPass: EditText
    private lateinit var checkRecordad: CheckBox
    private lateinit var botonLogin: Button

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_login,null)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder= AlertDialog.Builder(requireContext())
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        editNombre = vista.findViewById(R.id.edit_nombre)
        editPass = vista.findViewById(R.id.edit_pass)
        botonLogin = vista.findViewById(R.id.boton_login)
        checkRecordad = vista.findViewById(R.id.check_recordad)
    }

    override fun onResume() {
        super.onResume()
        botonLogin.setOnClickListener {
            // capturo lo que hay en los edit
            // ejecuto interfaz de callback y llevo los datos a la activty
        }
    }

}