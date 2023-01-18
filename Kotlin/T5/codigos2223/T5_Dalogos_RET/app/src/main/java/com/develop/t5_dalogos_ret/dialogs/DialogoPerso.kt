package com.develop.t5_dalogos_ret.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.develop.t5_dalogos_ret.R
import com.develop.t5_dalogos_ret.model.Usuario

class DialogoPerso: DialogFragment() {

    private lateinit var vista: View;
    private lateinit var editNombre: EditText
    private lateinit var editPass: EditText
    private lateinit var checkRecordad: CheckBox
    private lateinit var botonLogin: Button
    private lateinit var spinnerDpt: Spinner
    private lateinit var listener: OnRecyclerUsuariosListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnRecyclerUsuariosListener
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
        spinnerDpt = vista.findViewById(R.id.spinner_departamento)
        spinnerDpt.adapter = ArrayAdapter
            .createFromResource(requireContext(),R.array.departamentos,android.R.layout.simple_spinner_item)
        (spinnerDpt.adapter as ArrayAdapter<CharSequence>)
            .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

    }

    override fun onResume() {
        super.onResume()
        botonLogin.setOnClickListener {
            // capturo lo que hay en los edit
            // ejecuto interfaz de callback y llevo los datos a la activty
            listener.usuarioSelected(Usuario(editNombre.text.toString()
                ,editPass.text.toString()
                ,spinnerDpt.selectedItem.toString()
                ,checkRecordad.isChecked))
            dismiss()
        }
    }

    interface  OnRecyclerUsuariosListener{
        fun usuarioSelected(usuario: Usuario);
    }

}