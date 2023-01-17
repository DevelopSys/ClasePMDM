package com.develop.t5_dialogos.dialogs

import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.develop.t5_dialogos.R
import java.util.Calendar

class DialogoHora: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val caledario = Calendar.getInstance();
        val hora = caledario.get(Calendar.HOUR_OF_DAY)
        val minutos = caledario.get(Calendar.MINUTE)
        val dialogo = TimePickerDialog(requireContext(), R.style.DialogoColores  , requireContext() as OnTimeSetListener,hora,minutos,true)
        return dialogo
    }
}