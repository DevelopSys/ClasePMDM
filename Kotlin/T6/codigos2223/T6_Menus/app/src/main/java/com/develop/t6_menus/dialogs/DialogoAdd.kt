package com.develop.t6_menus.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.develop.t6_menus.R
import com.develop.t6_menus.adapter.AdaptadorCiclos
import com.develop.t6_menus.model.Asignatura
import com.develop.t6_menus.model.Ciclo
import javax.xml.transform.ErrorListener

class DialogoAdd : DialogFragment() {

    private lateinit var vista: View;
    private lateinit var editSiglas: EditText
    private lateinit var editNombre: EditText
    private lateinit var editProfesor: EditText
    private lateinit var spinnerHoras: Spinner
    private lateinit var adaptadorHoras: ArrayAdapter<CharSequence>
    private lateinit var spinnerCiclo: Spinner
    private lateinit var adaptadorCiclo: AdaptadorCiclos
    private lateinit var spinnerCurso: Spinner
    private lateinit var adaptadorCurso: ArrayAdapter<CharSequence>
    private lateinit var botonAdd: Button
    private lateinit var listener: OnDialogoAdd

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.personalizado_add_dialogo,null);
        adaptadorHoras = ArrayAdapter.createFromResource(context, R.array.coleccion_horas, android.R.layout.simple_spinner_item)
        adaptadorCurso = ArrayAdapter.createFromResource(context, R.array.coleccion_curso, android.R.layout.simple_spinner_item)
        val listaCiclos = ArrayList<Ciclo>()
        listaCiclos.add(Ciclo("DAM", R.drawable.dam))
        listaCiclos.add(Ciclo("DAW", R.drawable.daw))
        listaCiclos.add(Ciclo("ASIR", R.drawable.asir))
        adaptadorCiclo = AdaptadorCiclos(context, listaCiclos)
        listener = context as OnDialogoAdd

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireContext())
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        // declaro
        editSiglas = vista.findViewById(R.id.edit_siglas)
        editNombre = vista.findViewById(R.id.edit_nombre_asig)
        editProfesor = vista.findViewById(R.id.edit_nombre_prof)
        spinnerCiclo = vista.findViewById(R.id.spinner_ciclo)
        spinnerCurso = vista.findViewById(R.id.spinner_curso)
        spinnerHoras = vista.findViewById(R.id.spinner_horas)
        botonAdd = vista.findViewById(R.id.boton_add)
        spinnerHoras.adapter = adaptadorHoras;
        adaptadorHoras.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCurso.adapter = adaptadorCurso;
        adaptadorCurso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCiclo.adapter = adaptadorCiclo
    }

    override fun onResume() {
        super.onResume()
        // utilizo
        botonAdd.setOnClickListener {
            // capturar datos y pasarlos
            val siglas = editSiglas.text.toString()
            val nombre = editNombre.text.toString()
            val profesor = editProfesor.text.toString()
            val horas =  adaptadorHoras.getItem(spinnerHoras.selectedItemPosition).toString().toInt()
            val curso =  adaptadorCurso.getItem(spinnerCurso.selectedItemPosition).toString().toInt()
            val ciclo =  adaptadorCiclo.getItem(spinnerCiclo.selectedItemPosition)
            val asignatura = Asignatura(nombre,siglas,profesor,horas,ciclo.nombre,curso)
            listener.onAsignaturaSelected(asignatura)
            dismiss()
        }
    }

    interface OnDialogoAdd{
        fun onAsignaturaSelected(asignatura: Asignatura)
    }
}